/**                        Garage                        **/
import java.util.*;
public class Garage{
    private int floors;
    protected int numberOfSlots;
    protected Slots[] Dimension;
    protected double [][] TwoD_array;
    //Constructors
    Garage(){}
    Garage(int floors,int numberOfSlots){
        setNumberOfSlots(numberOfSlots);
        setFloors(floors);
    }

    //Setters and Getters
    public void setFloors(int f){ floors=f; }
    public void setNumberOfSlots(int numberOfSlots){ this.numberOfSlots=numberOfSlots; }
    public int getFloors(){ return floors; }
    public int getNumberOfSlots(){ return numberOfSlots; }

    //Functionalities
    public static void Sort2DArrayBasedOnColumnNumber(double[][] TwoD_array, final int columnNumber){
        Arrays.sort(
                TwoD_array,new Comparator<double[]>(){
                    @Override
                    public int compare(double []first,double []second){
                        if(first[columnNumber-1] > second[columnNumber-1])  return 1;
                        else return -1;
                    }
                }
        );
    }

    public void setDimension(){
        System.out.println("Set Width and Depth of each slot.");
        Dimension = new Slots [numberOfSlots];
        TwoD_array = new double [numberOfSlots][2];
        for(int i=0; i<numberOfSlots; i++){
            System.out.print("\tEnter The ["+ (i+1) +"] Slot Dimensions: ");
            Scanner slot = new Scanner(System.in);
            double width = slot.nextDouble();
            double depth = slot.nextDouble();
            Dimension[i] = new Slots();
            Dimension[i].setSlot(width,depth);
            TwoD_array[i][0]=width;
            TwoD_array[i][1]=depth;
        }
        //Sort2DArrayBasedOnColumnNumber(TwoD_array,2);       //Sorting on Columns
        Sort2DArrayBasedOnColumnNumber(TwoD_array,1);       //Sorting on Rows
    }
    public void getDimension(){
        System.out.println("\t\t\t\t\t\t Width \t\t Depth \t\t Status");
        System.out.println("--------------------------------------------------------");
        for(int i=0; i<numberOfSlots; i++){
            System.out.print("Slot ["+ (i+1) +"] Dimensions:\t"+
                    Dimension[i].getFixedWidth()+" \t\t "+
                    Dimension[i].getFixedDepth()+" \t\t "+
                    Dimension[i].getStatus()+"\n");
        }
        System.out.println("--------------------------------------------------------");
    }
    //For 2DArraySorted
    public void getWOW(){
        for(int i=0; i<numberOfSlots; i++){
            System.out.println("["+ TwoD_array[i][0] + " , " + TwoD_array[i][1] + "]" );
        }
    }
}
