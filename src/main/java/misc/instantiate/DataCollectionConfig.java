package misc.instantiate;

import lombok.Builder;
import lombok.Data;

/**
 * @author Bharath.MC
 */

@Data
@Builder
public class DataCollectionConfig {
    public String name;
    public String policy;
    public int requiredPeerCount;
    public int maxPeerCount;
    public int blockToLive;
}
