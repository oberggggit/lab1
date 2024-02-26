package main.model;

public class BedComponent implements BedInterface {
    private boolean bedUp;

    public BedComponent() {
        this.bedUp = true;
    } //konstruktor

    public boolean isBedUp() {
        return this.bedUp;
    }

    public boolean isBedDown() {
        return !this.bedUp;
    }

    public void raiseBed(double currentSpeed) {
        if (currentSpeed != 0) {
            throw new IllegalArgumentException("Please stop to raise bed");
        } else if (this.bedUp) {
            throw new IllegalArgumentException("Bed is already up");
        } else {
            this.bedUp = true;;
        }
    }

    public void lowerBed(double currentSpeed) {
        if (currentSpeed != 0) {
            throw new IllegalArgumentException("Please stop to lower bed");
        } else if (isBedDown()) {
            throw new IllegalArgumentException("Bed is already down");
        } else {
            this.bedUp = false;
        }
    }

//    public void setBedState(boolean newState, double currentSpeed) {
//        if (currentSpeed == 0) {
//            this.bedUp = newState;
//        } else {
//            throw new IllegalArgumentException("Stop to move the bed");
//        }
//    }
}
