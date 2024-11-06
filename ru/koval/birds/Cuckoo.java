package ru.koval.birds;
import java.util.Random;

public class Cuckoo extends Bird
{
    public Cuckoo()
    {
        text = "ку-ку";
    }
    @Override
    public String sing()
    {
        Random rnd = new Random();
        int num = rnd.nextInt(10) + 1;
        String str = "";
        for (int i = 0; i < num; i++) {
            str += text + "\n";
        }
        str = str.trim();
        return str;
    }
    @Override
    public String toString()
    {
        return "Кукушка";
    }
}