package com.anasim.masterdsa.ds.graphs;

import java.util.*;

public class MyGraph {

    private Map<Object, List<Object>> adjacentList;
    private int noOfNodes;

    MyGraph() {
        this.adjacentList = new HashMap<>();
        this.noOfNodes = 0;
    }

    public MyGraph addNode(Object node) {
        this.adjacentList.put(node, new ArrayList<>());
        this.noOfNodes += 1;
        return this;
    }

    public MyGraph addEdge(Object node1, Object node2) {
        this.adjacentList.get(node1).add(node2);
        this.adjacentList.get(node2).add(node1);
        return this;
    }

    @Override
    public String toString() {
        String res = "";
        Set<Object> nodes = this.adjacentList.keySet();
        for (Object node : nodes) {
            List<Object> connections = this.adjacentList.get(node);
            res = res + node + " --> " + connections + "\n";
        }
        return res;
    }

    public static void main(String[] args) {
        MyGraph mg = new MyGraph();
        System.out.println(mg.addNode(0));
        System.out.println(mg.addNode(1));
        System.out.println(mg.addNode(2));
        System.out.println(mg.addNode(3));
        System.out.println(mg.addNode(4));
        System.out.println(mg.addNode(5));
        System.out.println(mg.addNode(6));
        System.out.println(mg.addEdge(3, 1));
        System.out.println(mg.addEdge(3, 4));
        System.out.println(mg.addEdge(4, 2));
        System.out.println(mg.addEdge(4, 5));
        System.out.println(mg.addEdge(1, 2));
        System.out.println(mg.addEdge(1, 0));
        System.out.println(mg.addEdge(0, 2));
        System.out.println(mg.addEdge(6, 5));
    }
}
