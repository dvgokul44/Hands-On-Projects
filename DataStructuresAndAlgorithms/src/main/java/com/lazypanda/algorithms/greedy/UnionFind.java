package com.lazypanda.algorithms.greedy;

/**
 * Union-Find algorithm implementation to detect a cycle in a graph with no self loops.
 *
 * A disjoint-set data structure is a data structure that keeps track of a set of elements
 * partitioned into a number of disjoint (non-overlapping) subsets.
 *
 * A union-find algorithm is an algorithm that performs two useful operations on such a data structure:
 *
 * Find: Determine which subset a particular element is in. This can be used for determining
 * if two elements are in the same subset.
 *
 * Union: Join two subsets into a single subset.
 */
public class UnionFind {

    int parent[];

    /**
     * @param graph is an instance of class Graph
     * parent[] is a 1D array to keep track of subsets of vertices.
     *
     */
    UnionFind(Graph graph){
        for(int i=0; i<graph.numVertices; i++){
            parent[i] = -1;
        }
    }

    /**
     * Finds the subset of element
     * @param element
     * @return integer subset to which element belongs
     */

    int find(int element){
        if(parent[element] == -1){
            return element;
        }
        return find(parent[element]);
    }

    /**
     * Performs union of two subsets to which element1 and element2 belong
     * @param element1 integer vertice
     * @param element2 integer vertice
     */

    void union(int element1, int element2){
        int set1 = find(element1);
        int set2 = find(element2);
        parent[element1] = element2;
    }

    /**
     * Checks if a graph contains cycle
     * @param graph instance of class Graph
     * @return integer 1 is graph is a cycle 0 otherwise
     */

    int isCycle(Graph graph){

        for(int i=0; i<graph.numEdges; i++){
            int element1 = find(graph.edges[i].source);
            int element2 = find(graph.edges[i].destination);

            if(element1 == element2)
                return 1;
            union(element1, element2);
        }
        return 0;
    }
}
