package ru.koval.main;
import java.util.ArrayList;

public class Town
{
    final String name;
    private ArrayList<Road> roads;
    // public Town() 
    // {
    //     name = "";
    //     roads = new ArrayList<Road>();
    // }
    public Town(String name) 
    {
        this.name = name;
        roads = new ArrayList<Road>();
    }
    public Town(String name, ArrayList<Road> roads) 
    {
        this.name = name;
        this.roads = roads;
    }

    public String getName()
    {
        return name;
    }
    public Road getRoad(String name)
    {
        for (Road r : roads)
            if (r.getTown().getName().equals(name))
                return r;
        return null;
    }
    public ArrayList<Road> getRoads()
    {
        return roads;
    }
    // public void setName(String name)
    // {
    //     this.name = name;
    // }
    public void setRoads(ArrayList<Road> roads)
    {
        this.roads = roads;
    }

    private boolean isRoadExists(Road road)
    {
        for (Road r : roads) {
            if (road.getTown().getName().equals(r.getTown().getName()))
                return true;
        }
        return false;
    }
    public void addRoad(Road road) throws Exception
    {
        if (isRoadExists(road))
            throw new Exception("Дорога в этот город уже есть!");
        if (road.getTown().getName().equals(name))
            throw new Exception("Нельзя добавить дорогу в этот же город!");
        roads.add(road);
    }
    public void deleteRoad(Road road) throws Exception
    {
        if (!isRoadExists(road))
            throw new Exception("Дороги в этот город нет!");
        roads.remove(road);
    }

    @Override
    public String toString()
    {
        String res = "";
        res += "Город: " + name + "\n";
        res += "Пути из города:\n";
        for (Road road : roads) {
            res += road + "\n";
        }
        return res;
    }

    @Override
    public boolean equals(Object obj)
    {
        // Сравниваемый объект не должен быть равен нулю и должен иметь тот же класс
        if (obj == null) return false;
        if (!(obj instanceof Town)) return false;

        Town other = (Town) obj;

        int thisLen = this.getRoads().size();
        int otherLen = other.getRoads().size();

        // Количество дорог должно совпадать - в сравниваемом городе не должно быть лишних
        if (thisLen != otherLen) return false;

        for (Road tr : this.getRoads())
        {
            Road or = other.getRoad(tr.getTown().getName());

            // Для каждой дороги из данного города должна существовать аналогичная в сравниваемом городе
            if (or == null) return false;
            // И их стоимости должны совпадать
            if (tr.getCost() != or.getCost()) return false;
        }

        return true;
    }
}