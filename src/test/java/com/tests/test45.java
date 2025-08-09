package com.tests;

import org.testng.annotations.Test;

import java.awt.*;
import java.awt.datatransfer.StringSelection;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

/**
 * @author tasahu
 */
public class test45 {

    String s="venkateswara";

    @Test
    public static void generateAlphabeticString() {
        int sizeInBytes = 16777000;
        char[] alphabet = "abcdefghijklmnopqrstuvwxyz".toCharArray();
        char[] result = new char[sizeInBytes];

        for (int i = 0; i < sizeInBytes; i++) {
            result[i] = alphabet[i % alphabet.length];
        }
        System.out.println("string is: "+ result);

        try (FileWriter fileWriter = new FileWriter("test_alphanumeric.txt")) {
            fileWriter.write(result);
            System.out.println("Random string saved to test_alphanumeric.txt");
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println("test");

    }

    @Test
    static void getCharCount(){
        String s="venkateswaraae";
        int l=s.length();
        int count[]=new int[256];
        for(int i=0;i<l;i++){
            count[s.charAt(i)]++;
        }
        for(int i=0;i<l;i++){
            int count1=0;
            for(int j=0;j<=i;j++){
                if(s.charAt(i)==s.charAt(j)){
                    count1++;
                }
            }
            if(count1==1){
                System.out.println("Char "+s.charAt(i)+" is repaated by "+count[s.charAt(i)]+" times");
            }
        }
    }


}
