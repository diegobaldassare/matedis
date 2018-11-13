package main;

/**
 * Author: Froschauer Brian, Baldassare diego, De Luca Bruno
 * Date: 11/08/2018
 */
public class Main {

    public static void main(String[] args) {

        // create random randomGraph
        Graph<Integer> randomGraph = GraphGenerator.randomGraph();

        Graph<Integer> exampleB = GraphGenerator.exampleB();

        randomGraph.print();
        System.out.println();

        GraphApplication<Integer> graphApplication = new GraphApplication<>();

        System.out.println("Flat Search path: " + graphApplication.flatSearch(randomGraph));
        System.out.println("Depth First Search path: " + graphApplication.dfs(randomGraph, 0));
        System.out.println("Breadth Search path: " + graphApplication.bfs(randomGraph, 0));
        System.out.println("Fleury: "); graphApplication.fleury(exampleB);
    }
}
