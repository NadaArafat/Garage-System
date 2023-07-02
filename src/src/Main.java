/**                        Main                        **/
import java.util.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;
public class Main {
    public static void main(String [] args){
        int count =0;
        int totalCars = 0;
        double totalMoneyIncome = 0.0;
        String carID="null";
        int carModelYEAR=0;
        String carMODEL="null";
        double carWIDTH=0.0;
        double carDEPTH=0.0;
        int []position = new int[500];
        Vehicle []check = new Vehicle [500];
        //ParkingSlot []carsObjects = new ParkingSlot[500];       //Array of objects carrying (park_obj4)

        Scanner in = new Scanner(System.in);
        System.out.println("-Set Data of your Garage");
        System.out.print("\tFloors: ");           int fixedFloors = in.nextInt();
        System.out.print("\tConfiguration (1.BestFit - 2.FirstServed): ");     int con = in.nextInt();
        System.out.print("\tNumber Of Slots: ");  int fixedNumberOfSlots = in.nextInt();
        //Setting Garage Data into it Class
        Owner owner_information = new Owner (con);
        Garage Garage_Data = new Garage (fixedFloors,fixedNumberOfSlots);
        //Setting Dimension of each slot
        Garage_Data.setDimension();
        System.out.print("\n");
        String str = "YES";
        while(str!="NO") {
            System.out.println("1.Owner   2.User: ");
            int input = in.nextInt();
            //Admin Stuff:
            if (input == 1) {
                System.out.println("-What Do you Want!");
                System.out.print("\t(1.Update Garage Information   2.View Slots   3.View TotalIncome    4.View Total Vehicles): ");
                int n = in.nextInt();
                if (n == 1) {
                    Scanner owner = new Scanner(System.in);
                    System.out.println("-Please Enter The Required Data");
                    System.out.print("\tOwner's Name: ");
                    String Name = owner.nextLine();
                    System.out.print("\tOwner's ID: ");
                    String ID = owner.nextLine();
                    //Passing all These lots of information to the Owner's Constructor:
                    owner_information = new Owner(Name, ID);
                    int End = -1;
                    while (End != 2) {
                        System.out.print("1.Updating Slots\n" +
                                "2.Change Parking Cost per Hour\n" +
                                "3.Change Configuration Method\n");
                        int ToDo = owner.nextInt();
                        if (ToDo == 1) {
                            System.out.println("Enter The Update Values.");
                            System.out.print("\tNumber of Floors: ");
                            int floors = owner.nextInt();
                            System.out.print("\tNumber of Slots: ");
                            int numberOfSlots = owner.nextInt();
                            Garage_Data = new Garage(floors, numberOfSlots);        //Setting Data to it Class
                            Garage_Data.setDimension();                             //Assign slot Values
                            System.out.println("-Garage Data:");
                            System.out.println("  Floors:" + Garage_Data.getFloors());
                            System.out.println("  Slots: " + Garage_Data.getNumberOfSlots());
                            Garage_Data.getDimension();
                        }
                        if (ToDo == 2) {
                            System.out.print("Change Price to: ");
                            double price = owner.nextDouble();
                            owner_information.setInitialPrice(price);
                            System.out.println("\tPrice Has Changed Successfully to: " + owner_information.getInitialPrice());
                        }
                        if (ToDo == 3) {
                            System.out.print("1.BestFit   2.FirstCome: ");
                            int c = owner.nextInt();
                            owner_information.setConfiguration(c);
                            System.out.print("\tMethod Has Changed Successfully to: ");
                            if (owner_information.getConfiguration() == 1) {
                                System.out.println("Best-Fit");
                            }
                            if (owner_information.getConfiguration() == 2) {
                                System.out.println("First Come - First Served");
                            }
                        }
                        System.out.print("Do You Want to change something! (1.YES  2.NO): ");
                        End = owner.nextInt();
                    }
                }
                if (n == 2) {       //View Slots
                    ParkingSlot park_obj = new ParkingSlot();
                    park_obj.showBoth(Garage_Data.getNumberOfSlots(), Garage_Data.Dimension);
                }
                if (n == 3) {       //View Total Income
                    System.out.println("Total Money Income Today is " + totalMoneyIncome);
                }
                if (n == 4){
                    System.out.println("Total Vehicles Parked at this time is " + totalCars);
                }
            }


            //User Stuff:
            if (input == 2) {
                System.out.println("\t Hello!, Welcome To AVA-I0339 Parking System\nHow Can i Help you!");
                Scanner user = new Scanner(System.in);
                int End = -1;
                while (End != 2) {
                    System.out.print("1.View Available Slots.\n" +
                            "2.Search for specific Slot.\n" +
                            "3.Park-In.\n" +
                            "4.Park-Out.\n");
                    int WantTo = user.nextInt();
                    if (WantTo == 1) {
                        ParkingSlot park_obj2 = new ParkingSlot();
                        park_obj2.showAvailable(Garage_Data.getNumberOfSlots(), Garage_Data.Dimension);
                    }
                    if (WantTo == 2) {
                        ParkingSlot park_obj3 = new ParkingSlot();
                        System.out.println("Please Enter The Needed Data.");
                        System.out.print("Width: ");
                        double width = user.nextDouble();
                        System.out.print("Depth: ");
                        double depth = user.nextDouble();
                        park_obj3.search(width, depth, Garage_Data.getNumberOfSlots(), Garage_Data.Dimension);
                    }
                    ParkingSlot park_obj4 = new ParkingSlot();
                    if (WantTo == 3) {
                        Scanner string = new Scanner(System.in);
                        System.out.println("Please Enter the needed data.");
                        System.out.print("Car Model: ");
                        String model = string.nextLine();
                        System.out.print("Car Year: ");
                        int modelyear = user.nextInt();
                        System.out.print("Car Identification: ");
                        String id = string.nextLine();
                        System.out.print("Car Width: ");
                        double width = user.nextDouble();
                        System.out.print("Car Depth: ");
                        double depth = user.nextDouble();
                        Vehicle Vehicle_Data = new Vehicle(model, modelyear, id, width, depth);
                        carID=id;               //To Check on it in ParkOut Part
                        carMODEL=model;
                        carModelYEAR=modelyear;
                        carWIDTH=width;
                        carDEPTH=depth;
                        park_obj4.Park_In(Garage_Data.getNumberOfSlots(),owner_information.getConfiguration(),Garage_Data.Dimension,Vehicle_Data);
                        if(park_obj4.getPosition()==-1){
                            System.out.println("ERROR 304." );  //Not Modified
                        }
                        else{
                            Vehicle_Data.vehicle_Information();
                            System.out.println("\tSlot Number: " +park_obj4.getPosition());
                            position[count] = park_obj4.getPosition();
                            //Time (DD-MM-YYYY  HH:MM:SS)
                            park_obj4.assignCar(park_obj4.getPosition()-1, Garage_Data.Dimension);
                            System.out.println("Arrival Time: "+park_obj4.ArrivalTime());
                        }
                        check[count] = new Vehicle(carMODEL,carModelYEAR,carID,carWIDTH,carDEPTH);
                        count++;
                    }
                    if (WantTo == 4) {
                        System.out.print("-Please Enter Your Car Identification number: ");
                        Scanner x = new Scanner(System.in);
                        String id = x.nextLine();
                        for(int i=0; i<count; i++){
                            if(check[i].getCarIdentification().equals(id)){
                                totalCars++;
                                System.out.println("End Time: "+park_obj4.EndTime());
                                System.out.println("\tSlot Number: " +position[i]);
                                //slotNumber,startTime,endTime,Total Price
                                park_obj4.Park_Out(position[i]-1, Garage_Data.Dimension,check[i]);
                                park_obj4.duration(park_obj4.ArrivalTime(), park_obj4.EndTime());
                                System.out.println("Total Price: "+park_obj4.Price(owner_information.getInitialPrice()));
                                totalMoneyIncome += park_obj4.Price(owner_information.getInitialPrice());
                                break;
                            }
                            else{
                                System.out.println("ERROR.\n There is no car has " + id + "-ID parking in our Garage.");
                            }
                        }
                    }
                    System.out.print("Do You Want To Check on something! (1.YES  2.NO): ");
                    End = user.nextInt();
                }
            }
            Scanner yo = new Scanner(System.in);
            System.out.print("Again? Enter:(YES or NO): ");    str = yo.nextLine();
        }
    }
}



/*
public class Main {
    public static void main(String [] args){
        Scanner SC = new Scanner(System.in);
        int floors = SC.nextInt();
        int numberOfSlots = SC.nextInt();
        Garage obj = new Garage (floors,numberOfSlots);
        obj.setDimension();
        obj.getDimension();

        ParkingSlot obj_park = new ParkingSlot();
        //System.out.print("\n>>>>>>>>>>>>>>>>>\n");
        //obj_park.getWOW();
        //System.out.print("\n>>>>>>>>>>>>>>>>>\n");
    }
}
*/

