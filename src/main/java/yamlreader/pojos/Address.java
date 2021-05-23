package yamlreader.pojos;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @author Bharath.MC
 * @since May-2021
 */
@Data
public class Address {
    private String line;
    private String city;
    private String state;
    private Integer zip;
}
