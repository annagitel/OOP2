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

    public NodeData(String s){
        this.location = new Point3D(s.substring(0,s.indexOf(',')));
        this.weight = Double.parseDouble(s.substring(s.indexOf(',')+1,s.length()));
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
        return ("Node number: "+this.key+"\n Location: "+this.location.toString()+"\n Weight: "+this.weight+"\n"+"Tag: "+tag);
    }

    public void setLocation(Point3D p) {
        this.location = new Point3D(p);
    }

    public void setWeight(double w) {
        this.weight = w;
    }

    public void setInfo(String s) {
        this.location = new Point3D(s.substring(0,s.indexOf(',')));
        this.weight = Double.parseDouble(s.substring(s.indexOf(',')+1,s.length()));
    }

    public void setTag(int t) {
        this.tag = t;
    }
}
