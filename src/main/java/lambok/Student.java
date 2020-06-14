package lambok;

import lombok.*;

/**
 * @author Bharath.MC
 * @since Oct-2019
 */
@AllArgsConstructor
@ToString(exclude = {"lastName"})
@EqualsAndHashCode(of= {"age", "semister"})
public class Student {
    @NonNull String firstName;
    String lastName;
    @NonNull Integer age;
    @NonNull Integer semister;
}
