package com.company.stateMachine.iterItem;

import com.company.nodeItem.Impl.Item;
import com.company.stateMachine.PendulumSwingState;

import java.util.Iterator;

public interface IterItem extends Iterator<Item> {
    boolean getNewSample(PendulumSwingState state);
    boolean isNode();
    boolean hasNext();
    boolean checkTime();
    Item next();

}
