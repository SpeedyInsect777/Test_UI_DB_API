
package Test_Java.Test_20;

import lombok.Data;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

@Data
public class Trip {


    private String driverID;
    private List<String> date;
    private List<String> origin;
    private List<String> destination;
    private List<String> reeferTemp;
    private List<Integer> totalMiles;
    private Double gross;


    public String getDriverID() {
        return driverID;
    }

    public void setDriverID(String driverID) {
        this.driverID = driverID;
    }

    public List<String> getDate() {
        return date;
    }

    public void setDate(List<String> date) {
        this.date = date;
    }

    public List<String> getOrigin() {
        return origin;
    }

    public void setOrigin(List<String> origin) {
        this.origin = origin;
    }

    public List<String> getDestination() {
        return destination;
    }

    public void setDestination(List<String> destination) {
        this.destination = destination;
    }

    public List<String> getReeferTemp() {
        return reeferTemp;
    }

    public void setReeferTemp(List<String> reeferTemp) {
        this.reeferTemp = reeferTemp;
    }

    public List<Integer> getTotalMiles() {
        return totalMiles;
    }

    public void setTotalMiles(List<Integer> totalMiles) {
        this.totalMiles = totalMiles;
    }

    public Double getGross() {

        return this.gross;

    }

    public void setGross(List<Double> gross) {

        Double result = 0.0;

        for (Double num : gross) {
            result += num;
        }

        this.gross = result;


    }

    public static void main(String[] args) {
    }


    @DisplayName("Adding numbers")
    @Test
    public void test002() {

        List<Double> numList = new ArrayList<>();

        numList.add(2.0);
        numList.add(3.0);

        numList.add(2.0);
        numList.add(3.0);

        double sum = 0;
        for (Double num : numList) {
            System.out.println("Current sum: " + sum);
            System.out.println("Added: " + num);

            sum += num;

            System.out.println("TOTAL===: " + sum);
        }
        System.out.println(sum);
    }

    @Test
    public void test003() {
        Trip trip = new Trip();
        List<Double> numList = new ArrayList<>();

        numList.add(2.0);
        numList.add(3.0);

        numList.add(2.0);
        numList.add(3.0);

        double sum = 0;
        for (Double num : numList) {
            System.out.println("Current sum: " + sum);
            System.out.println("Added: " + num);

            sum += num;

            System.out.println("TOTAL===: " + sum);
        }
        System.out.println(sum);
        trip.setGross(numList);
        System.out.println(trip.getGross());
    }
    @Test
    public void test03(){
        Trip trip = new Trip();
        trip.setGross(List.of(2.0,3.0,2.0,3.0));
        System.out.println("Total: "+trip.getGross());
    }
}