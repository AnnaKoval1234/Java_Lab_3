package ru.koval.main;
public class Road
{
    final Town town;
    final int cost;

    public Road(Town town, int cost)
    {
        this.town = town;
        this.cost = cost;
    }

    public Town getTown()
    {
        return town;
    }
    public int getCost()
    {
        return cost;
    }
    // public void setTown(Town town)
    // {
    //     this.town = town;
    // }
    // public void setCost(int cost)
    // {
    //     this.cost = cost;
    // }
    @Override
    public String toString()
    {
        return town.getName() + ": " + cost;
    }
}