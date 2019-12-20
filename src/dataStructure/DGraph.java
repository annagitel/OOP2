package dataStructure;

import java.util.Collection;
import java.util.Hashtable;
import java.util.LinkedList;

public class DGraph implements graph{
	private Hashtable<Integer, Hashtable<Integer, edge_data>> edges;
	private Hashtable<Integer, node_data> nodes;
	private int nodeCount = 0;
/************constractors***************************/
	public DGraph(){

	}
	public DGraph (String fileName){

	}

	@Override
	public node_data getNode(int key) {
		return nodes.get(key);
	}

	@Override
	public edge_data getEdge(int src, int dest) {
		return edges.get(src).get(dest);
	}

	@Override
	public void addNode(node_data n) {
		nodes.put(nodeCount, n);
	}

	@Override
	public void connect(int src, int dest, double w) {
		EdgeData ed = new EdgeData(src,dest,w);
		if (edges.containsKey(src)){
			edges.get(src).put(dest,ed);
		}
		else {
			edges.put(src,new Hashtable<>());
			edges.get(src).put(dest,ed);
		}
	}

	@Override
	public Collection<node_data> getV() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Collection<edge_data> getE(int node_id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public node_data removeNode(int key) {
		NodeData n = (NodeData) nodes.get(key);
		nodes.remove(key);

		if(edges.containsKey(key)){
			edges.remove(key);
		}
		return n;
	}

	@Override
	public edge_data removeEdge(int src, int dest) {
		EdgeData e = (EdgeData) edges.get(src).get(dest);
		edges.get(src).remove(dest);
		if (edges.get(src).isEmpty())
			edges.remove(src);

		return e;
	}

	@Override
	public int nodeSize() {
		return nodes.size();
	}

	@Override
	public int edgeSize() {
		return edges.size();
	}

	@Override
	public int getMC() {
		// TODO Auto-generated method stub
		return 0;
	}

}
