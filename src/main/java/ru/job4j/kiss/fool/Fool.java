package ru.job4j.kiss.fool;

import java.util.Scanner;

public class Fool {

    public static void main(String[] args) {
        System.out.println("Игра FizzBuzz.");
        var startAt = 1;
        var io = new Scanner(System.in);
        while (startAt < 100) {
            System.out.println(checkNumber(startAt));
            startAt++;
            var answer = io.nextLine();
            checkAnswer(startAt, answer);
            startAt++;
        }
    }

    public static String checkNumber(Integer value) {
        if (value % 3 == 0 && value % 5 == 0) {
            return "FizzBuzz";
        } else if (value % 3 == 0) {
            return "Fizz";
        } else if (value % 5 == 0) {
            return "Buzz";
        } else {
            return value.toString();
        }
    }

    public static void checkAnswer(Integer value, String answer) {
        if ((value % 3 == 0 && value % 5 == 0) && !"FizzBuzz".equals(answer) ||
                (value % 3 == 0) && !"Fizz".equals(answer) ||
                (value % 5 == 0) && !"Buzz".equals(answer) ||
                !String.valueOf(answer).equals(answer)) {

            System.out.println("Ошибка. Начинай снова.");
            value = 0;
        }
        value++;

    }
}
