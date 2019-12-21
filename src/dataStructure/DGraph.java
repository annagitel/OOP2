package dataStructure;

import utils.Point3D;
import java.util.Collection;
import java.util.Hashtable;

public class DGraph implements graph{
	private Hashtable<Integer, Hashtable<Integer, edge_data>> edges;
	private Hashtable<Integer, node_data> nodes;
	public int modeCount =0;
	private int nodeCount = 0;

	/************constractors***************************/
	public DGraph(){

	}

	public DGraph (String fileName){

	}

	public DGraph(graph g){}

	/********** public methods ************************/
	public node_data getNode(int key) {
		return nodes.get(key);
	}

	public edge_data getEdge(int src, int dest) {
		return edges.get(src).get(dest);
	}

	public void addNode(node_data n) {
		if (!nodes.containsKey(n.getKey())){
			nodes.put(nodeCount, n);
			nodeCount++;
		}
	}

	public void addNode(Point3D l, double w){
		NodeData n = new NodeData(nodeCount,l,w);
		this.addNode(n);
	}

	public void connect(int src, int dest, double w) {
		EdgeData ed = new EdgeData(src,dest,w);
		if (edges.containsKey(src)){
			if (edges.get(src).containsKey(dest))
				System.out.println("The nodes are already connected.");
			edges.get(src).put(dest,ed);
		}
		else {
			edges.put(src,new Hashtable<>());
			edges.get(src).put(dest,ed);
		}
	}

	public Collection<node_data> getV() {
		Collection<node_data> c = nodes.values();
		return c;
	}

	public Collection<edge_data> getE(int node_id) {
		Collection<edge_data> c =edges.get(node_id).values();
		return c;
	}

	public node_data removeNode(int key) {
		NodeData n = (NodeData) nodes.get(key);
		nodes.remove(key);

		if(edges.containsKey(key)){
			edges.remove(key);
		}
		return n;
	}

	public edge_data removeEdge(int src, int dest) {
		EdgeData e = (EdgeData) edges.get(src).get(dest);
		edges.get(src).remove(dest);
		if (edges.get(src).isEmpty())
			edges.remove(src);

		return e;
	}

	public int nodeSize() {
		return nodes.size();
	}

	public int edgeSize() {
		return edges.size();
	}

	public int getMC() {
		return this.modeCount;
	}

}
