import java.util.*;

public class FractionCalculator
{
    public static void main(String[] args)
    {
        System.out.println("\nWelcome to the Fraction Calculator!\nIt will add, subtract, multiply, and divide fractions until you type Q to quit.\nPlease enter your fractions in the form a/b where a and b are both integers.\n\n-------------------------------\n");
        Scanner kb = new Scanner(System.in);
        while (true)
        {
            char op = getOperation(kb);
            if (op == 'q')
            {
                break;
            }
            Fraction a = getFraction(kb);
            Fraction b = getFraction(kb);
            Fraction result;
            switch (op)
            {
                default:
                    result = a.add(b);
                    break;

                case '-':
                    result = a.subtract(b);
                    break;

                case '*':
                    result = a.multiply(b);
                    break;

                case '/':
                    result = a.divide(b);
                    break;
            }
            result.toLowestTerms();
            System.out.println(a.toString() + " " + op + " " + b.toString() + " is " + result.toString());
        }
        System.out.println("\nGoodbye!");
    }

    static boolean isNumber(String str)
    {
        try
        {
            int n = Integer.parseInt(str);
        }
        catch (NumberFormatException e)
        {
            return false;
        }
        return true;
    }

    static boolean isFraction(String input)
    {
        if (isNumber(input))
        {
            return true;
        }
        String[] split = input.split("/", 2);
        return split.length > 1 && isNumber(split[0] + split[1]) && Integer.parseInt(split[1]) != 0;
    }

    static boolean isOperation(String input)
    {
        if (input.length() != 1)
        {
            return false;
        }
        char[] ops = {'+', '-', '*', '/', 'q'};
        char first = input.toLowerCase().charAt(0);
        for (char op : ops)
        {
            if (first == op)
            {
                return true;
            }
        }
        return false;
    }

    static char getOperation(Scanner kb)
    {
        System.out.print("Please enter an operation (+, -, *, /, = or Q to Quit): ");
        String input = kb.nextLine();
        while (!isOperation(input))
        {
            System.out.print("Invalid input (+, -, *, /, = or Q to Quit): ");
            input = kb.nextLine();
        }
        return input.toLowerCase().charAt(0);
    }

    static Fraction getFraction(Scanner kb)
    {
        System.out.print("Please enter a fraction (a/b) or integer (a): ");
        String input = kb.nextLine();
        while (!isFraction(input))
        {
            System.out.print("Invalid fraction. Please enter (a/b) or (a) where a and b are integers and b is not zero: ");
            input = kb.nextLine();
        }
        String[] split = input.split("/");
        if (split.length > 1)
        {
            return new Fraction(Integer.parseInt(split[0]), Integer.parseInt(split[1]));
        }
        else
        {
            return new Fraction(Integer.parseInt(split[0]));
        }
    }
}