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
        return ("Source: "+this.source+"\n Destination: "+this.destination+"\n Weight: "+this.weight+"\n Tag: "+this.tag);
    }

    public void setInfo(String s) {
    }

    public void setTag(int t) {
        this.tag = t;
    }
}
