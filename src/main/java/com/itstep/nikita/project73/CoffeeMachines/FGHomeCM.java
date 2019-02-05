package com.itstep.nikita.project73.CoffeeMachines;


//First Generation CoffeeMachine for Home
public class FGHomeCM extends FGCoffeeMachine {
    private String modelName = "FGHomeCM";

    public FGHomeCM() {
        super();
        this.boxOfCoffeeSize = 500;
        this.boxOfWaterSize = 1000;
        this.boxOfGarbageSize = 750;
    }
}
