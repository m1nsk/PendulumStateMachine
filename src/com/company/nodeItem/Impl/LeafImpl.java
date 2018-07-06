package com.company.nodeItem.Impl;

import com.company.nodeItem.ItemType;
import com.company.nodeItem.Leaf;
import com.company.nodeItem.LimitType;

public class LeafImpl extends Item implements Leaf<String> {
    private String data;

    public LeafImpl(LimitType limitType, int limitValue, String data) {
        super(ItemType.LEAF, limitType, limitValue);
        this.data = data;
    }

    @Override
    public String getData() {
        return data;
    }

    @Override
    public String toString() {
        return "LeafImpl{" +
                "data='" + data + '\'' +
                '}';
    }
}
