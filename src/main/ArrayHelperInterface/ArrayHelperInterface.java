package main.ArrayHelperInterface;

public interface ArrayHelperInterface {	
    public int[] leftUnion(int[] leftArray, int[] rightArray);
    
    public int[] innerUnion(int[] leftArray, int[] rightArray);
    
    public int[] outerUnion(int[] leftArray, int[] rightArray);	
    
    public int[] noDuplicatesMerge(int[] leftArray, int[] rightArray);
}
