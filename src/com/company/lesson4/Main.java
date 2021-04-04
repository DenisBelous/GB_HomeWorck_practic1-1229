package com.company.lesson4;

import java.util.Random;
import java.util.Scanner;

public class Main {

    public static char[][] MAP;
    public static final int SIZE_MAP = 3;
    public static final int DOT_TO_WIN = 3;
    public static final char DOT_EMPTY = '*';
    public static final char DOT_X = 'X';
    public static final char DOT_O = 'O';
    public static Scanner scanner = new Scanner(System.in);
    public static Random random = new Random();

    public static void main(String[] args) {

        initMAP();
        while (true){
            stepUser();
            if (isMapFll()) {
                System.out.println("Ничья!");
                break;
            }
            if (chechWin(DOT_X))
            {
                System.out.println("Выйграл хуман!");
                break;
            };
            stepAI();
            if (isMapFll()) {
                System.out.println("Ничья!");
                break;
            }
            if (chechWin(DOT_O))
            {
                System.out.println("Выйграла жестянка!");
                break;
            };
        }
        scanner.close();
    }

    private static boolean isMapFll() {
        for (int i = 0; i < MAP.length; i++) {
            for (int j = 0; j < MAP.length; j++) {
                if (MAP[i][j] == DOT_EMPTY) return false;
            }
        }
        return true;
    }

    private static boolean chechWin(char typePlayer) {
        return checkHorizontal(typePlayer) || checkVertical(typePlayer) || checkDiagonals(typePlayer);
    }

    private static boolean checkHorizontal(char typePlayer) {
        int count;
        for (int i = 0; i < MAP.length; i++) {
            count =0;
            for (int j = 0; j < MAP.length; j++)
                count += (MAP[i][j] == typePlayer) ? 1 : 0;
            if (count>2) return true;
        }
        return false;
    }

    private static boolean checkVertical(char typePlayer) {
        int count;
        for (int i = 0; i < MAP.length; i++) {
            count =0;
            for (int j = 0; j < MAP.length; j++)
                count += (MAP[j][i] == typePlayer) ? 1 : 0;

            if (count > 2) return true;
        }
        return false;
    }

    private static boolean checkDiagonals(char typePlayer) {
        int count =0;
        for (int i = 0; i < MAP.length; i++)
            count += (MAP[i][i] == typePlayer) ? 1 : 0;
        if (count>2) return true;
        count =0;
        for (int i = 0; i < MAP.length; i++)
            count += (MAP[MAP.length - i - 1][i] == typePlayer) ? 1 : 0;
        if (count>2) return true;
        return false;
    }

    private static void stepAI() {
        int x , y;
        System.out.println("Введите координаты вашей точки");
        do {
            x = random.nextInt(MAP.length);
            y = random.nextInt(MAP.length);
        } while (isNotValidDOT(x,y));
        MAP[y][x] = DOT_O;
        System.out.println("ИИ походил в точку X-> " + (x+1) + ", Y->" + (y+1) );
        printMAP();
    }

    public static void stepUser(){
        int x , y;
        System.out.println("Введите координаты вашей точки");
        do {
            System.out.println("Введите координаты X");
            x = scanner.nextInt()-1;
            System.out.println("Введите координаты Y");
            y = scanner.nextInt()-1;
        } while (isNotValidDOT(x,y));
        MAP[y][x] = DOT_X;
        printMAP();
    }

    private static boolean isNotValidDOT(int x, int y) {
        if (x < 0 || x > MAP.length-1 || y < 0 || y > MAP.length-1) return true;
        return MAP[y][x] != DOT_EMPTY;
    }

    private static void initMAP() {
        MAP = new char[SIZE_MAP][SIZE_MAP];
        for (int i = 0; i < MAP.length; i++) {
            for (int j = 0; j < MAP.length; j++) {
                MAP[i][j] = DOT_EMPTY;
            }
        }
        printMAP();
    }


    public static void printMAP () {
        for (int i = 0; i <= MAP.length; i++) {
            System.out.print(i + " ");
        }
        System.out.println();
        for (int i = 0; i < MAP.length; i++) {
            System.out.print((i + 1) + " ");
            for (int j = 0; j < MAP.length; j++) {
                System.out.print(MAP[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

}
