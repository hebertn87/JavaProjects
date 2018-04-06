//The maze itself that has rows and comlums, the entrance and exit
//Should determine if a particular path is a square or a wall
package hebenathproj5;

import java.io.*;
import java.util.*;

public class Maze 
{   
    //Variables Coulums, rows, start, end
    final int ROWS = 7, COLS = 20;
    int start[] = {6,12};
    int end[] = {0, 18};
    char grid[][] = new char[ROWS][COLS];    
    
    Maze()
    {
        int start[] = null;
        int end[] = null;
    }

    //Put's maze file into a char grid by determining row, col, start, end
    public void createMaze()
    {   
        try
        {
            char ngrid[][] = new char[ROWS][COLS];
            
            Scanner file = new Scanner(new File("maze.txt"));
            
            ArrayList<String> lines = new ArrayList<>();
            
            while (file.hasNextLine()) {
                String line = file.nextLine();
                lines.add(line);
            }
            
            ngrid = new char[lines.size()][];
           
            for (int i = 0; i < ROWS; i++)
            {
                System.arraycopy(ngrid[i], 0, grid[i], 0, COLS);   
            }
        } 
        catch (IOException e)
        {
            System.out.println("IOException");
        }
    }
    
    public void getMaze()
    {
        for (int i = 0; i < ROWS; i++)
        {
            for (int j = 0; j < COLS; j++)
            {
                System.out.println(grid[i][j]);
            }
        }
    }
    
    //Tels if there is a clear space in index in question
    public boolean isClear(int row, int col){
        //if index is whitespace
        return grid[row][col] == ' ';
    }
    
    //Tels if there is a wall in index in question
    public boolean isWall(int row, int col){
        //if index in question is wall
        return grid[row][col] == 'x';
    }
    
    //Tels if there is a path at index in question
    public boolean isPath(int row, int col){
        //if index in question is path
        return grid[row][col] == 'P';
    }
    
    //Tels if there is a visited in index in question
    public boolean isVisited(int row, int col){
        //if index in question is visited
        return grid[row][col] == 'V'; 
    }
}