package gui;
import utils.*;
import dataStructure.*;


public class Graph_GUI {

    public static void main(String[] args) {
        DGraph g = new DGraph();
        g.addNode("1,3,0");
        g.addNode("4,14,0");
        g.addNode("14,11,0");
        g.addNode("17,16,0");
        g.addNode("21,2,0");

        g.connect(1,2,2);
        g.connect(2,4,1);
        g.connect(4,5,7);
        g.connect(1,3,3);
        //g.connect(3,5,4);
        g.connect(5,1,6);
        g.connect(1,5,1);

        StdDraw.drawGraph(g);

    }
}
