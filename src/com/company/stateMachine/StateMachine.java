package com.company.stateMachine;

import com.company.nodeItem.Impl.Item;
import com.company.stateMachine.iterItem.ItemWithCounterFactory;
import com.company.stateMachine.iterItem.IterItem;
import com.company.stateMachine.iterItem.WrongTypeException;

import java.util.LinkedList;

public class StateMachine {
    private Item instruction;
    private LinkedList<IterItem> itemsStack;

    public StateMachine() {
        itemsStack = new LinkedList<>();
    }

    public void newState(PendulumSwingState state) throws WrongTypeException {
        if (itemsStack.peek().getNewSample(state)) {
            System.out.println(state);
            getNextItem();
        }
        checkTimeLimit();
    }

    private void getNextItem() throws WrongTypeException {
        itemsStack.pop();
        if(itemsStack.peek().hasNext()){
            Item newItem = itemsStack.peek().next();
            if(newItem != null) {
                pushItem(newItem);
            }
        } else {
            getNextItem();
        }
    }


    public void setInstructions(Item instruction) throws WrongTypeException {
        itemsStack.clear();
        this.instruction = instruction;
        pushItem(instruction);
    }

    private void pushItem(Item item) throws WrongTypeException {
        System.out.println(item);
        itemsStack.push(ItemWithCounterFactory.getItem(item));
        if (itemsStack.peek().isNode()) {
            pushItem(itemsStack.peek().next());
        }
    }

    private void checkTimeLimit() {
        for (int i = 0; i < itemsStack.size(); i++) {
            if (itemsStack.get(i).checkTime()) {
                for (int j = 0; j < itemsStack.size() - i ; j++) {
                    itemsStack.pop();
                }
                break;
            }
        }
    }
}
