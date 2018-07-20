package com.company.stateMachine;

import com.company.Node.enums.ItemType;
import com.company.Node.enums.LimitType;
import com.company.Node.exceptions.WrongTypeException;
import com.company.Node.impl.Item;

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

    public void newState(boolean state) throws WrongTypeException {
        if (onTop().hasNext()) {
            switch (onTop().getLimitType()){
                case COUNT: {
                    Item item = onTop().next(state);
                    if (item != onTop()) {
                        itemsStack.removeLast();
                        if (onTop() == item) {
                            newState(true);
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
