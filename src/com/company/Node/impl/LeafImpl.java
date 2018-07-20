package com.company.Node.impl;

import com.company.Node.enums.ItemType;
import com.company.Node.enums.LimitType;

public class LeafImpl extends Item {
    private String data;

    public LeafImpl(LimitType limitType, int limitValue, String data, Item next) {
        super(ItemType.LEAF, limitType, limitValue, new CurrentTimeImpl());
        this.data = data;
        setDeepNext(this);
        setNext(next);
    }

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
