package leetcode.strings;

import com.sun.source.tree.WhileLoopTree;

import java.util.HashMap;
import java.util.Map;

public class IntegerToRoman {

    public static void main (String[] args){
        int num = 1994;
        System.out.println("the integer to rmoan number is: "+intToRoman(num));
    }

    public static String intToRoman(int num) {
        String roman = "";
        int remainder=0;
        Map<Integer, String> value_symbols= new HashMap<>();
        value_symbols.put(1000, "M");
        value_symbols.put(900, "CM");
        value_symbols.put(500, "D");
        value_symbols.put(400, "CD");
        value_symbols.put(100, "C");
        value_symbols.put(90, "XC");
        value_symbols.put(50, "L");
        value_symbols.put(40, "XL");
        value_symbols.put(10, "X");
        value_symbols.put(9, "IX");
        value_symbols.put(5, "V");
        value_symbols.put(4, "IV");
        value_symbols.put(1, "I");

     //   while (num >1){
            while (num >=1000) {
                num = num - 1000;
                roman= roman+"M";
            }
            while (num >=900) {
                num = num - 900;
                roman= roman+"CM";
            }
            while (num >=500) {
                num = num - 500;
                roman= roman+"D";
            }
            while (num >=400) {
                num = num - 400;
                roman= roman+"CD";
            }
            while (num >=100) {
                num = num - 100;
                roman= roman+"C";
            }
            while (num >=90) {
                num = num - 90;
                roman= roman+"XC";
            }
            while (num >=50) {
                num = num - 50;
                roman= roman+"L";
            }
            while (num >=40) {
                num = num - 40;
                roman= roman+"XL";
            }
            while (num >=10) {
                num = num - 10;
                roman= roman+"X";
            }
            while (num >=9) {
                num = num - 9;
                roman= roman+"IX";
            }
            while (num >=5) {
                num = num - 5;
                roman= roman+"V";
            }
            while (num >=4) {
                num = num - 4;
                roman= roman+"IV";
            }
            while (num >=1) {
                num = num - 1;
                roman= roman+"I";
            }

   //     }
        return roman;
    }
}
