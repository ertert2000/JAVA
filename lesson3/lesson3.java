//ввод данных
package lesson3;

//подключения как include
import java.util.Scanner;

public class lesson3 {
    
    public static void main(String[] args)
    {
        Scanner scan = new Scanner(System.in); //создание объекта сканера
        
        System.out.print("enter your name");
        String userName = scan.nextLine(); //присвоение переменной, того что мы ввели

        System.out.println("Hello, " + userName);

        System.out.print("введите число:");
        int x = scan.nextInt(); //обратить внимание на next... в зависимоти от типа данных он будет отличаться то есть byte nextByte, boolean nextBoolean и т.д

        System.out.println("вы ввели: " + x);

        /*_________________ математические операции _________________*/

        int num = 50, num1 = 14, res;

        res = num + num1;
        System.out.println("результат: " + res);
        
        System.out.print("введите число:");
        int num3 = scan.nextInt();

        res = res + num3;

        System.out.println("результат: " + res);

        res+=10;

        System.out.println("прибавили 10: " + res);

        res++; //тоже работает)))

        System.out.println("прибавили 1: " + res);

        scan.close(); //закрытие сканера дабы избежать утечки памяти (VS Code ругается)
        
    }
}
