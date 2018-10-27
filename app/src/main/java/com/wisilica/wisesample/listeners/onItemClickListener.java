package com.wisilica.wisesample.listeners;

import android.view.View;

public interface onItemClickListener {
   /** Trigger when an item clicked.
     *
             * @param object   the object
     * @param view     the view
     * @param action   the action
     * @param position the position
     */
    void onItemClicked(Object object, View view, int action, int position);

    /**
     * Trigger when an item touched.
     *
     * @param object   the object
     * @param view     the view
     * @param action   the action
     * @param position the position
     */
    default void onItemTouched(Object object, View view, int action, int position) {
        //override to use this
    }

    /**
     * Trigger when an item long clicked.
     *
     * @param object   the object
     * @param view     the view
     * @param action   the action
     * @param position the position
     */
    default void onItemLongClicked(Object object, View view, int action, int position) {
        //override to use this
    }

}
