package com.company.lesson2;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {

        System.out.println("Задание №1 - заменить 1 на 0 в массиве вида {0,1,1,0,0,1,0,0,1,1,1,0}");
        int [] arrayTask1 = {0,1,1,0,0,1,0,0,1,1,1,0};
        invertArray(arrayTask1);
        for (int i : arrayTask1) System.out.print(arrayTask1[i]+" ");

        System.out.println("\nЗадание №2 - Задать пустой целочисленный массив размером 8. С помощью цикла заполнить его значениями 0 3 6 9 12 15 18 21");
        int[] arrayTask2 = new int[8];
        for (int i=0; i<arrayTask2.length; i++) {
            arrayTask2[i] += i*3;
            System.out.print(arrayTask2[i]+ " ");
        }

        System.out.println("\nЗадание №3 - Задать массив [ 1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1 ] пройти по нему циклом, и числа меньшие 6 умножить на 2");
        int[] arrayTask3 ={1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1};
        int valueChange =2;
        getChangeArray(arrayTask3,valueChange);
        for (int i : arrayTask3) System.out.print(arrayTask3[i]+" ");

        System.out.println("\nЗадание №4 - Создать квадратный двумерный целочисленный массив (количество строк и столбцов одинаковое), и с помощью цикла(-ов) заполнить его диагональные элементы единицами");
        int[][] arrayTask4 = new int[5][5];
        fooArray(arrayTask4);
        getChangeMatrix(arrayTask4);
        for (int[] ints : arrayTask4) {
            for (int anInt : ints) System.out.print(anInt + " ");
            System.out.println();
        }

        System.out.println("\nЗадание №5 - Задать одномерный массив и найти в нем минимальный и максимальный элементы");
        int[] arrayTask5 = new int[10];
        for (int i = 0; i<arrayTask5.length; i++)
        {
            arrayTask5[i]+=Math.random()*10;
            System.out.print(arrayTask5[i] + " ");
        }
        //System.out.println(Arrays.stream(arrTask5).min().getAsInt());
        //System.out.println(Arrays.stream(arrTask5).max().getAsInt());
        int max=arrayTask5[0],min=arrayTask5[0];
        for (int i=1; i< arrayTask5.length; i++)
        {
            if (max <= arrayTask5[i])
                max=arrayTask5[i];
            if (min >= arrayTask5[i])
                min=arrayTask5[i];
        }
        System.out.println("\nМаксимальное значение = " + max + " Минимальное значение = " + min);

        System.out.println("\nЗадание №6");
        int[] arrayTask6 ={1, 2, 2, 1, 5, 1};
        System.out.println(chechArrayOnSumm(arrayTask6));

        System.out.println("\nЗадание №7");
        int[] arrayTask7 ={1,2,3,4,5,6};
        int shift = -2;
        shiftArray(arrayTask7,shift);
        for (int j : arrayTask7) System.out.print(j + " ");

    }

    public static int[] invertArray (int[] array)
    {
        for (int i = 0; i < array.length; i++)
        {
            if (array[i]==0)
                array[i]=1;
            else
                array[i]=0;
        }
        return array;
    }

    public  static int[] getChangeArray (int[] array, int value)
    {
        for (int i =0; i<array.length; i++)
            if (array[i] < 6)
                array[i] = array[i] * value;
        return array;
    }

    public static int[][] fooArray (int[][] array) {
        for (int i =0; i<array.length; i++)
        {
            for (int j = 0; j<array[i].length; j++)
                array[i][j]+=Math.random()*10;
        }
        return array;
    }

    public static int[][] getChangeMatrix (int[][] array)
    {
        for (int i=0; i< array.length;i++)
            array[i][i]=1;
        return array;
    }

    public static boolean chechArrayOnSumm (int[] array)
    {
        int summL = 0, summR = 0 ;
        for (int i=0 ; i< array.length; i++)
        {
            summL+=array[i];
            for (int j=i+1; j<array.length; j++)
                summR+=array[j];
            if (summL==summR)
                return true;
            summR=0;
        }
        return false;
    }

    public static int[] shiftArray (int[] array, int shift)
    {
        int saveValue, mod = Math.abs(shift)%array.length;
        ArrayList<Integer> myArrayList = new ArrayList<>();
        for (int j : array) myArrayList.add(j);
        if (shift > 0)
        {
            for (int i=0; i<mod;i++)
                {
                    saveValue = myArrayList.get(0);
                    myArrayList.remove(0);
                    myArrayList.add(saveValue);
                }
        }
        else {
            for (int i=0; i<mod;i++)
            {
                saveValue = myArrayList.get(myArrayList.size()-1);
                myArrayList.remove(myArrayList.size()-1);
                myArrayList.add(0,saveValue);
            }
        }
        for (int i=0; i<array.length; i++) array[i] = myArrayList.get(i);
        return array;
    }
}
