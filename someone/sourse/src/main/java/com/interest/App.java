
package com.interest;

import java.awt.*;

import javax.imageio.ImageIO;
import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.filechooser.FileSystemView;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.List;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;


public class App extends JFrame implements KeyListener
{
    
    public static JFrame frame = new JFrame("Tic Tac Toe");
    
    public static JButton button1, button2, button3, button4, button5, button6, button7, button8, button9, buttonGame, buttonMultiGame, buttonSettings;
    
    private static boolean isSettings = false;

    private static CardLayout cardLayout;
    private static JPanel mainPanel;
    private static JPanel gamePanel;
    private static JPanel settingsPanel;
    private static JPanel settingsCustomizable;
    private static JSlider sliderVolume;
    private static JLabel header;

    //Colors
    private static String net = "#16354D", button_main = "#6B99C3";

    public App() throws IOException
    {
        //
        
        
        // LOGO
        frame.setIconImage(ImageIO.read(new File("F:\\work\\JAVA\\someone\\sourse\\src\\resources\\Logo.png")));


        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500, 500);
    
        frame.setLocationRelativeTo(null);
        frame.addKeyListener(this);
        frame.setFocusable(true);
        frame.requestFocusInWindow();

        cardLayout = new CardLayout();
        mainPanel = new JPanel(cardLayout);
        mainPanel.addKeyListener(this);
        mainPanel.setFocusable(true);
        mainPanel.requestFocusInWindow();

        gamePanel = new JPanel(new GridLayout(3, 3, 15, 15));
        gamePanel.setBackground(Color.decode(net)); // COLOR OF NET
        gamePanel.addKeyListener(this);
        gamePanel.setFocusable(true);
        gamePanel.requestFocusInWindow();

        button1 = new JButton();
        button1.setBackground(Color.decode(button_main)); // COLOR OF BUTTONS (SAME AS BACKGROUND)
        button1.addKeyListener(this);
        button1.setFocusable(true);
        button1.requestFocusInWindow();

        button2 = new JButton();
        button2.setBackground(Color.decode(button_main));
        button2.addKeyListener(this);
        button2.setFocusable(true);
        button2.requestFocusInWindow();

        button3 = new JButton();
        button3.setBackground(Color.decode(button_main));
        button3.addKeyListener(this);
        button3.setFocusable(true);
        button3.requestFocusInWindow();

        button4 = new JButton();
        button4.setBackground(Color.decode(button_main));
        button4.addKeyListener(this);
        button4.setFocusable(true);
        button4.requestFocusInWindow();

        button5 = new JButton();
        button5.setBackground(Color.decode(button_main));
        button5.addKeyListener(this);
        button5.setFocusable(true);
        button5.requestFocusInWindow();

        button6 = new JButton();
        button6.setBackground(Color.decode(button_main));
        button6.addKeyListener(this);
        button6.setFocusable(true);
        button6.requestFocusInWindow();

        button7 = new JButton();
        button7.setBackground(Color.decode(button_main));
        button7.addKeyListener(this);
        button7.setFocusable(true);
        button7.requestFocusInWindow();

        button8 = new JButton();
        button8.setBackground(Color.decode(button_main));
        button8.addKeyListener(this);
        button8.setFocusable(true);
        button8.requestFocusInWindow();

        button9 = new JButton();
        button9.setBackground(Color.decode(button_main));
        button9.addKeyListener(this);
        button9.setFocusable(true);
        button9.requestFocusInWindow();

        gamePanel.add(button1);
        gamePanel.add(button2);
        gamePanel.add(button3);
        gamePanel.add(button4);
        gamePanel.add(button5);
        gamePanel.add(button6);
        gamePanel.add(button7);
        gamePanel.add(button8);
        gamePanel.add(button9);
        
        settingsPanel = new JPanel();
        settingsPanel.setLayout(new BoxLayout(settingsPanel, BoxLayout.Y_AXIS));
        
        button1.addActionListener(ae -> logicGame.logicButton(button1, 0, 0));
        button2.addActionListener(ae -> logicGame.logicButton(button2, 0, 1));
        button3.addActionListener(ae -> logicGame.logicButton(button3, 0, 2));
        button4.addActionListener(ae -> logicGame.logicButton(button4, 1, 0));
        button5.addActionListener(ae -> logicGame.logicButton(button5, 1, 1));
        button6.addActionListener(ae -> logicGame.logicButton(button6, 1, 2));
        button7.addActionListener(ae -> logicGame.logicButton(button7, 2, 0));
        button8.addActionListener(ae -> logicGame.logicButton(button8, 2, 1));
        button9.addActionListener(ae -> logicGame.logicButton(button9, 2, 2));
        
        toolsSettingsPanel();
        buttonGame.addKeyListener(this);
        buttonGame.setFocusable(true);
        buttonGame.requestFocusInWindow();
        buttonMultiGame.addKeyListener(this);
        buttonMultiGame.setFocusable(true);
        buttonMultiGame.requestFocusInWindow();
        buttonSettings.addKeyListener(this);
        buttonSettings.setFocusable(true);
        buttonSettings.requestFocusInWindow();
        
        settingsCustomizable = new JPanel();
        settingsCustomizable.setLayout(new BoxLayout(settingsCustomizable, BoxLayout.Y_AXIS));

        mainPanel.add(gamePanel, "GAME_PANEL");
        mainPanel.add(settingsPanel, "SETTINGS_PANEL");
        mainPanel.add(settingsCustomizable, "SETTINGS_CUSTOMIZABLE");

        
        
        frame.add(mainPanel);
        frame.setVisible(true);
    }
    
    
    private static void toolsSettingsPanel() 
    {
        buttonGame = new JButton("Play");
        buttonMultiGame = new JButton("Multiplay");
        buttonSettings = new JButton("Settings");
        header = new JLabel("Main Menu");
        
        // Set preferred sizes
        buttonGame.setPreferredSize(new Dimension(300, 50));
        buttonMultiGame.setPreferredSize(new Dimension(100, 50));
        buttonSettings.setPreferredSize(new Dimension(300, 50));
        header.setPreferredSize(new Dimension(300, 50));
        header.setFont(new Font("Main Menu", Font.PLAIN, 50));
        header.setForeground(Color.decode(button_main)); // COLOR OF ?TEXT? (SAME AS BACKGROUND)
        buttonGame.setBackground(Color.decode(button_main));
        buttonMultiGame.setBackground(Color.decode(button_main));
        buttonSettings.setBackground(Color.decode(button_main));
        header.setBackground(Color.decode(button_main));
        settingsPanel.setBackground(Color.decode(net));

        buttonGame.addActionListener(ae -> actionPlay());

        buttonMultiGame.addActionListener(ae -> actionMultiGame());

        buttonSettings.addActionListener(ae -> actionSettings());
        
        // Set layout
        settingsPanel.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        
        // Add header
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 2;
        gbc.insets = new Insets(10, 10, 10, 10); // Add padding around the header
        gbc.anchor = GridBagConstraints.CENTER;
        settingsPanel.add(header, gbc);
        
        // Add buttonGame
        gbc.gridy = 1;
        gbc.gridwidth = 1;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        settingsPanel.add(buttonGame, gbc);
        
        // Add rigid area for spacing
        gbc.gridy = 2;
        gbc.insets = new Insets(10, 0, 10, 0);
        settingsPanel.add(Box.createRigidArea(new Dimension(0, 10)), gbc);
        
        // Add buttonMultiGame
        gbc.gridy = 3;
        settingsPanel.add(buttonMultiGame, gbc);
        
        // Add rigid area for spacing
        gbc.gridy = 4;
        settingsPanel.add(Box.createRigidArea(new Dimension(0, 20)), gbc);
        
        // Add buttonSettings
        gbc.gridy = 5;
        settingsPanel.add(buttonSettings, gbc);
        
        // Invalidate and revalidate the panel to ensure proper layout
        settingsPanel.invalidate();
        settingsPanel.revalidate();
        settingsPanel.repaint();
    }

    private static void openFileChooser() throws ClassNotFoundException, InstantiationException, IllegalAccessException, UnsupportedLookAndFeelException
    {

        
        JFileChooser pickMusic = new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory());
        



        int r = pickMusic.showOpenDialog(null);
        
        pickMusic.setFileSelectionMode(JFileChooser.FILES_ONLY);

        if (r == JFileChooser.APPROVE_OPTION)
        {
            Music.setFilePath(pickMusic.getSelectedFile().getAbsolutePath());
        }

        new Thread(new Runnable() {
            public void run()
                {
                    Music.playMusic();
                }
        }).start();
    }

    public static List<Component> getAllComponents(final Container c) {
        Component[] comps = c.getComponents();
        List<Component> compList = new ArrayList<Component>();
        for (Component comp : comps) {
            compList.add(comp);
            if (comp instanceof Container)
                compList.addAll(getAllComponents((Container) comp));
        }
        return compList;
    }

    private static void SettingsApplication()
    {
        // Music
        /* 
        * Выбор файла
        */
        
        JButton pick = new JButton("Pick");
        pick.addActionListener(ae -> {
            try {
                openFileChooser();
            } catch (ClassNotFoundException | InstantiationException | IllegalAccessException
                    | UnsupportedLookAndFeelException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        });
        
        String[] choices = {"Purple Sunset", "Rose dawn", "Blue Lagoon", "Green Forest"};
        JComboBox<String> list = new JComboBox<String>(choices);

        ImageIcon icon = new ImageIcon("F:\\work\\JAVA\\someone\\sourse\\src\\resources\\back.png");

        JButton exit = new JButton();
        exit.setIcon(icon);
        exit.addActionListener(ae ->{
            cardLayout.show(mainPanel, "SETTINGS_PANEL");
            settingsCustomizable.remove(pick);
            settingsCustomizable.remove(sliderVolume);
            settingsCustomizable.remove(list);
            settingsCustomizable.remove(exit);
        });
        
        // Volume of music
        /*
        * Ползунок (-... , 6)
        */

        sliderVolume = new JSlider(-60,6);

        sliderVolume.setOrientation(JSlider.VERTICAL);


        sliderVolume.addChangeListener(new ChangeListener() 
        {
            @Override
            public void stateChanged(ChangeEvent e) 
            {
                // меняем надпись
                int value = ((JSlider)e.getSource()).getValue();
                Music.setVolume(value);
            }
        });
        // Themes
        /*
        * Выпадающее меню
        * Custom color - юзер сам вписывает свои цвета
        */

        
        ActionListener actionListener = new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String item = (String)list.getSelectedItem();
                
                if(item.equals("Purple Sunset"))
                {
                    //https://color.romanuke.com/czvetovaya-palitra-4537/
                    net = "#453C41";
                    button_main = "#7B586B";
                    changeColors();
                }
                if(item.equals("Rose dawn"))
                {
                    //https://color.romanuke.com/czvetovaya-palitra-4497/
                    net = "#1C252C";
                    button_main = "#E1D5D9";
                    changeColors();
                }
                if(item.equals("Blue Lagoon"))
                {
                    //https://color.romanuke.com/czvetovaya-palitra-4542/
                    net = "#16354D";
                    button_main = "#6B99C3";
                    changeColors();   
                }
                if(item.equals("Green Forest"))
                {
                    //https://color.romanuke.com/czvetovaya-palitra-4573/
                    net = "#344C11";
                    button_main = "#AEC670";
                    changeColors(); 
                    
                }
            }
        };
        list.addActionListener(actionListener);
        list.setMaximumSize(list.getPreferredSize());
        list.setAlignmentX(Component.CENTER_ALIGNMENT);

        //settingsCustomizable.add(pick, BorderLayout.WEST);
        settingsCustomizable.add(sliderVolume);
        //settingsCustomizable.add(list, BorderLayout.SOUTH);
        //settingsCustomizable.add(exit);
    }
    
    //server
    private static void actionPlay()
    {
        cardLayout.show(mainPanel, "GAME_PANEL");
        isSettings = false;
    }

    private static void actionSettings()
    {
        cardLayout.show(mainPanel, "SETTINGS_CUSTOMIZABLE");
        SettingsApplication();
    }
    
    private static void changeColors()
    {
        //Main
        gamePanel.setBackground(Color.decode(net));
        settingsPanel.setBackground(Color.decode(net));

        //Secondary
        button1.setBackground(Color.decode(button_main));
        button2.setBackground(Color.decode(button_main));
        button3.setBackground(Color.decode(button_main));
        button4.setBackground(Color.decode(button_main));
        button5.setBackground(Color.decode(button_main));
        button6.setBackground(Color.decode(button_main));
        button7.setBackground(Color.decode(button_main));
        button8.setBackground(Color.decode(button_main));
        button9.setBackground(Color.decode(button_main));
        header.setForeground(Color.decode(button_main)); 
        buttonGame.setBackground(Color.decode(button_main));
        buttonMultiGame.setBackground(Color.decode(button_main));
        buttonSettings.setBackground(Color.decode(button_main));
        header.setBackground(Color.decode(button_main));
    }
    
    private static void actionMultiGame() //ловушка насмерть
    {
        new Thread(new Runnable() {
            public void run()
            {
                HttpServer serr = new HttpServer();
                try 
                {
                    serr.startServer();
                } 
                catch (Throwable t) 
                {
                    t.printStackTrace();
                }
            }
            
        }).start();
        
    }
    
    @Override
    public void keyTyped(KeyEvent e) {}
    
    @Override
    public void keyReleased(KeyEvent e) {}
    
    //client
    @Override
    public void keyPressed(KeyEvent e)
    {
        if (e.getKeyCode() == KeyEvent.VK_ESCAPE)
        {
            System.out.println("ya");
            if(isSettings == false)
            {
                cardLayout.show(mainPanel, "SETTINGS_PANEL");
                isSettings = true;
            }
            else
            {
                cardLayout.show(mainPanel, "GAME_PANEL");
                isSettings = false;
            }
        }
    }
    
    public static void main(String[] args) throws IOException
    {
        new App();
        cardLayout.show(mainPanel, "SETTINGS_PANEL");
        System.out.println(Music.getMaxVolume());
        
    }
    
}

/*TODO
2) Отловка ESC + настройки (лайтовые) (1, 0.8)
3) Клиент + сервер (0, 0.2)
4) Темы (кастом) + музыка (каастом) (1 (хуево сделанный), 1)
5) Анимации (палочка победителя) (0)
*/


/*
* сервер должен обрабатывать запросы в формате 
* "эей, сервер, я нажал на кнопку (button1)" -> 
* "принял кнопку, смотрю count если ноль или чентное то х, иначе о. Далее проверяю выигрыш если победа отправляю \\
* клиенту 1 ты выиграл, клиенту 2 нарисуй тут иконку и ты проиграл. после нажатием клиентами 1 и 2 ок отправляю команду сброса иконок\\
* а сам привожу показатели в исходное состояние. Если выигрыша нет отправляю клиенту 1 и 2 рисуйте иконку и жду ответа и блокирую соеденение с клиентом 1" ->
* "Получил ответ, жду второго игрока"
* 
* протокол будем использовать TCP, встроенные библиотеки import java.io.IOException; import java.net.ServerSocket; import java.net.Socket; (может еще чтото)
* 
 */

 /* */