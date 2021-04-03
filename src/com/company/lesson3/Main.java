package com.company.lesson3;

import java.util.Random;
import java.util.Scanner;

public class Main {
    public static int userTrye = 3;
    public static final int rangeValue = 10;
    public static Random random = new Random();
    public static Scanner scanner = new Scanner(System.in);
    public static final int lengthBoard = 15;
    public static String[] words = {"apple",
                                    "orange",
                                    "lemon",
                                    "banana",
                                    "apricot",
                                    "avocado",
                                    "broccoli",
                                    "carrot",
                                    "cherry",
                                    "garlic",
                                    "grape",
                                    "melon",
                                    "leak",
                                    "kiwi",
                                    "mango",
                                    "mushroom",
                                    "nut",
                                    "olive",
                                    "pea",
                                    "peanut",
                                    "pear",
                                    "pepper",
                                    "pineapple",
                                    "pumpkin",
                                    "potato"};


    public static void main(String[] args) {

        System.out.println("1. Угадайка1 - угадать число \n2. Угадайка2 - угадать слово\nВыберете игру: ");
        switch (scanner.nextInt())
        {
            case 1:
                do {
                } while (guessNumber());
                break;
            case 2:
                do {
                } while (guessWords());
                break;
        }

    }

    private static boolean guessWords() {

        String randomWordFromArray = words[random.nextInt(words.length)];
        System.out.println(randomWordFromArray);
        String userWord;
        boolean nextTrye;
        do {
            System.out.print("Введите слово: ");
            userWord = scanner.next().toLowerCase();
            StringBuilder answer = new StringBuilder();
            int i = Math.min(randomWordFromArray.length(), userWord.length());
            for (int j = 0 ; j < lengthBoard; j++)
            {
                if (j < i)
                {
                    if (randomWordFromArray.charAt(j) == userWord.charAt(j))
                        answer.append(randomWordFromArray.charAt(j));
                    else answer.append("#");
                } else answer.append("#");
            }
            if (!randomWordFromArray.equals(userWord))
                System.out.println("Вы не угадали =( Совпадающие буквы: " + answer);

            System.out.print("Хотите продолжить отгадывать? Y/N ");
            nextTrye = scanner.next().equalsIgnoreCase("y");
        } while (nextTrye);

        System.out.print("Хотите продолжить? Y/N ");
        return scanner.next().equalsIgnoreCase("y");
    }

    private static boolean guessNumber() {

        System.out.println("Игра Угадайка. \nМы загадали случайное число от 0 до 9! Попытайтесь отгадать за 3 попытки. Удачи=)");
        int randomValue = random.nextInt(rangeValue);
        int getScanerValue = 0;
        while (userTrye>0)
        {
            System.out.print("Введите число: ");
            getScanerValue = scanner.nextInt();
            if (getScanerValue > randomValue)
                System.out.println("Введенное значение больше загаданного, " + "осталось попыток " + userTrye);
            else if (getScanerValue < randomValue)
                    System.out.println("Введенное значение меньше загаданного, " + "осталось попыток " + userTrye);
                else
                    {
                        System.out.println("Вы угадали!");
                        break;
                    }
            userTrye--;
        }
        System.out.print("Было загадано "+ getScanerValue + " Хотите продолжить? Y/N ");
        return scanner.next().equalsIgnoreCase("y");
    }
}
