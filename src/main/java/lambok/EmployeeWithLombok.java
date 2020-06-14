package lambok;

import lombok.Builder;
import lombok.ToString;

/**
 * @author Bharath.MC
 * @since Oct-2019
 */
@Builder
@ToString
public class EmployeeWithLombok {
    private String empId;
    private String firstName;
    private String lastname;
    private String phoneNo;
}
