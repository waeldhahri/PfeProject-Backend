package com.example.pfeprojectbackend.udemy;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Customer {




    String name;
    String creditlimit;
    String email;



    public Customer(String name,String creditlimit, String email){

        this.name=name;
        this.creditlimit=creditlimit;
        this.email=email;

    }


    public Customer(){

    }


    public Customer(String name,String email){
        this.name=name;
        this.email=email;
    }



    public  char index(String name){


       Customer B=new Customer();

       return B.name.charAt(3);




    }



}
