package com.lazypanda.algorithms.greedy;

/**
 * Creates a representation of Graph
 */
public class Graph {

    int numVertices;
    int numEdges;
    Edge edges[];

    class Edge{
        int source;
        int destination;
    }

    /**
     * Initializes
     * @param v integer number of vertices
     * @param e integer number of edges
     */
    Graph(int v, int e){
        numVertices = v;
        numEdges = e;

        for(int i=0; i<numEdges; i++){
            edges[i] = new Edge();
        }
    }

}
