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
    public EdgeData(String s){
        this.source = 0;
        this.destination = 0;
        this.weight = 0;
        this.tag = 0;
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
        return ("Source: "+this.source+"\n Destination: "+this.destination+"\n Weight: "+this.weight+"\n Tag: "+this.tag);
    }

    public void setInfo(String s) {
        String s1 = s.replace(" ","");
        if(isValid(s1)){
            String[] str = s1.split(",");
            this.source = Integer.parseInt(str[0]);
            this.destination = Integer.parseInt(str[1]);
            this.weight = Double.parseDouble(str[2]);
        }
    }

    public void setTag(int t) {
        this.tag = t;
    }

    private boolean isValid(String s){
        try {
            String[] str = s.split(",");
            int src = Integer.parseInt(str[0]);
            int dest = Integer.parseInt(str[1]);
            Double w = Double.parseDouble(str[2]);
        }
        catch (Exception e){
            return false;
        }
        finally {
            return true;
        }
    }
}
