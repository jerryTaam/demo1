package com.example.demo.game;

import java.util.Scanner;

public class WellGame {
    public static void main(String[] args) {

        char[][] array = new char[3][3];

        showMap(array);

        int step = 0;

        int row, column;

        Scanner input = new Scanner(System.in);

        while (step < 5 || !isWin(array) && step < 9) {

            if (step % 2 == 0) //用奇偶来区别XO输入

            {

                System.out.print("Enter a row(0, 1, or 2) for player X:");

                row = input.nextInt();

                System.out.print("Enter a column(0, 1, or 2) for player X:");

                column = input.nextInt();

                array[row][column] = 'X';

                showMap(array);

            } else {

                System.out.print("Enter a row(0, 1, or 2) for player O:");

                row = input.nextInt();

                System.out.print("Enter a column(0, 1, or 2) for player O:");

                column = input.nextInt();

                array[row][column] = 'O';

                showMap(array);

            }

            step++;

        }

        if (step == 9) //平局

            System.out.println("The game ended in a draw");

    }

    public static boolean isWin(char[][] chess) {

        for (int i = 0; i < 3; i++) //行判断

        {

            boolean row = true;

            if (chess[i][0] == '\u0000')

                continue;

            for (int j = 1; j < 3; j++) {

                if (chess[i][j] != chess[i][0] || chess[i][j] == '\u0000') {

                    row = false;

                    break;

                }

            }

            if (row) {

                System.out.println(chess[i][0] + " player won");

                return true;

            }

        }

        for (int i = 0; i < 3; i++) //列判断

        {

            boolean column = true;

            if (chess[0][i] == '\u0000')

                continue;

            for (int j = 1; j < 3; j++) {

                if (chess[j][i] != chess[0][i] || chess[j][i] == '\u0000') {

                    column = false;

                    break;

                }

            }

            if (column) {

                System.out.println(chess[0][i] + " player won");

                return true;

            }

        }

        boolean mainDiagonal = true;

        boolean deputyDiagonal = true;

        for (int i = 0; i < 3; i++) {

            for (int j = 0; j < 3; j++) {

                if (mainDiagonal && i == j)//主对角线判断

                {

                    if (chess[i][j] == '\u0000' || chess[i][j] != chess[0][0])

                        mainDiagonal = false;

                }

                if (deputyDiagonal && i == 2 - j) //斜对角线判断

                {

                    if (chess[i][j] == '\u0000' || chess[i][j] != chess[0][2])

                        deputyDiagonal = false;

                }

            }

        }

        if (mainDiagonal) //主对角线连成直线

        {

            System.out.println(chess[0][0] + " player won");

            return true;

        }

        if (deputyDiagonal) //斜对角线连成直线

        {

            System.out.println(chess[0][2] + " player won");

            return true;

        }

        return false;

    }

    public static void showMap(char[][] map)//显示九个格

    {

        System.out.println("-------------");

        for (int i = 0; i < 3; i++) {

            System.out.print("|");

            for (int j = 0; j < 3; j++) {

                if (map[i][j] != '\u0000')

                    System.out.print(" " + map[i][j] + " |");

                else

                    System.out.print(" |");

            }

            System.out.println();

            System.out.println("-------------");

        }

    }
}
