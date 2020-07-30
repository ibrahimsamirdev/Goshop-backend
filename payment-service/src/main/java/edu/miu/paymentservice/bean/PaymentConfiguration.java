package pm.goshop.paymentservice.bean;

public class PaymentConfiguration {
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

    public PaymentConfiguration(int minimum, int maximum) {
        this.minimum = minimum;
        this.maximum = maximum;
    }
}
