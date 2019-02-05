package com.itstep.nikita.project73.CoffeeMachines;


import com.itstep.nikita.project73.Coffee.Americano;
import com.itstep.nikita.project73.Coffee.Espresso;
import com.itstep.nikita.project73.Exception.CoffeeMachineException;
import com.itstep.nikita.project73.Exception.FullBoxOfGarbageException;
import com.itstep.nikita.project73.Exception.NoCoffeeException;
import com.itstep.nikita.project73.Exception.NoWaterException;
import com.itstep.nikita.project73.InterF.MakingAmericano;
import com.itstep.nikita.project73.InterF.MakingEspresso;

//First Generation CoffeeMachine (for Task1)
public abstract class FGCoffeeMachine extends AbstractCoffeeMachine implements MakingAmericano, MakingEspresso {

    public Espresso makeEspresso() throws CoffeeMachineException {
        if (isOn && this.coffee > 22 && this.water > 30 && this.garbage < this.boxOfGarbageSize - 22) {
            this.coffee -= 22;
            this.water -= 30;
            this.garbage += 22;
            return new Espresso();
        } else if (this.coffee < 22) {
            throw new NoCoffeeException();
        } else if (this.water < 30) {
            throw new NoWaterException();
        } else if (this.garbage > this.boxOfGarbageSize - 22) {
            throw new FullBoxOfGarbageException();
        } else return null;
    }

    public Americano makeAmericano() throws CoffeeMachineException {
        if (isOn && this.coffee > 22 && this.water > 30 && this.garbage < this.boxOfGarbageSize - 22) {
            this.coffee -= 22;
            this.water -= 100;
            this.garbage += 22;
            return new Americano();
        } else if (this.coffee < 22) {
            throw new NoCoffeeException();
        } else if (this.water < 100) {
            throw new NoWaterException();
        } else if (this.garbage > this.boxOfGarbageSize - 22) {
            throw new FullBoxOfGarbageException();
        } else return null;
    }
}
