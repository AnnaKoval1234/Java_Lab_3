package ru.koval.logistics;
import ru.koval.main.*;
import java.util.ArrayList;

public class Route
{
    private Town begin;
    private Town end;
    private final ArrayList<Town> route;

    // Признак того, что рассчитанный маршрут соответствует действительности
    private boolean isValid;

    public Town getBegin()
    {
        return begin;
    }
    public Town getEnd()
    {
        return end;
    }
    public ArrayList<Town> getRoute()
    {
        calculateRoute();
        return route;
    }

    public void setBegin(Town begin)
    {
        this.begin = begin;
        this.isValid = false;
    }
    public void setEnd(Town end)
    {
        this.end = end;
        this.isValid = false;
    }

    public Route(Town begin, Town end)
    {
        if (begin == null) 
            throw new IllegalArgumentException("Не задан город начала");
        if (end == null) 
            throw new IllegalArgumentException("Не задан город конца");

        this.begin = begin;
        this.end = end;
        this.route = new ArrayList<>();
        this.isValid = false;
    }

    @Override
    public String toString()
    {
        calculateRoute();
        if (route.isEmpty()) 
            return "Маршрут не существует";

        String result = "";
        for (Town t : route)
        {
            if (!result.isEmpty()) result += " - ";
            result += t.getName();
        }
        return result;
    }

    private void calculateRoute()
    {
        // Не следует пересчитывать маршрут, если с последнего вычисления города не изменились
        if (isValid) 
            return;
        route.clear();
        route.add(begin);
        // Если не удалось найти маршрут, он должен быть пустым
        if (!calculateRouteRecursive(begin)) 
            route.clear();
        isValid = true;
    }

    private boolean calculateRouteRecursive(Town current)
    {
        boolean found = false;
        for (Road r : current.getRoads())
        {
            Town neighbor = r.getTown();
            // Избегаем циклов при обходе в глубину
            if (route.contains(neighbor))
                continue;
            route.add(neighbor);
            // Возвращаемое значение - признак того, что маршрут найден - всплывает вверх по рекурсии
            if (neighbor.getName().equals(end.getName()))
                found = true;
            else
                found = calculateRouteRecursive(neighbor);
            // Принимаем первый попавшийся маршрут, даже если он неоптимален
            if (found)
                break;
            else
                route.remove(neighbor);
        }
        return found;
    }
}
