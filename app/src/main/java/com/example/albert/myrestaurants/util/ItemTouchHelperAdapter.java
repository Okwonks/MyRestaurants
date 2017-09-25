package com.example.albert.myrestaurants.util;

/**
 * Created by albert on 9/25/17.
 */

public interface ItemTouchHelperAdapter {
    boolean onItemMove(int fromPosition, int toPosition);
    void onItemDismiss(int position);
}
