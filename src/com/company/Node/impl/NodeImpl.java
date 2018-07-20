package com.company.Node.impl;

import com.company.Node.enums.ItemType;
import com.company.Node.enums.LimitType;

public class NodeImpl extends Item {

    public NodeImpl(LimitType limitType, int limitValue) {
        super(ItemType.NODE, limitType, limitValue, new CurrentTimeImpl());
    }

}
