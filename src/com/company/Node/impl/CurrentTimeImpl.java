package com.company.Node.impl;

import com.company.Node.CurrentTime;

public class CurrentTimeImpl implements CurrentTime {
    @Override
    public long getCurrentTimeMs() {
        return System.nanoTime() / 1000;
    }
}
