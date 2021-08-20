package misc.instantiate;

import lombok.Builder;
import lombok.NonNull;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * @author Bharath.MC
 */

@Builder
public class InstantiateChaincode {
    public String channelName;
    public String chaincodeVersion;
    public TransientMap transientMap;
    public EndorsementPolicy endorsementPolicy;
    public List<String> args;
    public List<DataCollectionConfig> dataCollectionConfig;
    public String chaincodeType;
    public List<Peer> peers;

    public InstantiateChaincode addDataCollectionConfig(DataCollectionConfig dataCollectionConfig){
        if(Objects.isNull(this.dataCollectionConfig)){
            this.dataCollectionConfig = new ArrayList<>();
        }
        this.dataCollectionConfig.add(dataCollectionConfig);
        return this;
    }
}
