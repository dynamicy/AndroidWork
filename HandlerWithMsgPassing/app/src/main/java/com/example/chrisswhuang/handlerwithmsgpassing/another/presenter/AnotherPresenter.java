package com.example.chrisswhuang.handlerwithmsgpassing.another.presenter;

import com.example.chrisswhuang.handlerwithmsgpassing.common.IPresenter;
import com.example.chrisswhuang.handlerwithmsgpassing.common.IView;
import com.example.chrisswhuang.handlerwithmsgpassing.common.MyThread;

/**
 * Title: com.example.chrisswhuang.handlerwithmsgpassing.another.presenter.IPresenter<br>
 * Description: IPresenter
 *
 * @author chris
 * @version 1.0
 */
public class AnotherPresenter implements IPresenter {

    private IView myView;

    public AnotherPresenter(IView myView) {
        this.myView = myView;
    }

    @Override
    public void doThreadStuff() {
        new MyThread(myView).start();
    }
}
