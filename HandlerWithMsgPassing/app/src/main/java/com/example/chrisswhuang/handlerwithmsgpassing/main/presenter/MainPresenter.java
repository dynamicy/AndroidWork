package com.example.chrisswhuang.handlerwithmsgpassing.main.presenter;

import com.example.chrisswhuang.handlerwithmsgpassing.common.IPresenter;
import com.example.chrisswhuang.handlerwithmsgpassing.common.MyThread;
import com.example.chrisswhuang.handlerwithmsgpassing.common.IView;

/**
 * Title: com.example.chrisswhuang.handlerwithmsgpassing.main.presenter.MainPresenter<br>
 * Description: MainPresenter
 *
 * @author chris
 * @version 1.0
 */
public class MainPresenter implements IPresenter {

    private IView myView;

    public MainPresenter(IView myView) {
        this.myView = myView;
    }

    @Override
    public void doThreadStuff() {
        new MyThread(myView).start();
    }
}
