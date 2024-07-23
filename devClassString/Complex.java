package devClassString;

public class Complex 
{
    private double real;
    private double imaginary;

    private double absConplex;

    private double argComplex;

    public Complex(double r, double i)
    {
        real = r;
        imaginary = i;
    }

    public Complex()
    {
        real = 0;
        imaginary = 0;
    }

    public Complex(Complex sourse)
    {
        real = sourse.real;
        imaginary = sourse.imaginary;
    }

    public double getReal()
    {
        return real;
    }

    public double getImaginary()
    {
        return imaginary;
    }

    public double absConplex()
    {
        absConplex = Math.sqrt(Math.pow(real, 2) + Math.pow(imaginary, 2));

        return absConplex;
    }

    public double trigComplex()
    {
        argComplex = Math.atan((imaginary/real));
        return argComplex;
    }

    public Complex add(Complex other)
    {
        return new Complex(real + other.real, imaginary + other.imaginary);
    }

    public Complex minus(Complex other)
    {
        return new Complex(real - other.real, imaginary - other.imaginary);
    }

    public Complex multi(Complex other)
    {
        return new Complex(real * other.real + imaginary * other.imaginary * (-1), real * other.imaginary + imaginary * other.real);
    } // a + bi * c + di = a * c + a * di + bi * c + bi * di

    public Complex div(Complex other)
    {
        
        double tempImaginary = other.imaginary * (-1);
        Complex temp = new Complex(other.real, tempImaginary);

        Complex denominator = new Complex(multi(temp));
        Complex numerator = new Complex(other.multi(temp));

        return new Complex(denominator.real / numerator.rational(), denominator.imaginary / numerator.rational());
    }

    public String printComplex(int i)
    {
        String str = null;
        switch (i) 
        {   
            case 1:
                if(imaginary < 0)
                    str = String.format("%.2f%.2fi", real, imaginary);
                else
                    str = String.format("%.2f+%.2fi", real, imaginary);
            break;

            case 2:
                absConplex();
                trigComplex();
                str = String.format("%.2f(cos(%.2f)+isin(%.2f))", absConplex, argComplex, argComplex);
            break;

            case 3:
                absConplex();
                trigComplex();
                if (argComplex >= 0)
                    str = String.format("%.2f*e^(i*%.2f)",absConplex, argComplex);
                else
                    str = String.format("%.2f*e^(i*(%.2f))",absConplex, argComplex);
            break;
        }
        
        return str;
    }

    private double rational()
    {
        return real * (-1);
    }
}
