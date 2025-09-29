package ch04;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Graph {
    ArrayList<GraphNode> nodeList; // 그래프 노드 리스트
    int[][] adjMatrix; // 인접행렬

    public Graph(ArrayList<GraphNode> nodeList) {
        this.nodeList = nodeList;
        adjMatrix = new int[nodeList.size()][nodeList.size()];
    }

    public void addDirectedEdge(int i, int j) {
        i = i - '1';
        j = j - '1';
        adjMatrix[i][j] = 1;
    }

    public void addUndirectedEdge(int i, int j) {
        adjMatrix[i][j] = 1;
        adjMatrix[j][i] = 1;
    }

    @Override
    public String toString() {
        System.out.println("== 그래프 인접 행렬 ==");
        StringBuilder sb = new StringBuilder();
        sb.append("  ");
        for (int i = 0; i < nodeList.size(); i++) {
            sb.append(nodeList.get(i).getName() + " ");
        }
        sb.append("\n");
        for (int i = 0; i < nodeList.size(); i++) {
            sb.append(nodeList.get(i).getName() + " ");
            for (int j : adjMatrix[i]) {
                sb.append(j + " ");
            }
            sb.append("\n");
        }
        return sb.toString();
    }

    public void dfs() {
        for (GraphNode node : nodeList) {
            if (!node.isVisited()) {
                dfsVisit(node);
            }
        }
    }

    private void dfsVisit(GraphNode node) {
        Stack<GraphNode> stack = new Stack<>();
        stack.push(node);

        while (!stack.isEmpty()) {
            GraphNode currentNode = stack.pop();
            currentNode.setVisited(true);
            System.out.print(currentNode.getName() + " ");

            ArrayList<GraphNode> neighbors = getNeighbors(currentNode);
            for (GraphNode neighbor : neighbors) {
                if (!neighbor.isVisited()) {
                    stack.push(neighbor);
                    neighbor.setVisited(true);
                }
            }
        }
    }

    private ArrayList<GraphNode> getNeighbors(GraphNode currentNode) {
        ArrayList<GraphNode> neighbors = new ArrayList<>();
        int index = currentNode.getIndex();
        for (int i = 0; i < adjMatrix.length; i++) {
            if (adjMatrix[index][i] == 1) {
                neighbors.add(nodeList.get(i));
            }
        }
        return neighbors;
    }

    public void bfs() {
        for (GraphNode node : nodeList) {
            if(!node.isVisited()) {
                bfsVisit(node);
            }
        }
    }

    private void bfsVisit(GraphNode node) {
        Queue<GraphNode> queue = new LinkedList<>();
        queue.add(node);

        while(!queue.isEmpty()) {
            GraphNode currentNode = queue.remove();
            System.out.print(currentNode.getName() + " ");
            currentNode.setVisited(true);
            ArrayList<GraphNode> neighbors = getNeighbors(currentNode);
            for (GraphNode neighbor : neighbors) {
                if (!neighbor.isVisited()) {
                    queue.add(neighbor);
                    neighbor.setVisited(true);
                }
            }
        }
    }
}
