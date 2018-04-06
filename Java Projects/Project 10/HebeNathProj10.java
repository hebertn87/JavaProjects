//Nathan Hebert
//12/05/16
//This program allows the user to create identifiers
package hebenathproj10;
import java.util.Scanner;

//THis is the main class of the project
public class HebeNathProj10 {
    
    //This is the driver program that demonstrates my table class
    public static void main(String[] args) {
        
        //Variables
        Scanner in = new Scanner(System.in);
        int choice;
        String insert, delete;
        Table ht = new Table();
        
        //Inserted data
        ht.insert("abstract");
        ht.insert("do");
        ht.insert("import");
        ht.insert("return");
        ht.insert("try");
        ht.insert("boolean");
        ht.insert("instanceof");
        ht.insert("short");
        ht.insert("void");
        ht.insert("break");
        ht.insert("char");
        ht.insert("int");
        ht.insert("new");
        ht.insert("throw");
        ht.insert("private");
        ht.insert("public");
        ht.insert("class");
        ht.insert("default");
        ht.insert("implements");
        
        //Welcome message
        System.out.println("Welcome. This program will allow you to create an identifier, and will check for correctness.");
        
        do
       {          
           //Menu
           System.out.println("\n Please pick a choice");
           System.out.println("1. Create an identifier.");
           System.out.println("2. Delete an identifier.");
           System.out.println("3. Display list of identifiers.");
           System.out.println("4. Exit.");
           choice = in.nextInt();
           
           //Switch
           switch (choice)
           {
               case 1:
                   //Insert method
                   System.out.println("Please type an identifier you want to create: (Note that it must start with $ or a letter.");
                   insert = in.next();
                   ht.insert(insert);
                   break;
               case 2: 
                   //Delete mthod
                   System.out.println("Please pick an identifier to delete from the table.");
                   delete = in.next();
                   ht.delete(delete);
                   break;
               case 3: 
                   //Displays table
                   System.out.println("Here is your table.");
                   ht.display();
                   break;
               case 4:
                   //Exits
                   System.out.println("Program will now exit. Goodbye.");
                   break;                         
            }
           
       } while (choice !=4); //Exits when choice is 4
    }
    
}
