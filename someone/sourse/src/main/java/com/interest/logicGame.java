package com.interest;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

class logicGame
{
    private static ImageIcon iconX = new ImageIcon("F:\\work\\JAVA\\someone\\sourse\\src\\resources\\x.png");
    private static ImageIcon icony = new ImageIcon("F:\\work\\JAVA\\someone\\sourse\\src\\resources\\o.png");


    private static boolean arr[][] = new boolean[3][3];
    private static byte field[][] = new byte[3][3];

    private static int count;

    public static void logicButton(JButton button, int x, int y)
    {
        if(arr[x][y] == false)
        {
            button.setIcon((count % 2 == 0) ? iconX : icony);
            field[x][y] = (byte) ((count % 2 == 0) ? 1 : 2);
            count++;
            arr[x][y] = true;
        }
        else
        {
            // "может понадобиться"
        }
        check_win();
    }
    
    public static void check_win()
    {
        for (int i = 0; i < 3; i++)
            for (int j = 1; j == 1 || j == 2; j++)
            {
                if ((field[i][0] == field[i][1] && field[i][1] == field[i][2]) && field [i][0] == j)
                    resetGame(j);
                if ((field[0][i] == field[1][i] && field[1][i] == field[2][i]) && field [0][i] == j)
                    resetGame(j);
                if ((field[0][0] == field[1][1] && field[1][1] == field[2][2]) && field [0][0] == j)
                    resetGame(j);
                if ((field[0][2] == field[1][1] && field[1][1] == field[2][0]) && field [0][2] == j)
                    resetGame(j);
            }

        if (count == 9)
            resetGame(3);
    }
        
        //server
        public static void resetGame(int choise)
        {
            //client
            switch (choise)
            {
                case 1:
                JOptionPane.showMessageDialog(App.frame, "Выиграли крестики!");
                break;
                case 2:
                JOptionPane.showMessageDialog(App.frame, "Выиграли нолики!");
                break;
                case 3:
                JOptionPane.showMessageDialog(App.frame, "Боевая ничья!");
                default:
                break;
            }
            //end
            
            count = 0;

            for(int i = 0; i<3; i++)
                for(int j = 0; j<3; j++)
                    {
                        field[i][j] = 0;
                        arr[i][j] = false;
                    }
                
                App.button1.setIcon(null);
                App.button2.setIcon(null);
                App.button3.setIcon(null);
                App.button4.setIcon(null);
                App.button5.setIcon(null);
                App.button6.setIcon(null);
                App.button7.setIcon(null);
                App.button8.setIcon(null);
                App.button9.setIcon(null);
                
                
        }

}

