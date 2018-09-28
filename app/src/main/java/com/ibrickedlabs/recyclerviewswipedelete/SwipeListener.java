package com.ibrickedlabs.recyclerviewswipedelete;

/**
 * Created by RajeshAatrayan on 28-09-2018.
 */

/**
 * The only way to communicate between to classes is via interfaces
 */
public interface SwipeListener {
    void onSwipe(int pos);
}
