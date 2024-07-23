package devClassString;

public class Main 
{
    public static void main(String[] args)
    {
        Complex com1 = new Complex(13, 1);
        Complex com2 = new Complex(7, 6);

        System.out.println(com1.div(com2).printComplex(1));
        System.out.println(com2.printComplex(1));
    }
}
