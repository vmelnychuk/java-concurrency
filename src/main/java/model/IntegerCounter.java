package model;

public class IntegerCounter implements Counter<Integer> {
    private int counter = 0;
    @Override
    public void inc() {
        counter++;
    }

    @Override
    public void dec() {
        counter--;
    }

    @Override
    public Integer getCounterValue() {
        return Integer.valueOf(counter);
    }

    @Override
    public void setCounterValue(Integer value) {
        counter = value;
    }

    public IntegerCounter() {
        this.counter = 0;
    }
}
