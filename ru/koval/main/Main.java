package ru.koval.main;
import static java.lang.Integer.parseInt;
import static java.lang.Math.pow;
import java.util.ArrayList;
import java.util.Scanner;
import ru.koval.birds.*;
import ru.koval.geometry.*;
import ru.koval.logistics.*;

public class Main
{
    public static Scanner in = new Scanner(System.in);

    public static double power(String x, String y)
    {
            int a = parseInt(x);
            int b = parseInt(y);
            return pow(a, b);
    }

    void Task_1()
    {
        System.out.println("Задание 1.10: Дороги");

        Town a = new Town("A");
        Town b = new Town("B");
        Town c = new Town("C");
        Town d = new Town("D");

        try
        {
            a.addRoad(new Road(b, 5));
            a.addRoad(new Road(d, 6));

            b.addRoad(new Road(a, 5));
            b.addRoad(new Road(c, 3));

            c.addRoad(new Road(b, 3));
            c.addRoad(new Road(d, 4));
            
            d.addRoad(new Road(a, 6));
            d.addRoad(new Road(c, 4));
            
            ArrayList<Road> from_f = new ArrayList<Road>();
            from_f.add(new Road(b, 1));
            Town f = new Town("F", from_f);

            a.addRoad(new Road(f, 1));
            
            ArrayList<Road> from_e = new ArrayList<Road>();
            from_e.add(new Road(f, 2));
            Town e = new Town("E", from_e);
            
            f.addRoad(new Road(e, 2));

            d.addRoad(new Road(e, 2));
            
            // System.out.println("Карта города аналогична карте из задания 3.3 предыдущей лабораторной работы");
            
            // System.out.println(d);
            // System.out.println(e);
            // System.out.println(f);

            System.out.println(c);
            System.out.println("Добавление пути из C в Е стоимостью 5");
            Road from_c_to_e = new Road(e, 5);
            c.addRoad(from_c_to_e);
            System.out.println(c);

            // тут будет исключение
            System.out.println("Добавление пути из C в B стоимостью 2");
            Road from_c_to_b = new Road(b, 2);
            c.addRoad(from_c_to_b);
        }
        catch (Exception e1)
        {
            System.out.println(e1);
            System.out.println();
    
            try
            {
                System.out.println(b);
                System.out.println("Удаление пути из B в A");
                Road from_b_to_a = b.getRoad(a.getName());
                b.deleteRoad(from_b_to_a);
                System.out.println(b);
                
                // тут будет исключение
                System.out.println(a);
                System.out.println("Удаление пути из A в C");
                Road from_a_to_c = new Road(c, 1);
                a.deleteRoad(from_a_to_c);
            }
            catch (Exception e2)
            {
                System.out.println(e2);
            }
        }
    }

    void Task_2()
    {
        System.out.println("Задание 2.5: Маршрут");

        Town a = new Town("A");
        Town b = new Town("B");
        Town c = new Town("C");
        Town d = new Town("D");
        Town e = new Town("E");
        Town f = new Town("F");

        try
        {
            a.addRoad(new Road(b, 5));
            a.addRoad(new Road(d, 6));
            a.addRoad(new Road(f, 1));

            b.addRoad(new Road(a, 5));
            b.addRoad(new Road(c, 3));

            c.addRoad(new Road(b, 3));
            c.addRoad(new Road(d, 4));
            
            d.addRoad(new Road(a, 6));
            d.addRoad(new Road(c, 4));
            d.addRoad(new Road(e, 2));

            e.addRoad(new Road(f, 2));

            f.addRoad(new Road(b, 1));
            f.addRoad(new Road(e, 2));

            // System.out.println(a);
            // System.out.println(b);
            // System.out.println(c);
            // System.out.println(d);
            // System.out.println(e);
            // System.out.println(f);

            Route r = new Route(f, d);
            System.out.println("Маршрут из города F в город D: ");
            System.out.println(r);
        }
        catch (Exception ex)
        {
            System.out.println(ex);
        }
    }
    void Task_3()
    {
        System.out.println("Задание 3.3: Двусторонняя дорога");

        BidirectionalTown a = new BidirectionalTown("A");
        BidirectionalTown b = new BidirectionalTown("B");
        BidirectionalTown c = new BidirectionalTown("C");

        try
        {
            System.out.println("Добавление пути из А в B");
            a.addRoad(new Road(b, 1));
            System.out.println(b);

            System.out.println("Добавление пути из B в C");
            b.addRoad(new Road(c, 1));
            System.out.println(c);

            System.out.println("Добавление пути из C в A");
            c.addRoad(new Road(a, 1));
            System.out.println(a);

            System.out.println("Удаление пути из A в C");
            a.deleteRoad(a.getRoad(c.getName()));
            System.out.println(c);
        }
        catch(Exception ex)
        {
            System.out.println(ex);
        }
    }

    void Task_4()
    {
        System.out.println("Задание 3.5: Трёхмерная точка");
        int x = Check.inputInteger("Введите координату X: ");
        int y = Check.inputInteger("Введите координату Y: ");
        int z = Check.inputInteger("Введите координату Z: ");
        Point3D p = new Point3D(x, y, z);
        System.out.println("Введённая точка: " + p);
    }

    void Task_5()
    {
        System.out.println("Задание 4.3: Птицы");

        Sparrow sparrow = new Sparrow();
        System.out.println("Воробей поёт: " + sparrow.sing());

        Cuckoo cuckoo = new Cuckoo();
        for (int i = 1; i <= 3; i++)
        {
            System.out.println("Кукушка поёт: ");
            System.out.println(cuckoo.sing());
        }

        System.out.println("Введите текст для попугая: ");
        String text = in.nextLine();
        Parrot parrot = new Parrot(text);
        for (int i = 1; i <= 3; i++)
            System.out.println("Попугай поёт: " + parrot.sing());
    }

    void Task_6()
    {
        System.out.println("Задание 5.9: Городим");

        BidirectionalTown a = new BidirectionalTown("A");
        Town b = new Town("B");
        Town c = new Town("C");
        BidirectionalTown d = new BidirectionalTown("D");
        Town e = new Town("E");

        try
        {
            a.addRoad(new Road(b, 1));
            a.addRoad(new Road(c, 1));

            b.addRoad(new Road(c, 1));

            d.addRoad(new Road(b, 1));
            d.addRoad(new Road(e, 1));

            e.addRoad(new Road(c, 1));

            System.out.println(a);
            System.out.println(b);
            System.out.println(c);
            System.out.println(d);
            System.out.println(e);
        }
        catch (Exception ex)
        {
            System.out.println(ex);
        }
    }

    void Task_7()
    {
        System.out.println("Задание 6.5: Сравнение городов");

        Town a = new Town("A");
        Town b = new Town("B");
        Town c = new Town("C");
        Town d = new Town("D");
        BidirectionalTown e = new BidirectionalTown("E");

        try
        {
            a.addRoad(new Road(b, 1));
            a.addRoad(new Road(c, 1));

            d.addRoad(new Road(b, 1));
            d.addRoad(new Road(c, 1));

            e.addRoad(new Road(b, 1));
            e.addRoad(new Road(c, 1));

            System.out.println(a);
            System.out.println(b);
            System.out.println(c);
            System.out.println(d);
            System.out.println(e);

            System.out.println("Город A равен городу D: " + a.equals(d));
            System.out.println("Город A равен двунаправленному городу E: " + a.equals(e));
            System.out.println("Город B равен городу D: " + b.equals(d));
            System.out.println("Город B равен двунаправленному городу E: " + b.equals(e));
        }
        catch (Exception ex)
        {
            System.out.println(ex);
        }
    }

    void Task_8()
    {
        System.out.println("Задание 8.4: Клонирование точки");

        int x = Check.inputInteger("Введите координату X: ");
        int y = Check.inputInteger("Введите координату Y: ");
        int z = Check.inputInteger("Введите координату Z: ");
        Point3D p1 = new Point3D(x, y, z);
        System.out.println("Введённая точка: " + p1);
        Point3D p2 = p1.clone();
        System.out.println("Клонированная точка: " + p2);
    }

    public static void main(String args[])
    {   
        if (args.length > 0)
        {
            try
            {
                System.out.println(power(args[0], args[1]));
            }
            catch (Exception ex)
            {
                System.out.println("В параметры командной строки переданы не числа!");
            }
        }
        else
        {
            Main m = new Main();
            m.Task_1();
            m.Task_2();
            m.Task_3();
            m.Task_4();
            m.Task_5();
            m.Task_6();
            m.Task_7();
            m.Task_8();
        }
    }
}