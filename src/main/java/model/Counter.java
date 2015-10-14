package model;

public interface Counter<T> {
    void inc();
    void dec();
    T getCounterValue();
    void setCounterValue(T value);
}
