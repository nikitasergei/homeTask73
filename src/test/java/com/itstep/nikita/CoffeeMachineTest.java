package com.itstep.nikita;

import com.itstep.nikita.project73.Coffee.Americano;
import com.itstep.nikita.project73.Coffee.Capuchino;
import com.itstep.nikita.project73.Coffee.Espresso;
import com.itstep.nikita.project73.Coffee.Latte;
import com.itstep.nikita.project73.CoffeeMachines.*;
import com.itstep.nikita.project73.Exception.*;
import org.junit.Assert;
import org.junit.Test;


public class CoffeeMachineTest {

    @Test
    public void AllTests() throws CoffeeMachineException{
        //Task1
        testFGHomeCMNoWE();
        testFGHomeCMPositive();
        testFGOfficeCMNoCE();
        testFGOfficeCMGarbageE();
        //Task2
        testSGHomeCMNoME();
        testSGOfficeCMNoWE();
        testSGHomeCMNoCE();
        //Task3
        testTGOfficeCMGrind();
        testTGOfficeCMNoCBE();
        testTGOfficeCMNoCE();


    }

    //FGHomeCM Positive Test
    @Test
    public void testFGHomeCMPositive() throws CoffeeMachineException {
        //Given
        FGCoffeeMachine model = new FGHomeCM();
        model.fillOfWater(760);
        model.fillOfCoffee(1100);
        model.pressOn();
        //When
        Americano americano = model.makeAmericano();
        //Then
        Assert.assertNotNull(americano);
    }

    //FGHomeCM NoWaterException Test
    @Test
    public void testFGHomeCMNoWE() throws CoffeeMachineException {
        //Given
        FGCoffeeMachine model = new FGHomeCM();
        model.fillOfWater(10);
        model.fillOfCoffee(1100);
        model.pressOn();
        Americano americano;
        //When
        try {
            americano = model.makeAmericano();
        } catch (CoffeeMachineException exception) {
            if (exception instanceof NoWaterException)
                model.fillOfWater(500);
        }
        //Then
        americano = model.makeAmericano();
        Assert.assertNotNull(americano);
    }

    //FGOfficeCM NoCoffeeException Test
    @Test
    public void testFGOfficeCMNoCE() throws CoffeeMachineException {
        //Given
        FGCoffeeMachine model = new FGOfficeCM();
        model.fillOfWater(500);
        model.fillOfCoffee(21);
        model.pressOn();
        Espresso espresso;
        //When
        try {
            espresso = model.makeEspresso();
        } catch (CoffeeMachineException exception) {
            if (exception instanceof NoCoffeeException)
                model.fillOfCoffee(100);
        }
        //Then
        espresso = model.makeEspresso();
        Assert.assertNotNull(espresso);
    }

    //SGHomeCM NoMilkException Test
    @Test
    public void testSGHomeCMNoME() throws CoffeeMachineException {
        //Given
        SGCoffeeMachine model = new SGHomeCM();
        model.fillOfWater(100);
        model.fillOfCoffee(1100);
        model.fillOfMilk(10);
        model.pressOn();
        Latte latte;
        //When
        try {
            latte = model.makeLatte();
        } catch (CoffeeMachineException exception) {
            if (exception instanceof NoMilkException)
                model.fillOfMilk(500);
        }
        //Then
        latte = model.makeLatte();
        Assert.assertNotNull(latte);
    }

    //SGHomeCM NoCoffeeException Test
    @Test
    public void testSGHomeCMNoCE() throws CoffeeMachineException {
        //Given
        SGCoffeeMachine model = new SGHomeCM();
        model.fillOfWater(100);
        model.fillOfMilk(100);
        model.pressOn();
        Latte latte;
        //When
        try {
            latte = model.makeLatte();
        } catch (CoffeeMachineException exception) {
            if (exception instanceof NoCoffeeException)
                model.fillOfCoffee(500);
        }
        //Then
        latte = model.makeLatte();
        Assert.assertNotNull(latte);
    }

    //SGOfficeCM NoWaterException Test
    @Test
    public void testSGOfficeCMNoWE() throws CoffeeMachineException {
        //Given
        SGCoffeeMachine model = new SGOfficeCM();
        model.fillOfWater(10);
        model.fillOfCoffee(1100);
        model.fillOfMilk(100);
        model.pressOn();
        Capuchino capuchino;
        //When
        try {
            capuchino = model.makeCapuchino();
        } catch (CoffeeMachineException exception) {
            if (exception instanceof NoWaterException)
                model.fillOfWater(500);
        }
        //Then
        capuchino = model.makeCapuchino();
        Assert.assertNotNull(capuchino);
    }

    //TGOfficeCM NoCoffeeBeansException Test
    @Test
    public void testTGOfficeCMNoCBE() throws CoffeeMachineException {
        //Given
        TGCoffeeMachine model = new TGOfficeCM();
        model.fillOfWater(132);
        model.fillOfCoffee(1100);
        model.fillOfMilk(100);
        model.pressOn();
        Latte latte;
        //When
        try {
            latte = model.makeLatte();
        } catch (CoffeeMachineException exception) {
            if (exception instanceof NoCoffeeBeansException)
                model.fillOfCoffeBeans(500);
        }
        //Then
        latte = model.makeLatte();
        Assert.assertNotNull(latte);
    }

    //TGHomeCM NoCoffeeException Test
    @Test
    public void testTGOfficeCMNoCE() throws CoffeeMachineException {
        //Given
        TGCoffeeMachine model = new TGHomeCM();
        model.fillOfWater(150);
        model.fillOfMilk(100);
        model.fillOfCoffeBeans(200);
        model.pressOn();
        Americano americano;
        //When
        try {
            americano = model.makeAmericano();
        } catch (CoffeeMachineException exception) {
            if (exception instanceof NoCoffeeException)
                model.fillOfCoffee(500);
        }
        //Then
        americano = model.makeAmericano();
        Assert.assertNotNull(americano);
    }

    //TGOfficeCM grindCoffee Test
    @Test
    public void testTGOfficeCMGrind() throws CoffeeMachineException {
        //Given
        TGCoffeeMachine model = new TGOfficeCM();
        model.fillOfCoffee(0);
        model.fillOfWater(1000);
        model.fillOfMilk(200);
        model.fillOfCoffeBeans(0);
        model.pressOn();
        Latte latte;
        //When
        try {
            latte = model.makeLatte();
        } catch (CoffeeMachineException exception) {
            if (exception instanceof NoCoffeeException) {
                if (model.coffeeBeans > 0)
                    model.grindCoffee();
                else {
                    model.fillOfCoffeBeans(200);
                    model.grindCoffee();
                }
            }
        }
        //Then
        latte = model.makeLatte();
        Assert.assertNotNull(latte);
    }

    //FGOfficeCM FullBoxOfGarbageException Test
    @Test
    public void testFGOfficeCMGarbageE() throws CoffeeMachineException {
        //Given
        FGCoffeeMachine model = new FGOfficeCM();
        model.fillOfWater(500);
        model.fillOfCoffee(100);
        model.setGarbage();
        model.pressOn();
        Espresso espresso;
        //When
        try {
            espresso = model.makeEspresso();
        } catch (CoffeeMachineException exception) {
            if (exception instanceof FullBoxOfGarbageException)
                model.cleanGarbage();
        }
        //Then
        espresso = model.makeEspresso();
        Assert.assertNotNull(espresso);
    }
}

