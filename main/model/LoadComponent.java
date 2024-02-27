package main.model;

import java.util.ArrayList;
import java.util.Stack;


public class LoadComponent <V extends Vehicle> { // TODO använd parametrisk polymorfism KLAR
    private Stack<V> carStack; //should imply composition to main.model.Vehicle since main.model.LoadComponent has attribute with class Stack<main.model.Vehicle>?
    private int loadCapacity;

    public LoadComponent(int capacity) {
        if (capacity > 0 && capacity <= 50) {
            this.loadCapacity = capacity;
            this.carStack = new Stack<>();
        }
        else {
            throw new IllegalArgumentException("Invalid load capacity");
        }
    }

    public void load(V car) {
        if (carStack.size() >= loadCapacity) {
            throw new IllegalArgumentException("Load capacity is full");
        }
        carStack.push(car);
    }

    public V unload() { //If no regNr entered, then no overload and we just pop out the last car.
        if (!carStack.empty()) {
            V car = carStack.pop();
            return car;
        }
        throw new IllegalArgumentException("Load capacity is empty");

    }

    public V unload(int regNum) { // if regNum is sent as argument this function will be used, i.e if we have another method signature this overloads statically
        ArrayList<V> carList = new ArrayList<V>(carStack);

        for (int i = 0; i < carList.size(); i++) {
            if (carList.get(i).getRegNum() == regNum) {
                V foundCar = carList.get(i);
                carList.remove(i);
                carStack.clear();
                carStack.addAll(carList);
                return foundCar;
            }
        }
        throw new IllegalArgumentException("Could not find vehicle with correct registration number");
    }

    public int getLoadCapacity() {
        return this.loadCapacity;
    }

    public Stack<V> getCarStack(){
        return this.carStack;
    }

}
