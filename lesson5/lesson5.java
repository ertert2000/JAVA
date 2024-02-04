//циклы
package lesson5;

public class lesson5 {
    
    public static void main(String[] args)
    {
        for (int i = 1; i<10; i++)
            System.out.println("Element: " + i);

        
        int a = 1;
        while (a <= 10) {
            System.out.println("Element: " + a);
            a++;
        }

        int b = 0;
        do{
            System.out.println(b);
            b++;
        } while(b<=10);
    }
}
