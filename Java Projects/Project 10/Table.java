//Nathan Hebert
//12/5/16
//This is the table class, that holds the identifiers in a string
package hebenathproj10;

//This is the hash table class
public class Table {
    
    //Variables
    int TABLESIZE = 53; 
    int prime;
    String hashtable[];
    
    //This is the constructor
    public Table(){
 
        hashtable = new String[TABLESIZE]; 
        
        //Instantiates all new indexes to null
        for (int i = 0; i < TABLESIZE; i++){
           hashtable[i] = null;
        }
    }
    
    //This is the insert method, which will determine what can go into the table
    public void insert(String item){
        
        //Variables
        int hash1 = Math.abs(item.hashCode()) % TABLESIZE;
        boolean input = true;  

    
        //If item is in list already
        for (int i = 0; i < TABLESIZE; i++){
            if(item.equals(hashtable[i])){
                System.out.println("You cannot enter this item, as it is already an identifier. Please try again.");
                input = false;
            }
        }
                
        //If the item is not in the list, continue
        if (input == true){
            
            //Or if item contains inappropriate symbols
            if(!item.startsWith("0") && !item.startsWith("1") && !item.startsWith("2") 
                && !item.startsWith("3") && !item.startsWith("4") && !item.startsWith("5") && !item.startsWith("6") 
                && !item.startsWith("7") && !item.startsWith("8") && !item.startsWith("9") && !item.contains("-")
                && !item.contains("+") && !item.contains("*") && !item.contains("/") && !item.contains("'") 
                && !item.contains("`") && !item.contains("~") && !item.contains("^") && !item.contains("(")
                && !item.contains(")") && !item.contains("@") && !item.contains("!")){

                //Inputs item if there is nothing at its address
                if (hashtable[hash1] == null)
                {
                  hashtable[hash1] = item;
                  System.out.println("Item successfully created");
                }
                //If there is a collision, it will create a new address
                else if (hashtable[hash1] != null){
                   int hash2 = Math.abs(item.hashCode()) %(TABLESIZE - 7);
                   hashtable[hash2] = item;
                   System.out.println("Item successfully created");
                }    
            }
            else //Else it contains one of those characters
             System.out.println("This identifier contains an invalid character. Please try again.");        
        }
    }
    
    //This is the display method which will display the table
    public void display(){
      
        //Displays table by way of for loop
        for (int i = 0; i < TABLESIZE; i++){
            if (hashtable[i] != null){
                System.out.println(hashtable[i]);
            }
        }   
    }
   
    //THhis is the delete method, which will delete a selected method
    public void delete(String item){
        
        //Variables for hahs
        int hash1 = Math.abs(item.hashCode()) % TABLESIZE;
        int hash2 = Math.abs(item.hashCode()) %(TABLESIZE - 7);
        
        //Searches list until it finds the hash address that matches the item address
        for (int i = 0; i < TABLESIZE; i++){
            if(hashtable[hash1] == hashtable[i]){
              hashtable[hash1] = null;
            }
            else if(hashtable[hash2] == hashtable[i]){
              hashtable[hash2] = null;      
            }
        }
        
        //If the index is now empty, it will say it is removed, if not, it will ouput that it is not found
        if (hashtable[hash1] == null || hashtable[hash2] == null){
          System.out.println("Successfully deleted " + item + " from the list");
        }
        else
          System.out.println("This item was not found, please try again.");
    }
}
