package dataStructure;

import utils.Point3D;

import java.io.Serializable;


public class NodeData implements node_data, Serializable {
    /********** private vars **************/
    private int key;
    private Point3D location;
    private double weight= Double.MAX_VALUE;
    private int tag=0;
    private String info = "false";
    /******** constarctors **********/

    public NodeData(int k, Point3D p){
        this.key = Math.abs(k);
        this.location = p;
    }

    public NodeData(){
        this.key=0; //default
        this.location = new Point3D(0,0,0);
    }
    public NodeData(int key, Point3D location , double weight,String info,int tag){
        this.key=key;
        this.location=location;
        this.weight=weight;
        this.info=info;
        this.tag=tag;
    }
    public NodeData(int key, Point3D location , double weight){
        this.key=key;
        this.location=location;
        this.weight=weight;
    }



    public NodeData(Point3D p){
        this.key = p.ix();
        this.location = p;
    }



    /********* public methods ********/

    public int getKey() {
        return this.key;
    }

    public Point3D getLocation() {
        return this.location;
    }

    public double getWeight() {
        return this.weight;
    }

    public int getTag() {
        return this.tag;
    }

    public String getInfo() {
        return this.info;
    }

    public void setLocation(Point3D p) {
        this.location = new Point3D(p);
    }

    public void setWeight(double w) {
        this.weight = w;
    }

    public void setInfo(String s) {
        this.info = s;
    }

    public void setTag(int t) {
        this.tag = t;
    }
    @Override
    public  String toString(){
        return "key: "+this.getKey()+" Location: "+this.location+" Weight: "+this.weight+ " Info: "
                +this.info +" Tag: "+this.tag;
    }



}