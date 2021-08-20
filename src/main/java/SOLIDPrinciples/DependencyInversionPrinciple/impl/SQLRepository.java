package SOLIDPrinciples.DependencyInversionPrinciple.impl;

import java.util.Arrays;
import java.util.List;

public class SQLRepository implements ProductRepository{
    @Override
    public List<String> getAllProductNames() {
        return Arrays.asList(new String[] {"apple", "banana"});
    }
}
