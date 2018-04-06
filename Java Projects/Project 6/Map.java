//This file is the Map file, containing the city class and the map class
package project.pkg6;

import java.io.*;
import java.util.LinkedList;
import java.util.Stack;

//Map class
public class Map
{
    //Linked list reference
    LinkedList<City> flightmap;

    //City class
    public class City
    {
        //Variables
        String cityname;
	Boolean visited;
        String flightto;
        String flightfrom;
        Boolean isAdjacent;
        int index;
        
        //Constructor
        City()
        {
            cityname="";
            visited = false;
            index = 0;
        }
    }
    
    //Creates empty flight map
    public void createFlightMap()
    {
       LinkedList<City> newflightmap = new LinkedList<>();    
       flightmap = newflightmap;
    }
    
    //Reads flight information into flight map
    public void ReadFlightMap(String cityFile, String flightFile) throws FileNotFoundException, IOException
    {
        //Variables
        String line;
        City c = new City();
        File f = new File(cityFile);
        FileReader r = new FileReader(f);
        BufferedReader reader = new BufferedReader(r);
        
        //Reads the city names into the linked list
        while((line= reader.readLine()) != null)
        {
            if(line.trim().equals(""))
            {
                for(int i = 0; i < flightmap.size(); i++)
                {
                 c.cityname = line;
                 flightmap.add(c);
                 c.index = i;
                }
            }
        }
        
        //Variables
        String line2;
        City c2 = new City();
        File f2 = new File(flightFile);
        FileReader r2 = new FileReader(f2);
        BufferedReader reader2 = new BufferedReader(r2);
        
        //REads the adjacent cities into the map
        while((line2= reader2.readLine()) != null)
        {
            if(line2.trim().equals(","))
            {
                c2.flightfrom = line2;
                flightmap.add(c2);
            }
            else if (line2.trim().equals("\n"))
            {
                c2.flightto = line2;
                flightmap.add(c2);
            }
        }
    }
    
    //Displays flight information
    public void displayFlightMap()
    {
       City c;
       
       //while the size of index is smaller than biggest print each member of the flightmap
       for (int i = 0; i < flightmap.size(); i++)
       {
           System.out.println(flightmap.get(i));
       }
    }
    
    //Displays the names of all cities that HPAir serves
    public void displayAllCities()
    {
        //Displays all cities with a for loop
       for (int i = 0; i < flightmap.size(); i++)
        System.out.println(flightmap.get(i));
    }
    
    //Displays all the cities that are adjacent to a given city
    public void displayAdjacentCities(City aCity)
    {
        //will get adjacent citites to a user inputted city
    }
    
    //Marks a city as visited
    public void markVisited(City aCity)
    {
       if (aCity.visited == false)
       {
           aCity.visited = true;
       }
    }
    
    //Clears marks on all cities
    public void unvisitAll()
    {
        City c = new City();
        
        //reset returns all City.visited booleans to false
        for (int i = 0;  i <flightmap.size() ;i++)
        { 
            flightmap.get(i);
            c.visited = false;
        }
    }
    
    //Determines whether a city was visited
    public boolean isVisited(City aCity)
    {       
        return aCity.visited == true;
    }
    
    //Inserts a city adjacent to another city ina flight map
    public boolean insertAdjacent(City aCity)
    {
        City c = new City();
        return aCity.flightto.equals(c.flightfrom);
        
    }
    
    //Returns the next unvisited city, if any, that is adjacent to a given city.
    //Returns null if unvisited adjacent city was found
    public City getNextCity(City fromCity)
    {
        if (fromCity.visited == false)
        {
            return flightmap.get(fromCity.index +1);
        }
        else
            return null;
    }
    
    // ---------------------------------------------------
    // Determines whether a sequence of flights between two cities
    // exists. Nonrecursive stack version.
    // Precondition: originCity and destinationCity are the origin
    // and destination cities, respectively.
    // Postcondition: Returns true if a sequence of flights exists
    // from originCity to destinationCity, otherwise returns
    // false. Cities visited during the search are marked as
    // visited in the flight map.
    // Implementation notes: Uses a stack for the cities of a
    // potential path. Calls unvisitAll, markVisited, and
    // getNextCity.
    // ---------------------------------------------------
    public boolean isPath(City originCity, City destinationCity) 
    {

      Stack stack = new Stack();

      City topCity, nextCity; 
      unvisitAll();  // clear marks on all cities

      // push origin city onto stack, mark it visited
      stack.push(originCity);
      markVisited(originCity);

      topCity = (City)(stack.peek());
      while (!stack.isEmpty() && (topCity.compareTo(destinationCity) != 0))
      {
        // loop invariant: stack contains a directed path
        // from the origin city at the bottom of the stack
        // to the city at the top of the stack

        // find an unvisited city adjacent to the city on
        // the top of the stack
        nextCity = getNextCity(topCity);

        if (nextCity == null) 
        {
          stack.pop();  // no city found; backtrack
        }
        else 
        {                
          stack.push(nextCity);
          markVisited(nextCity);
        }
        
        topCity = (City)stack.peek();
      }  
        return !stack.isEmpty(); // no path exists  
    }
}