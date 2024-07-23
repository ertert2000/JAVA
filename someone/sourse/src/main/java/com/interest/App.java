package com.interest;

import java.awt.*;
import javax.swing.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Scanner;


public class App extends JFrame implements KeyListener
{

    public static JFrame frame = new JFrame();
    private static ImageIcon iconX = new ImageIcon("F:\\work\\JAVA\\someone\\sourse\\src\\resources\\x.png");
    private static ImageIcon icony = new ImageIcon("F:\\work\\JAVA\\someone\\sourse\\src\\resources\\o.png");
    
    private static JButton button1, button2, button3, button4, button5, button6, button7, button8, button9;

    private static int count;

    private static byte field[][] = new byte[3][3]; 
    
   

    public App()
    {
        
        new Thread(new Runnable() {
            public void run()
                {
                    
                    Music.playMusic();
                }
        }).start();
        
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500, 500);
        frame.setLayout(new GridLayout(3, 3, 15, 15));
        frame.getContentPane().setBackground(Color.decode("#16354D"));
        frame.setLocationRelativeTo(null);
        frame.addKeyListener(this);

        frame.setFocusable(true);

        button1 = new JButton();
        button1.setBackground(Color.decode("#6B99C3"));

        button2 = new JButton();
        button2.setBackground(Color.decode("#6B99C3"));

        button3 = new JButton();
        button3.setBackground(Color.decode("#6B99C3"));

        button4 = new JButton();
        button4.setBackground(Color.decode("#6B99C3"));

        button5 = new JButton();
        button5.setBackground(Color.decode("#6B99C3"));

        button6 = new JButton();
        button6.setBackground(Color.decode("#6B99C3"));
        
        button7 = new JButton();
        button7.setBackground(Color.decode("#6B99C3"));
        
        button8 = new JButton();
        button8.setBackground(Color.decode("#6B99C3"));

        button9 = new JButton();
        button9.setBackground(Color.decode("#6B99C3"));

        frame.add(button1);
        frame.add(button2);
        frame.add(button3);
        frame.add(button4);
        frame.add(button5);
        frame.add(button6);
        frame.add(button7);
        frame.add(button8);
        frame.add(button9);
        
        button1.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent ae) 
            {
                button1.setIcon((count % 2 == 0) ? iconX : icony);
                field[0][0] = (byte) ((count % 2 == 0) ? 1 : 2);
                count++; 
                check_win();
            }
        });
        button2.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent ae) 
            {
                button2.setIcon((count % 2 == 0) ? iconX : icony);
                field[0][1] = (byte) ((count % 2 == 0) ? 1 : 2);
                count++;
                check_win();
            }
        });
        button3.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent ae) 
            {
                button3.setIcon((count % 2 == 0) ? iconX : icony);
                field[0][2] = (byte) ((count % 2 == 0) ? 1 : 2);
                count++;
                check_win();
            }
        });
        button4.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent ae) 
            {
                button4.setIcon((count % 2 == 0) ? iconX : icony);
                field[1][0] = (byte) ((count % 2 == 0) ? 1 : 2);
                count++;
                check_win();
            }
        });
        button5.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent ae) 
            {
                button5.setIcon((count % 2 == 0) ? iconX : icony);
                field[1][1] = (byte) ((count % 2 == 0) ? 1 : 2);
                count++;
                check_win();
            }
        });
        button6.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent ae) 
            {
                button6.setIcon((count % 2 == 0) ? iconX : icony);
                field[1][2] = (byte) ((count % 2 == 0) ? 1 : 2);
                count++;
                check_win();
            }
        });
        button7.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent ae) 
            {
                button7.setIcon((count % 2 == 0) ? iconX : icony);
                field[2][0] = (byte) ((count % 2 == 0) ? 1 : 2);
                count++;
                check_win();
            }
        });
        button8.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent ae) 
            {
                button8.setIcon((count % 2 == 0) ? iconX : icony);
                field[2][1] = (byte) ((count % 2 == 0) ? 1 : 2);
                count++;
                check_win();
            }
        });
        button9.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent ae) 
            {
                button9.setIcon((count % 2 == 0) ? iconX : icony);
                field[2][2] = (byte) ((count % 2 == 0) ? 1 : 2);
                count++;
                check_win();
            }
        });
        
        frame.setVisible(true);
    }
    public static void main(String[] args)
    {
        new App();
    }


    public static void check_win()
    {
        if ((field[0][0] == field[0][1] && field[0][1] == field[0][2]) && field [0][0] == 1) 
            resetGame(1);
        if ((field[0][0] == field[0][1] && field[0][1] == field[0][2]) && field [0][0] == 2) 
            resetGame(2);
        
        if ((field[1][0] == field[1][1] && field[1][1] == field[1][2]) && field [1][0] == 1)
            resetGame(1);
        if ((field[1][0] == field[1][1] && field[1][1] == field[1][2]) && field [1][0] == 2)
            resetGame(2);
        
        if ((field[2][0] == field[2][1] && field[2][1] == field[2][2]) && field [2][0] == 1)
            resetGame(1);
        if ((field[2][0] == field[2][1] && field[2][1] == field[2][2]) && field [2][0] == 2)
            resetGame(2);
        
        if ((field[0][0] == field[1][0] && field[1][0] == field[2][0]) && field [0][0] == 1)
            resetGame(1);
        if ((field[0][0] == field[1][0] && field[1][0] == field[2][0]) && field [0][0] == 2)
            resetGame(2);
       
        if ((field[0][1] == field[1][1] && field[1][1] == field[2][1]) && field [0][1] == 1)
            resetGame(1);
        if ((field[0][1] == field[1][1] && field[1][1] == field[2][1]) && field [0][1] == 2)
            resetGame(2);
      
        if ((field[0][2] == field[1][2] && field[1][2] == field[2][2]) && field [0][2] == 1)
            resetGame(1);
        if ((field[0][2] == field[1][2] && field[1][2] == field[2][2]) && field [0][2] == 2)
            resetGame(2);
        
        if ((field[0][0] == field[1][1] && field[1][1] == field[2][2]) && field [0][0] == 1)
            resetGame(1);
        if ((field[0][0] == field[1][1] && field[1][1] == field[2][2]) && field [0][0] == 2)
            resetGame(2);
        
        if ((field[0][2] == field[1][1] && field[1][1] == field[2][0]) && field [0][2] == 1)
            resetGame(1);
        if ((field[0][2] == field[1][1] && field[1][1] == field[2][0]) && field [0][2] == 2)
            resetGame(2); 
        if (count == 9)
            resetGame(3);

    }

    public static void resetGame(int choise)
    {
        switch (choise) 
        {
            case 1:
                JOptionPane.showMessageDialog(frame, "Выиграли крестики!");
            break;
            case 2:
                JOptionPane.showMessageDialog(frame, "Выиграли нолики!");
            break;
            case 3:
                JOptionPane.showMessageDialog(frame, "Боевая ничья!");
            default:
                break;
        }

        count = 0;

        for(int i = 0; i<3; i++)
            for(int j = 0; j<3; j++)
                field[i][j] = 0;

        button1.setIcon(null);
        button2.setIcon(null);
        button3.setIcon(null);
        button4.setIcon(null);
        button5.setIcon(null);
        button6.setIcon(null);
        button7.setIcon(null);
        button8.setIcon(null);
        button9.setIcon(null);
    }
    @Override
    public void keyTyped(KeyEvent e) {

    }
    @Override
    public void keyReleased(KeyEvent e) {

    }
    // @Override
    // public void keyPressed(KeyEvent e)
    // {
    //     if (e.getKeyCode()==KeyEvent.VK_ESCAPE)
    //         System.out.println("EC");
    // }
    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode()==KeyEvent.VK_0)
            JOptionPane.showMessageDialog(frame, "Выиграли нолики!");
    }
}

// TODO
// 1) Фикс бага с накликом на одно место
// 2) Отловка ESC + настройки (лайтовые)
// 3) Клиент + сервер
// 4) Темы (кастом) + музыка (каастом) 
// 5) Анимации (палочка победителя)


