package main.ArrayHelperClass;

import java.util.Arrays;

import main.ArrayHelperInterface.ArrayHelperInterface;

public class ArrayHelper implements ArrayHelperInterface {
    @Override
    public int[] leftUnion(int[] leftArray, int[] rightArray) {
        int totalArrayLength = leftArray.length + rightArray.length; 
        int[] totalArray = Arrays.copyOf(leftArray, totalArrayLength);
        int duplicateCount = 0;
        
        for(int i : rightArray) {
            for (int j : leftArray) {
                if (i == j) {
                    totalArray[leftArray.length + duplicateCount] = j;
                    duplicateCount++;
                }
            }
        }
        totalArray = Arrays.copyOf(totalArray, leftArray.length + duplicateCount);
        
        return totalArray;
    }

    //Show explicitly common elements
    @Override
    public int[] innerUnion(int[] leftArray, int[] rightArray) {
        
        int[] totalArray = new int [leftArray.length];
        int duplicateCount = 0;
        
        for(int i : leftArray) {
            for (int j : rightArray) {
                if (i == j) {
                    totalArray[duplicateCount] = i;
                    duplicateCount++;
                }
            }
        }
        totalArray = Arrays.copyOf(totalArray, duplicateCount);
        totalArray = this.getRidOfDuplicates(totalArray);
        
        return totalArray;              
    }

    //Show explicitly unique elements
    @Override
    public int[] outerUnion(int[] leftArray, int[] rightArray) {
        
        int[] UniqueArray = new int[leftArray.length + rightArray.length];
        int[] nonUniqueArray = new int[leftArray.length + rightArray.length];
        System.arraycopy(leftArray, 0, nonUniqueArray, 0, leftArray.length);
        System.arraycopy(rightArray, 0, nonUniqueArray, leftArray.length, rightArray.length);

        int UniqueArrayIndex = 0; 

        for (int i = 0; i < nonUniqueArray.length; i++) {
            int temp = nonUniqueArray[i];
            boolean unique = true;
            
            for (int j = 0; j < nonUniqueArray.length; j++) {
                if (temp == nonUniqueArray[j] && i != j) {
                unique = false;
                break;
                }
            }
            if (unique == true) {
                UniqueArray[UniqueArrayIndex] = temp;
                UniqueArrayIndex++;
            } 
        }
        UniqueArray = Arrays.copyOf(UniqueArray, UniqueArrayIndex);
        
        return UniqueArray; 
    }

    @Override
    public int[] noDuplicatesMerge(int[] leftArray, int[] rightArray) {
        
        int[] noDuplicatesArray = Arrays.copyOfRange(leftArray, 0, leftArray.length + rightArray.length);
        System.arraycopy(rightArray, 0, noDuplicatesArray, leftArray.length, rightArray.length);
        int[] cleanArray = this.getRidOfDuplicates(noDuplicatesArray);
        
        return cleanArray;
    }
    
    public int[] getRidOfDuplicates(int[] nonUniqueArray) {
        int[] uniqueArray = nonUniqueArray;

        for (int i = 0; i < nonUniqueArray.length; i++) {
            int temp = nonUniqueArray[i];
            
            for (int j = 0; j < nonUniqueArray.length; j++) {
                if (temp == nonUniqueArray[j] && i != j) {
                    uniqueArray = new int[nonUniqueArray.length - 1];
                    System.arraycopy(nonUniqueArray, 0, uniqueArray, 0, j);
                    System.arraycopy(nonUniqueArray, j + 1, uniqueArray, j, uniqueArray.length - j);
                    nonUniqueArray = uniqueArray;
                }
            }
        }
        return uniqueArray; 
    }
	

}
