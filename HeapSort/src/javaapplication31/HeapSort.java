package javaapplication31;

import static java.lang.Math.floor;
import java.util.Arrays;
import java.util.Random;

/**
 *
 * @author Max
 */
public class HeapSort {

    /**
     * @param args the command line arguments
     */
    static int heapsize;
    
    public static void main(String[] args) {
        int[] someArray;
        someArray = buildArray();
        heapsize = someArray.length;
        heapSort(someArray);
    }
    
        public static int[] buildArray()
    {
        Random rand = new Random();
        int randNum = rand.nextInt(10000)+1;
        int[] newArray = new int[randNum];
        
        for (int i=0; i<newArray.length;i++)
        {
            int randElement = rand.nextInt(101000);
            newArray[i] = randElement;
        }
        
        return newArray;
        
    }
        public static void maxHeapify(int[] myArray, int arrayIndex){
            int left_index;
            int right_index;
            int largest = arrayIndex;
            left_index = arrayIndex*2 + 1;
            right_index = arrayIndex*2 + 2;
            if (left_index < heapsize && myArray[left_index] > myArray[largest]){
                largest = left_index;
            }
            if (right_index < heapsize && myArray[right_index] > myArray[largest]){
                largest = right_index;
            }
            if (largest != arrayIndex){
                int temp = myArray[arrayIndex];
                myArray[arrayIndex]=myArray[largest];
                myArray[largest]=temp;
                //System.out.println("Efter heapify: ");
                //System.out.println(Arrays.toString(myArray));
                maxHeapify(myArray, largest);
            }
            
            
        }
        
        public static void buildMaxHeap(int[] myArray){
            //System.out.println((int)floor(myArray.length/2));
            for(int i=(int) floor(myArray.length/2); i >= 0;i--){
                maxHeapify(myArray, i);
            }
                
            
        }
        
        public static void heapSort(int[] myArray){
            buildMaxHeap(myArray);
            for(int i = myArray.length-1; i>0; i--){
                int temp = myArray[0];
                myArray[0] = myArray[i];
                myArray[i] = temp;
                heapsize -= 1;
                 //System.out.println(heapsize);
                maxHeapify(myArray, 0);
            }
        }
    
}
