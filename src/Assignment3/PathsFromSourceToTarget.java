package Assignment3;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class PathsFromSourceToTarget {
    public static void main(String[] args) {
        int[][] graph = {{1,2},{3},{3},{}};

        var object = new PathsFromSourceToTarget();
        var res = object.allPathsSourceTarget(graph);
        System.out.println(res);
    }
     static int target;
     int [][]graph;
     List<List<Integer>> results;
    public  List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        this.target = graph.length-1;
        this.graph = graph;
        this.results = new ArrayList<>();
        LinkedList<Integer> path = new LinkedList<>();
        path.add(0);
        this.backtrack(0,path);
        return this.results;
    }
    public void backtrack(int currNode, LinkedList<Integer> path) {
        if (currNode == this.target) {
            this.results.add(new ArrayList<Integer>(path));
            return;
        }
        for (int nextNode : this.graph[currNode]) {
            path.addLast(nextNode);
            this.backtrack(nextNode, path);
            path.removeLast();
        }
    }
}
