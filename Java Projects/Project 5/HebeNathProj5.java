
package hebenathproj5;

public class HebeNathProj5 
{
    public static void main(String[] args) 
    {
      Maze m = new Maze();
      
      
      //Welcome message
      System.out.println("Welcome. This program takes a maze saved in a file, and solves the maze.");
      
      m.createMaze();
      m.getMaze();
      
    }
}
