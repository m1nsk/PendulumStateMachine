package com.company.stateMachine.iterItem;

import com.company.nodeItem.Impl.Item;
import com.company.stateMachine.PendulumSwingState;

public class ItemWithCounterByCount implements IterItem {
    private int start;
    private int counter;

    public ItemWithCounterByCount(Item item) {
        start = 0;
        counter = item.getLimitValue();
    }

    @Override
    public boolean getNewSample(PendulumSwingState state) {
        if(state == PendulumSwingState.LEFT || state == PendulumSwingState.RIGHT && --counter <= 0) {
          return true;
        }
        return false;
    }

    @Override
    public boolean checkTime() {
        return false;
    }
}
