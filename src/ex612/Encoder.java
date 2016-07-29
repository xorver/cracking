package ex612;

import java.util.Collection;
import java.util.Map;

public class Encoder{
    Map<String, Integer> mapping;

    public Encoder(Map<String, Integer> mapping) {
        this.mapping = mapping;
    }

    public String encode(Collection<Encodable> elements) {
        StringBuilder builder = new StringBuilder();
        builder.append(" ");
        for(Encodable e: elements) {
            builder.append(e.encode());
            builder.append(" ");
        }
        return builder.toString();
    }

    public String encode(Element element) {
        return mapping.get(element.tag) + encode(element.attributes)
                + "0" + encode(element.children) + "0";
    }

    public String encode(Attribute attribute) {
        return mapping.get(attribute.tag) + " " + attribute.value;
    }

    public String encode(Value value) {
        return value.value;
    }
}