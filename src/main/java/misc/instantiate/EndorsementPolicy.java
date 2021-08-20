package misc.instantiate;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Bharath.MC
 */

@NoArgsConstructor
@Data
public class EndorsementPolicy {
    public List<Object> identities = new ArrayList<>();
    public Policy policy = new Policy();
}
