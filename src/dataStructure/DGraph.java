package dataStructure;

import java.util.Collection;
import java.util.LinkedList;

public class DGraph implements graph{
	LinkedList<EdgeData> edges;
	LinkedList<NodeData> nodes;
/************constractors***************************/
	public DGraph(){

	}
	public DGraph (String fileName){

	}

	@Override
	public node_data getNode(int key) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public edge_data getEdge(int src, int dest) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void addNode(node_data n) {
		nodes.add(new NodeData((NodeData) n));
	}

	@Override
	public void connect(int src, int dest, double w) {
		edges.add(new EdgeData(src, dest, w));
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
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public edge_data removeEdge(int src, int dest) {
		// TODO Auto-generated method stub
		return null;
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
