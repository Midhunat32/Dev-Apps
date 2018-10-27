package com.wisilica.wisesample.presenter;



/**
 * Created by Godwin on 01-11-2017 11:50 for WiSeItAndroid.
 *
 * @author : Godwin Joseph Kurinjikattu
 */
public interface BaseView {
    /**
     * This is a general method used for showing some kind of progress during a background task. For example, this
     * method should show a progress bar and/or disable buttons before some background work starts.
     *
     * @param message the message
     */
    void showProgress(String message);

    /**
     * This is a general method used for hiding progress information after a background task finishes.
     */
    void dismissProgress();

    /**
     * This method is used for showing error messages on the UI.
     *
     * @param message The error message to be dislayed.
     */
    void showMessage(String message);

    /**
     * Show alert.
     *
     * @param title    the title
     * @param message  the message
     * @param callback the callback
     * @param objects  the objects
     */
//    default void showAlert(String title, String message, AlertListener callback, Object... objects) {
//        //if you want just override
//    }
}
