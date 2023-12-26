package org.example;

import javax.print.DocFlavor;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws Exception {
        System.out.println(calc("8 + 6"));
        System.out.println(calc("X - IV"));
        System.out.println(calc("7 * 7"));
        System.out.println(calc("VIII / II"));
        System.out.println(calc("VI - 4"));

    }
    public static String calc(String input) throws Exception {

        int x1;
        int x2;
        String sign;
        int result = 0;
        boolean isRomanCalc = false;
        String[] romanLowNumbers = {"I","II","III","IV","V","VI","VII","VIII","IX","X"};
        String[] romanHightNumbers = {"X","XX","XXX","XL","L","LX","LXX","LXXX","XC","C"};
        Map <String,Integer> romanNumbers = new HashMap<>();

        for (int i = 0; i < 10; i++) {
            romanNumbers.put(romanLowNumbers[i],i+1);
        }

        String[] inputs = input.split(" ");
        if(inputs.length > 3) {
            throw new Exception("Данный калькулятор может работать только с двумя переменными!");
        }

        try {
            x1 = Integer.parseInt(inputs[0]);
            x2 = Integer.parseInt(inputs[2]);
        }catch (Exception e){
            isRomanCalc = true;
            x1 = romanNumbers.get(inputs[0]);
            x2 = romanNumbers.get(inputs[2]);
        }
        sign = inputs[1];

        switch (sign) {
            case "+" -> {
                result = x1 + x2;
                break;
            }
            case "-" -> {
                result = x1 - x2;
                break;
            }
            case "*" -> {
                result = x1 * x2;
                break;
            }
            case "/" -> {
                result = x1 / x2;
                break;
            }
        }

        if(isRomanCalc){
            if(result>10) {
                return (romanHightNumbers[result / 10 - 1] + romanLowNumbers[result % 10 - 1]);
            }else {
               return romanLowNumbers[result - 1];
            }
        }

        return String.valueOf(result);
    }
}
