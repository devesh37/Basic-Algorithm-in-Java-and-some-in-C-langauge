
import java.util.*;

class Heap
{
 int[] a;
int n,heap_size; 
 double time;
void initialize_random()
{
Scanner S=new Scanner(System.in);
System.out.print("Enter the size of array:");	
heap_size=n=S.nextInt();
a=new int[n];	
Random r1=new Random();	
	for(int i=0;i<n;i++)
	{
	a[i]=r1.nextInt(1000);
	}
}
	
	void Max_heapify(int i)
	{
		int l,r,large=i;
		l=i*2+1;
		r=i*2+2;
	
		if(l<heap_size&&a[large]<a[l])
		{
		large=l;	
		}
		if(r<heap_size&&a[large]<a[r])
		{
		large=r;
		}	
		if(i!=large)
		{
		int temp=a[large];
		a[large]=a[i];
		a[i]=temp;
		Max_heapify(large);
		}
	}
	void Build_heap()
	{
	int root=heap_size/2;	
		
	for(int i=root;i>=0;i--)
	{
	Max_heapify(i);	
		
	}
			
	}
	
	void Extract_heap()
	{
		
		int max;
	if(heap_size==-1)
	{
	System.out.println("Heap is in underflow");
	}
        else{  
		max=a[0];
          a[0]=a[heap_size-1];
		 a[heap_size-1]=max;
		  heap_size--;
		Max_heapify(0);
		
		}
	
	}
	void heap_sort()
	{
	time=System.currentTimeMillis();		
	Build_heap();
	for(int i=heap_size-1;i>=0;i--)
	{
	Extract_heap();
	}
	time=System.currentTimeMillis()-time;
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

class HeapSortMain
{

public static void main(String []args)
{
Heap H1=new Heap();
	
	H1.initialize_random();
	H1.display();
	H1.heap_sort();
	H1.display();
}



}
