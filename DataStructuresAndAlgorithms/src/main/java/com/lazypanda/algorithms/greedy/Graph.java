package com.lazypanda.algorithms.greedy;

import com.lazypanda.algorithms.exceptions.DSAException;
/**
 * Creates a representation of Graph
 */
public class Graph {

    int numVertices;
    int numEdges;
    Edge edges[];

    public int getEdgeLimit() {
        return edgeLimit;
    }

    int edgeLimit;

    class Edge {
        int source;
        int destination;
    }

    public int getNumVertices() {
        return numVertices;
    }

    public int getNumEdges() {
        return numEdges;
    }

    public Edge[] getEdges() {
        return edges;
    }

    /**
     * Initializes a graph with number of edges and vertices and an edge instance
     * @param v integer number of vertices
     * @param e integer number of edges
     */
    public Graph(int v, int e) throws DSAException {
        numVertices = v;
        numEdges = e;

        if (numVertices<2){
            throw new DSAException("Number of vertices should be more than 1");
        }
        edges = new Edge[numEdges];
        for (int i=0; i<e; ++i)
            edges[i] = new Edge();
        edgeLimit = 0;
    }

    /**
     * Add and edge to graph.
     * @param src integer source vertex of edge created
     * @param dest integer destination vertex of edge created
     * @throws DSAException
     */
    public void addEdge(int src, int dest) throws DSAException {
        if (src>numVertices || dest>numVertices) throw new DSAException("Vertex not valid");
        if (src == dest) throw new DSAException("Self loop edge not valid");
        if (edgeLimit < numEdges) {
            edges[edgeLimit].source = src;
            edges[edgeLimit].destination = dest;
            edgeLimit += 1;
        } else {
            throw new DSAException("Can not add more edges to graph.");
        }
    }
}