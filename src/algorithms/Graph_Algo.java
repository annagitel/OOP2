package algorithms;
// add priority queue and comperator for him. bts algo.
import java.util.*;

import com.sun.source.tree.ReturnTree;
import dataStructure.DGraph;
import dataStructure.edge_data;
import dataStructure.graph;
import dataStructure.node_data;
/**
 * This empty class represents the set of graph-theory algorithms
 * which should be implemented as part of Ex2 - Do edit this class.
 * @author Anna
 *
 */
public class Graph_Algo implements graph_algorithms{
	DGraph dg = new DGraph();
    public Graph_Algo(){}
	public void init(graph g) {
		this.dg = new DGraph(g);
	}

	@Override
	public void init(String file_name) {

	}

	@Override
	public void save(String file_name) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean isConnected() {
		for (node_data node: dg.getV()) {
			if (!isCon(node.getKey()))
				return false;
			this.zeroTags();
		}
		return true;
	}

	private boolean isCon (int node_key){
		changeTags(node_key);
		for (node_data node: dg.getV()) {
			if (node.getTag()!= 1)
				return false;
		}
		return true;
	}

	private void changeTags (int node_key){
		for (node_data node: dg.getV()) {
			int key = node.getKey();
			for (edge_data edge: dg.getE(key)) {
				int d = edge.getDest();
				if (dg.getNode(d).getTag() != 1) {
					dg.getNode(d).setTag(1);
					changeTags(d);
				}
			}
		}
	}
	
	private void zeroTags(){
		Collection<node_data> n = dg.getV();
		Iterator<node_data> it = n.iterator();
		while (it.hasNext()){
			it.next().setTag(0);
		}

		Iterator<node_data> nit = dg.getV().iterator();
		while (nit.hasNext()){
			Collection<edge_data> e = dg.getE(nit.next().getTag());
			Iterator<edge_data> eit = e.iterator();
			while (eit.hasNext()){
				eit.next().setTag(0);

			}
		}
	}

    public double shortestPathDist(int src, int dest) {
        List<node_data> path= shortestPath(src,dest);
        double answer=0;
        for (node_data nodesInPath:	path) {
            answer+=nodesInPath.getWeight();
        }
        return answer;
    }
    private void setTheSmallWeight(int dest, double w,int whereW){
        if (dg.getNode(dest).getWeight()>w){
            dg.getNode(dest).setWeight(w);
            dg.getNode(dest).setTag(whereW);
        }
    }
    private double sendTheWeight(int current, edge_data e){
        return dg.getNode(current).getWeight()+e.getWeight();
    }

    @Override
    public List<node_data> shortestPath(int src, int dest) {
        List<node_data> answer= new ArrayList<>();
        PriorityQueue<node_data> q = new PriorityQueue<node_data>(dg.getV().size(), new v_Comp());
        q.addAll(dg.getV());
        node_data current;
        dg.getNode(src).setWeight(0);
        while (!q.isEmpty()) {
            current=q.remove();
            dg.getNode(current.getKey()).setInfo("true");
            if (dg.getNode(current.getKey())!=null){
                for (edge_data e: dg.getE(current.getKey())) {
                    if (dg.getNode(e.getDest()).getInfo() == "false") {
                        setTheSmallWeight(e.getDest(), sendTheWeight(current.getKey(), e), current.getKey());
                    }
                }

            }

        }
        Stack<node_data> stack = new Stack<node_data>();
        stack.push(dg.getNode(dest));
        int temp=dg.getNode(dest).getTag();//the node before dest
        stack.push(dg.getNode(temp));
        while (temp!=src){// if we didnt came to src
            int temp2=dg.getNode(temp).getTag();
            temp=temp2;
            stack.push(dg.getNode(temp));
        }
        while (!stack.empty()){
            answer.add(stack.pop());
        }
        return answer;
    }

    private class v_Comp implements Comparator<node_data> {
        public v_Comp() {

        }

        @Override
        public int compare(node_data v2, node_data v1) {
            if (v1.getWeight() - v2.getWeight() > 0)
                return -1;
            else return 1;
        }
    }

    private double dist(int s, int d){
		double dist = 0;
		return dist;
	}


	@Override
    public List<node_data> TSP(List<Integer> targets) {

        List<node_data> TSP = new LinkedList<node_data>();
        Iterator<Integer> i = targets.iterator();
        int src=i.next();
        TSP.add(0,dg.getNode(src));
        while(i.hasNext())
        {
            int dest=i.next();
            List<node_data> temp = shortestPath(src,dest);
            if (temp==null) return null;
            temp.remove(0);//avoid duplicates
            TSP.addAll(temp);
            src=dest;
        }
        return TSP;
    }

	@Override
    public graph copy() {
        graph copyGraph = new DGraph();
        if (this.dg != null) {
            Collection<node_data> colleOfNodes = dg.getV();
            for (node_data node : colleOfNodes) {
                copyGraph.addNode(node);
                Collection<edge_data> edges = dg.getE(node.getKey());
                if (edges != null) {
                    for (edge_data edge : edges) {
                        copyGraph.connect(edge.getSrc(), edge.getDest(), edge.getWeight());
                    }
                }
            }

        }
        return copyGraph;
    }


}
