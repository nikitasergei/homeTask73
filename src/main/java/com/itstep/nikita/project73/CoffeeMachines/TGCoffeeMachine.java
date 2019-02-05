package com.itstep.nikita.project73.CoffeeMachines;


import com.itstep.nikita.project73.Coffee.Americano;
import com.itstep.nikita.project73.Coffee.Latte;
import com.itstep.nikita.project73.Exception.*;
import com.itstep.nikita.project73.InterF.MakingAmericano;
import com.itstep.nikita.project73.InterF.MakingLatte;

//Third Generation CoffeeMachine (for Task3)
public class TGCoffeeMachine extends AbstractCoffeeMachine implements MakingAmericano, MakingLatte {
    public int boxOfMilkSize;
    public int milk;
    public int boxOfCoffeeBeans;
    public int coffeeBeans;


    public void fillOfMilk(int milk) {
        if (this.milk < boxOfMilkSize && this.milk + milk < boxOfMilkSize)
            this.milk += milk;
        else this.milk = boxOfMilkSize;
    }


    public Americano makeAmericano() throws CoffeeMachineException {
        if (isOn && this.coffee > 22 && this.water > 30 && this.garbage < this.boxOfGarbageSize - 22) {
            this.coffee -= 22;
            this.water -= 100;
            this.garbage += 22;
            return new Americano();
        } else if (this.coffee < 22) {
            throw new NoCoffeeException();
        } else if (this.coffeeBeans ==0) {
            throw new NoCoffeeBeansException();
        } else if (this.water < 100) {
            throw new NoWaterException();
        } else if (this.garbage > this.boxOfGarbageSize - 22) {
            throw new FullBoxOfGarbageException();
        } else return null;
    }

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

    public void fillOfCoffeBeans(int coffeeBeans) {
        if (this.coffeeBeans < boxOfCoffeeBeans && this.coffeeBeans + coffeeBeans < boxOfCoffeeBeans)
            this.coffeeBeans += coffeeBeans;
        else this.coffeeBeans = boxOfCoffeeBeans;
    }

    public void grindCoffee() {
        if (this.coffeeBeans > 0 && this.coffee < this.boxOfCoffeeSize) {
            if (this.coffeeBeans <= this.boxOfCoffeeSize - this.coffee) {
                coffee += coffeeBeans;
                coffeeBeans = 0;
            } else {
                if (coffeeBeans >= this.boxOfCoffeeSize - this.coffee) {
                    this.coffeeBeans -= (this.boxOfCoffeeSize - this.coffee);
                    this.coffee = this.boxOfCoffeeBeans;
                }
                else {
                    this.coffee += this.coffeeBeans;
                    this.coffeeBeans = 0;
                }
            }
        }
    }
}
