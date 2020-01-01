package dataStructure;

import utils.Point3D;


public class NodeData implements node_data{
    /********** private vars **************/
    private int key;
    private Point3D location;
    private double weight;
    private int tag;
    private String info = "false";
    /******** constarctors **********/

    public NodeData(int k, Point3D p){
        this.key = Math.abs(k);
        this.location = p;
        this.weight = Double.MAX_VALUE;
        this.tag = 0;
    }

    public NodeData(){
        this.key = 0;
        this.location = new Point3D(0,0,0);
        this.weight = Double.MAX_VALUE;
        this.tag = 0;
    }

    public NodeData(Point3D p){
        this.key = 0;
        this.location = p;
        this.weight = Double.MAX_VALUE;
        this.tag =  0;
    }

    public NodeData(String s){
        this.key = 0;
        this.location = new Point3D(0,0,0);
        this.weight = Double.MAX_VALUE;
        this.tag = 0;
        this.setInfo(s);
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

    private boolean isValid(String s){
        try {
            Point3D p = new Point3D(s.substring(1,s.indexOf(')')));
            double w = Double.parseDouble(s.substring(s.indexOf(',')+1,s.length()));
        }
        catch (Exception e){
            return false;
        }
        finally {
            return true;
        }
    }

}