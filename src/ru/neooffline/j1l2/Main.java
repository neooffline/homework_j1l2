package ru.neooffline.j1l2;

public class Main {

    public static void main(String[] args) {

        double[] arrayTest = {-100,4242,4242.1,-1,2,3,5,10,-20,18};
        printArray(findMinMaxElement(arrayTest));
    }
    //Задание 5
    static double[] findMinMaxElement(double[] array){
        double[] arrResult = new double[2];
        for (int i = 0; i < array.length; i++) {
            if(arrResult[0]>array[i]){
                arrResult[0]=array[i];
            }
            if (arrResult[1]<array[i]){
                arrResult[1]=array[i];
            }
        }
        return arrResult;
    }
    static void printArray(double[] array){
        for (double value:array
             )
        if ((int)value==value){
            System.out.println((int) value);
        } else {
            System.out.println(value);
        }
    }
}
