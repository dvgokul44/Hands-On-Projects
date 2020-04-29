package com.lazypanda.algorithms.greedy;

import com.lazypanda.algorithms.exceptions.DSAException;
/**
 * Creates a representation of Graph
 */
public class Graph {

    int numVertices;
    int numEdges;
    Edge edges[];
    int edgeLimit;

    class Edge {
        int source;
        int destination;
    }

    /**
     * Initializes a graph with number of edges and vertices and an edge instance
     * @param v integer number of vertices
     * @param e integer number of edges
     */
    Graph(int v, int e) {
        numVertices = v;
        numEdges = e;

        for (int i = 0; i < numEdges; i++) {
            edges[i] = new Edge();
        }
        edgeLimit = 0;
    }

    /**
     * Add and edge to graph.
     * @param src integer source vertex of edge created
     * @param dest integer destination vertex of edge created
     * @throws DSAException
     */
    void addEdge(int src, int dest) throws DSAException {
        if (edgeLimit < numEdges) {
            edges[edgeLimit].source = src;
            edges[edgeLimit].destination = dest;
            edgeLimit += 1;
        } else {
            throw new DSAException("Can not add more edges to graph.");
        }
    }
}