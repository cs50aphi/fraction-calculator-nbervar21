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
        return this(num, 1);
    }

    public Fraction()
    {
        return this(0, 1);
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
        int denom = denominator * other.getDenominator();
        int num = (numerator * other.getDenominator()) + (other.getNumerator() * denominator);
        return this(num, denom);
    }

    public Fraction subtract(Fraction other)
    {
        return this.add(this, other.multiply(-1));
    }

    public Fraction multiply(int scale)
    {
        return this(numerator * scale, denominator);
    }

    public Fraction multiply(Fraction other)
    {
        return this(numerator * other.getNumerator(), denominator * other.getDenominator());
    }

    public Fraction divide(int scale)
    {
        if (scale == 0)
        {
            throw new IllegalArgumentException("/ by 0");
        }
        return this(numerator, denominator * scale);
    }

    public void toLowestTerms()
    {
        return this.divide(Fraction.gcd(numerator, denominator));
    }

    public boolean equals(Fraction other)
    {
        return this.numerator == other.getNumerator() && this.denominator == other.getDenominator();
    }

    public static gcd(int num, int den)
    {
        num = Math.abs(num);
        den = Math.abs(den);

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