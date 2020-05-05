import java.util.*;

public class Fraction
{
    int numerator;
    int denominator;

    public Fraction(int num, int denom)
    {
        if (denom == 0)
        {
            throw new IllegalArgumentException("/ by 0");
        }
        else if (denom < 0)
        {
            num *= -1;
            denom *= -1;
        }
        numerator = num;
        denominator = denom;
    }

    public Fraction(int num)
    {
        this(num, 1);
    }

    public Fraction()
    {
        this(0, 1);
    }

    public int getNumerator()
    {
        return numerator;
    }

    public int getDenominator()
    {
        return denominator;
    }

    public String toString()
    {
        if (denominator == 1)
        {
            return Integer.toString(numerator);
        }
        return numerator + "/" + denominator;
    }

    public double toDouble()
    {
        return (double) numerator / denominator;
    }

    public Fraction add(Fraction other)
    {
        int num = (numerator * other.getDenominator()) + (other.getNumerator() * denominator);
        int denom = denominator * other.getDenominator();
        return new Fraction(num, denom);
    }

    public Fraction subtract(Fraction other)
    {
        return add(other.multiply(-1));
    }

    public Fraction multiply(int scale)
    {
        return new Fraction(numerator * scale, denominator);
    }

    public Fraction multiply(Fraction other)
    {
        return new Fraction(numerator * other.getNumerator(), denominator * other.getDenominator());
    }

    public Fraction divide(int scale)
    {
        if (scale == 0)
        {
            throw new IllegalArgumentException("/ by 0");
        }
        return new Fraction(numerator, denominator * scale);
    }

    public Fraction divide(Fraction other)
    {
        return new Fraction(numerator * other.getDenominator(), denominator * other.getNumerator());
    }

    public void toLowestTerms()
    {
        int gcd = Fraction.gcd(numerator, denominator);
        numerator /= gcd;
        denominator /= gcd;
    }

    public boolean equals(Object other)
    {
        if (other instanceof Fraction)
        {
            Fraction otherFraction = (Fraction) other;
            return this.numerator == otherFraction.getNumerator() && this.denominator == otherFraction.getDenominator();
        }
        return false;
    }

    public static int gcd(int num, int den)
    {
        num = Math.abs(num);

        int n = 1;
        for (int i = 1; i <= Math.min(num, den); i++)
        {
            if (num % i == 0 && den % i == 0)
            {
                n = i;
            }
        }

        return n;
    }
}