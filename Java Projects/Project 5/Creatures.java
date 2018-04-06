//Creature Class tells the current position of creature
//Contains operations to move creature based on maze
package hebenathproj5;

//Creature class
public class Creatures 
{
    //variable
    boolean success = false;
    
    //Determines if creature should go north
    public boolean goNorth(Maze maze, Creatures creature) 
    {
        if (0==0/*square north is clear inside maze and unvisited*/)
        {
           //move creatuer north
           //mark square as part of path
           if (0==0) //at exit
           {
               success = true;
           }
           else {
               success = goNorth(maze, creature);
               if(!success)
               {
                   success = goWest(maze, creature);
                   if(!success)
                   {
                       success = goEast(maze, creature);
                       if(!success)
                       {
                           //mark square as visited
                           //go south
                       }
                   }
               }
           }
        }
        else{
            success = false;
        }
        return success;    
    }
    
    //Determines if creature should go west
    public boolean goWest(Maze maze, Creatures creature) 
    {
        if (0==0/*square west is clear inside maze and unvisited*/)
        {
           //move creatuer west
           //mark square as part of path
           if (0==0) //at exit
           {
               success = true;
           }
           else {
               success = goNorth(maze, creature);
               if(!success)
               {
                   success = goEast(maze, creature);
                   if(!success)
                   {
                       success = goSouth(maze, creature);
                       if(!success)
                       {
                           //mark square as visited
                           //go east
                       }
                   }
               }
           }
        }
        else
        {
            success = false;
        }
        return success;
    }
    
    //Determines if creature should go east
    public boolean goEast(Maze maze,Creatures creature) 
    {
        if (0==0/*square north is clear inside maze and unvisited*/)
        {
           //move creatuer east
           //mark square as part of path
           if (0==0) //at exit
           {
               success = true;
           }
           else {
               success = goNorth(maze, creature);
               if(!success)
               {
                   success = goEast(maze, creature);
                   if(!success)
                   {
                       success = goSouth(maze, creature);
                       if(!success)
                       {
                           //mark square as visited
                           //backtrack west
                       }
                   }
               }
           }
        }
        else
        {
            success = false;
        }
        return success;
    }
    
    //Determines if creatuer should go south
    public boolean goSouth(Maze maze, Creatures creature) 
    {
        if (0==0/*square south is clear inside maze and unvisited*/)
        {
           //move creatuer south
           //mark square as part of path
           if (0==0) //at exit
           {
               success = true;
           }
           else {
               success = goWest(maze, creature);
               if(!success)
               {
                   success = goEast(maze, creature);
                   if(!success)
                   {
                       success = goSouth(maze, creature);
                       if(!success)
                       {
                           //mark square as visited
                           //bactrack north
                       }
                   }
               }
           }
        }
        else
        {
            success = false;
        }
        return success;
    }
}
