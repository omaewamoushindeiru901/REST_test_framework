package entity.book;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Size {
    @JsonProperty("height")
    private double height;
    @JsonProperty("width")
    private double width;
    @JsonProperty("length")
    private double length;

    public Size(){}

    @Override
    public String toString() {
        return "Size{" +
                "height=" + height +
                ", width=" + width +
                ", length=" + length +
                '}';
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public double getWidth() {
        return width;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    public double getLength() {
        return length;
    }

    public void setLength(double length) {
        this.length = length;
    }

    public Size(double height, double width, double length) {
        this.height = height;
        this.width = width;
        this.length = length;
    }



}
