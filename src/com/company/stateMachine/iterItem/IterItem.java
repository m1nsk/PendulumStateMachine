package com.company.stateMachine.iterItem;

import com.company.stateMachine.PendulumSwingState;

public interface IterItem {
    boolean getNewSample(PendulumSwingState state);
    boolean checkTime();
}
