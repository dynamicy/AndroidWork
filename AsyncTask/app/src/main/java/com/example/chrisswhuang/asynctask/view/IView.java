package com.example.chrisswhuang.asynctask.view;

/**
 * Title: com.example.chrisswhuang.asynctask.view.IView<br>
 * Description: MyTask
 *
 * @author chris
 * @version 1.0
 */
public interface IView {

    // Set text view
    void setText(int resouce);

    // Set progress bar
    void setProgressBar(int progress);

    // Update progress bar
    void updateProgressBar(int progress);
}
