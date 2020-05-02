import com.lazypanda.algorithms.exceptions.DSAException;
import com.lazypanda.algorithms.greedy.Graph;
import com.lazypanda.algorithms.greedy.UnionFind;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;


public class UnionFindTest {
    Graph graph;

    @Tag("Is-Cycle-Positive")
    @Test
    void isGraphPositive() throws DSAException {
        graph = new Graph(5,5);
        graph.addEdge(0,1);
        graph.addEdge(1,2);
        graph.addEdge(2,0);
        UnionFind checkCycle = new UnionFind(graph);
        Assertions.assertEquals(1,checkCycle.isCycle(graph));
    }

    @Tag("Is-Cycle-Partial-Negative")
    @Test
    void isGraphPartialNegative() throws DSAException{
        Graph graph = new Graph(5,4);
        graph.addEdge(0,1);
        graph.addEdge(1,2);
        graph.addEdge(2,3);
        graph.addEdge(3,4);
        UnionFind checkCycle = new UnionFind(graph);
        Assertions.assertEquals(0,checkCycle.isCycle(graph));

    }
}
