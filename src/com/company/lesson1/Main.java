package com.company.lesson1;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        /*
        Создать переменные всех пройденных типов данных и инициализировать их значения.
        */
        byte pByte = 127;
        short pShort = 32767;
        int pInt = 2147483647;
        long pLong = 9223372036854775807L;
        float pFloat = 11.22f;
        double pDouble = 11.33;
        char pChar = 'D';
        boolean pBollean = false;
        String[] pString = {String.valueOf(pByte), String.valueOf(pShort), String.valueOf(pInt), String.valueOf(pLong), String.valueOf(pFloat), String.valueOf(pDouble), String.valueOf(pChar), String.valueOf(pBollean)};
        for (String s : pString) System.out.println(s);

        System.out.println("Задание: Написать метод вычисляющий выражение a * (b + (c / d)) и возвращающий результат, где a, b, c, d – аргументы этого метода, имеющие тип float.");
        System.out.println("Ответ: " + calcExpression(2.2f, 3f, 44.4f, 5.2123f));


        System.out.println("Задание: Написать метод, принимающий на вход два целых числа и проверяющий, что их сумма лежит в пределах от 10 до 20 (включительно), если да – вернуть true, в противном случае – false.");
        System.out.println("Ответ: " + checkSumm(2,5));


        System.out.println("Задание: Написать метод, которому в качестве параметра передается целое число, метод должен напечатать в консоль, положительное ли число передали или отрицательное. Замечание: ноль считаем положительным числом.");
        if (checkValue(-10))
            System.out.println("Ответ: " + "Число отрицательное");
        else
            System.out.println("Ответ: " + "Число положительное");


        System.out.println("Задание: Написать метод, которому в качестве параметра передается целое число. Метод должен вернуть true, если число отрицательное, и вернуть false если положительное.");
        System.out.println("Ответ: " + checkValue(-5));


        System.out.println("Задание: Написать метод, которому в качестве параметра передается строка, обозначающая имя. Метод должен вывести в консоль сообщение «Привет, указанное_имя!».");
        message("Denis");


        System.out.println("Написать метод, который определяет, является ли год високосным, и выводит сообщение в консоль. Каждый 4-й год является високосным, кроме каждого 100-го, при этом каждый 400-й – високосный.");
        Scanner scaner = new Scanner(System.in);
        System.out.println("Введите год");
        int year;
        if (!scaner.hasNextInt())
            System.out.println("Некорректно введен год");
        else {
                year = scaner.nextInt();
                if ((year%400)==0 || ((year%4) == 0 && (year%100) != 0))
                    {
                        System.out.println("Ответ: " + year + "г високосный год");
                    }
                    else System.out.println("Ответ: " + year + "г не високосный год");
        }
    }


    public static float calcExpression (float a, float b, float c, float d)
    {
        return a*(b+(c/d));
    }

    public static boolean checkSumm (int a, int b)
    {
        return 10 <= (a + b) && (a + b) <= 20;
    }

    public static boolean checkValue (int a)
    {
        return a < 0;
    }

    public static void message(String a)
    {
        System.out.println("Ответ: " + "Привет, " + a + "!");
    }
}
