package com.wyre;

public class Main {

    public static void main(String[] args) {
        if(args.length==0){
        }
	Translater tans = new Translater();
	System.out.println(tans.translate("es","he","hello there, what is up"));

    }
}
