//массивы
package lesson7;

import java.util.Scanner;

public class lesson7 {
    
    public static void main(String[] args)
    {
        int[] nums = new int[5]; //new выделение памяти

        nums[0] = 10;
        nums[1] = 11;
        nums[2] = 12;
        nums[3] = 13;
        nums[4] = 14;

        System.out.println(nums[0]);

        int res = nums[2]+nums[3];

        System.out.println(res);


        float[] nums2 = new float[] {5.2f, 22.8f, 164.365f};

        System.out.println(nums2[2] + "\n");

        for(int i = 0; i < nums2.length; i++)
        {
            System.out.println(nums2[i]);
        }

        /* не знаю нахуй, но практика */

        System.out.println();

        Scanner scan = new Scanner(System.in);
        int[] arr = new int[4];

        for(int i = 0; i < arr.length; i++)
        {
            System.out.println("enter number");
            arr[i] = scan.nextInt();
        }

        System.out.println();

        int min = 1000000000;

        for(int i = 0; i < arr.length; i++)
        {
            if(arr[i]<min)
            {
                min = arr[i];
            }
        }

        System.out.println(min + "\n");

        for(int i = 0; i < arr.length; i++)
        {
            System.out.println(arr[i]);
        }

        /* многомерный массив */

        char[][] ar = new char[2][2];
        for(int i = 0; i < ar.length; i++)
        {
            for(int j = 0; j < ar.length; j++)
            {
                ar[i][j] = scan.next().charAt(0);//ввод символа
            }
        }

        for(int i = 0; i < ar.length; i++)
        {
            for(int j = 0; j < ar.length; j++)
            {
                System.out.print(ar[i][j] + "\t");
            }
            System.out.println();
        }
        scan.close();
    }
}
