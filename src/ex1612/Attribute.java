package ex1612;

public class Attribute implements Encodable{
    public String tag;
    public String value;
    public Encoder encoder;

    public Attribute(String tag, String value, Encoder encoder) {
        this.tag = tag;
        this.value = value;
        this.encoder = encoder;
    }

    @Override
    public String encode() {
        return encoder.encode(this);
    }
}