package com.company.stateMachine.iterItem;

import com.company.nodeItem.Impl.Item;
import com.company.stateMachine.PendulumSwingState;

public class LeafWithCounterByCount implements IterItem {
    private int start;
    private int counter;

    public LeafWithCounterByCount(Item item) {
        start = 0;
        counter = item.getLimitValue();
    }

    @Override
    public boolean getNewSample(PendulumSwingState state) {
        if(state == PendulumSwingState.RIGHT || state == PendulumSwingState.LEFT && --counter <= 0) {
            return true;
        }
        return false;
    }

    @Override
    public boolean checkTime() {
        return false;
    }

    @Override
    public boolean hasNext() {
        return true;
    }

    @Override
    public boolean isNode() {
        return false;
    }

    @Override
    public Item next() {
        return null;
    }
}
