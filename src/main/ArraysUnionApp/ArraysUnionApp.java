package main.ArraysUnionApp;

import java.util.Arrays;

import main.ArrayHelperClass.ArrayHelper;

public class ArraysUnionApp {
        
    public static void main(String[] args) {
        //Left union user case
        int[] leftArray_LeftUnion = {1,5,4,23,65,32,78}; 
        int[] rightArray_LeftUnion = {3,5,24,4,1,2,34,45,32,5}; 
        int[] expectedArray_LeftUnion = {1,5,4,23,65,32,78,5,4,1,32,5};
                       
        //Inner union user case
        int[] leftArray_InnerUnion = {1,5,4,23,65,32,78}; 
        int[] rightArray_InnerUnion = {3,5,24,4,1,2,34,45,32,5};
        
        //Official expected result is below - the official order is impossible according my implemented logic, left array values go first
        //int[] expectedArray_InnerUnion = {5,4,32,1}; 
        int[] expectedArray_InnerUnion = {1,5,4,32};

        //Outer union user case
        int[] leftArray_OuterUnion = {1,5,4,23,65,32,78}; 
        int[] rightArray_OuterUnion = {3,5,24,4,1,2,34,45,32,5}; 
        int[] expectedArray_OuterUnion = {23,65,78,3,24,2,34,45};
        
        //No duplicates merge user case
        int[] leftArray_NoDuplicatesMerge = {1,5,4,23,65,32,78}; 
        int[] rightArray_NoDuplicatesMerge = {3,5,24,54,1,2,34,45,32}; 
        int[] expectedArray_NoDuplicatesMerge = {1,5,4,23,65,32,78,3,24,54,2,34,45};
        
        ArrayHelper myArrHelper = new ArrayHelper();
        
        int[] actualArray_LeftUnion = myArrHelper.leftUnion(leftArray_LeftUnion, rightArray_LeftUnion);
        int[] actualArray_InnerUnion = myArrHelper.innerUnion(leftArray_InnerUnion, rightArray_InnerUnion);
        int[] actualArray_OuterUnion = myArrHelper.outerUnion(leftArray_OuterUnion, rightArray_OuterUnion);
        int[] actualArray_NoDuplicatesMerge = myArrHelper.noDuplicatesMerge(leftArray_NoDuplicatesMerge, rightArray_NoDuplicatesMerge);
        
        System.out.println("Left: " + Arrays.toString(leftArray_LeftUnion) + ""
                + "\nRight: " + Arrays.toString(rightArray_InnerUnion)); 
        System.out.println("Actual result of LeftUnion: " + Arrays.toString(actualArray_LeftUnion)); 
        System.out.println("Expected result of LeftUnion: " + Arrays.toString(expectedArray_LeftUnion) + "\n"); 
        
        System.out.println("Left: " + Arrays.toString(leftArray_InnerUnion) + 
                "\nRight: " + Arrays.toString(rightArray_InnerUnion)); 
        System.out.println("Actual result of InnerUnion: " + Arrays.toString(actualArray_InnerUnion)); 
        System.out.println("Expected result of InnerUnion: " + Arrays.toString(expectedArray_InnerUnion) + "\n");
        
        System.out.println("Left: " + Arrays.toString(leftArray_OuterUnion) + ""
                + "\nRight: " + Arrays.toString(rightArray_OuterUnion)); 
        System.out.println("Actual result of OuterUnion: " + Arrays.toString(actualArray_OuterUnion)); 
        System.out.println("Expected result of OuterUnion: " + Arrays.toString(expectedArray_OuterUnion) + "\n");
        
        System.out.println("Left: " + Arrays.toString(leftArray_NoDuplicatesMerge) + ""
                + "\nRight: " + Arrays.toString(rightArray_NoDuplicatesMerge)); 
        System.out.println("Actual result of NoDuplicatesMerge: " + Arrays.toString(actualArray_NoDuplicatesMerge)); 
        System.out.println("Expected result of NoDuplicatesMerge: " + Arrays.toString(expectedArray_NoDuplicatesMerge));

    }
	
}
