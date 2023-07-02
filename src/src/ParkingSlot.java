/**                        ParkingSlot                        **/
import java.util.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class ParkingSlot extends Garage{
    private int position;
    public String A_Time;
    public String E_Time;
    protected double price;
    ParkingSlot(){};

    public void setPosition(int p){
        position=p;
    }
    public int getPosition(){ return position; }

    //Functionalities
    public boolean isEmpty(int index,Slots []Dimension){
        if(!Dimension[index].getStatus()){
            return true;            //Empty
        }
        else {
            return false;           //NOT Empty
        }
    }
    public void showAvailable(int numOfSlots,Slots []Dimension){     //For User only
        for(int i=0; i<numOfSlots; i++){
            if(!Dimension[i].getStatus())
                System.out.println("Slot ["+ (i+1) +"]: \tEmpty");
        }
    }
    public void showBoth(int numOfSlots,Slots []Dimension){          //For Admin     "Available , UnAvailable"
        for(int i=0; i<numOfSlots; i++){
            if(!Dimension[i].getStatus())
                System.out.println("Slot ["+ (i+1) +"]: \tEmpty");
            else
                System.out.println("Slot ["+ (i+1) +"]: \tNOT Empty");
        }
    }
    public void search(double width,double depth,double numOfSlots,Slots []Dimension){
        for(int i=0,k=-1; i<numOfSlots; i++){
            if(isEmpty(i,Dimension)){
                if(width<=Dimension[i].getFixedWidth() && depth<=Dimension[i].getFixedDepth()){
                    if(k==-1){
                        System.out.print("Available Slots for the taken Dimensions are:[");
                        k++;
                    }
                    System.out.print(i+1);
                    if(i!=(numOfSlots-1))
                        System.out.print(",");
                }
            }
        }
        System.out.println("].");
    }

    public void assignCar(int index,Slots []Dimension){
        //True ->   Dimension[index].getStatus()=True;
        Dimension[index].setStatus(true);
    }
    public void Park_In(int numofSlots,int config,Slots []Dimension,Vehicle obj){

        //call function: assignCar
        if(config==1){
            int pos=-1;
            double best_width=100000,best_depth=100000;
            for(int i=0; i<numofSlots; i++){
                if(obj.getCarWidth()<=Dimension[i].getFixedWidth() && obj.getCarDepth()<=Dimension[i].getFixedDepth()){
                    if(best_width>Dimension[i].getFixedWidth() && best_depth>Dimension[i].getFixedDepth()) {
                        best_width = Dimension[i].getFixedWidth();
                        best_depth = Dimension[i].getFixedDepth();
                        pos = i + 1;
                    }
                }
            }
            if(pos!=-1){
                setPosition((pos));
                Dimension[pos-1].setStatus(true);
            }
            else{
                setPosition(-1);
            }
        }
        else if(config==2){
            for(int j=0; j<numofSlots; j++){
                if(obj.getCarWidth()<=Dimension[j].getFixedWidth() && obj.getCarDepth()<=Dimension[j].getFixedDepth()){
                    if(!Dimension[j].getStatus()){
                        setPosition(j + 1);
                        Dimension[j].setStatus(true);
                        break;
                    }
                }
                else{
                    setPosition(-1);
                }
            }
        }
        else{
            setPosition(-1);
        }
        System.out.println("Arrival Time is: "+ArrivalTime());
        //Show his Data (Main: 143)
    }
    public void Park_Out(int index,Slots []Dimension,Vehicle obj){
        //call function: removeCar
        if(Dimension[index].getStatus()){
            obj.vehicle_Information();
            System.out.println("You Checked Out Successfully.");
            Dimension[index].setStatus(false);
        }
        else{
            System.out.println("ERROR 404.");       //NOT FOUND
        }
        //Show his Data (Main: 152)
        System.out.println("End Time: "+EndTime());
    }


    public void setArrivalTime(String s){
        A_Time = s;     //start
    }
    public void setEndTime(String e){
        E_Time=e;       //end
    }
    public String getArrivalTime(){
        return A_Time;
    }
    public String getEndTime(){
        return E_Time;
    }

    public String ArrivalTime(){
        Date date = new Date();
        SimpleDateFormat DateFormat = new SimpleDateFormat("HH:mm:ss");
        A_Time = DateFormat.format(date);

        return A_Time;
    }
    public String EndTime(){
        Date date = new Date();
        SimpleDateFormat DateFormat = new SimpleDateFormat("HH:mm:ss");
        E_Time = DateFormat.format(date);
        return E_Time;
    }
    public int duration(String s,String e){
        int StartHour,StartMinute,StartSecond;
        String []Start_Str = s.split(":",4);
        StartHour   = Integer.parseInt(Start_Str[0]);
        StartMinute = Integer.parseInt(Start_Str[1]);
        StartSecond = Integer.parseInt(Start_Str[2]);

        int EndHour,EndMinute,EndSecond;
        String []End_Str   = e.split(":",4);
        EndHour   = Integer.parseInt(End_Str[0]);
        EndMinute = Integer.parseInt(End_Str[1]);
        EndSecond = Integer.parseInt(End_Str[2]);

        int NumberOfHours=(EndHour-StartHour);
        if(EndMinute-StartMinute>=0){
            NumberOfHours++;
        }
        return NumberOfHours;
    }
    public double Price(double initialprice){

        price=initialprice * duration(A_Time,E_Time);
        return price;
    }
}