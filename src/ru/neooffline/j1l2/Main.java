package ru.neooffline.j1l2;

public class Main {

    public static void main(String[] args) {
//        float[] arr1 = generateRandomArray(10,-100,100,"float");
//        printArray(arr1);
//        float[] arrm = generateRandomArray(10,-1000,10,"int");
//        printArray(arrm);
//        float[] arrk = generateRandomArray(6,-10,10,"");
//        printArray(arrk);
//        float[] arrayTest = {-100,4242,4242,-1,2,3,5,10,-20,18};
//        findMinMaxElement(arr1);
        int[] arrayTest = {1,2,3,4,5,6};
        shiftArray(arrayTest,2);
        arrayTest = new int[]{1, 2, 3, 4, 5, 6};
        shiftArray(arrayTest,-3);

    }
    static void printArray(float[] array){
        for (float value:array
        )
            if ((int)value==value){
                System.out.println((int) value);
            } else {
                System.out.println(value);
            }
        System.out.println("--------------");
    }
    static float[] generateRandomArray(int size, double min, double max, String type ){
        float[] resArray = new float[size];
        for (int i = 0; i < resArray.length; i++) {
            switch (type) {
                case "float":{
                    resArray[i] = (float) (Math.random() * (max - min + 1) + min);
                    break;
                }
                case "int":{
                    resArray[i] = Math.round(Math.random() * (max - min + 1) + min);
                    break;
                }
                default:{
                    resArray[i]=0;
                    break;
                }
            }
        }
        return resArray;
    }
    //Задание 5
    static void findMinMaxElement(float[] array){
        float[] arrResult = new float[2];
        for (int i = 0; i < array.length; i++) {
            if(arrResult[0]>array[i]){
                arrResult[0]=array[i];
            }
            if (arrResult[1]<array[i]){
                arrResult[1]=array[i];
            }
        }
        System.out.println("Минимальный элемент массива = " + arrResult[0]+";");
        System.out.println("Максимальный элемент массива = " + arrResult[1]+";");
    }
    //Задание 7 (если step > 0 - смещение вправо, step < 0 - влево)
    static void shiftArray(int[] array, int step){
        String direction = step > 0 ? "вправо":"влево";
        System.out.println("Исходный массив:");
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i]+" ");
        }
        System.out.print("\n");
        for (int i = 1; i <= Math.abs(step); i++) {
            if (step<0) {
                int temp = array[0];
                for (int j = 0; j < array.length - 1; j++) {
                    array[j] = array[j + 1];
                }
                array[array.length - 1] = temp;
            } else {
                int temp = array[array.length-1];
                for (int j = array.length-1; j > 0; j--) {
                    array[j] = array[j-1];
                }
                array[0]=temp;
            }
        }
        System.out.println("Смещеный " + direction + " на " + Math.abs(step) + " позиции массив:");
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i]+" ");
        }
        System.out.println("\n-------------");

    }

}
