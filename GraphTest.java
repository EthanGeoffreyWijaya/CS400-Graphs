// --== CS400 File Header Information ==--
// Name: Ethan Geoffrey Wijaya
// Email: egwijaya@wisc.edu
// Team: CI
// TA: Tingjia Cao
// Lecturer: Florian Heimerl
// Notes to Grader:
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.platform.console.ConsoleLauncher;
import java.lang.invoke.MethodHandles;

/**
 * Tests the implementation of CS400Graph for the individual component of
 * Project Three: the implementation of Dijsktra's Shortest Path algorithm.
 */
public class GraphTest {

    private CS400Graph<String> graph;
    
    /**
     * Instantiate graph from last week's shortest path activity.
     */
    @BeforeEach
    public void createGraph() { // TODO: Make everything not static again later
        graph = new CS400Graph<>();
        // insert vertices A-F
        graph.insertVertex("A");
        graph.insertVertex("B");
        graph.insertVertex("C");
        graph.insertVertex("D");
        graph.insertVertex("E");
        graph.insertVertex("F");
        // insert edges from Week 11. Shortest Path Activity
        graph.insertEdge("A","B",6);
        graph.insertEdge("A","C",2);
        graph.insertEdge("A","D",5);
        graph.insertEdge("B","E",1);
        graph.insertEdge("B","C",2);
        graph.insertEdge("C","B",3);
        graph.insertEdge("C","F",1);
        graph.insertEdge("D","E",3);
        graph.insertEdge("E","A",4);
        graph.insertEdge("F","A",1);
        graph.insertEdge("F","D",1);
    }

    /**
     * Checks the distance/total weight cost from the vertex A to F.
     */
    @Test
    public void testPathCostAtoF() {
        assertTrue(graph.getPathCost("A", "F") == 3);
    }

    /**
     * Checks the distance/total weight cost from the vertex A to D.
     */
    @Test
    public void testPathCostAtoD() {
        assertTrue(graph.getPathCost("A", "D") == 4);
    }

    /**
     * Checks the ordered sequence of data within vertices from the vertex 
     * A to D.
     */
    @Test
    public void testPathAtoD() {
        assertTrue(graph.shortestPath("A", "D").toString().equals(
            "[A, C, F, D]"
        ));
    }

    /**
     * Checks the ordered sequence of data within vertices from the vertex 
     * A to F.
     */
    @Test
    public void testPathAtoF() {
        assertTrue(graph.shortestPath("A", "F").toString().equals(
            "[A, C, F]"
        ));
    }
    
    /**
     * Checks the distance/total weight cost from the vertex D to B.
     */
    @Test
    public void testPathCostDtoB() {
    	assertTrue(graph.getPathCost("D", "B") == 12);
    }
    
    /**
     * Checks the ordered sequence of data within vertices from the vertex 
     * D to B.
     */
    @Test
    public void testPathDtoB() {
        assertTrue(graph.shortestPath("D", "B").toString().equals(
            "[D, E, A, C, B]"
        ));
    }
    
    /**
     * Checks the ordered sequence of data within vertices from the vertex 
     * F to B, thus confirming C is B's predecessor.
     */
    @Test
    public void testPathFtoB() {
        assertTrue(graph.shortestPath("F", "B").toString().equals(
            "[F, A, C, B]"
        ));
    }
    
    /**
     * Checks the distance/total weight cost from the vertex B to F.
     */
    @Test
    public void testPathCostBtoF() {
    	assertTrue(graph.getPathCost("B", "F") == 3);
    }
    
    /**
     * Checks the distance/total weight cost from the vertex A to A.
     */
    @Test
    public void testPathCostAtoA() {
    	assertTrue(graph.getPathCost("A", "A") == 0);
    }

    public static void main(String[] args) {
    	
        String className = MethodHandles.lookup().lookupClass().getName();
        String classPath = System.getProperty("java.class.path").replace(" ", "\\ ");
        String[] arguments = new String[] {
          "-cp",
          classPath,
          "--include-classname=.*",
          "--select-class=" + className };
        ConsoleLauncher.main(arguments);
        
    	/*
    	createGraph();
    	System.out.println(graph.shortestPath("A", "F"));
    	*/
      }

}