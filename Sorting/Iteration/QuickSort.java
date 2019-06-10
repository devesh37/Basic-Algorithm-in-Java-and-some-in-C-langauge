
import java.util.*;

class QuickSort
{
 int[] a;
int n; 
 double time;
void initialize_random()
{
Scanner S=new Scanner(System.in);
System.out.println("Enter the size of array:");	
n=S.nextInt();
a=new int[n];	
Random r1=new Random();	
	for(int i=0;i<n;i++)
	{
	a[i]=r1.nextInt(1000);
	}
}

	int partition(int low, int high)
    {
        int pivot = a[high]; 
        int i = (low-1); 
        for (int j=low; j<high; j++)
        {
            if (a[j] <= pivot)
            {
                i++;
 
                 int temp = a[i];
                a[i] = a[j];
                a[j] = temp;
            }
        }
 
         int temp = a[i+1];
        a[i+1] = a[high];
        a[high] = temp;
 
        return i+1;
    }	
	void quicksort(int p,int q)
	{
		int mid;
		
		if(p<q)
		{
		mid=partition(p,q);	
		quicksort(p,mid-1);	
		quicksort(mid+1,q);	
		}

		
	}
	void QuickCall()
	{	
		 time=System.currentTimeMillis();
		 quicksort(0,n-1);
		time=(System.currentTimeMillis())-time;	

	}
	
	
	void display()
	{
	
		System.out.println("\nTime Taken:"+time+" ms\nArray:");
		for(int i=0;i<n;i++)
		{
		System.out.print(" "+a[i]);		
		}
		
		
	}
	

	
}

class QuickSortMain
{

public static void main(String []args)
{
QuickSort M1=new QuickSort();
M1.initialize_random();
M1.display();
M1.QuickCall();
M1.display();	
	
}



}