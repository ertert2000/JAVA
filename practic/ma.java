package practic;

import java.util.Scanner;

public class ma {
    
    public static void main(String[] args)
    {
        Scanner scan = new Scanner(System.in);
        
        int x;
        
        System.out.print("введите целое число: ");
        x = scan.nextInt();

        if((x%2) == 0)
            System.out.println("число "+ x +" четное");
        else
            System.out.println("число "+ x +" не четное");

        scan.close();
    }
}
