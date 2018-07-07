package com.company.nodeItem.Impl;

import com.company.nodeItem.ItemType;
import com.company.nodeItem.LimitType;
import com.company.nodeItem.Node;

import java.util.List;

public class NodeImpl extends Item implements Node {
    List<Item> items;

    public NodeImpl(LimitType limitType, int limitValue, List<Item> items) {
        super(ItemType.NODE, limitType, limitValue);
        this.items = items;
    }

    @Override
    public Item getItem(int i) {
        return items.get(i);
    }

    @Override
    public int getLen() {
        return items.size();
    }

    @Override
    public String toString() {
        return "NodeImpl{" +
                "items=" + items +
                '}';
    }
}
