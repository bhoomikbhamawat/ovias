package com.example.akash.login;

public class bikes {
    String bikeid;
    String avail;
    public bikes(){

    }
    public bikes(String bikeid,String avail){
        this.avail=avail;
        this.bikeid=bikeid;
    }

    public String getBikeid(){
        return bikeid;
    }

    public String getavail(){
        return avail;
    }

}
