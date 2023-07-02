/**                        Slots                        **/
public class Slots {
    private double fixedWidth;
    private double fixedDepth;
    private boolean status;
    //Constructors


    //Setters and Getters
    public void setFixedWidth(double w){ fixedWidth=w; }
    public void setFixedDepth(double d){ fixedDepth=d; }
    public void setStatus(boolean s){ status=s; }
    public double getFixedWidth(){ return fixedWidth; }
    public double getFixedDepth(){ return fixedDepth; }
    public boolean getStatus(){ return status; }

    //Functionalities
    void setSlot(double width,double depth){
        fixedWidth=width;
        fixedDepth=depth;
        status=false;
    }
    void slot_Information(int position){
        System.out.println("Slot Number: "+position);
        System.out.println("Slot Width: "+getFixedWidth());
        System.out.println("Slot Depth: "+getFixedDepth());
    }
}
