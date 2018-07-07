package com.company.stateMachine.iterItem;

import com.company.nodeItem.Impl.Item;

public class ItemWithCounterFactory {
    public static IterItem getItem(Item item) throws WrongTypeException {
        switch (item.getLimitType()) {
            case TIME:
                switch (item.isNode()) {
                    case LEAF:
                        return new LeafWithCounterByTime(item);
                    case NODE:
                        return new NodeWithCounterByTime(item);
                    default:
                        throw new WrongTypeException();
                }
            case COUNT: {
                switch (item.isNode()) {
                    case LEAF:
                        return new LeafWithCounterByCount(item);
                    case NODE:
                        return new NodeWithCounterByCount(item);
                    default:
                        throw new WrongTypeException();
                }
            }
            default:
                throw new WrongTypeException();
        }
    }
}
