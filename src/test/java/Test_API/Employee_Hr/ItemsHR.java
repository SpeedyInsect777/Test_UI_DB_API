package Test_API.Employee_Hr;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import java.util.List;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)

public class ItemsHR {
    private int employee_id;
    private String first_name;
    private String last_name;
    private String email;
    private String phone_number;
    private String hire_date;
    private String job_id;
    private int salary;
    private String commission_pct;
    private String manager_id;
    private int department_id;
    private List <Links> links;
}
