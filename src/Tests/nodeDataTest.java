package Tests;

import dataStructure.NodeData;
import org.junit.Test;
import static org.junit.jupiter.api.Assertions.*;

public class nodeDataTest {

    @Test
    public void getTest(){
        NodeData n1 = new NodeData("(5,6,7)");
        NodeData n2 = new NodeData("(-3,5,100)");
        NodeData n3 = new NodeData(n2.getLocation());
        NodeData n4 = new NodeData(n1.getLocation());
        NodeData n5 = new NodeData();
        NodeData n6 = new NodeData(-9, n5.getLocation());

        assertEquals(n1.getLocation().toString(), "5.0,6.0,7.0");
        assertEquals(n1.getWeight(), n3.getWeight());
        assertEquals(n6.getKey(), 9);
        assertEquals(n6.getWeight(),90);
        assertEquals(n2.getLocation(), n3.getLocation());
        assertEquals(n5.getInfo(), "Node number: 0\n" + " Location: 0.0,0.0,0.0\n" + " Weight: 0.0\n" + "Tag: 0");

    }

    @Test
    public void setTest(){
        NodeData n1 = new NodeData("(5,6,7),4.0");
        NodeData n2 = new NodeData("(-3,5,100) , 78.5");
        NodeData n3 = new NodeData();
        NodeData n4 = new NodeData();

        n3.setLocation(n2.getLocation());
        n4.setLocation(n1.getLocation());
        n3.setWeight(n1.getWeight());
        n4.setWeight(n2.getWeight());

        assertEquals(n1.getLocation(),n4.getLocation());
        assertEquals(n2.getLocation(),n3.getLocation());
        assertEquals(n1.getWeight(),n3.getWeight());
        assertEquals(n2.getWeight(),n4.getWeight());

        n1.setInfo("(-3,5,100) , 78.5");
        n2.setInfo("(5,6,7),4.0");

        assertEquals(n1.getLocation(),n3.getLocation());
        assertEquals(n2.getLocation(),n4.getLocation());
        assertEquals(n1.getWeight(),n4.getWeight());
        assertEquals(n2.getWeight(),n3.getWeight());

        n1.setTag(0);
        n2.setTag(-3);
        n3.setTag(2);
        n4.setTag(1);

        assertEquals(n1.getTag(),n2.getTag());
        assertEquals(n3.getTag(),2);
        assertEquals(n4.getTag(),1);
    }



}
