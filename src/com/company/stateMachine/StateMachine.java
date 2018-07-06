package com.company.stateMachine;

import com.company.nodeItem.Impl.Item;
import com.company.stateMachine.iterItem.ItemWithCounterFactory;
import com.company.stateMachine.iterItem.IterItem;
import com.company.stateMachine.iterItem.WrongLimitTypeException;

import java.util.ArrayList;
import java.util.LinkedList;

public class StateMachine {
    private Item instruction;
    private LinkedList<IterItem> itemsStack;

    public StateMachine() {
        itemsStack = new LinkedList<>();
    }

    public void newState(PendulumSwingState state){
        if (itemsStack.peek().getNewSample(state)) {
            itemsStack.pop();
        }

    }

    public void setInstructions(Item instruction) throws WrongLimitTypeException {
        itemsStack.clear();
        this.instruction = instruction;
        pushItem(instruction);
    }

    private void pushItem(Item item) throws WrongLimitTypeException {
        itemsStack.add(ItemWithCounterFactory.getItem(item));
    }
}
