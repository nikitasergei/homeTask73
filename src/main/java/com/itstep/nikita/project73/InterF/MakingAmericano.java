package com.itstep.nikita.project73.InterF;

import com.itstep.nikita.project73.Coffee.Americano;
import com.itstep.nikita.project73.Exception.CoffeeMachineException;

public interface MakingAmericano {
    Americano makeAmericano() throws CoffeeMachineException;
}
