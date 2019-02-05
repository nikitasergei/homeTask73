package com.itstep.nikita.project73.InterF;

import com.itstep.nikita.project73.Coffee.Latte;
import com.itstep.nikita.project73.Exception.CoffeeMachineException;

public interface MakingLatte {
    Latte makeLatte() throws CoffeeMachineException;
}
