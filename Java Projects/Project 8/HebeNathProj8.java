//Project 8 Nathan Hebert 11/4/2016
//This program will ask the user questions about specific popular restaurants and try to guess their animal they are thinking of.
package hebenathproj8;
import BinaryTree.BinaryTree;
import java.util.Scanner;

//This Is the main driver class
public class HebeNathProj8 
{
    //This is the main driver method
    public static void main(String[] args)
    {  
       //Variables
       Scanner in = new Scanner(System.in);
       String cont;
       
       //Creates new Binary Tree
       BinaryTree<String> tree = new BinaryTree<>("Is your restaurant a Fast Food place?");
       tree.attachLeftSubtree(new BinaryTree<>("Is it Denny's?"));
       tree.attachRightSubtree(new BinaryTree<>("Is it McDonalds?"));
       

       //Welcome message
       System.out.println("Welcome, this program will ask you questions about a restaurant and then try to guess you're answer.)");
       System.out.println("Please input your answer in either YES, or NO (all caps).");
       
       //Do while
       do
       {
        System.out.println("Think of a restaurant. Ready?");
        tree = getAnswer(tree); //Calls tree
        System.out.println("Continue? (YES OR NO)");
        cont = in.next();      
       }
       while(!"NO".equals(cont));        
       
       //Goodbye message
       System.out.println("Goodbye!");
    }
    
    //Method that returns an answer for your tree 
    public static BinaryTree getAnswer(BinaryTree<String> theTree)
    {
        //Variables
        BinaryTree<String> temp;
        String answer;
        Scanner in = new Scanner(System.in);
        
        //Output and Input
        String item = theTree.getRootItem();
        System.out.println(item);
        answer = in.nextLine(); 
        
        //If tree isnt empt
        if (!theTree.isEmpty())
        {
            //IF the answer is yes, go right in tree
            if("YES".equals(answer))
            {
                //Detach tree
                temp = theTree.detachRightSubtree();
                
                //if temp is not empty, recursion
                if(!temp.isEmpty()){
                  theTree.attachRightSubtree(getAnswer(temp));
                }
                //Else bot wins
                else{
                 theTree.attachRightSubtree(temp);
                 System.out.println("I win! Want to continue?");
                }                      
            }
            //Else not empty, go left
            else
            {  
               temp = theTree.detachLeftSubtree();

               //If temp is not empty recursion happens
               if(!temp.isEmpty()){
                  theTree.attachLeftSubtree(getAnswer(temp));
               }
               //If its empty it loses
               else{
                 theTree.attachLeftSubtree(temp);
                 String tempAnswer;
                 
                 //Input for new answers
                 System.out.println("I give up. What is it? (Phrase your answer as an 'Is it 'insert blank here'?' question.");
                 tempAnswer = in.nextLine();
                 System.out.println("Please type a question for whose answer is yes for your answer and no for mine.");
                 BinaryTree tempTree = new BinaryTree<>(in.nextLine());
                 
                 //Sets the new tree into the old tree
                 tempTree.attachLeftSubtree(temp);
                 tempTree.attachRight(tempAnswer);
                 theTree.attachLeftSubtree(temp);               
               }        
            }
        }
       return theTree;    
    }
}
