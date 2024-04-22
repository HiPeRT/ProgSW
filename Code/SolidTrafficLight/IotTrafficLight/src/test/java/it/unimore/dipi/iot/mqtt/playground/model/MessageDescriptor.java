package it.unimore.dipi.iot.mqtt.playground.model;

/**
 * Basic and demo structure of a common message carrying a numeric value
 *
 * @author Marco Picone, Ph.D. - picone.m@gmail.com
 * @project mqtt-playground
 * @created 14/10/2020 - 09:19
 */
public class MessageDescriptor {

    private long timestamp;

    private String type;

    private double value;

    public MessageDescriptor() {
    }

    public MessageDescriptor(long timestamp, String type, double value) {
        this.timestamp = timestamp;
        this.type = type;
        this.value = value;
    }

    public long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(long timestamp) {
        this.timestamp = timestamp;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("MessageDescriptor{");
        sb.append("timestamp=").append(timestamp);
        sb.append(", type='").append(type).append('\'');
        sb.append(", value=").append(value);
        sb.append('}');
        return sb.toString();
    }
}