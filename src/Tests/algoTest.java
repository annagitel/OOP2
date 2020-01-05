package Tests;
import static org.junit.jupiter.api.Assertions.*;

import dataStructure.DGraph;
import dataStructure.NodeData;
import dataStructure.graph;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import algorithms.*;
import utils.Point3D;

public class algoTest {
    static graph g = new DGraph();
@BeforeEach
    void createGraph(){
    Point3D p1=new Point3D(1,5,0);
    Point3D p2=new Point3D(5,5,0);
    Point3D p3=new Point3D(1,1,0);
    Point3D p4=new Point3D(5,1,0);
    Point3D p5=new Point3D(10,3,0);
    NodeData n1= new NodeData(1,p1);
    NodeData n2= new NodeData(2,p2);
    NodeData n3= new NodeData(3,p3);
    NodeData n4= new NodeData(4,p4);
    NodeData n5= new NodeData(5,p5);
    g.addNode(n1);
    g.addNode(n2);
    g.addNode(n3);
    g.addNode(n4);
    g.addNode(n5);

    g.connect(4,1,5);
    g.connect(5,3,6);
    g.connect(1,2,2);
    g.connect(1,3,1);
    g.connect(3,2,5);
    g.connect(3,4,5);
    g.connect(2,4,12);
    g.connect(4,5,10);
    g.connect(2,5,23);

}
@Test
    void isconetctedt(){


}

}
