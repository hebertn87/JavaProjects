package hebenathproj4;
import java.util.Scanner;

public class HebeNathProj4 {

    //This is the main class
    public static void main(String[] args) {
        
        //Variables
        int degree, answer, pow, coef;
        double x;
        Scanner in = new Scanner(System.in);
        Poly.Node node = null;
       
        //Welcome message
        System.out.println("Welcome. This program allows you to create polynomials, evaluate them, and add polynomials together.");
        
        //New object
        Poly p = new Poly();
        
        //Do while for menu
        do
        {
            //Menu
            System.out.println("Please choose a number:");
            System.out.println("1.Set Coefficients.");
            System.out.println("2.Get a Coefficient.");
            System.out.println("3.Evaluate polynomial.");
            System.out.println("4.Add 2 polynomial expressions together.");
            System.out.println("5.Convert to a string.");
            System.out.println("6.Exit");
            
            //Input for switch from menu
            answer = in.nextInt();

            switch (answer)
            {
                case 1:
                    System.out.print("Please enter a power:");
                    pow = in.nextInt();
                    System.out.print("Please enter a Coefficient");
                    coef = in.nextInt();
                    p.setCoef(coef, pow, node);
                        break;
                case 2: 
                    System.out.print("Please enter a power:");
                    pow = in.nextInt();
                    System.out.println(p.getCoef(pow, node));
                        break;
                case 3: 
                    System.out.print("Please enter a variable to evaluate for x.");
                    x = in.nextFloat();
                    System.out.println(p.eval(x, node));
                    break;
                case 4:
                    System.out.print(p.add(node, node));
                        break;
                case 5:
                    System.out.print(p.toaString(node));
                        break;
                default:
                        break; //default for switch

            }   
        }
        while (answer != 6); //Exits if answer is 6
    }
    
}
