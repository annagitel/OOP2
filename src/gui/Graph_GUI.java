package gui;
import utils.*;
import dataStructure.*;


public class Graph_GUI {

    public static void main(String[] args) {
        DGraph g = new DGraph();
        NodeData n1= new NodeData(1);
        NodeData n2= new NodeData(2);
        NodeData n3= new NodeData(3);
        NodeData n4= new NodeData(4);
        NodeData n5= new NodeData(5);
        g.addNode(n1);
        g.addNode(n2);
        g.addNode(n3);
        g.addNode(n4);
        g.addNode(n5);


        g.connect(1,2,2);
        g.connect(2,4,1);
        g.connect(4,5,7);
        g.connect(1,3,3);
        g.connect(3,5,4);
        g.connect(5,1,6);
        g.connect(1,5,1);

        StdDraw.drawGraph(g);

    }
}
