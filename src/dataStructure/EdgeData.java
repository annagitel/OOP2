package dataStructure;

import java.io.Serializable;

public class EdgeData implements edge_data , Serializable {
    /********** private vars *************/
    private int source;
    private int destination;
    private double weight;
    private String info="";
    private int tag=0;
    /************ constructors ****************/
    public EdgeData(int s, int d, double w){
        this.source = s;
        this.destination = d;
        this.weight = w;
    }
    public EdgeData(){
        this.tag=0;
    }
    public EdgeData(int src, int dest, double weight, String info, int tag){
        this.source=src;
        this.destination=dest;
        this.weight=weight;
        this.info=info;
        this.tag=tag;
    }

    public EdgeData(String s){
        this.source = 0;
        this.destination = 0;
        this.weight = 0;
        this.setInfo(s);
    }
    /*********** public methods ****************/
    public int getSrc() {
        return this.source;
    }

    public int getDest() {
        return this.destination;
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

    public void setInfo(String s) {
      this.info=s;
    }

    public void setTag(int t) {
        this.tag = t;
    }


    @Override
    public String toString(){
        return "Src: "+this.source+ " Weight: "+this.weight+" Dest: "+this.destination+" Info: "+this.info+" Tag: "+this.tag;
    }
}
