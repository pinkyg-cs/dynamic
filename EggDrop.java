package com.test.dynamic;

import java.util.Arrays;

public class EggDrop {
	static int[][] vals;
	//static int minV = Integer.MAX_VALUE;
	
	public static void main(String[] args) {
		int n = 2;
		int k = 10;
		vals = new int[n+1][k+1];
		
		System.out.println(getCount(n,k));
		
		for(int i=2;i<=n;i++)
		{
			for(int j=1;j<=k;j++)
			{
				//System.out.print(vals[i][j]+" ");
				System.out.println(i+" eggs, "+ j+" floors: "+ vals[i][j]);
			}
			//System.out.println();
		}
		
		//Arrays.sort(maxvals);
		//System.out.println(maxvals[0]);

	}
	
	private static int getCount(int n, int k)
	{		
		if(k==0 || k==1)
		{
			vals[n][k] = k;
			return k;
		}
			
		if(n==1)
		{
			vals[n][k] = k;
			return k;
		}
			
		
		int minV = Integer.MAX_VALUE;
		
		for(int x=1;x<=k;x++)
		{
			int a = vals[n-1][x-1]==0? getCount(n-1,x-1):vals[n-1][x-1];
			int b = vals[n][k-x]==0? getCount(n,k-x):vals[n][k-x];
			int max = Integer.max(a, b);			
			if(max<minV)
			{
				minV = max;
			}			
		}
		vals[n][k] = minV+1;
		return minV+1;
	}

}
