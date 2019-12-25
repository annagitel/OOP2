package gui;
import utils.*;
import dataStructure.*;
import algorithms.*;
import java.awt.*;
import java.util.Collection;
import java.util.Hashtable;
import java.util.Iterator;
import javax.swing.*;


public class Graph_GUI {

    public void drawGraph(int width, int height, Range rx, Range ry, int resolution, graph g) {
        StdDraw.setCanvasSize(width,height);                                           // set canvas size
        StdDraw.setYscale(ry.get_min(),ry.get_max());                                  // set X line
        StdDraw.setXscale(rx.get_min(),rx.get_max());                                  // set Y line

        double delta = rx.get_max()-rx.get_min()/resolution;
        Collection<node_data> nodes = g.getV();
        Iterator<node_data> it = nodes.iterator();
        StdDraw.setPenColor(StdDraw.BLACK);
        StdDraw.setPenRadius(0.005);
        Iterator<node_data> nit = g.getV().iterator();
        while (nit.hasNext()){
            Collection<edge_data> e = g.getE(nit.next().getKey());
            if (e != null){
                Iterator<edge_data> eit = e.iterator();
                while (eit.hasNext()) {
                    edge_data current = eit.next();
                    NodeData s = (NodeData) g.getNode(current.getSrc());
                    NodeData d = (NodeData) g.getNode(current.getDest());
                    StdDraw.line(s.getLocation().x(), s.getLocation().y(), d.getLocation().x(), d.getLocation().y());
                    StdDraw.text((s.getLocation().x()+d.getLocation().x())/2, (s.getLocation().y()+d.getLocation().y())/2, String.format("%.1f", current.getWeight()));
                }
            }
        }
        while (it.hasNext()){
            node_data current = it.next();
            StdDraw.setPenRadius(0.001);                                                   // set pen radius
            StdDraw.setPenColor(Color.yellow);
            StdDraw.filledCircle(current.getLocation().x(), current.getLocation().y(), 3);
            StdDraw.setPenColor(Color.BLACK);
            StdDraw.setPenRadius(0.005);
            StdDraw.circle(current.getLocation().x(), current.getLocation().y(), 3);
            StdDraw.text(current.getLocation().x(), current.getLocation().y(), String.valueOf(current.getKey()));
        }
    }

    public static void main(String[] args) {
        DGraph g = new DGraph();
        for (int i=0; i<10; i++){
            double x = Math.random()*100;
            double y = Math.random()*100;
            double z = Math.random()*100;
            Point3D p = new Point3D(x,y,z);
            g.addNode(p);
        }

        for (int i=0; i<10; i++){
            int s = (int) (Math.random() * 8);
            int d = (int) (Math.random()*8);
            while (s==d)
                d= (int) (Math.random()*10);
            g.connect(s,d,Math.random()*10);
        }
        Range x = new Range(0,100);
        Range y = new Range(0,100);

        Graph_GUI gg = new Graph_GUI();
        gg.drawGraph(500,500,x,y,2000,g);
    }
}
