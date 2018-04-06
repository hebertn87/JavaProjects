//Nathan Hebert 11/21/16
//This program implements an array based priority queue
package project9;
import java.util.Scanner;

//This is the main class of this program.
public class HebeProj9 {

    //This is the main method of the program which includes an implementation of the PriorityQueue class in the PriorityQueue.java file
    public static void main(String[] args) {
     
        //Data values
        PriorityQueue pq = new PriorityQueue(50);
        Scanner in = new Scanner(System.in);
        int choice;
        boolean check;
        
        //Welcome Message
        System.out.println("Welcome! This program allows you to see how a sorted array based implementation of a priority queue works.");
        
        do{
            //Menu
            System.out.println("Please make a choice.");
            System.out.println("1. Check to see if it's empty.");
            System.out.println("2. Insert an item into the queue.");
            System.out.println("3. Delete an item in the queue.");
            System.out.println("4. Display the queue");
            System.out.println("5. Exit.");
            choice = in.nextInt(); //Enter choice
            
            //Switch statment based on menus
            switch (choice){
                case 1:                   
                    check = pq.isEmpty(); //Returns the check to isempty      
                    
                    //If queue is is empty it will output it, if not it will display that its not empty
                    if (check)
                      System.out.println("Queue is Currently empty.");
                    else
                      System.out.println("Queue is not empty.");
                    
                    break;           
                case 2:   
                    Float insert; 
                    
                    //Allows user to insert the number they wish to add, then inserts it into its correct location
                    System.out.println("Please enter a floating point number to insert into the queue.");
                    insert = in.nextFloat();
                    pq.insert(insert);
                    System.out.println("Item now insterted into the queue.");
                    
                    break;
                case 3:
                    Float item; //item for delete to return
                    item = pq.delete();
                    System.out.println("You have successfully removed " + item + "."); //outputs item removed
                    
                    break;                
                case 4:
                    //Displayes Queue so far
                    System.out.println("Your queue so far is as follows:");
                    
                    pq.display();
                    break;                    
                case 5:
                    //Exit
                    System.out.println("Program will now exit. Thank you.");
                    
                    break;
            }       
        }while(choice != 5); //When choice is 5 program will exit
    }       
}

