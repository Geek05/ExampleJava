package DesignPatterns.Creational.Builder;

import lombok.Builder;
import lombok.Data;
import lombok.ToString;

@ToString
@Builder
public class LOrder {
    private int id;
    private String name;
}
