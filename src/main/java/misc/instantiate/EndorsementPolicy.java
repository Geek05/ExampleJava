package Domain.chaincodes.instantiate;

import lombok.Data;

import java.util.List;

/**
 * @author Bharath.MC
 */

@Data
public class EndorsementPolicy {
    public List<Object> identities;
    public Policy policy;
}
