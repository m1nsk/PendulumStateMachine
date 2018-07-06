package com.company.stateMachine.iterItem;

import com.company.nodeItem.Impl.Item;

public class ItemWithCounterFactory {
    public static IterItem getItem(Item item) throws WrongLimitTypeException {
        switch (item.getLimitType()) {
            case TIME:
                return new ItemWithCounterByTime(item);
            case COUNT:
                return new ItemWithCounterByCount(item);
            default:
                throw new WrongLimitTypeException();
        }
    }
}
