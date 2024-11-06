package ru.koval.birds;
abstract class Bird
{
    protected String text;
    public String getText()
    {
        return text;
    }
    public abstract String sing();
    
    @Override
    public abstract String toString();
}