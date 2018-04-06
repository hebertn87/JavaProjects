//Nathan Hebert
//12/14/2016
//This class is the graph class
package graph;

/**
 *
 * @author Nathan
 * @param <T>
 */
public class Graph<T> implements GraphInterface<T> {
    
    //Variables
    private Integer numvertices;
    private final Integer[][] adjmatrix;
    private final int SIZE;
    private final T[] vertex;
    
    //Constructor
    public Graph(int size){   
      SIZE = size;
      numvertices = 0;
      adjmatrix = new Integer[size][size];  
      vertex = (T[])(new Object[size]);
    }
    
    //Determines whether the graph is empty
    public boolean isEmpty(){ 
        
        boolean bool = false;
        
        if (adjmatrix == null) {
            bool = true;
        }
        
        return bool;
    }
    
    // Determines the number of vertices in the graph.
    // Precondition: None.
    // Postcondition: Returns the number of vertices in
    // the graph.
    public int getNumVertices(){     
        return numvertices;
    }
    
    // Determines the number of edges in the graph.
    // Precondition: None.
    // Postcondition: Returns the number of edges in
    // the graph.
    public int getNumEdges(){
        
        int numedge = 0;
        
        //Iterates when and finds how many edges are in the graph
        for (int i = 0; i < SIZE; i++){
            for (int j = 0; j < SIZE; j++){
                if (adjmatrix[i][j] != 0)
                    numedge++;
            }
        }
        
        return numedge;
    }
    
    // Determines whether there is an edge between vertices v1 and v2.
    public boolean isEdge(Object v1, Object v2){
        
        boolean isedge = false;
        
        if (adjmatrix[v1.hashCode()][v2.hashCode()] == 1){
            isedge = true;
        }
        
        return isedge;
    }
    
    // Inserts newV into the graph whose items are distinct from newV's item.
    // Throws GraphException if the insertion is not successful.
    public void insertVertex(T newV) throws GraphException {
        
        int index = 0;
        
        //Will add up the index till it finds a null index
        while (vertex[index] != null){
            index++;
        }
        
        //Inserts new item at index and adds 1 to the total number of vertices
        vertex[index] = newV;
        numvertices++;
    }
    
    // Inserts an edge between vertices v1 and v2 if there is not already an
    // edge.
    // Precondition: The vertices exist in the graph.
    // Postcondition: The edge is part of the graph.
    // Throws GraphException if the insertion is not successful.
    public void insertEdge(T v1, T v2) throws GraphException{
      
        //If there is an edge between the 2
        if (isEdge(v1, v2)){
            System.out.println("There is already an edge between these two.");
        }
        else{}
           adjmatrix[v1.hashCode()][v2.hashCode()] = 1;          
    }
    
    // Deletes a vertex from the graph and any edges between the vertex and
    // other vertices.
    // Precondition: The vertex exists in the graph.
    // Postcondition: The vertex and associated edges are no longer in the
    // graph.
    // Throws a GraphException if the deletion is not successful.
    public void deleteVertex(T v) throws GraphException{
        
        //Will assign the vertex you want to delete to null, unless it's not found
        for (int i = 0; i < SIZE; i++){
            if (vertex[i] == v)
            {
                vertex[i] = null;
            }
            else
                System.out.println("This vertex does not exist.");
        }
    }
    
    // Deletes the edge between vertices v1 and v2.
    // Precondition: The edge exists in the graph.
    // Postcondition: The edge is no longer in the graph.
    // Throws a GraphException if the deletion is not successful.
    public void deleteEdge(T v1, T v2) throws GraphException{
        if(isEdge(v1, v2)){
           adjmatrix[v1.hashCode()][v2.hashCode()] = null;
        }
    }
    
    // Displays all graph information by displaying each vertex's item wuth
    // a list of adjacent vertices' items.
    public void display(){
            
            //Outputs the vertices
            for (int h = 0; h < SIZE; h++){
                System.out.print(vertex[h] + "   ");  
            }
            
            //Displays the adjacency list
            for (int i = 0; i <= SIZE; i++){
                System.out.print(vertex[i] + "   ");    
                for (int j = 0; j < SIZE; j++){
                    System.out.print(adjmatrix[i][j] + " ");           

                }
                System.out.println("");
            }
    }
}
