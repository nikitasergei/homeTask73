package com.itstep.nikita.project73.CoffeeMachines;

import com.itstep.nikita.project73.Coffee.Capuchino;
import com.itstep.nikita.project73.Coffee.Latte;
import com.itstep.nikita.project73.Exception.*;
import com.itstep.nikita.project73.InterF.MakingCapuchino;
import com.itstep.nikita.project73.InterF.MakingLatte;


//Second Generation CoffeeMachine (for Task2)
public class SGCoffeeMachine extends FGCoffeeMachine implements MakingCapuchino, MakingLatte {
    public int boxOfMilkSize;
    public int milk;


    public Latte makeLatte() throws CoffeeMachineException {
        if (isOn && this.coffee > 22 && this.water > 30 && this.garbage < this.boxOfGarbageSize - 22) {
            int milkToLatte = (int) (Math.random() * 90) + 10; //generate random int from 10 to 100, how much milk we need to make Latte
            if (this.milk > milkToLatte) {
                return new Latte();
            } else throw new NoMilkException();
        } else if (this.coffee < 22) {
            throw new NoCoffeeException();
        } else if (this.water < 30) {
            throw new NoWaterException();
        } else if (this.garbage > this.boxOfGarbageSize - 22) {
            throw new FullBoxOfGarbageException();
        } else return null;
    }

    public Capuchino makeCapuchino() throws CoffeeMachineException {
        if (isOn && this.coffee > 22 && this.water > 30 && this.garbage < this.boxOfGarbageSize - 22) {
            int milkToCapuchino = (int) (Math.random() * 90) + 10; //generate random int from 10 to 100, how much milk we need to make Capuchino
            if (this.milk > milkToCapuchino) {
                return new Capuchino();
            } else throw new NoMilkException();
        } else if (this.coffee < 22) {
            throw new NoCoffeeException();
        } else if (this.water < 30) {
            throw new NoWaterException();
        } else if (this.garbage > this.boxOfGarbageSize - 22) {
            throw new FullBoxOfGarbageException();
        } else return null;
    }

    public void fillOfMilk(int milk){
        if (this.milk < boxOfMilkSize && this.milk + milk < boxOfMilkSize)
            this.milk += milk;
        else this.milk = boxOfMilkSize;
    }
}
