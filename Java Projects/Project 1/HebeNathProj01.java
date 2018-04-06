//Scanner Package for input
import java.util.Scanner;

//Main Class
public class HebeNathProj01 {
    //Main Driver
    public static void main(String[] args) 
    {
       //Variables
       int credits, ID;
       double total, GPE, GPA;
       Scanner in = new Scanner(System.in);
       Student s;
       String name;
       
       //Welcome and Input Name
       System.out.println("Welcome. This program will show the information of a Student. Please type a student's name:");
       name = in.nextLine();
 
       //Input ID
       System.out.println("Please enter an ID number:");
       ID = in.nextInt();
       
       //New instance of student
       s = new Student(name, ID);
       
       //Credits for student
       System.out.println("Please enter the amount of Credits for the student");
       credits = in.nextInt();
       s.setCredits(credits);

       //Total Grade Points
       System.out.println("Please enter the total grade points for John Doe");
       total = in.nextDouble();
       s.setGPE(total);

       //Output Name
       System.out.println("Student's Name is:");
       name = s.getName();
       System.out.println(name);
       
       //Output ID
       System.out.println("Student's ID is:");
       ID = s.getID();
       System.out.println(ID);

       //Output Credits
       System.out.println("Student's Credits is:");
       credits = s.getCredits();
       System.out.println(credits);

       //Output Total Grade points
       System.out.println("Students Total Grade Points earned is");
       GPE = s.getGPE();
       System.out.println(GPE);

       //Output GPA
       System.out.println("Student Total GPA is:");
       GPA = s.getGPA();
       System.out.println(GPA);
    } 
}
