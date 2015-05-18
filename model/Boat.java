package model;

import java.util.*;

public class Boat extends Viewable
{   private int id;
    private int stops;
    private LinkedList<Person> passengers = new LinkedList<Person>();
    private double rate = 10.00;
    
    public Boat(int id, int stops)
    {   this.id = id;
        this.stops = stops;   }
        
    public boolean has(int id)
    {   return this.id == id;  }
    
    public void book(String name, int start, int end)
    {   passengers.add(new Person(name, start, end));   }
             
    public String on(int i)
    {   String s = "";
        for (Person person: passengers)
            if (person.getsOn(i))
                s += person.name() + " ";
        return s;  }
        
    public String off(int i)
    {   String s = "";
        for (Person person: passengers)
            if (person.getsOff(i))
                s += person.name() + " ";
        return s;   }
                
    public int id()
    {   return id;  }
    
    public int stops()
    {   return stops;  }
}
