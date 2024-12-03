package org.example;

public class Calculator {
    public  Integer add(Integer a, Integer b){
        if(a==null || b==null){
            return null;
        }
       return a+b;
    }

    public Integer divide(Integer a,Integer b){
        if(a==null || b==null){
            return null;
        }
        return a/b;
    }

    public int[] array(){
        return new int[]{1,2,3};
    }

    public int generate(int min,int max){
        return (int) (Math.random()*(max-min+1))+min;
    }

//    public boolean checkCondition(int a,int b){
//        return a>b;
//    }
//
//    public void getException() throws  Exception{
//        throw new Exception("Exception Found!!");
//    }
//

//
//    public void checkBool(){
//        System.out.println("Condition Checked!");
//    }
//
//    public String str(String s){
//        return s;
//    }
}