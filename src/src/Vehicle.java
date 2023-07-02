/**                        Vehicle                        **/
public class Vehicle {
    private String carModel;
    private int carModelYear;
    private String carIdentification;
    public double carWidth;
    public double carDepth;
    //Constructors
    Vehicle(){
        carIdentification="null";
    }
    Vehicle(String id){
        carIdentification=id;
    }
    Vehicle(String carModel,int carModelYear,String carIdentification,double carWidth,double carDepth){
        this.carModel=carModel;
        this.carModelYear=carModelYear;
        this.carIdentification=carIdentification;
        this.carWidth=carWidth;
        this.carDepth=carDepth;
    }

    //Setters and Getters
    public void setCarModel(String Model){ carModel=Model; }
    public void setCarModelYear(int ModelYear){ carModelYear=ModelYear; }
    public void setCarIdentification(String Identification){ carIdentification=Identification; }
    public void setCarWidth(double Width){ carWidth=Width; }
    public void setCarDepth(double Depth){ carDepth=Depth; }
    public String getCarModel(){ return carModel; }
    public int getCarModelYear(){ return carModelYear; }
    public String getCarIdentification(){ return carIdentification; }
    public double getCarWidth(){ return carWidth; }
    public double getCarDepth(){ return carDepth; }

    public void vehicle_Information(){
        System.out.println("Car Model: "+getCarModel());
        System.out.println("Car Model Year: "+getCarModelYear());
        System.out.println("Car Identification: "+getCarIdentification());
        System.out.println("Car Width: "+getCarWidth());
        System.out.println("Car Depth: "+getCarDepth());
    }
}
