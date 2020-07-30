<<<<<<< HEAD:order-service/src/main/java/com/goshop/orderservice/configuration/OrderConfiguration.java
package com.goshop.orderservice.configuration;
=======
package com.goshop.orderservice.bean;
>>>>>>> 0d197d81e037db7c090a9413c06f27777b9bb42d:order-service/src/main/java/com/goshop/orderservice/bean/OrderConfiguration.java

public class OrderConfiguration {

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

    public OrderConfiguration(int minimum, int maximum) {
        this.minimum = minimum;
        this.maximum = maximum;
    }
}
