package ru.koval.geometry;

public class Point
{
    protected int X;
    protected int Y;

    public int getX()
    {
        return X;
    }
    public int getY()
    {
        return Y;
    }
    public void setX(int x)
    {
        X = x;
    }
    public void setY(int y)
    {
        Y = y;
    }

    public Point(int X, int Y)
    {
        this.X = X;
        this.Y = Y;
    }

    @Override
    public String toString()
    {
        return "{" + X + "; " + Y + "}";
    }
}