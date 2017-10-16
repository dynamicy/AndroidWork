package io.csie.chris.rxjava;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import io.reactivex.Flowable;
import io.reactivex.Observable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        Logger.d("onCreate");

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

    }

    @Override
    protected void onResume() {
        super.onResume();

        Flowable.just("Hello world1");

        Flowable.just("Hello world2").subscribe(System.out::println);

        // Without java8
        Flowable.just("Hello world3")
                .subscribe(new Consumer<String>() {
                    @Override
                    public void accept(String s) {
                        System.out.println(s);
                    }
                });

        Observable<String> myObservable = Observable.just("Hello world3");

        Disposable myObservable1 = Observable.just("Hello world4").subscribe(System.out::println);

        Disposable myObservable2 = Observable.just("Hello world5")
                .map(s -> s + " 777")
                .subscribe(System.out::println);

        Disposable myObservable4 = Observable.just("Hello world6")
                .map(String::hashCode)
                .subscribe(i -> System.out.println(Integer.toString(i)));

        Disposable myObservable5 = Observable.just("Hello world7")
                .map(String::hashCode)
                .map(i -> Integer.toString(i))
                .subscribe(System.out::println);

        Disposable myObservable6 = Observable.just("Hello world8")
                .map(s -> s + " 999")
                .map(String::hashCode)
                .map(i -> Integer.toString(i))
                .subscribe(System.out::println);
    }

}
