package ru.koval.birds;
public class Sparrow extends Bird
{
    public Sparrow()
    {
        text = "чырык";
    }
    @Override
    public String sing()
    {
        return text;
    }
    @Override
    public String toString()
    {
        return "Воробей";
    }
}