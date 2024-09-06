package lib.poject1;
import java.util.Scanner;

public class Main {

    final private static int size = 10;
    public static int[] sort(int[] arr)
    {
        int temp;

        for(int i = 0; i < size; i++)
            for(int j = 0; j < size - i - 1; j++)
                if(arr[j + 1] < arr[j])
                {
                    temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }

        return arr;
    } 

    public static void main(String[] args) 
    {
        Scanner scan = new Scanner(System.in);
        int arr[] = new int[size];

        System.out.println("Enter 10 numbers:");
        for (int i = 0; i < size; i++)
            arr[i] = scan.nextInt();

        sort(arr);

        System.out.println("\nResult:");

        for (int i = 0; i < size; i++)
            {
                if(i == 0)
                    System.out.print("[" + arr[i] + ", " );
                else if(i == size - 1)
                    System.out.print(arr[i] + "]" );
                else
                    System.out.print( + arr[i] + ", " );
            }

        scan.close();
            
    }
}