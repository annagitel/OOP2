package dataStructure;

import utils.Point3D;

import java.io.Serializable;
import java.util.Collection;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Iterator;


public class DGraph implements graph {
	private HashMap<Integer, HashMap<Integer, edge_data>> edges;
	private HashMap<Integer, node_data> nodes;
	public int modeCount =0;
	private int nodeCount = 0;

	/************constractors***************************/
	public DGraph(){
		this.nodes = new HashMap<>();
		this.edges = new HashMap<>();
	}

	public DGraph (String fileName){

	}

	public DGraph(graph g){
		Collection<node_data> n = g.getV();
		Iterator<node_data> it = n.iterator();
		while (it.hasNext()){
			this.addNode(it.next());
		}

		Iterator<node_data> nit = this.getV().iterator();
		while (nit.hasNext()){
			Collection<edge_data> e = g.getE(nit.next().getTag());
			Iterator<edge_data> eit = e.iterator();
			while (eit.hasNext()){
				edge_data current = eit.next();
				this.connect(current.getSrc(), current.getDest(), current.getWeight());
			}
		}
	}

	/********** public methods ************************/
	public node_data getNode(int key) {
		return nodes.get(key);
	}

	public edge_data getEdge(int src, int dest) {
		return edges.get(src).get(dest);
	}

	public void addNode(node_data n) {
		NodeData newn = new NodeData(nodeCount, n.getLocation());
		this.nodes.put(this.nodeCount, newn);
		this.nodeCount++;
	}

	public void addNode(Point3D l){
		NodeData newn = new NodeData(nodeCount, l);
		this.nodes.put(this.nodeCount, newn);
		this.nodeCount++;
	}

	public void connect(int src, int dest, double w) {
		EdgeData ed = new EdgeData(src,dest,w);
		if (edges.containsKey(src)){
			if (edges.get(src).containsKey(dest))
				System.out.println("The nodes are already connected.");
			else
				edges.get(src).put(dest,ed);
		}
		else {
			edges.put(src, new HashMap<>());
			edges.get(src).put(dest,ed);
		}
	}

	public Collection<node_data> getV() {
		Collection<node_data> c = nodes.values();
		return c;
	}

	public Collection<edge_data> getE(int node_id) {
		if(this.edges.containsKey(node_id)) {
			Collection<edge_data> c = this.edges.get(node_id).values();
			return c;
		}
		else
			return null;
	}

	public Collection<Integer> nodesWithEdges(){
		Collection<Integer> c = edges.keySet();
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
