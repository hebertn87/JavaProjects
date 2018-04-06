//This file contains main class driver and will run what is in the date class.
package hebenathproj3;
import java.util.Scanner;

//This is the Project class that contains main class
public class HebeNathProj3 {

    //This is the main class
    public static void main(String[] args) {
        
        //Variables
        int month, day, year, answer;
        Scanner in = new Scanner(System.in);
       
        //Welcome message
        System.out.println("Welcome. This is a calendar program that allows you to choose a date, advance the date, and display the date.");
       
        //Input for month
        System.out.print("Please enter The month");
        month = in.nextInt();
        
        //Input for day
        System.out.print("Enter the Day:");
        day = in.nextInt();
        
        //Input for year
        System.out.print("Enter the Year:");
        year = in.nextInt();
        
        //New object
        Date n = new Date(month, day, year);
        
        //Do while for menu
        do
        {
            //Menu
            System.out.println("Please choose a number:");
            System.out.println("1.Advance the date.");
            System.out.println("2.Display date in Month Day, Year format.");
            System.out.println("3.Display the date in MM/DD/YYYY format.");
            System.out.println("4.Exit");
            
            //Input for switch from menu
            answer = in.nextInt();

            switch (answer)
            {
                case 1: n.advancedate(); //Calls the date method to advance date by 1
                        break;
                case 2: n.displaymonthword(); //calls the display month as a word method
                        break;
                case 3: n.displaymonthNum(); //calls the display month as a number
                        break;
                default:
                        break; //default for switch

            }   
        }
        while (answer != 4); //Exits if answer is 4
    }
    
}
