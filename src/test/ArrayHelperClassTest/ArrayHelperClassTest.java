package test.ArrayHelperClassTest;

import main.ArrayHelperClass.ArrayHelper;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class ArrayHelperClassTest {
    private ArrayHelper arrayHelper;
    
    //Left Union user case
    private static int[] leftArray_LeftUnion = {1,5,4,23,65,32,78}; 
    private static int[] rightArray_LeftUnion = {3,5,24,4,1,2,34,45,32,5}; 
    private static int[] expectedArray_LeftUnion = {1,5,4,23,65,32,78,5,4,1,32,5};
                   
    //Inner union user case
    private static int[] leftArray_InnerUnion = {1,5,4,23,65,32,78}; 
    private static int[] rightArray_InnerUnion = {3,5,24,4,1,2,34,45,32,5};
    
    //Expected result on slides is impossible int[] expectedArray_InnerUnion = {5,4,32,1}
    //According my implemented logic, left array values go first
    private static int[] expectedArray_InnerUnion = {1,5,4,32};
 
    
    //Outer union user case
    private static int[] leftArray_OuterUnion = {1,5,4,23,65,32,78}; 
    private static int[] rightArray_OuterUnion = {3,5,24,4,1,2,34,45,32,5}; 
    private static int[] expectedArray_OuterUnion = {23,65,78,3,24,2,34,45};
    
    //No duplicates merge user case
    private static int[] leftArray_NoDuplicatesMerge = {1,5,4,23,65,32,78}; 
    private static int[] rightArray_NoDuplicatesMerge = {3,5,24,54,1,2,34,45,32}; 
    private static int[] expectedArray_NoDuplicatesMerge = {1,5,4,23,65,32,78,3,24,54,2,34,45};
    
    //Common user case inputs
   
    private static int[] emptyArray = {}; 

//    Integer.MAX_VALUE unaccepted value?Initialization breaks all tests
//    private static int[] maxSizeArray = new int[Integer.MAX_VALUE];

    private static int[] duplicatesArray = {0,0,5,5,0,0,1,1,1,1,2}; 
    private static int[] expectedNoDuplicatesArray = {0,5,1,2}; 
    private static int[] expectedArray_LeftUnion_rightArrayWithDup = {1,5,4,23,65,32,78,5,5,1,1,1,1};
    
    @Before 
    public void initializeTestClass() {
       arrayHelper = new ArrayHelper();
    }

    @Test
    public void testLeftUnion() {
        int[] actualResultLeftUnion = this.arrayHelper.leftUnion(leftArray_LeftUnion, rightArray_LeftUnion);
        Assert.assertArrayEquals(expectedArray_LeftUnion, actualResultLeftUnion);
    }
    
    @Test
    public void testLeftUnion_EmptyFirstArray() {
        int[] actualResult_EmptyFirstArray = this.arrayHelper.leftUnion(emptyArray, rightArray_LeftUnion);
        Assert.assertTrue(actualResult_EmptyFirstArray.length == 0);
    }
    
    @Test
    public void testLeftUnion_EmptySecondArray() {
        int[] actualResult_EmptySecondArray = this.arrayHelper.leftUnion(leftArray_LeftUnion, emptyArray);
        Assert.assertArrayEquals(actualResult_EmptySecondArray, leftArray_LeftUnion);
    }
    
    @Test (expected = NullPointerException.class )
    public void testLeftUnion_LeftArrayIsNull() {
        this.arrayHelper.leftUnion(null, rightArray_LeftUnion);
        Assert.class.getClass();
    }
    
    @Test (expected = NullPointerException.class )
    public void testLeftUnion_RightArrayIsNull() {
        this.arrayHelper.leftUnion(leftArray_LeftUnion, null);
        Assert.class.getClass();
    }
    
//    Unclear how to test using array as new int[Integer.MAX_VALUE]    
//    @Test 
//    public void testLeftUnion_maxValueOfLeftArray() {
//        this.arrayHelper.leftUnion(maxSizeArray, rightArray_LeftUnion);
//        Assert.fail();
//    }
    
    @Test
    public void testLeftUnion_ArrayWithDuplicates() { 
        int[] actualResultLeftUnion_ArrayWithDuplicates = this.arrayHelper.leftUnion(leftArray_LeftUnion, duplicatesArray);
        Assert.assertArrayEquals(expectedArray_LeftUnion_rightArrayWithDup, actualResultLeftUnion_ArrayWithDuplicates);
    }
    
    @Test
    public void testInnerUnion() {
        int[] actualResultInnerUnion = this.arrayHelper.innerUnion(leftArray_InnerUnion, rightArray_InnerUnion);
        Assert.assertArrayEquals(expectedArray_InnerUnion, actualResultInnerUnion);
    }
    
    @Test
    public void testOuterUnion() {
        int[] actualResultOuterUnion = this.arrayHelper.outerUnion(leftArray_OuterUnion, rightArray_OuterUnion);
        Assert.assertArrayEquals(expectedArray_OuterUnion, actualResultOuterUnion);
    }

    @Test
    public void testNoDuplicatesMerge() {
        int[] actualResultNoDuplicatesMerge = this.arrayHelper.noDuplicatesMerge(leftArray_NoDuplicatesMerge, rightArray_NoDuplicatesMerge);
        Assert.assertArrayEquals(expectedArray_NoDuplicatesMerge, actualResultNoDuplicatesMerge);
    }
    
    //Need to be fixed
    @Test
    public void testGetRidOfDuplicates() {
        int[] actualResult = this.arrayHelper.getRidOfDuplicates(duplicatesArray);
        Assert.assertArrayEquals(expectedNoDuplicatesArray, actualResult);
    }
}
