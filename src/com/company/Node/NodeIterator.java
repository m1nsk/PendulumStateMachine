package com.company.Node;

public interface NodeIterator {
    boolean hasNext();

    Item next(Boolean turn);

    Item next();
}
