package com.example.yrx217.http.presenter;


import com.example.yrx217.http.HttpMethods;
import com.example.yrx217.http.entity.MemberEntity;


import rx.Observable;
import rx.Subscriber;

public class MemberPresenter extends HttpMethods {
    public static void regrister(Subscriber<MemberEntity> subscriber, String username, String emial, String password){
        Observable observable=memberService.register(username,password,emial)
                .map(new HttpResultFunc<MemberEntity>());
        toSubscribe(observable,subscriber);

    }
    public static void login(Subscriber<MemberEntity> subscriber, String username, String password){
        Observable observable=memberService.login2(username,password)
                .map(new HttpResultFunc<MemberEntity>());
        toSubscribe(observable,subscriber);
    }
    public static void changePassword(Subscriber subscriber ,String memberId,String old_pwd,String new_pwd){
        Observable observable=memberService.changePassword(memberId,old_pwd,new_pwd);
        toSubscribe(observable,subscriber);
    }
}