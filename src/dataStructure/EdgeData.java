package dataStructure;

public class EdgeData implements edge_data {
    /********** private vars *************/
    private int source;
    private int destination;
    private double weight;
    private int tag;
    /************ constructors ****************/
    public EdgeData(int s, int d, double w){
        this.source = s;
        this.destination = d;
        this.weight = w;
        this.tag = 0;
    }


    /*********** public methods ****************/
    @Override
    public int getSrc() {
        return this.source;
    }

    @Override
    public int getDest() {
        return this.destination;
    }

    @Override
    public double getWeight() {
        return this.weight;
    }

    @Override
    public String getInfo() {
        return ("Source: "+this.source+"\n Destination: "+this.destination+"\n Weight: "+this.weight+"\n Tag: "+this.tag);
    }

    @Override
    public void setInfo(String s) {
        //yani init from string kus emek;
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
