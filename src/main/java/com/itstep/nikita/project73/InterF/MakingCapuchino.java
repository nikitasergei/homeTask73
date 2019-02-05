package com.itstep.nikita.project73.InterF;

import com.itstep.nikita.project73.Coffee.Capuchino;
import com.itstep.nikita.project73.Exception.CoffeeMachineException;

public interface MakingCapuchino {
    Capuchino makeCapuchino() throws CoffeeMachineException;
}
