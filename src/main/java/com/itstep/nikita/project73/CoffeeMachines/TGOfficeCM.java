package com.itstep.nikita.project73.CoffeeMachines;


//Third Generation CoffeeMachine for Office
public class TGOfficeCM extends TGCoffeeMachine {
    private String modelName="TGOfficeCM";

    public TGOfficeCM(){
        super();
        this.boxOfCoffeeSize = 1000;
        this.boxOfWaterSize = 2000;
        this.boxOfGarbageSize = 1000;
        this.boxOfMilkSize = 1000;
        this.boxOfCoffeeBeans=1000;
    }
}
