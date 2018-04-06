//Nathan Hebert Project 6
//This File is the main driver class
package project.pkg6;
import java.util.Scanner;
import java.io.*;

//This is the main class
public class HebeNathProj6 
{
    //This is the driver method
    public static void main(String[] args) 
    {
        //Try block
        try{
            //Variables
            Scanner in = new Scanner(System.in);
            String city, flight, request;
            Map m = new Map();
            Map.City c;
            int answer = 0;
            
            //Welcome message and input
            System.out.println("Welcome. This program will allow you to determine a flight path based upon the city, flight, and request files.");

            System.out.println("Please enter a file name for the cities in your flight map: (Make sure you add .txt at the end of each file)");     
            city = in.next();

            System.out.println("Please enter a file name for the flight routes for your flight map:");
            flight = in.next();

            System.out.println("Please enter a request path for your flight map;");
            request = in.next();
            
            //Create map
            m.createFlightMap();
            m.ReadFlightMap(city, flight);
            
                //Do while loop for menu
                do
                {
                System.out.println("PLease Choose an option:");

                System.out.println("1. Display flight map.");
                System.out.println("2. Display all cities.");
                System.out.println("3. Display adjacent cities.");
                System.out.println("4. Get flight path.");
                System.out.println("5. Quit.");
                answer = in.nextInt();
                    switch (answer)
                    {
                        case 1:
                            m.displayFlightMap(); //displays flight map
                            break;
                        case 2:
                            m.displayAllCities(); //displays all cities in map
                            break;
                        case 3:
                            String choice;
                            System.out.println("Please input the city in question");
                            choice = in.next();
                            
                            //if the cities input is the city we are looking for
                            if (c.cityname.equals(choice))
                            {
                                m.displayAdjacentCities(c); //Displays adjacent cities
                            }
                            break;
                        case 4:
                            Map.City origin = new City();
                            Map.City dest = new City();
                            System.out.println("Please choose an origin city and a destination city");
                            origin.cityname = in.next();
                            dest.cityname = in.next();
                            m.isPath(origin, dest); //Determines correct pathway for flight
                            break;
                        case 5:
                            break;
                    }
                }while (answer != 5);

        } //Exceptions
        catch(FileNotFoundException e)
        {
            System.out.println("File was not found. please try again.");
        }
        catch(IOException e)
        {
            System.out.println("An error with the stream has occurred Please try again later.");
        }
    }
}
