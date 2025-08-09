package com.tests;

import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;

import java.time.LocalDate;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;

public class FizzBuzz  {

    private static class BaseDataTemplate {
        ObjectNode plainFieldsTemplate;
        ObjectNode fieldGroupL1Template;
        ObjectNode fieldGroupL2Template;
        ObjectNode fieldGroupL3Template;
        ObjectNode allData;

        public BaseDataTemplate(int value,
                                String countryCode,
                                String stateCode) {
            this(String.valueOf(value),
                    value,
                    value > 0,
                    LocalDate.now(),
                    countryCode,
                    stateCode,
                    value + 0.11);
        }

        public BaseDataTemplate(String stringValue,
                                int intValue,
                                boolean booleanValue,
                                LocalDate dateValue,
                                String countryCode,
                                String stateCode,
                                Double doubleValue) {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
            String formattedDate = dateValue.format(formatter);

            plainFieldsTemplate = JsonUtil.getDefaultObjectMapper().createObjectNode();
            plainFieldsTemplate.put("integer", intValue);
            plainFieldsTemplate.put("text", stringValue);
            ArrayNode textAllowMany = plainFieldsTemplate.putArray("textAllowMany");
            textAllowMany.add(JsonUtil.getDefaultObjectMapper().createObjectNode()
                    .put("_id", "id1").put("_value", stringValue));
            textAllowMany.add(JsonUtil.getDefaultObjectMapper().createObjectNode()
                    .put("_id", "id2").put("_value", stringValue));
            plainFieldsTemplate.put("boolean", booleanValue);
            plainFieldsTemplate.put("date", formattedDate);
            plainFieldsTemplate.put("dateTime", LocalDate.now().atStartOfDay().toEpochSecond(ZoneOffset.UTC));
            plainFieldsTemplate.put("decimal", String.valueOf(doubleValue));
            plainFieldsTemplate.put("double", doubleValue);
            plainFieldsTemplate.putObject("lookup_countryCd")
                    .put("country_code", countryCode);
            plainFieldsTemplate.putObject("dependent_lookup_stateCd")
                    .put("state_code", stateCode);

            allData = plainFieldsTemplate.deepCopy();

            fieldGroupL1Template = allData.putObject("fieldGroupL1");
            fieldGroupL1Template.setAll(plainFieldsTemplate.deepCopy());
            fieldGroupL2Template = fieldGroupL1Template.putObject("fieldGroupL2");
            fieldGroupL2Template.setAll(plainFieldsTemplate.deepCopy());
            fieldGroupL3Template = fieldGroupL2Template.putObject("fieldGroupL3");
            fieldGroupL3Template.setAll(plainFieldsTemplate.deepCopy());

            ArrayNode multiValueFieldGroupL3 = fieldGroupL2Template.putArray("multiValueFieldGroupL3");
            multiValueFieldGroupL3.add(fieldGroupL3Template.deepCopy());
            multiValueFieldGroupL3.add(fieldGroupL3Template.deepCopy());
            ((ObjectNode) multiValueFieldGroupL3.get(0)).put("_id", "id1");
            ((ObjectNode) multiValueFieldGroupL3.get(1)).put("_id", "id2");

            ArrayNode multiValueFieldGroupL2 = fieldGroupL1Template.putArray("multiValueFieldGroupL2");
            multiValueFieldGroupL2.add(fieldGroupL2Template.deepCopy());
            multiValueFieldGroupL2.add(fieldGroupL2Template.deepCopy());
            ((ObjectNode) multiValueFieldGroupL2.get(0)).put("_id", "id1");
            ((ObjectNode) multiValueFieldGroupL2.get(1)).put("_id", "id2");

            ArrayNode multiValueFieldGroupL1 = allData.putArray("multiValueFieldGroupL1");
            multiValueFieldGroupL1.add(fieldGroupL1Template.deepCopy());
            multiValueFieldGroupL1.add(fieldGroupL1Template.deepCopy());
            ((ObjectNode) multiValueFieldGroupL1.get(0)).put("_id", "id1");
            ((ObjectNode) multiValueFieldGroupL1.get(1)).put("_id", "id2");
        }
    }

    public static void main(String[] args) {
        BaseDataTemplate baseDataTemplate = new BaseDataTemplate(1, "CA", "ON");
        ObjectNode base = baseDataTemplate.allData;
        System.out.println(base);



        ObjectNode expectedValue = base.deepCopy();


    }
}

