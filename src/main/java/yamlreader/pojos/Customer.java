package yamlreader.pojos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.Map;

/**
 * @author Bharath.MC
 * @since May-2021
 */
@Data
public class Customer {
    private String firstName;
    private String lastName;
    private int age;

    private List<Contact> contactDetails;

    private Address homeAddress;

    private Map<String, Integer> simpleMapping;
}
