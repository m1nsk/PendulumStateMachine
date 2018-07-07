package com.company.stateMachine.iterItem;

import com.company.nodeItem.Impl.Item;
import com.company.nodeItem.Node;
import com.company.stateMachine.PendulumSwingState;

public class NodeWithCounterByTime implements IterItem {
    int currentId;
    private int start;
    private int counter;
    Node node;

    public NodeWithCounterByTime(Item item) {
        this.node = (Node)item;
        currentId = 0;
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
        currentId++;
        return true;
    }

    @Override
    public boolean isNode() {
        return true;
    }

    @Override
    public Item next() {
        return node.getItem(currentId % node.getLen());
    }
}
