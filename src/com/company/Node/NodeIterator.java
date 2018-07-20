package com.company.Node;

import com.company.Node.impl.Item;

public interface NodeIterator {
    boolean hasNext();

    Item next(Boolean turn);

    Item next();
}
