package ch04;

import lombok.Data;

@Data
public class GraphNode {
    private String name;
    private int index;
    private boolean visited;

    public GraphNode(String name, int index) {
        this.name = name;
        this.index = index;
        this.visited = false;
    }
}
