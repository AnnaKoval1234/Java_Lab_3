package ru.koval.birds;
import java.util.Random;

public class Parrot extends Bird
{
    public void setText(String text) 
    {
        this.text = text;
    }
    public Parrot(String text)
    {
        this.text = text;
    }
    @Override
    public String sing()
    {
        Random rnd = new Random();
        int num = rnd.nextInt(text.length());
        String str = text.substring(0, num);
        return str;
    }
    @Override
    public String toString()
    {
        return "Попугай";
    }
}