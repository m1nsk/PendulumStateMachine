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

    private IterItem onTop(){
        return itemsStack.peekLast();
    }

    public void newState(PendulumSwingState state) throws WrongTypeException {
        if (onTop().getNewSample(state)) {
            System.out.println(state);
            getNextItem();
        }
        checkTimeLimit();
    }

    private void getNextItem() throws WrongTypeException {
        itemsStack.removeLast();
        if(onTop().hasNext()){
            Item newItem = onTop().next();
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
        pushItem(this.instruction);
    }

    private void pushItem(Item item) throws WrongTypeException {
        System.out.println(item);
        itemsStack.addLast(ItemWithCounterFactory.getItem(item));
        if (onTop().isNode()) {
            pushItem(onTop().next());
        }
    }

    private void checkTimeLimit() {
        for (int i = 0; i < itemsStack.size(); i++) {
            if (itemsStack.get(i).checkTime()) {
                for (int j = 0; j < itemsStack.size() - i ; j++) {
                    itemsStack.removeLast();
                }
                break;
            }
        }
    }
}
