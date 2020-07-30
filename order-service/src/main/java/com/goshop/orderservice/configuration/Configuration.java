<<<<<<< HEAD:order-service/src/main/java/com/goshop/orderservice/configuration/Configuration.java
package com.goshop.orderservice.configuration;
=======
package com.goshop.orderservice;
>>>>>>> 0d197d81e037db7c090a9413c06f27777b9bb42d:order-service/src/main/java/com/goshop/orderservice/Configuration.java

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties("order-service")
public class Configuration {
    private int minimum;
    private int maximum;

    public void setMinimum(int minimum) {
        this.minimum = minimum;
    }

    public void setMaximum(int maximum) {
        this.maximum = maximum;
    }

    public int getMinimum() {
        return minimum;
    }

    public int getMaximum() {
        return maximum;
    }
}
