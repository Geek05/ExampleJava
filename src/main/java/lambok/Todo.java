package lambok;

import lombok.Data;
import lombok.Setter;

/**
 * @author Bharath.MC
 * @since Oct-2019
 */
@Data
public class Todo {
    @Setter
    String taskName;
    @Setter
    Integer duration;

}
