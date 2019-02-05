package com.itstep.nikita.project73.CoffeeMachines;


//First Generation CoffeeMachine for Office
public class FGOfficeCM extends FGCoffeeMachine {
    private String modelName = "FGOfficeCM";

    public FGOfficeCM() {
        super();
        this.boxOfCoffeeSize = 1000;
        this.boxOfWaterSize = 2000;
        this.boxOfGarbageSize = 1000;
    }
}
