package test;

import main.Edge;
import main.UndirectedGraph;
import org.junit.jupiter.api.Test;

class UndirectedGraphTest {

    @Test
    void addEdgeTest() {
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

        Edge<String> e1 = new Edge<>(a, b);
        Edge<String> e2 = new Edge<>(b, c);
        Edge<String> e3 = new Edge<>(c, d);
        Edge<String> e4 = new Edge<>(d, e);
        Edge<String> e5 = new Edge<>(e, f);
        Edge<String> e6 = new Edge<>(f, a);

        graph.addEdge(e1);
        graph.addEdge(e2);
        graph.addEdge(e3);
        graph.addEdge(e4);
        graph.addEdge(e5);
        graph.addEdge(e6);

        assert graph.hasEdge(e1);
        assert graph.hasEdge(e2);
        assert graph.hasEdge(e3);
        assert graph.hasEdge(e4);
        assert graph.hasEdge(e5);
        assert graph.hasEdge(e6);
    }


    @Test
    void getVertexTest() {
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

        Edge<String> e1 = new Edge<>(a, b);
        Edge<String> e2 = new Edge<>(b, c);
        Edge<String> e3 = new Edge<>(c, d);
        Edge<String> e4 = new Edge<>(d, e);
        Edge<String> e5 = new Edge<>(e, f);
        Edge<String> e6 = new Edge<>(f, a);

        graph.addEdge(e1);
        graph.addEdge(e2);
        graph.addEdge(e3);
        graph.addEdge(e4);
        graph.addEdge(e5);
        graph.addEdge(e6);

        assert graph.getVertex(0).equals("A");
        assert graph.getVertex(1).equals("B");
        assert graph.getVertex(2).equals("C");
        assert graph.getVertex(3).equals("D");
        assert graph.getVertex(4).equals("E");
        assert graph.getVertex(5).equals("F");
    }


    @Test
    public void removeVertexTest() {
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

        Edge<String> e1 = new Edge<>(a, b);
        Edge<String> e2 = new Edge<>(b, c);
        Edge<String> e3 = new Edge<>(c, d);
        Edge<String> e4 = new Edge<>(d, e);
        Edge<String> e5 = new Edge<>(e, f);
        Edge<String> e6 = new Edge<>(f, a);

        graph.addEdge(e1);
        graph.addEdge(e2);
        graph.addEdge(e3);
        graph.addEdge(e4);
        graph.addEdge(e5);
        graph.addEdge(e6);

        graph.removeVertex(a);

        assert !graph.hasEdge(e1);
        assert  graph.hasEdge(e2);
        assert  graph.hasEdge(e3);
        assert  graph.hasEdge(e4);
        assert  graph.hasEdge(e5);
        assert !graph.hasEdge(e6);
    }

    @Test
    void removeEdgeTest() {
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

        Edge<String> e1 = new Edge<>(a, b);
        Edge<String> e2 = new Edge<>(b, c);
        Edge<String> e3 = new Edge<>(c, d);
        Edge<String> e4 = new Edge<>(d, e);
        Edge<String> e5 = new Edge<>(e, f);
        Edge<String> e6 = new Edge<>(f, a);

        graph.addEdge(e1);
        graph.addEdge(e2);
        graph.addEdge(e3);
        graph.addEdge(e4);
        graph.addEdge(e5);
        graph.addEdge(e6);

        graph.removeEdge(e1);
        graph.removeEdge(e2);
        graph.removeEdge(e3);
        graph.removeEdge(e4);
        graph.removeEdge(e5);
        graph.removeEdge(e6);

        assert !graph.hasEdge(e1);
        assert !graph.hasEdge(e2);
        assert !graph.hasEdge(e3);
        assert !graph.hasEdge(e4);
        assert !graph.hasEdge(e5);
        assert !graph.hasEdge(e6);
    }

    @Test
    void edgesAmountTest() {
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

        Edge<String> e1 = new Edge<>(a, b);
        Edge<String> e2 = new Edge<>(b, c);
        Edge<String> e3 = new Edge<>(c, d);
        Edge<String> e4 = new Edge<>(d, e);
        Edge<String> e5 = new Edge<>(e, f);
        Edge<String> e6 = new Edge<>(f, a);

        graph.addEdge(e1);
        graph.addEdge(e2);
        graph.addEdge(e3);
        graph.addEdge(e4);
        graph.addEdge(e5);
        graph.addEdge(e6);

        assert graph.edgesAmount() == 6;
    }

    @Test
    void orderTest() {
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

        Edge<String> e1 = new Edge<>(a, b);
        Edge<String> e2 = new Edge<>(b, c);
        Edge<String> e3 = new Edge<>(c, d);
        Edge<String> e4 = new Edge<>(d, e);
        Edge<String> e5 = new Edge<>(e, f);
        Edge<String> e6 = new Edge<>(f, a);

        graph.addEdge(e1);
        graph.addEdge(e2);
        graph.addEdge(e3);
        graph.addEdge(e4);
        graph.addEdge(e5);
        graph.addEdge(e6);

        assert graph.order() == 6;
    }
}