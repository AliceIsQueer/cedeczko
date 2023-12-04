package com.cedeczko.windows.components;

import com.cedeczko.logic.util.Pair;

public interface StateChangeListener {
    void onStateChange(Pair<Integer, String> newState);
}
