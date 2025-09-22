package ch04;

import java.util.ArrayList;

public class GraphMain {
    public static void main(String[] args) {
        ArrayList<GraphNode> nodeList = new ArrayList<>();
        nodeList.add(new GraphNode("1", 0));
        nodeList.add(new GraphNode("2", 1));
        nodeList.add(new GraphNode("3", 2));
        nodeList.add(new GraphNode("4", 3));
        nodeList.add(new GraphNode("5", 4));

        Graph g = new Graph(nodeList);
        System.out.println(g);
        g.addDirectedEdge('1', '2');
        g.addDirectedEdge('1', '4');
        g.addDirectedEdge('1', '5');
        g.addDirectedEdge('2', '3');
        g.addDirectedEdge('2', '4');
        g.addDirectedEdge('3', '4');
        g.addDirectedEdge('4', '5');

        System.out.println(g);

        g.dfs(); // 깊이우선탐색 , 스택으로 구현
    }
}
