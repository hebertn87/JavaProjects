package hebenathproj02;

//Import for scanner class
import java.util.Scanner;

//Class with rabbit, parade, main, and job methods in it.
public class HebeNathProj02
{
    //Main method
    public static void main(String[] args) 
    {
        //Data
        int answer, n, rab, floats, bands, total, poss, indent = 0, day = 30;
        Scanner in = new Scanner(System.in);
        
        //Welcome message
        System.out.println("Welcome to this program. This program allows you to try 3 different recursive methods.");
        
        do
        {
            //Menu
            System.out.println("Please enter a number representing your choice.");
            System.out.println("1.Counting a Parade");
            System.out.println("2.Rabbits");
            System.out.println("3.Money in a Job");
            System.out.println("4.Exit");
            
            //Input
            answer = in.nextInt();

            //Case for answer
            switch(answer)
            {
                //Parade method case
                case 1:
                    System.out.println("You selected Parade. This option will allow you to find the number of possibilites to arrange floats and bands so that bands are never next to each other.");
                    
                    System.out.println("Please enter how many floats there are in the parade.");
                    floats = in.nextInt();
                    
                    System.out.println("Please enter how many bands there are in the parade.");
                    bands = in.nextInt();
                    
                    total = bands + floats;
                    poss = parade(total);
                    System.out.println("There are this many possiblities:");
                    System.out.println(poss);
                    break;
                //Rabbit method case
                case 2:
                    System.out.println("Please enter a number of times you want the rabbit to populate.");
                    n = in.nextInt();
                    rabbit(n, indent);
                    break;
                //Job method case
                case 3:
                    System.out.println("This function will output how much money you will make each day in a 30 day period if your money doubles each day.");
                    job(day);
                    break;
            }        
        } while (answer != 4);
    }

    //Counting a Parade Method
    public static int parade(int total)
    {       
        //Switch statment to set conditions for recursion
        switch (total) {
            case 1:
                return 2;
            case 2:
                return 3;
            default:
                return parade(total - 1) + parade(total - 2);
        }
    }
    
    //Counting Rabbit population method
    public static int rabbit(int n, int indent) //Indent parameter to pass the current indent to next iteration
    {   
        //this is the value returned in each recursion
        int value;
        
        //for loop for indentation
        for (int i = 0; i < indent; i++)
        {
            System.out.print("    ");
        }
        
        //Enter rabbit output
        System.out.println("Enter Rabbit: n = " + n);
        
        //Recursive statement
        if (n <= 2) 
          value = 1;        
        else
           value = rabbit(n-1, indent + 1) + rabbit(n-2, indent + 1);
        
        //For loop indenting each recursion of the problem
        for (int i = 0; i < indent; i++)
            System.out.print("    ");
        
        //Outputs leave rabbit and the value after that
        System.out.println("Leave Rabbit: n = " + n + " Value = " + value);
        
        //Returns value here from recursion as output needed to be after calculations
        return value;
    }  
    
    //Job method calculates how much money you will get if you doubled your money every day of work for 30 days
    public static double job(int day)
    {
        //Amnount variable in order to return conditional
        double amount;
        
        //Recursive statement that will calculate the total every day
        if(day == 1) 
            amount = 1;
        else
            amount = 2 * job(day - 1); 
        
        //Displays Day number and amount made that day in $0.00 format
        System.out.println("Day " + day + " = " + "$" + amount/100);
        
        //Returns upon conditionals here so that ouput may be displayed after the conditions are met, acheiveing count up
        return amount;
    }
}