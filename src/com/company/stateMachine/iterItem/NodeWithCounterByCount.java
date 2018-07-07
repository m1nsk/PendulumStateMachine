package com.company.stateMachine.iterItem;

import com.company.nodeItem.Impl.Item;
import com.company.nodeItem.Node;
import com.company.stateMachine.PendulumSwingState;

public class NodeWithCounterByCount implements IterItem {
    private Node node;
    private int start;
    private int counter;
    private int currentId;

    public NodeWithCounterByCount(Item item) {
        this.node = (Node)item;
        currentId = 0;
        start = 0;
        counter = item.getLimitValue();
    }

    @Override
    public boolean getNewSample(PendulumSwingState state) {
       return false;
    }

    @Override
    public boolean checkTime() {
        return false;
    }

    @Override
    public boolean hasNext() {
        currentId++;
        if (currentId >= node.getLen()) {
            counter--;
            if (counter >= 0) {
                return false;
            } else {
                if (currentId < 0)
                    currentId = 0;
                return true;
            }
        } else {
            return true;
        }
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
