package main;

import static main.GraphApplication.randomGraph;

/**
 * Author: Froschauer Brian, Baldassare diego, De Luca Bruno
 * Date: 11/08/2018
 */
public class Main {

    public static void main(String[] args) {

        // create random graph
        Graph<Integer> graph = randomGraph();
        graph.print();
        System.out.println();

        GraphApplication<Integer> graphApplication = new GraphApplication<>();

        System.out.println("Flat Search path: " + graphApplication.flatSearch(graph));
        System.out.println("Depth First Search path: " + graphApplication.dfs(graph, 0));
        System.out.println("Breadth Search path: " + graphApplication.bfs(graph, 0));
    }
}
