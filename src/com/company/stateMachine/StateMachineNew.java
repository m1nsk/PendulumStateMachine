package com.company.stateMachine;

import com.company.Node.Item;
import com.company.nodeItem.ItemType;
import com.company.nodeItem.LimitType;
import com.company.stateMachine.iterItem.WrongTypeException;

import java.util.LinkedList;

public class StateMachineNew {
    private Item instruction;
    private LinkedList<Item> itemsStack;

    public StateMachineNew() {
        itemsStack = new LinkedList<>();
    }

    private Item onTop(){
        return itemsStack.peekLast();
    }

    public void newState(PendulumSwingState state) throws WrongTypeException {
        if (onTop().hasNext()) {
            switch (onTop().getLimitType()){
                case COUNT: {
                    Item item = onTop().next(isTurn(state));
                    if (item != onTop()) {
                        itemsStack.removeLast();
                        if (itemsStack.peekLast() == item) {
                            pushItem(item.next(true));
                        } else {
                            pushItem(item);
                        }
                    }
                    break;
                }
                case TIME: {
                    onTop().next();
                    break;
                }
                default: {
                    throw new WrongTypeException();
                }
            }
        }
        checkTimeLimit();
    }

    private boolean isTurn(PendulumSwingState state) {
        return state == PendulumSwingState.LEFT || state == PendulumSwingState.RIGHT;
    }


    public void setInstructions(Item instruction) {
        itemsStack.clear();
        this.instruction = instruction;
        pushItem(this.instruction);
    }

    private void pushItem(Item item) {
        itemsStack.addLast(item);
        while (onTop().isNode().equals(ItemType.NODE)) {
            pushItem(item.getDeepNext());
        }
    }

    private void checkTimeLimit() {
        for (int i = 0; i < itemsStack.size(); i++) {
            if(itemsStack.get(i).getLimitType() == LimitType.TIME && itemsStack.get(i).next() != itemsStack.get(i)) {
                for (int j = 0; j < itemsStack.size() - i ; j++) {
                    itemsStack.removeLast();
                }
                pushItem(onTop().next(true));
                break;
            }
        }
    }
}
