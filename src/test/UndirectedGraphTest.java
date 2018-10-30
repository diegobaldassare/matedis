package test;

import main.Graph;
import main.UndirectedGraph;
import org.junit.jupiter.api.Test;

public class UndirectedGraphTest {

    @Test
    public void addEdge() {
        UndirectedGraph<String> graph = new UndirectedGraph<>(6);

        String a = "A";
        String b = "B";
        String c = "C";
        String d = "D";
        String e = "E";
        String f = "F";

        graph.addVertex(a);
        graph.addVertex(b);
        graph.addVertex(c);
        graph.addVertex(d);
        graph.addVertex(e);
        graph.addVertex(f);

        graph.addEdge(0, 1);
        graph.addEdge(1, 2);
        graph.addEdge(2, 3);
        graph.addEdge(3, 4);
        graph.addEdge(4, 5);
        graph.addEdge(5, 0);

        assert graph.hasEdge(0, 1);
        assert graph.hasEdge(1, 2);
        assert graph.hasEdge(2, 3);
        assert graph.hasEdge(3, 4);
        assert graph.hasEdge(4, 5);
        assert graph.hasEdge(5, 0);
        assert graph.hasEdge(1, 0);
        assert graph.hasEdge(2, 1);
        assert graph.hasEdge(3, 2);
        assert graph.hasEdge(4, 3);
        assert graph.hasEdge(5, 4);
        assert graph.hasEdge(0, 5);
    }

    @Test
    public void addVertex() {
        UndirectedGraph<String> graph = new UndirectedGraph<>(6);

        String a = "A";
        String b = "B";
        String c = "C";
        String d = "D";
        String e = "E";
        String f = "F";

        graph.addVertex(a);
        graph.addVertex(b);
        graph.addVertex(c);
        graph.addVertex(d);
        graph.addVertex(e);
        graph.addVertex(f);

        graph.addEdge(0, 1);
        graph.addEdge(1, 2);
        graph.addEdge(2, 3);
        graph.addEdge(3, 4);
        graph.addEdge(4, 5);
        graph.addEdge(5, 0);

        assert graph.getVertex(0).equals("A");
        assert graph.getVertex(1).equals("B");
        assert graph.getVertex(2).equals("C");
        assert graph.getVertex(3).equals("D");
        assert graph.getVertex(4).equals("E");
        assert graph.getVertex(5).equals("F");
    }

    @Test
    public void removeVertex() {
        UndirectedGraph<String> graph = new UndirectedGraph<>(6);

        String a = "A";
        String b = "B";
        String c = "C";
        String d = "D";
        String e = "E";
        String f = "F";

        graph.addVertex(a);
        graph.addVertex(b);
        graph.addVertex(c);
        graph.addVertex(d);
        graph.addVertex(e);
        graph.addVertex(f);

        graph.addEdge(0, 1);
        graph.addEdge(0, 4);
        graph.addEdge(1, 5);
        graph.addEdge(2, 3);
        graph.addEdge(2, 4);
        graph.addEdge(3, 4);
        graph.addEdge(3, 5);
        graph.addEdge(4, 5);

        graph.removeVertex(3);

        assert !graph.hasEdge(0, 0);
        assert  graph.hasEdge(0, 1);
        assert !graph.hasEdge(0, 2);
        assert  graph.hasEdge(0, 3);
        assert !graph.hasEdge(0, 4);
        assert !graph.hasEdge(1, 1);
        assert !graph.hasEdge(1, 2);
        assert !graph.hasEdge(1, 3);
        assert  graph.hasEdge(1, 4);
        assert !graph.hasEdge(2, 2);
        assert  graph.hasEdge(2, 3);
        assert !graph.hasEdge(2, 4);
        assert !graph.hasEdge(3, 3);
        assert  graph.hasEdge(3, 4);
        assert !graph.hasEdge(4, 4);

        Graph<String> graph1 = new UndirectedGraph<>(5);

        String bruno = "Bruno";
        String brian = "Brian";
        String tomas = "Tomas";
        String mati = "Mati";
        String alicia = "Alicia";

        graph1.addVertex(bruno);
        graph1.addVertex(brian);
        graph1.addVertex(tomas);
        graph1.addVertex(mati);
        graph1.addVertex(alicia);

        graph1.addEdge(0, 2);
        graph1.addEdge(1, 3);
        graph1.addEdge(0, 1);
        graph1.addEdge(3, 2);
        graph1.addEdge(4, 1);
        graph1.addEdge(4, 2);

        graph1.removeVertex(2);

        assert graph1.hasEdge(0, 1);
        assert graph1.hasEdge(2, 1);
        assert graph1.hasEdge(1, 3);

        assert !graph1.hasEdge(0, 2);
        assert !graph1.hasEdge(0, 3);
        assert !graph1.hasEdge(3, 2);
        assert !graph1.hasEdge(2, 3);
    }

    @Test
    public void removeEdge() {
        UndirectedGraph<String> graph = new UndirectedGraph<>(6);

        String a = "A";
        String b = "B";
        String c = "C";
        String d = "D";
        String e = "E";
        String f = "F";

        graph.addVertex(a);
        graph.addVertex(b);
        graph.addVertex(c);
        graph.addVertex(d);
        graph.addVertex(e);
        graph.addVertex(f);

        graph.addEdge(0, 1);
        graph.addEdge(1, 2);
        graph.addEdge(2, 3);
        graph.addEdge(3, 4);
        graph.addEdge(4, 5);
        graph.addEdge(5, 0);

        graph.removeEdge(0, 1);
        graph.removeEdge(1, 2);
        graph.removeEdge(2, 3);
        graph.removeEdge(3, 4);
        graph.removeEdge(4, 5);
        graph.removeEdge(5, 0);

        assert !graph.hasEdge(0, 1);
        assert !graph.hasEdge(1, 2);
        assert !graph.hasEdge(2, 3);
        assert !graph.hasEdge(3, 4);
        assert !graph.hasEdge(4, 5);
        assert !graph.hasEdge(5, 0);
    }

    @Test
    public void hasEdge() {
    }

    @Test
    public void edgesAmount() {
    }

    @Test
    public void getVertex() {
    }

    @Test
    public void order() {
    }

    @Test
    public void getAdjList() {
    }
}
