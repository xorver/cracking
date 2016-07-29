package ex612;

public class Value implements Encodable{
    public String value;
    public Encoder encoder;

    public Value(String value, Encoder encoder) {
        this.value = value;
        this.encoder = encoder;
    }

    @Override
    public String encode() {
        return encoder.encode(this);
    }
}
