//Nathan Hebert 11/21/16
//This class is the priority queue .java file that is responsible for the priority queue
package project9;

//Priority Queue Class, which contains the methods of handling a sorted array based priority queue
public class PriorityQueue {
    
    //Data fields
    Float items[];
    Integer maxsize, count;
    
    //Creates a new queue
    public PriorityQueue(int size){
        
        maxsize = size;
        items = new Float[maxsize];
        count = 0;
    }
    
    //Returns if queue is empty
    public boolean isEmpty(){
        return count == 0;
    }
    
    //Inserts the item in its correct location in the array
    public void insert(Float newitem){
      int pos = count-1;
        
      //While the position is not at index 0 and newitem is less than the item in said index
      while(pos >= 0 && items[pos] >= newitem){
          
        items[pos+1] = items[pos]; //Assigning values to 1 higher index to make room for the new value
        --pos;
      }
      
      items[pos+1] = newitem; //Sets new item in its correct location
      ++count; //Add a new item to maxsize
      
    }
    
    //deletes and returns the last value in the sorted array
    public Float delete(){    
        
        --count;
        Float temp = items[count]; //store item in a temp location
        items[count] = null; //makes last item in queue null, or in other words, deletes it.
        
        return temp;
    }
    
    //Displays the items that are currently not null in the queue
    public void display(){
        
        for (int i = 0; i < maxsize-1; i++)
        {
            if(items[i] != null){
            System.out.print(items[i] + "  ");
            }
        }
    }
}
