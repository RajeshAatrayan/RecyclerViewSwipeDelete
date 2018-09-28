package com.ibrickedlabs.recyclerviewswipedelete;

import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.helper.ItemTouchHelper;

/**
 * Created by RajeshAatrayan on 28-09-2018.
 */

/**
 * Inorder to get listened whenever we swip the item we need extend the ItemTouchHelper.Callback or ItemTouchHelper.SimpleCallback
 */
public class SimpleTouchCallback extends ItemTouchHelper.Callback {
    private SwipeListener mSwipeListener;

    SimpleTouchCallback(SwipeListener mSwipeListener) {
        this.mSwipeListener = mSwipeListener;
    }

    @Override
    public int getMovementFlags(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder) {
        /**
         * Here dragFlags=0 bcz we dont want to drag but swipe so i have mentioned the swipe direction ie..L->R
         */
        return makeMovementFlags(0, ItemTouchHelper.END);
    }

    @Override
    public boolean onMove(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder, RecyclerView.ViewHolder target) {
        //Since we dont want to move just return false
        return false;
    }

    @Override
    public boolean isLongPressDragEnabled() {
        return false;//since we dont want to drag
    }

    @Override
    public boolean isItemViewSwipeEnabled() {
        return true;//bcz we want to swipe enabled on our items
    }

    //onSwiped will be called after swiping & only if swiping is enabled
    @Override
    public void onSwiped(RecyclerView.ViewHolder viewHolder, int direction) {
        mSwipeListener.onSwipe(viewHolder.getAdapterPosition());

    }
}
