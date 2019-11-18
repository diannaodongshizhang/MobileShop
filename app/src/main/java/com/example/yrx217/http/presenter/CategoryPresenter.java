package com.example.yrx217.http.presenter;

import com.example.yrx217.http.HttpMethods;
import com.example.yrx217.http.entity.CategoryEntity;

import java.util.List;

import rx.Observable;
import rx.Subscriber;

public class CategoryPresenter extends HttpMethods {

    public static void getTopList(Subscriber<List<CategoryEntity>> subscriber){
        Observable<List<CategoryEntity>> observable = categoryService.getTopList()
                .map(new HttpResultFunc<List<CategoryEntity>>());
        toSubscribe(observable,subscriber);
    }

    public static void getSecondList(Subscriber<List<CategoryEntity>> subscriber,int parentId){
        Observable<List<CategoryEntity>> observable = categoryService.getSecondList(parentId)
                .map(new HttpResultFunc<List<CategoryEntity>>());
        toSubscribe(observable,subscriber);
    }


}
