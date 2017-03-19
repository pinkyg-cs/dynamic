package com.test.dynamic;

public class LIS {
	//static int[] A = {3,2,6,4,5,1};
	static int[]A = {0, 8, 4, 12, 2, 10, 6, 14, 1, 9, 5, 13, 3, 11, 7, 15};
	static int prev = A[0];

	public static void main(String[] args) {
		/*int longest = 1; // stores longest increasing subsequence
		int curr;
		int val=0;
		System.out.println("Length: "+ A.length);
		for(int i=0;i<A.length;i++)
		{
			curr = lis(i);
			System.out.println("LIS "+i+"= "+ curr);
			if(curr>longest)
			{
				longest = curr;
				val = i;
			}
				
		}
		System.out.println("********************");
		System.out.println("LIS: "+ longest);
		System.out.println("Val: "+ val);*/
		int[] arr = {2,4,5};
		int[] op = findPosition(arr, 1);
		for(int i=0;i<op.length;i++)
		System.out.print(op[i]+", ");
	}
	
	static int lis(int i)
	{
		if(i==0)
			return 1;
		int j=i-1;
		if(A[i]>prev)
		{
			prev = A[i];
			return lis(j)+1;
		}			
		else
		{
			prev = A[j];
			return lis(j);
		}
			
	}
	
	static int[] findPosition(int[] arr,int num)
	{
		int low = 0;
		int high = arr.length-1;
		int position=0;
		
		while(low<high)
		{
			int mid = low + ((high - low) / 2);
			if(num<arr[mid])
			{
				high = mid-1;
			}
			else if(num>arr[mid])
			{
				low = mid+1;
			}
			else
			{
				position = mid;
				break;
			}
		}
		System.out.println("low: "+ arr[low]);
		System.out.println("high: "+ arr[high]);
		int[] op = new int[low+2];
		for(int i=0;i<=low;i++)
		{
			op[i] = arr[i];
		}
		op[low+1] = num;
		return op;
	}
	
	static int findPosition2(int[] arr,int low, int high, int num)
	{		
		int position=0;
		
		while(low<high)
		{
			int mid = low + ((high - low) / 2);
			if(num<arr[mid])
			{
				high = mid-1;
			}
			else if(num>arr[mid])
			{
				low = mid+1;
			}
			else
			{
				position = mid;
				break;
			}
		}
		return low+1;
	}

}
