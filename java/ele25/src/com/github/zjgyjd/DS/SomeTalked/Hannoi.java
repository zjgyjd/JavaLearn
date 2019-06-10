package com.github.zjgyjd.DS.SomeTalked;

//汉诺塔
public class Hannoi {
    //0 A
    //1 B
    //2 C
    public void Hannoi(int n,int src,int dest){
        //TODO
        if(n==1){
            //把盘子从src移到dest
        }else {
            Hannoi(n-1,src,3-src-dest);
        }
    }
}
