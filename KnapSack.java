package com.test.dynamic;
import java.util.*;

public class KnapSack {

	public static void main(String[] args) {
		/*int[] wt = {1,3,4,5};
		int[] val = {1,4,5,7};*/
		int[] wt = {4,5,1};
		int[] val = {3,1,2};
		/*int[] wt = {10,20,30};
		int[] val = {60, 100, 120};*/
		Arrays.sort(wt);
		int W = 4;
		//W = 50;
		System.out.println(getMaxVal(val, wt, W));
	}
	
	private static int getMaxVal(int[] val,int[] wt,int W)
	{
	    int n = val.length;
	    int[][] arr = new int[n][W+1];
	    
	    /*for(int i=0;i<n;i++)
	    {
	        arr[i][0] = 0;
	    }*/
	    
	    for(int j=1;j<=W;j++)
	    {
	        arr[0][j] = val[0];
	    }
	    
	    for(int i=1;i<n;i++)
	    {
	        for(int j=1;j<=W;j++)
	        {
	            if(j<wt[i])
	            {
	                arr[i][j] = arr[i-1][j];
	            }
	            else
	            {
	                int diff = j-wt[i];
	                int val1 = arr[i-1][j];
	                int difVal = arr[i][diff];
	                int val2 = difVal+val[i];
	                arr[i][j] =  Math.max(arr[i-1][j],
	                           arr[i][diff]+val[i]);
	            }
	        }
	    }
	    return arr[n-1][W];
	}

}
