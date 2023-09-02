package Test_Java.Test_01;

import lombok.Data;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Test06 {

    CustomerInfo customerInfo = new CustomerInfo();
CustomerInfo2 customerInfo2 = new CustomerInfo2() ;
    @Test
    public void test01() {

        customerInfo.setFullName("Mike");
        customerInfo.setFullAddress("123 Main St");
        customerInfo.setPhoneNumber(1234567890L);


        Map<Integer, CustomerInfo> customerInfoMap = new HashMap<>();

        customerInfoMap.put(1, customerInfo);

        System.out.println("customer 1: "+customerInfoMap.get(1));


        customerInfo.setFullName("John");
        customerInfo.setFullAddress("321 Broad St");
        customerInfo.setPhoneNumber(9876543210L);

        customerInfoMap.put(2, customerInfo);

        System.out.println("customer 2: "+customerInfoMap.get(2));

        System.out.println("customer 1: "+customerInfoMap.get(1));

      customerInfo2=  new CustomerInfo2("Mike","123 Main St",1234567890L);

       Map<Integer,CustomerInfo2> customerInfoMap2 = new HashMap<>();

       customerInfoMap2.put(1,customerInfo2);

        System.out.println("customer 3: "+customerInfoMap.get(3));

        System.out.println("customer 4: "+ customerInfoMap2.get(1).toString());
    }

    @Test
    public void test02() {

        System.out.println(customerInfo);

    }
}
@Data

class CustomerInfo {

    private String fullName;
    private String fullAddress;
    private long phoneNumber;


}
class CustomerInfo2 {

    private String fullName;
    private String fullAddress;
    private long phoneNumber;


public CustomerInfo2(){}

    public CustomerInfo2(String fullName, String fullAddress, long phoneNumber) {
        this();
        this.fullName = fullName;
        this.fullAddress = fullAddress;
        this.phoneNumber = phoneNumber;
    }

}