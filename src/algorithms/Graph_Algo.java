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
	@Override
	public void init(graph g) {
		this.dg = (DGraph) g;
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

	@Override
	public double shortestPathDist(int src, int dest) {
		LinkedList<node_data> nodeList  = (LinkedList) shortestPath(src, dest);
		double weightCounter = 0;
		int prev  = -1;
		ListIterator<node_data> listIterator = nodeList.listIterator(0);
		while (listIterator.hasNext()){
			int current = listIterator.next().getKey();
			if (prev != -1)
				weightCounter = weightCounter + dg.getEdge(prev,current).getWeight();
			prev = current;
		}
		return weightCounter;
	}

	@Override
	public List<node_data> shortestPath(int src, int dest) {
		// add priority queue and comperator for him. bts algo.
		ArrayList<node_data> nodeList = new ArrayList<node_data>();
		PriorityQueue<node_data> pq = new PriorityQueue<>();






		return nodeList;
	}

	private double dist(int s, int d){
		double dist = 0;
		return dist;
	}


	@Override
	public List<node_data> TSP(List<Integer> targets) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public graph copy() {
		DGraph newg = new DGraph(this.dg);
		return newg;
	}


}
