package com.company.stateMachine.iterItem;

import com.company.nodeItem.Impl.Item;
import com.company.stateMachine.PendulumSwingState;

public class LeafWithCounterByTime implements IterItem {
    private int start;
    private int counter;

    public LeafWithCounterByTime(Item item) {
        start = (int)(System.nanoTime() / 1_000_000_000);
        counter = start + item.getLimitValue();
    }

    @Override
    public boolean getNewSample(PendulumSwingState state) {
        return false;
    }

    @Override
    public boolean checkTime() {
        return System.nanoTime() / 1_000_000_000 > counter;
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
