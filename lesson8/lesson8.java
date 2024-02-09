//коллекции
package lesson8;

import java.util.ArrayList;
import java.util.LinkedList;

public class lesson8 {
    
    public static void main(String[] args)
    {
        ArrayList<Integer> numders = new ArrayList<>();//динамический массив

        numders.add(5);
        numders.add(50);
        numders.add(1,30);

        System.out.println(numders.size());//размер
        System.out.println(numders.get(2));//получение элементов
        numders.remove(1);// удаление элемента


        for(Integer i : numders) //ебать сократили
        {
            System.out.println(i);
        }
        for(int i = 0; i < numders.size();i++) //муторно, но можно
        {
            System.out.println(numders.get(i));
        }

        numders.clear();//удалениве всего массива


        LinkedList<Float> num = new LinkedList<>();//привязывает элементы массива друго к другу для вставки/удаления

        num.add(6.2547f);
        num.add(254.47f);
        num.add(7.257f);

        for(Float i : num)
        System.out.println(i);
    }
}
