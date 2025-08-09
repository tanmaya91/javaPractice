package com.tests;


import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.Module;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import org.springframework.http.MediaType;

import org.apache.commons.lang3.StringUtils;


import java.awt.*;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Iterator;
import java.util.Map;
import java.util.Optional;
import java.util.function.Consumer;

/**
 * JSON Utilities
 */

public class JsonUtil {

    public static final MediaType JSON_UTF8 = new MediaType("application", "json", StandardCharsets.UTF_8);
    public static final String APPLICATION_JSON_UTF8_VALUE = "application/json;charset=UTF-8";
    public static final MediaType APPLICATION_JSON = MediaType.APPLICATION_JSON;



    private static final ObjectMapper objectMapper;
    private static final ObjectMapper objectMapperIgnoreUnknown;
    private static final ObjectMapper defaultObjectMapper;
    private static final ObjectMapper longForIntsObjectMapper;
    protected static final String NODE_FOR = "node for ";

    static {
        objectMapper = new ObjectMapper();
        objectMapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);
        objectMapper.configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, true);
        objectMapper.configure(DeserializationFeature.READ_ENUMS_USING_TO_STRING, true);
        objectMapper.configure(SerializationFeature.WRITE_ENUMS_USING_TO_STRING, true);

        objectMapperIgnoreUnknown = new ObjectMapper();
        objectMapperIgnoreUnknown.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);

        defaultObjectMapper = new ObjectMapper();

        longForIntsObjectMapper = new ObjectMapper();
        longForIntsObjectMapper.configure(DeserializationFeature.USE_LONG_FOR_INTS, true);
    }

    public void registerModule(Module module) {
        objectMapper.registerModule(module);
    }

    public ObjectNode createObjectNode() {
        return objectMapper.createObjectNode();
    }

    public ArrayNode createArrayNode() {
        return objectMapper.createArrayNode();
    }

    public JsonNode parse(String json) throws IOException {
        return getObjectMapper().readTree(json);
    }

    public <T extends JsonNode> T map(Object object) {
        return getObjectMapper().valueToTree(object);
    }

    public <T> T fromJson(JsonNode schema, Class<T> clazz) throws Exception {
        try {
            return getObjectMapper().treeToValue(schema, clazz);
        } catch (JsonProcessingException e) {
            throw new Exception(e);
        }
    }

    public <T> T fromJsonString(String jsonString, Class<T> clazz) throws IOException {
        return getObjectMapper().readValue(jsonString, clazz);
    }

    public String toJsonString(Object object) throws Exception {
        try {
            ObjectMapper mapper = getObjectMapper();
            return mapper.writeValueAsString(object);
        } catch (JsonProcessingException e) {
            throw new Exception(e);
        }
    }

    public ObjectMapper getObjectMapper() {
        return getMapper();
    }

    public static ObjectMapper getMapper() {
        return objectMapper;
    }

    public static ObjectMapper getIgnoreUnknownObjectMapper() {
        return objectMapperIgnoreUnknown;
    }

    public static ObjectMapper getDefaultObjectMapper() {
        return defaultObjectMapper;
    }

    public static ObjectMapper getLongForIntsObjectMapper() {
        return longForIntsObjectMapper;
    }

    public static ObjectNode getObjectNode(ObjectNode objectNode, String path) {
        JsonNode node = objectNode.get(path);

        if(node == null) {
            throw new IllegalStateException(NODE_FOR + path + " is not available");
        } else if (!node.isObject()){
            throw new IllegalStateException(NODE_FOR + path + " is not an object node!");
        }

        return (ObjectNode) node;
    }

    public static String getTextValue(JsonNode objectNode, String... paths) {

        JsonNode object = objectNode;

        String totalPath = StringUtils.EMPTY;

        for(String path: paths) {
            totalPath = String.join(".", totalPath, path);

            object = object.get(path);
            if (path == null) {
                throw new IllegalStateException(NODE_FOR + totalPath + " is not available");
            }
        }

        if (object == null || !object.isTextual()) {
            throw new IllegalStateException(NODE_FOR + totalPath + " is not textual");
        }
        return object.asText();
    }

    public static Optional<String> getOptionalStringValue(ObjectNode objectNode, String... paths) {

        Optional<JsonNode> jsonNode = getOptionalJsonNode(objectNode, paths);
        return jsonNode.map(JsonNode::toString);
    }

    public static Optional<ArrayNode> getOptionalArrayNode(ObjectNode objectNode, String... paths) {

        Optional<JsonNode> jsonNode = getOptionalJsonNode(objectNode, paths);
        return jsonNode.map(ArrayNode.class::cast);
    }

    private static Optional<JsonNode> getOptionalJsonNode(JsonNode objectNode, String... paths) {

        JsonNode currentNode = objectNode;

        for (String path : paths) {
            currentNode = currentNode.get(path);
            if (currentNode == null) {
                return Optional.empty();
            }
        }

        return Optional.ofNullable(currentNode);
    }

    public static Optional<JsonNode> getJsonNode(JsonNode node, String... paths) {
        return node == null ? Optional.empty() :
                getOptionalJsonNode(node, paths);
    }

    public static JsonNode traverse(JsonNode top, Consumer<Map.Entry<String, JsonNode>> consumer) {

        if (top instanceof ObjectNode) {
            ObjectNode objectNode = (ObjectNode) top;
            Iterator<Map.Entry<String, JsonNode>> fields = objectNode.fields();
            while (fields.hasNext()) {
                Map.Entry<String, JsonNode> entry = fields.next();
                consumer.accept(entry);
                if (entry.getValue().isContainerNode()) {
                    traverse(entry.getValue(), consumer);
                }
            }
        }
        if (top instanceof ArrayNode) {
            ArrayNode arrayNode = (ArrayNode) top;
            for (JsonNode jsonNode : arrayNode) {
                traverse(jsonNode, consumer);
            }
        }

        return top;
    }

}

