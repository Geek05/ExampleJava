package Domain.chaincodes.instantiate;

import lombok.Builder;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Bharath.MC
 */

@Builder
public class InstantiateChaincode {
    public String channelName;
    public String chaincodeVersion;
    public TransientMap transientMap;
    public EndorsementPolicy endorsementPolicy;
    public List<String> args = new ArrayList<>();
    public List<DataCollectionConfig> dataCollectionConfig;
    public String chaincodeType;
    public List<Peer> peers;
}
