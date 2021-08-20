package SOLIDPrinciples.DependencyInversionPrinciple.impl;

import java.util.List;

public interface ProductRepository {
    List<String> getAllProductNames();
}
