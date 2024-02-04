//условные опреаторы
package lesson4;

import java.util.Scanner;

public class lesson4 {
    
    public static void main(String[] args)
    {
        int a = 15, b = 10;
        if (a>b)
            System.out.println("Yes");
        
        boolean HC = false;
        if (HC)
            System.out.println("Ja");
        else 
            System.out.println("Nien");
        
        HC = true;
        if (HC)
            System.out.println("Ja");
        else if(a>b)
            System.out.println("second test");
        else 
            System.out.println("Nien");

        
        // практика

        Scanner scan = new Scanner(System.in);

        String role = scan.nextLine();
        String pass = scan.nextLine();

        if (role.equals("Admin") && pass.equals("1234")) //так не канает нужен не ==, а метод equalse
                System.out.println("Hello Admin");
        else
        {
            System.out.println("Hello, what is your name?");
            role = scan.nextLine();
        }

        
        int next = scan.nextInt();

        switch (next) {
            case 1:
                System.out.println("Number is one");
                break;
            case 2:
                System.out.println("Number is 2");
            default:
                break;
        }
        
        scan.close();
    }
}
