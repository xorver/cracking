package ex612;

import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class Ex612 {

    public static void main(String[] Args) {
        Map<String, Integer> mapping = new HashMap<>();
        mapping.put("family", 1);
        mapping.put("person", 2);
        mapping.put("firstName", 3);
        mapping.put("lastName",4);
        mapping.put("state",5);

        Encoder encoder = new Encoder(mapping);

        Attribute lastName = new Attribute("lastName", "Kowalska", encoder);
        Attribute state = new Attribute("state", "CA", encoder);
        Attribute firstName = new Attribute("firstName", "Anna", encoder);
        Value value = new Value("Some message", encoder);
        Element person = new Element("person", Arrays.asList(firstName), Arrays.asList(value), encoder);
        Element family = new Element("family", Arrays.asList(lastName, state), Arrays.asList(person), encoder);

        System.out.println(family.encode());
    }

}
