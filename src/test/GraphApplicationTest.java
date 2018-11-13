package test;

import main.Graph;
import main.GraphApplication;
import main.GraphGenerator;
import org.junit.jupiter.api.Test;

import java.util.List;

/**
 * Created by Diego Baldassare on 2018-11-13.
 */
public class GraphApplicationTest {

    @Test
    void dfsTest() {
        Graph<Integer> graph = GraphGenerator.exampleA();
        GraphApplication graphApplication = new GraphApplication();
        List dfs = graphApplication.dfs(graph, 0);
        System.out.println(dfs);
    }

    @Test
    void bfsTest() {
        Graph<Integer> graph = GraphGenerator.exampleA();
        GraphApplication graphApplication = new GraphApplication();
        List bfs = graphApplication.bfs(graph, 0);
        System.out.println(bfs);
    }

    @Test
    void fleuryTest() {
        Graph<Integer> graph = GraphGenerator.exampleB();
        GraphApplication graphApplication = new GraphApplication();
        graphApplication.fleury(graph, 2);
    }
}
