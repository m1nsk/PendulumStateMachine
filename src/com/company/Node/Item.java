package com.company.Node;

import com.company.nodeItem.IsNode;
import com.company.nodeItem.ItemType;
import com.company.nodeItem.LimitType;
import com.company.nodeItem.Limits;

public class Item implements IsNode, Limits, NodeIterator {
    private ItemType isNode;
    private LimitType limitType;
    private int limitValue;
    protected int counter;
    private long timeCounter;
    private Item deepNext;
    private Item next;


    public Item(ItemType isNode, LimitType limitType, int limitValue) {
        this.isNode = isNode;
        this.limitType = limitType;
        this.limitValue = limitValue;
        counter = 0;
        timeCounter = System.nanoTime() / 1000;
    }

    public void setDeepNext(Item deepNext) {
        this.deepNext = deepNext;
    }

    public void setNext(Item next) {
        this.next = next;
    }

    public Item getDeepNext() {
        return deepNext;
    }

    @Override
    public ItemType isNode() {
        return isNode;
    }

    @Override
    public boolean hasNext() {
        return deepNext != null;
    }

    @Override
    public Item next(Boolean turn) {
        if (getLimitType() == LimitType.TIME)
            throw new WrongTypeIterException();
        if (turn) {
            System.out.println(this);
            counter++;
        }
        if (limitValue <= counter) {
            counter = 0;
            return next;
        }
        return deepNext;
    }

    @Override
    public Item next() {
        if (limitType == LimitType.COUNT)
            throw new WrongTypeIterException();
        if (timeCounter + limitValue <= System.nanoTime() / 1000) {
            return deepNext;
        }
        return this;
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
    public String toString() {
        return "Item{" +
                "isNode=" + isNode +
                ", limitType=" + limitType +
                ", limitValue=" + limitValue +
                ", counter=" + counter +
                '}';
    }

    public void clear() {
        counter = 0;
    }
}
