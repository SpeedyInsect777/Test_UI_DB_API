package Test_Java.Test_21;

public class Drivers {

    private static final int TRUCK_NUMBER = 1234;  // Uppercase constant name
    private static String fullName;  // Static field
    private int tripNumber;  // Instance field
    private double milesDriven;  // Instance field
private static int count = 0;

    public Drivers(String fullName, int tripNumber, double milesDriven) {
        Drivers.fullName = fullName;  // Note the use of the class name for the static field
        this.tripNumber = tripNumber;
        this.milesDriven = milesDriven;
        count++;
    }

    public int getTruckNumber() {
        return TRUCK_NUMBER;
    }

    public static String getFullName() {
        return fullName;
    }

    public static void setFullName(String fullName) {
        Drivers.fullName = fullName;  // Corrected this line to modify the static field
    }

    public int getTripNumber() {
        return tripNumber;
    }

    public void setTripNumber(int tripNumber) {
        this.tripNumber = tripNumber;
    }

    public double getMilesDriven() {
        return milesDriven;
    }

    public void setMilesDriven(double milesDriven) {
        this.milesDriven += milesDriven;
    }

    // To accumulate miles driven
    public void addMiles(double miles) {
        this.milesDriven += miles;
    }
    public static int getCount() {
        return count;
    }

    @Override
    public String toString() {
        return "Driver: " + fullName + "\n" +
                "Truck Number: " + TRUCK_NUMBER + "\n" +
                "Trip Number: " + tripNumber + "\n" +
                "Miles Driven: " + milesDriven;
    }
}
