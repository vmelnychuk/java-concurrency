package model;

public class LongCounter implements Counter<Long> {
    private long counter;
    @Override
    public void inc() {
        counter++;
    }

    @Override
    public void dec() {
        counter--;
    }

    @Override
    public Long getCounterValue() {
        return Long.valueOf(counter);
    }

    @Override
    public void setCounterValue(Long value) {
        counter = value;
    }

    public LongCounter() {
        counter = 0L;
    }
}
