package ch04;

import java.util.ArrayList;

public class TopologicalSortMain {
    public static void main(String[] args) {
        ArrayList<GraphNode> nodeList = new ArrayList<>();
        nodeList.add(new GraphNode("1", 0));
        nodeList.add(new GraphNode("2", 1));
        nodeList.add(new GraphNode("3", 2));
        nodeList.add(new GraphNode("4", 3));
        nodeList.add(new GraphNode("5", 4));
        nodeList.add(new GraphNode("6", 5));
        nodeList.add(new GraphNode("7", 6));

        Graph g = new Graph(nodeList);

        g.addDirectedEdge('1', '2');
        g.addDirectedEdge('1', '4');
        g.addDirectedEdge('2', '4');
        g.addDirectedEdge('2', '6');
        g.addDirectedEdge('3', '4');
        g.addDirectedEdge('3', '5');
        g.addDirectedEdge('4', '6');
        g.addDirectedEdge('5', '6');
        g.addDirectedEdge('5', '7');
        g.addDirectedEdge('6', '7');

        System.out.println(g);

        g.topologicalSort();
    }
}
