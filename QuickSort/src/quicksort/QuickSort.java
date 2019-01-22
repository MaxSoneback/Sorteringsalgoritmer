/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package quicksort;

import java.util.Arrays;
import java.util.Random;

/**
 *
 * @author Max
 */
public class QuickSort {

    static Random rand = new Random();
    
    public static void main(String[] args) {
        int[] ollesArray = buildArray();
        quickSort(ollesArray, 0, ollesArray.length-1);
        //System.out.println(Arrays.toString(ollesArray));
        
    }
    
    static int randomizedPartition(int[] arr, int start, int finish){
        
        
        int random_index = rand.nextInt(finish - start) + start;
        int temp = arr[random_index];
        arr[random_index] = arr[finish];
        arr[finish] = temp;
        
        return partition(arr, start, finish);
    } 
    
    static int partition(int[] arr, int start,int finish ){
        int pivot = arr[finish];
        int i = start -1;
        int temp;
        
        for(int j=start; j<finish; j++){
            if(arr[j]<= pivot){
                i++;
                temp=arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
        temp = arr[i+1];
        arr[i+1] = pivot;
        arr[finish] = temp;
        
        return i +1;
        
    }
    
    static void quickSort(int[] arr, int start, int finish){
        if (start<finish){
            int sorted = randomizedPartition(arr,start,finish);
            //int sorted = partition(arr,start,finish);
            quickSort(arr,start,sorted-1);
            quickSort(arr,sorted+1,finish);
        }
        
    }
    public static int[] buildArray()
    {
        int randNum = rand.nextInt(1000000)+1;
        int[] newArray = new int[randNum];
        
        for (int i=0; i<newArray.length;i++)
        {
            int randElement = rand.nextInt(1000000);
            newArray[i] = randElement;
        }
        
        return newArray;
        
    }
    
}
