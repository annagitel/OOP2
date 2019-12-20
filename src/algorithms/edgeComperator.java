package algorithms;
import dataStructure.EdgeData;

import java.util.Comparator;

public class edgeComperator implements Comparator<EdgeData> {

    public edgeComperator(){;}
    public int compare(EdgeData o1, EdgeData o2) {
        int i = o1.getSrc()-o2.getSrc();
        if (i == 0)
            i = o1.getDest()-o2.getDest();
        return i;
    }
}
