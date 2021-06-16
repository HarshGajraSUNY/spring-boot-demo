package com.springboot.payroll;

//you can also use imports, for example:
//import java.util.*;

//you can write to stdout for debugging purposes, e.g.
//System.out.println("this is a debug message");

class prac {
	
	public static void main(String[] args) {
		
		System.out.println("final is " + solution("01111111111111111111111111111111"));
		
		
	}
 public static int solution(String S) {
     // write your code in Java SE 8
     
     if(validateString(S)){

         int number = Integer.parseInt(S,2);
         System.out.println(number);
         int count=0;
         int n=number;
         if(n==0){
             return 0;
         }
         while(n>0){
             count++;
              if(n%2==0){

                  n=n/2;

              }else{
                  n=n-1;

              }

         }
            


     return count;

     }
     
 return 0;
 }

 public static boolean validateString(String S){

     if(S.length()<1 || S.length()>100000){
         return false;
     }

     if(S.matches("^[01]+$")){
         return true;
     }else{
         return false;
     }
 }

 

}

