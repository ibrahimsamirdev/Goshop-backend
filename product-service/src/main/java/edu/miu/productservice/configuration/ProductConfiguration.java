package edu.miu.productservice.configuration;

public class ProductConfiguration {

    private int minimum;
    private int maximum;



    public int getMinimum() {
        return minimum;
    }

    public void setMinimum(int minimum) {
        this.minimum = minimum;
    }

    public int getMaximum() {
        return maximum;
    }

    public void setMaximum(int maximum) {
        this.maximum = maximum;
    }

    public ProductConfiguration(int minimum, int maximum) {
        this.minimum = minimum;
        this.maximum = maximum;
    }
}
