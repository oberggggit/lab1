package main.model;

public interface BedInterface {
    void raiseBed(double currentSpeed);
    void lowerBed(double currentSpeed);
    boolean isBedUp();
    boolean isBedDown();
}
