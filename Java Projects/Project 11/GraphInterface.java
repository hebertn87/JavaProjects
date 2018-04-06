/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Graph;

/**
 *
 * @author Garth
 * @param <T>
 */
public interface GraphInterface<T> {
    
    public boolean isEmpty();
    // Determines whether the graph is empty.

    public int getNumVertices();
    // Determines the number of vertices in the graph.
    // Precondition: None.
    // Postcondition: Returns the number of vertices in
    // the graph.
    
    public int getNumEdges();
    // Determines the number of edges in the graph.
    // Precondition: None.
    // Postcondition: Returns the number of edges in
    // the graph.
    
    public boolean isEdge(T v1, T v2);
    // Determines whether there is an edge between vertices v1 and v2.
    
    public void insertVertex(T newV) throws GraphException;
    // Inserts newV into the graph whose items are distinct from newV's item.
    // Throws GraphException if the insertion is not successful.
    
    public void insertEdge(T v1, T v2) throws GraphException;
    // Inserts an edge between vertices v1 and v2 if there is not already an
    // edge.
    // Precondition: The vertices exist in the graph.
    // Postcondition: The edge is part of the graph.
    // Throws GraphException if the insertion is not successful.
    
    public void deleteVertex(T v) throws GraphException;
    // Deletes a vertex from the graph and any edges between the vertex and
    // other vertices.
    // Precondition: The vertex exists in the graph.
    // Postcondition: The vertex and associated edges are no longer in the
    // graph.
    // Throws a GraphException if the deletion is not successful.
    
    public void deleteEdge(T v1, T v2) throws GraphException;
    // Deletes the edge between vertices v1 and v2.
    // Precondition: The edge exists in the graph.
    // Postcondition: The edge is no longer in the graph.
    // Throws a GraphException if the deletion is not successful.
    
    public void display();
    // Displays all graph information by displaying each vertex's item wuth
    // a list of adjacent vertices' items.
        
}
