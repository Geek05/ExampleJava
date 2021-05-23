package yamlreader;

import org.yaml.snakeyaml.Yaml;
import org.yaml.snakeyaml.constructor.Constructor;
import yamlreader.pojos.Customer;

import java.io.InputStream;
import java.util.Map;

/**
 * @author Bharath.MC
 * @since May-2021
 */
public class YamlExample {

    public void readFromYamlAsMap(){
        Yaml yaml = new Yaml();
        InputStream inputStream = this.getClass()
                .getClassLoader()
                .getResourceAsStream("customer.yaml");
        Map<String, Object> obj = yaml.load(inputStream);
        System.out.println(obj);
    }

    public void readFromYamlUsingCustomObject(){
        Yaml yaml = new Yaml(new Constructor(Customer.class));
        InputStream inputStream = this.getClass()
                .getClassLoader()
                .getResourceAsStream("customer.yaml");
        Customer customer = yaml.load(inputStream);
        System.out.println(customer);
        for (Map.Entry<String, Integer> stringIntegerEntry : customer.getSimpleMapping().entrySet()) {
            System.out.println(stringIntegerEntry.getKey() + " , "+ stringIntegerEntry.getValue());
        }
    }

    public static void main(String[] args) {
        YamlExample yamlExample = new YamlExample();
        yamlExample.readFromYamlUsingCustomObject();
    }
}
