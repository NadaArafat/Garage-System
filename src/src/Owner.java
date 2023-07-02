/**                        Owner                        **/
import java.lang.module.Configuration;

public class Owner {
    private String Name;
    private String OwnerID;
    protected int Configuration;
    private double InitialPrice = 5.00;

    //Constructors
    Owner(){}
    Owner(double InitialPrice){
        this.InitialPrice = InitialPrice;
    }
    Owner(int method){
        Configuration=method;
    }
    Owner(String Name,String OwnerID){
        this.Name = Name;
        this.OwnerID = OwnerID;
    }

    //Setters and Getters
    public void setName(String n){ Name=n; }
    public void setOwnerID(String ID){ OwnerID=ID; }
    public void setConfiguration(int conf){ Configuration=conf; }
    public void setInitialPrice(double price){ InitialPrice=price; }
    public String getName(){ return Name; }
    public String getOwnerID(){ return OwnerID; }
    public int getConfiguration(){ return Configuration; }
    public double getInitialPrice(){ return InitialPrice; }

    public void admin_Information(){
        System.out.println("Owner's Name: "+getName());
        System.out.println("Owner's ID: "+getOwnerID());
        System.out.println("Configuration: "+getConfiguration());
        System.out.println("Initial Price: "+getInitialPrice());
    }

}
