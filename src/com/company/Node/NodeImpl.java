package com.company.Node;

import com.company.nodeItem.ItemType;
import com.company.nodeItem.LimitType;

public class NodeImpl extends Item {

    public NodeImpl(LimitType limitType, int limitValue) {
        super(ItemType.NODE, limitType, limitValue);
    }

}
