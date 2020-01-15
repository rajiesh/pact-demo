package org.pact.demo;


public class DataRepository {

    String data;


    public String get(){
        return data;
    }

    public void put(String data){
        this.data = data;
    }

}
