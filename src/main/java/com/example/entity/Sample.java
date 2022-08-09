package com.example.entity;

/**
 * @author zhoupeng
 * @create time 2021-04-14-14:50
 */
public class Sample {
    private String id;
    private String type;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "Sample{" +
                "id='" + id + '\'' +
                ", type='" + type + '\'' +
                '}';
    }

    public Sample(String id, String type) {
        this.id = id;
        this.type = type;
    }

    public Sample() {
    }
}
