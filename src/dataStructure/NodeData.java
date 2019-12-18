package dataStructure;

import utils.Point3D;

public class NodeData implements node_data{
    /********** vars **************/
    private int key;
    private Point3D location;
    private double weight;
    private int tag;

    /******** constarctors **********/
    public NodeData(int k, Point3D p, double w, int t){
        this.key = k;
        this.location = p;
        this.weight = w;
        this.tag = t;
    }

    public NodeData(NodeData n){
        this.key = n.getKey();
        this.location = n.getLocation();
        this.weight = n.getWeight();
        this.tag = n.getTag();
    }

    public NodeData(){
        this.key = 0;
        this.location = new Point3D(0,0,0);
        this.weight = 0;
        this.tag = 0;
    }

    public NodeData(Point3D p, double w){
        this.key = 0;
        this.location = p;
        this.weight = w;
        this.tag =  0;
    }

    /********* public methods ********/
    @Override
    public int getKey() {
        return this.key;
    }

    @Override
    public Point3D getLocation() {
        return this.location;
    }

    @Override
    public void setLocation(Point3D p) {
        this.location = new Point3D(p);
    }

    @Override
    public double getWeight() {
        return this.weight;
    }

    @Override
    public void setWeight(double w) {
        this.weight = w;
    }

    @Override
    public String getInfo() {
        return ("Node number: "+this.key+"\n Location: "+this.location.toString()+"\n Weight: "+this.weight+"\n"+"Tag: "+tag);
    }

    @Override
    public void setInfo(String s) {
        // yani init fron string. kus emek;
    }

    @Override
    public int getTag() {
        return this.tag;
    }

    @Override
    public void setTag(int t) {
        this.tag = t;
    }
}
