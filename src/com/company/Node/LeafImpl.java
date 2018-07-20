package com.company.Node;

import com.company.nodeItem.ItemType;
import com.company.nodeItem.Leaf;
import com.company.nodeItem.LimitType;

public class LeafImpl extends Item implements Leaf<String> {
    private String data;

    public LeafImpl(LimitType limitType, int limitValue, String data, Item next) {
        super(ItemType.LEAF, limitType, limitValue);
        this.data = data;
        setDeepNext(this);
        setNext(next);
    }

    @Override
    public String getData() {
        return data;
    }

    @Override
    public String toString() {
        return "LeafImpl{" +
                "data='" + data + '\'' +
                ", counter=" + counter +
                '}';
    }
}
