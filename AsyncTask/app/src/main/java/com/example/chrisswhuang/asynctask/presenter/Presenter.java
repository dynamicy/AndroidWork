package com.example.chrisswhuang.asynctask.presenter;

import com.example.chrisswhuang.asynctask.common.MyTask;
import com.example.chrisswhuang.asynctask.view.IView;

/**
 * Title: com.example.chrisswhuang.asynctask.presenter.Presenter<br>
 * Description: Presenter
 *
 * @author chris
 * @version 1.0
 */
public class Presenter implements IPresenter {

    private IView myView;

    public Presenter(IView myView) {
        this.myView = myView;
    }

    @Override
    public void doThreadStuff() {
        new MyTask(myView).execute();
    }
}
