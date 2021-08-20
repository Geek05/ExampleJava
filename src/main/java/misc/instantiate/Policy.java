package misc.instantiate;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Bharath.MC
 */

@Data
@NoArgsConstructor
public class Policy {
    @JsonProperty("0-of")
    public List<Object> _0Of = new ArrayList<>();
}
