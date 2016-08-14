package ex1612;

import java.util.Collection;

public class Element implements Encodable{
    public String tag;
    public Collection<Encodable> attributes;
    public Collection<Encodable> children;
    public Encoder encoder;

    public Element(String tag, Collection<Encodable> attributes, Collection<Encodable> children, Encoder encoder) {
        this.tag = tag;
        this.attributes = attributes;
        this.children = children;
        this.encoder = encoder;
    }

    @Override
    public String encode() {
        return encoder.encode(this);
    }
}
