package ru.neooffline.j1l2;

public class Main {

    public static void main(String[] args) {
        float[] arrFloat = generateRandomArray(10,-100,100,"float");
        float[] arrInt = generateRandomArray(10,-1000,10,"int");
//        float[] arrNull = generateRandomArray(6,-10,10,"");
//        printArray(arrNull);
//        float[] arrayTestMax = {-100,4242,4242,-1,2,3,5,10,-20,18};
    /*Если необходимо посмотреть что за массив изучается
    раскоментировать строку снизу*/
//        printArray(arrFloat);
        findMinMaxElement(arrFloat);
        /*Если необходимо посмотреть что за массив изучается
        раскоментировать строку снизу*/
//        printArray(arrInt);
        findMinMaxElement(arrInt);
        int[] arrayTestShift = {1,2,3,4,5,6};
        shiftArray(arrayTestShift,2);
        arrayTestShift = new int[]{1, 2, 3, 4, 5, 6};
        shiftArray(arrayTestShift,-3);
        int[] arrayBalance = {10,-1,2,3,4};
        arrayBalance = new int[]{2,2,2,1,2,2,10,1};
//        arrayBalance = new int[]{20,15,1,1,2,33};
        System.out.println(isBalancedArray(arrayBalance)?"Массив балансирован":"Массив не банасирован");

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
        System.out.println("----------------------------------");
    }
    //Задание 6
    static boolean isBalancedArray(int[] array){
        int sumLeft, sumRight = 0;
        int i =0;
        do{
            sumLeft = sumArrayElements(array,0,i);
            sumRight = sumArrayElements(array,i+1,array.length-1);
            i++;
            if (sumLeft==sumRight) break;
        } while(i<array.length-2);
//        String bal = sumLeft==sumRight?"баланисирован":"не баланисрован";
//        System.out.println("Сумма слева = " + sumLeft + "\nСумма справа = "+ sumRight + "\nИскомое i = " + i);
//        System.out.println(bal);
        return sumLeft==sumRight;
    }
    static int sumArrayElements(int[] array,int fistElement, int lastElement){
        int sum=0;
        for (int i = fistElement; i <= lastElement; i++) {
            sum+=array[i];
        }
        return sum;
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
