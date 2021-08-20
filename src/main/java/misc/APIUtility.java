package misc;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationConfig;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import lombok.SneakyThrows;
import misc.instantiate.*;
import org.apache.kafka.common.errors.SerializationException;

import java.io.IOException;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Bharath.MC
 */
public class APIUtility {


    public static String convertJavaObjectToJsonUsingGson(Object className) {
        Gson gson = new Gson();
        String jsonPayload = gson.toJson(className);
        return jsonPayload;
    }

    public static String pojoToJsonUsingJackson(Object requestBody) {
        ObjectMapper mapper = new ObjectMapper();
        mapper.enable(SerializationFeature.INDENT_OUTPUT);
        try {
            return mapper.writeValueAsString(requestBody);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
            return null;
        }
    }

    @SneakyThrows
    public static String getObjectToJSON(Object className) {
        String json = null;
        org.codehaus.jackson.map.ObjectMapper mapper = new org.codehaus.jackson.map.ObjectMapper();
        mapper.configure(org.codehaus.jackson.map.DeserializationConfig.Feature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        //mapper.setSerializationInclusion(JsonSerialize.Inclusion.NON_NULL);
        json = mapper.writeValueAsString(className);
        return json;
    }

    @SneakyThrows
    public static String getObjectToJSONUsingFasterXML(Object className) {
        String json = null;
        com.fasterxml.jackson.databind.ObjectMapper mapper = new com.fasterxml.jackson.databind.ObjectMapper();
        mapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);
        json = mapper.writeValueAsString(className);
        return json;
    }


    public static String convertJavaObjectToJsonUsingGson(Object className, String dateFormate) {
        new Gson();
        GsonBuilder gb = new GsonBuilder();
        Gson gson = gb.setDateFormat(dateFormate).create();
        String jsonPayload = gson.toJson(className);
        return jsonPayload;
    }

    public static String GetObjectToJSONUsingFasterXML(Object className) throws IOException {
        String json = null;
        com.fasterxml.jackson.databind.ObjectMapper mapper = new com.fasterxml.jackson.databind.ObjectMapper();
        mapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);
        mapper.disable(SerializationFeature.FAIL_ON_EMPTY_BEANS);
        json = mapper.writeValueAsString(className);
        return json;
    }

    public static <T> String ObjectToJsonString(T object) throws Exception {
            Gson gson = new Gson();
        gson.htmlSafe();
        return gson.toJson(object);
    }

    /**
     * {
     *       "channelName": "apichannel01",
     *       "chaincodeVersion": "v1",
     *       "transientMap": {},
     *       "endorsementPolicy": {
     *         "identities": [],
     *         "policy": {
     *           "0-of": []
     *         }
     *       },
     *       "args": [],
     *       "dataCollectionConfig": [
     *         {
     *           "name": "collectionMarbles",
     *           "policy": "OR('JulyDepFounder.member')",
     *           "requiredPeerCount": 0,
     *           "maxPeerCount": 0,
     *           "blockToLive": 99999
     *         }
     *       ],
     *       "chaincodeType": "golang",
     *       "peers": [
     *         {
     *           "url": "grpcs://julydepfounder-2-bcsnativetest-iad.blockchain.test.ocp.oc-test.com:20009"
     *         }
     *       ]
     *     }
     *
     * @throws Exception
     */

    @SneakyThrows
    public static void PrettyPrintJson(Object jsonObject){
        Gson gson = new GsonBuilder().setPrettyPrinting().create(); // pretty print
        String s1 = APIUtility.GetObjectToJSONUsingFasterXML(jsonObject);
        JsonElement je = JsonParser.parseString(s1);
        String prettyJson = gson.toJson(je);
        System.out.println(prettyJson);
    }

    public static void main(String[] args) throws Exception {
        List<Peer> peers = new ArrayList<>();
        peers.add(new Peer("grpcs://julydepfounder-2-bcsnativetest-iad.blockchain.test.ocp.oc-test.com:20009"));

        List<DataCollectionConfig> dataCollectionConfigs = new ArrayList<>();
        DataCollectionConfig dataCollectionConfig = DataCollectionConfig.builder()
                .name("collectionMarbles")
                .policy("OR('JulyDepFounder.member')")
                .blockToLive(100)
                .build();
        dataCollectionConfigs.add(dataCollectionConfig);

        InstantiateChaincode instantiateChaincode = InstantiateChaincode.builder()
                .channelName("apichannel01")
                .chaincodeVersion("v1")
                .chaincodeType("golang")
                .endorsementPolicy(new EndorsementPolicy())
                .dataCollectionConfig(dataCollectionConfigs)
                .peers(peers)
                .build();

        String s = APIUtility.GetObjectToJSONUsingFasterXML(instantiateChaincode);
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        String json = gson.toJson(s);
        System.out.println(s);

        Emp emp = new Emp("Raja", "115", "Content Engineer", "Java", "Hyderabad");
        PrettyPrintJson(emp);
    }
}
