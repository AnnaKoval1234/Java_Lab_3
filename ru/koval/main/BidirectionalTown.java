package ru.koval.main;
import java.util.ArrayList;

public class BidirectionalTown extends Town
{
    public BidirectionalTown(String name)
    {
        super(name);
    }
    public BidirectionalTown(String name, ArrayList<Road> roads)
    {
        super(name, roads);
    }

    @Override
    public void addRoad(Road road) throws Exception
    {
        Town neighbor = road.getTown();
        super.addRoad(road);
        try
        {
            neighbor.addRoad(new Road(this, road.getCost()));
        }
        catch(Exception e) {}
    }

    @Override
    public void deleteRoad(Road road) throws Exception
    {
        Town neighbor = road.getTown();
        super.deleteRoad(road);
        try
        {
            neighbor.deleteRoad(neighbor.getRoad(name));
        }
        catch(Exception e) {}
    }
}