package lesson2;

public class lesson2 {
    //переменные
    public static void main(String[] args)
    {
        int age;

        age = 18;
        System.out.println("возраст: " + age + ".");

        age = 45;
        System.out.println(age);

        //-127...127 используется один байт памяти
        byte weit = 127;
        byte weit2 = -127;
        System.out.println(weit2 + "..." + weit);

        //числа с плавающей запятой
        float x = 5.24578f; //f в конце обязательна
        double y = 4.21684; //по желанию можно писать d
        System.out.println(x + y);
        System.out.println(x + " " + y);
        System.out.print(x);
        System.out.println(y);
        String answer = String.format("%f, %f", x, y);
        System.out.println(answer); //сушествует printf() - синтаксис СИ

        //символы
        char ch = 'c';
        System.out.println(ch);

        //строки
        String userName = "Alex";
        System.out.println(userName);

        //логика
        boolean logic = true;
        if (logic != false)
            System.out.println("No");
        if (logic == true)
        {
            System.out.println("Yes");
        }
    }
}