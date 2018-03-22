package com.example.chrisswhuang.handlerwithmsgpassing.common;

/**
 * Title: com.example.chrisswhuang.handlerwithmsgpassing.common.IView<br>
 * Description: AnotherActivity
 *
 * @author chris
 * @version 1.0
 */
public interface IView {

    // Set result
    void setText(int result);

    // Intent to the target activity
    void gotoActivity();
}
