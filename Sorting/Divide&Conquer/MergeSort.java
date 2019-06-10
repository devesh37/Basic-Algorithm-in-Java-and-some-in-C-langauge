import java.util.*;
class MergeSort
{
 int[] a;
int n; 
 double time;
MergeSort(int arg[])
{
	a=arg;
	n=a.length;
}
 void initialize_random()
{
	Scanner S=new Scanner(System.in);
	System.out.print("Enter the size of array:");	
	n=S.nextInt();
	a=new int[n];	
	Random r1=new Random();	
	for(int i=0;i<n;i++)
	{
	a[i]=r1.nextInt(10000);
	}
}
	
	void merge(int p,int q,int r)
	{
	 int n1,n2,i,j,k;
	 n1=q-p+1;
	 n2=r-q;
	
		int L[]=new int[n1],R[]=new int[n2];
		for(i=0;i<n1;i++)
		{
			L[i]=a[p+i];
		}
		
		for(i=0;i<n2;i++)
		{
			R[i]=a[q+i+1];
		}
		i=0;
		j=0;
	k=p;
	while(i<n1&&j<n2)
	{
		if(L[i]>R[j])
		{
			a[k]=R[j];
			j++;
		}
		else
		{
			a[k]=L[i];
			i++;
		}
	k++;	
	}
	while(i<n1)
	{
	a[k]=L[i];	
		k++;
		i++; 
	}
	while(j<n2)
	{
	a[k]=R[j];	
		k++;
		j++;
	}
	
	
	}
	
	
	void mergesort(int p,int q)
	{	
		if(p<q)
		{
		int m;
		m=((p+q)/2);
		mergesort(p,m);
		mergesort(m+1,q);
		merge(p,m,q);
		}
		
	}
	void MergeCall()
	{
		 time=System.currentTimeMillis();
			mergesort(0,n-1);
	time=(System.currentTimeMillis()-time);
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

class MergeSortMain
{

public static void main(String []args)
{
MergeSort M1=new MergeSort();
M1.initialize_random();
M1.display();
M1.MergeCall();
M1.display();	
	
}



}
