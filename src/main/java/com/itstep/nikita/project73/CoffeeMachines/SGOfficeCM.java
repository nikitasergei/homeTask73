package com.itstep.nikita.project73.CoffeeMachines;


//Second Generation CoffeeMachine for Office
public class SGOfficeCM extends SGCoffeeMachine {
    private String modelName = "SGOfficeCM";

    public SGOfficeCM(){
        super();
        this.boxOfCoffeeSize = 1000;
        this.boxOfWaterSize = 2000;
        this.boxOfGarbageSize = 1000;
        this.boxOfMilkSize = 1000;
    }
}
