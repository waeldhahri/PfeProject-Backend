package com.example.pfeprojectbackend.udemy;




public class StringMethods {


    public static void main(String[] args){


        String birthdayDate="02/05/1997";

        int startingIndex = birthdayDate.indexOf("1997");
        System.out.println("StartingIndex="+startingIndex);

        System.out.println("Birth year = "+ birthdayDate.substring(startingIndex));

        System.out.println("Month = "+birthdayDate.substring(3,5));


        String newDate= String.join("/","02","03","04");
        System.out.println("month ="+newDate);





    }
}


