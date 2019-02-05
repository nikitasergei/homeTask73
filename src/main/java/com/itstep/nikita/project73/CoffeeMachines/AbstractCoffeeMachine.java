package com.itstep.nikita.project73.CoffeeMachines;

import com.itstep.nikita.project73.InterF.Enable;
import com.itstep.nikita.project73.InterF.Fillable;

public abstract class AbstractCoffeeMachine implements Enable, Fillable {
    public int boxOfCoffeeSize;
    public int boxOfWaterSize;
    public int boxOfGarbageSize;
    public boolean isOn = false;
    public int garbage;
    public int coffee;
    public int water;


    AbstractCoffeeMachine() {
    }

    public void pressOn() {
        this.isOn = true;
    }

    public void pressOff() {
        this.isOn = false;
    }

    public void cleanGarbage() {
        this.garbage = 0;
    }

    public void fillOfCoffee(int coffee) {
        if (this.coffee < boxOfCoffeeSize && this.coffee + coffee < boxOfCoffeeSize)
            this.coffee += coffee;
        else this.coffee = boxOfCoffeeSize;
    }

    public void fillOfWater(int water) {
        if (this.water < boxOfWaterSize && this.water + water < boxOfWaterSize)
            this.water += water;
        else this.water = boxOfWaterSize;
    }

    public void setGarbage(){
        this.garbage = boxOfGarbageSize-20;
    }
}
