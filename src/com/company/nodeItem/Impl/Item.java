package com.company.nodeItem.Impl;

import com.company.nodeItem.ItemType;
import com.company.nodeItem.LimitType;
import com.company.nodeItem.Limits;

public abstract class Item implements com.company.nodeItem.isNode, Limits {
    private ItemType isNode;
    private LimitType limitType;
    private int limitValue;

    public Item(ItemType isNode, LimitType limitType, int limitValue) {
        this.isNode = isNode;
        this.limitType = limitType;
        this.limitValue = limitValue;
    }

    @Override
    public LimitType getLimitType() {
        return limitType;
    }

    @Override
    public int getLimitValue() {
        return limitValue;
    }

    @Override
    public ItemType isNode() {
        return isNode;
    }
}
