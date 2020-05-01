import com.lazypanda.algorithms.exceptions.DSAException;
import com.lazypanda.algorithms.greedy.Graph;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.fail;

public class GraphSetupTest {
    static Graph graph;
    @BeforeAll
    static void setup() throws DSAException {
        graph = new Graph(3,3);
    }

    @Tag("Vertices-Positive")
    @Test
    void verticesPositiveTest(){
        Assertions.assertEquals(3, graph.getNumVertices());
        System.out.println("Vertices-Positive Test Passed");

    }

    @Tag("Vertices-Negative")
    @Test
    void verticesNegativeTest(){
        try {
            Graph gr = new Graph(1, 3);
        }
        catch (DSAException e){
            Assertions.assertEquals(true,true);
            System.out.println(e.getMessage());
            System.out.println("Vertices-Negative Test Passed");
        }
    }

    @Tag("Edges-Positive")
    @Test
    void edgesPositiveTest(){
        Assertions.assertEquals(3, graph.getNumEdges());
        System.out.println("Edge-Positive Test Passed");
    }

    @Tag("Add Edge-Postive")
    @Test
    void addEdgePositiveTest() throws DSAException{
        graph.addEdge(0,1);
        graph.addEdge(0,2);
        graph.addEdge(1,2);

        Assertions.assertEquals(true, graph.getEdgeLimit() <= graph.getNumEdges());
    }

    @Tag("Add Edge-Negative-Invalid Vertex")
    @Test
    void addEdgeTypeTest() throws DSAException{
        try{
            graph.addEdge(3,4);
            fail("Add Edge-Negative-Self Loop Test Failed");
        }
        catch (DSAException e){
            System.out.println(e);
            System.out.println("Add Edge-Negative-Invalid Vertex Passed");
            Assertions.assertEquals(true,true);
        }
    }

    @Tag("Add Edge-Negative-Self Loop")
    @Test
    void addEdgeLoopTest() throws DSAException{
        try{
            graph.addEdge(2,2);
            fail("Add Edge-Negative-Self Loop Test Failed");
        }
        catch (DSAException e){
            System.out.println(e);
            System.out.println("Add Edge-Negative-Self Loop Test Passed");
            Assertions.assertEquals(true,true);
        }
    }

    @Tag("Add Edge-Negative-Edge Limit")
    @Test
    void addEdgeLimitTest() throws DSAException{
        try{
            graph.addEdge(1,2);
            fail("Add Edge-Negative-Edge Limit Test Failed");
        }
        catch (DSAException e){
            System.out.println(e);
            System.out.println("Add Edge-Negative-Edge Limit Test Passed");
            Assertions.assertEquals(true,true);
        }
    }
}