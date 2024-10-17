package com.proghelp;
import java.awt.*;
import javax.swing.*;
public class logic 
{
	
	private static JFrame addWindow;
	
    private static void saving(JTextField nameP, JTextField time, JTextField nameD)
    {
        Main.quant = Main.quant + 1;
        Object[][] newData = new String[Main.quant][3];
        for(int i = 0; i < Main.quant; i++){
            for(int j = 0; j < 3; j++){
                if (i == Main.quant - 1){
                    newData[i][0] = nameP.getText();
                    newData[i][1] = time.getText();
                    newData[i][2] = nameD.getText();
                    break;
                }
                else 
                    newData[i][j] = Main.data[i][j];
            }
        }

        Main.data = newData;
        Main.model.fireTableDataChanged();
        addWindow.
    }

	public static void b1Click()
	{
        addWindow = new JFrame("Добавление");
        addWindow.setResizable(false);
		addWindow.setSize(400, 200);
		addWindow.setLocation(600, 100);
		addWindow.getContentPane().setBackground(new java.awt.Color(90, 90, 90));
        
        
        JLabel lable1 = new JLabel("Имя пациента");
        lable1.setForeground(Color.WHITE);
        JLabel lable2 = new JLabel("Время");
        lable2.setForeground(Color.WHITE);
        JLabel lable3 = new JLabel("Имя врача");
        lable3.setForeground(Color.WHITE);
        JTextField nameP = new JTextField("");
        nameP.setPreferredSize(new Dimension(300, 25));
        nameP.setBackground(new java.awt.Color(169, 169, 169));
        nameP.setForeground(new java.awt.Color(69, 69, 69));
        nameP.setBorder(BorderFactory.createLineBorder(new java.awt.Color(69, 69, 69), 2));
        
        JTextField time = new JTextField("");
        time.setPreferredSize(new Dimension(300, 25));
        time.setBackground(new java.awt.Color(169, 169, 169));
        time.setForeground(new java.awt.Color(69, 69, 69));
        time.setBorder(BorderFactory.createLineBorder(new java.awt.Color(69, 69, 69), 2));
        
        JTextField nameD = new JTextField("");
        nameD.setPreferredSize(new Dimension(300, 25));
        nameD.setBackground(new java.awt.Color(169, 169, 169));
        nameD.setForeground(new java.awt.Color(69, 69, 69));
        nameD.setBorder(BorderFactory.createLineBorder(new java.awt.Color(69, 69, 69), 2));

        JButton save = new JButton("Сохранить");
        save.setPreferredSize(new Dimension(100, 30));
        save.setBackground(new java.awt.Color(169, 169, 169));
        save.setForeground(new java.awt.Color(69, 69, 69));
        save.setBorder(BorderFactory.createLineBorder(new java.awt.Color(69, 69, 69), 2));
        save.addActionListener(ae -> logic.saving(nameP, time, nameD));
        
        addWindow.setLayout(new GridLayout(4, 2));
        addWindow.add(lable1);
        addWindow.add(nameP);
        addWindow.add(lable2);
        addWindow.add(time);
        addWindow.add(lable3);
        addWindow.add(nameD);
        addWindow.add(save);

        
        
		addWindow.setVisible(true);
        //GridBagConstraints mainGrid = new GridBagConstraints();
	}
    /*GridLayoutDemo() { 
  
    // Creating Object P1 of JPanel class 
    JPanel p1 = new JPanel(); 
  
    // set the layout 
    p1.setLayout(new GridLayout(4, 2)); 
  
    // Creating Object of "FlowLayout" class 
    FlowLayout layout = new FlowLayout(); 
  
    // Creating Object P2 of JPanel class 
    JPanel p2 = new JPanel(); 
  
    // set the layout 
    p2.setLayout(layout); 
  
    // Declaration of objects of JLabel class. 
    JLabel one, two, three, four; 
  
    // Declaration of objects of JTextField class. 
    JTextField tname, tsalary, tcode, tdesig; 
  
    // Declaration of objects of JButton class. 
    JButton buttonSave, buttonExit; 
  
    // Initialization of object  
    // "one" of JLabel class. 
    one = new JLabel("NAME"); 
  
    // Initialization of object  
    // "tname" of JTextField class. 
    tname = new JTextField(20); 
  
    // Initialization of object 
    // "two" of JLabel class. 
    two = new JLabel("CODE"); 
  
    // Initialization of object  
    // "tcode" of JTextField class. 
    tcode = new JTextField(20); 
  
    // Initialization of object 
    // "three" of JLabel class. 
    three = new JLabel("DESIGNATION"); 
  
    // Initialization of object  
    // "tdesig" of JTextField class. 
    tdesig = new JTextField(20); 
  
    // Initialization of object 
    // "four" of JLabel class. 
    four = new JLabel("SALARY"); 
  
    // Initialization of object  
    // "tsalary" of JTextField class. 
    tsalary = new JTextField(20); 
  
    // Initialization of object 
    // "buttonsave" of JButton class. 
    buttonSave = new JButton("SAVE"); 
  
    // Initialization of object 
    // "buttonexit" of JButton class. 
    buttonExit = new JButton("EXIT"); 
  
    // Adding Jlabel "one" on JFrame. 
    p1.add(one); 
  
    // Adding JTextField "tname" on JFrame. 
    p1.add(tname); 
  
    // Adding Jlabel "two" on JFrame. 
    p1.add(two); 
  
    // Adding JTextField "tcode" on JFrame. 
    p1.add(tcode); 
  
    // Adding Jlabel "three" on JFrame. 
    p1.add(three); 
  
    // Adding JTextField "tdesig" on JFrame. 
    p1.add(tdesig); 
  
    // Adding Jlabel "four" on JFrame. 
    p1.add(four); 
  
    // Adding JTextField "tsalary" on JFrame. 
    p1.add(tsalary); 
  
    // Adding JButton "buttonsave" on JFrame. 
    p2.add(buttonSave); 
  
    // Adding JButton "buttonexit" on JFrame. 
    p2.add(buttonExit); 
  
    // add the p1 object which  
    // refer to the Jpanel 
    add(p1, "North"); 
  
    // add the p2 object which 
    // refer to the Jpanel 
    add(p2, "South"); 
  
    // Function to set visible 
    // status of JFrame. 
    setVisible(true); 
  
    // this Keyword refers to current 
    // object. Function to set size of JFrame. 
    this.setSize(400, 180); 
}  */
	
	public static void b2Click(){
		JOptionPane.showMessageDialog(Main.frame, "pizda");
	}
}
