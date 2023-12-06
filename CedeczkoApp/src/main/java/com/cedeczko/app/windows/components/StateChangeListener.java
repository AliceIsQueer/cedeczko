package com.cedeczko.app.windows.components;

import com.cedeczko.app.logic.util.Pair;

public interface StateChangeListener {
    void onStateChange(Pair<Integer, String> newState);
}
