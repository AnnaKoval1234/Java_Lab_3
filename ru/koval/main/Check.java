package ru.koval.main;
import java.util.Scanner;

public class Check
{
    public static Scanner in = new Scanner(System.in);

    public static int inputInteger(String text)
    {   
        int number = 0;
        boolean flag = false;
        while (!flag) 
        {
            try
            {
                System.out.println(text);
                number = in.nextInt();
                flag = true;
            }
            catch (Exception ex)
            {
                System.out.println("Введено не целое число!");
                in.nextLine();
            }
        }
        return number;
    }

    public static int inputNotNegativeInteger(String text)
    {   
        int number = 0;
        boolean flag = false;
        while (!flag) 
        {
            number = inputInteger(text);
            if (number < 0)
            {
                System.out.println("Введено отрицательное число!");
                in.nextLine();
            }
            else
                flag = true;
        }
        return number;
    }

    public static int inputPositiveInteger(String text)
    {   
        int number = 0;
        boolean flag = false;
        while (!flag) 
        {
            number = inputInteger(text);
            if (number <= 0)
            {
                System.out.println("Введено неположительное число!");
                in.nextLine();
            }
            else
                flag = true;
        }
        return number;
    }

    public static int inputIndex(String text, int arraySize)
    {
        int number = 0;
        boolean flag = false;
        while (!flag) 
        {
            number = inputNotNegativeInteger(text);
            if (number >= arraySize)
            {
                System.out.println("Индекс выходит за пределы массива!");
                in.nextLine();
            }
            else
                flag = true;
        }
        return number;
    }

    public static double inputDouble(String text)
    {   
        double number = 0.0;
        boolean flag = false;

        while (!flag) 
        {
            try
            {
                System.out.println(text);
                number = in.nextDouble();
                if (Math.abs(number - (int)number) < 0.0000000000000001)
                {
                    System.out.println("Введено целое число!");
                    in.nextLine();
                }
                else
                    flag = true;
            }
            catch (Exception ex)
            {
                System.out.println("Введено не число!");
                in.nextLine();
            }
        }
        return number;
    }

    public static char inputCharNumber(String text)
    {   
        String line;
        char symbol = '\0';
        boolean flag = false;

        while (!flag) 
        {
            System.out.println(text);
            line = in.next();
            if (line.length() > 1)
            {
                System.out.println("Введено больше одного символа!");
                in.nextLine();
            }
            else
            {
                symbol = line.charAt(0);
                if (symbol < '0' || symbol > '9')
                {
                    System.out.println("Введена не цифра!");
                    in.nextLine();
                }
                else
                    flag = true;
            } 
        }
        return symbol;
    }

    public static long inputLong(String text)
    {   
        long number = 0;
        boolean flag = false;
        while (!flag) 
        {
            try
            {
                System.out.println(text);
                number = in.nextLong();
                flag = true;
            }
            catch (Exception ex)
            {
                System.out.println("Введено не целое число!");
                in.nextLine();
            }
        }
        return number;
    }
}