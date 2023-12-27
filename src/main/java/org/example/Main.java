package org.example;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {
        try (Scanner scanner = new Scanner(System.in)) {
            while (true) {
                System.out.println(calc(scanner.nextLine()));
            }
        }
    }

    public static String calc(String input) throws Exception {

        int x1;
        int x2;
        String sign;
        int result = 0;
        boolean isRomanCalc = false;
        String[] romanLowNumbers = {"I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX", "X"};
        String[] romanHightNumbers = {"X", "XX", "XXX", "XL", "L", "LX", "LXX", "LXXX", "XC", "C"};
        Map<String, Integer> romanNumbers = new HashMap<>();

        for (int i = 0; i < 10; i++) {
            romanNumbers.put(romanLowNumbers[i], i + 1);
        }

        String[] inputs = input.split(" ");
        if (inputs.length > 3)
            return "Данный калькулятор может работать только с двумя переменными!";
        try {
            x1 = Integer.parseInt(inputs[0]);
            x2 = Integer.parseInt(inputs[2]);
            if (x1 <= 0 || x2 <= 0 || x1 > 10 || x2 > 10)
                return "Числа должны быть от 1 до 10 включительно";
        } catch (Exception e) {
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

        if (isRomanCalc) {
            if (result > 10) {
                return (romanHightNumbers[result / 10 - 1] + romanLowNumbers[result % 10 - 1]);
            } else {
                return romanLowNumbers[result - 1];
            }
        }

        return String.valueOf(result);
    }
}
