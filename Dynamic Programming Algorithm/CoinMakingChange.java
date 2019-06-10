import java.util.*;
import java.lang.*;
class MakingChange
{
	int coin[],n,T[],C[],amount,finalCoin[];
	Scanner S;
	MakingChange()
	{
		S=new Scanner(System.in);
		System.out.print("Enter Number of Coin:");
		n=S.nextInt();
		coin=new int[n];
		for(int i=0;i<n;i++)
		{
			System.out.print("Enter Coin["+i+"]:");	
			while((coin[i]=S.nextInt())<=0)
				System.out.println("Enter Valid Coin!");
		}
		System.out.print("Enter amount:");
		amount=(S.nextInt());
		C=new int[++amount];
		T=new int[amount];
		for(int i=1;i<amount;i++)
		{
			T[i]=Integer.MAX_VALUE;
		}
	}
	
	void makingChangeFunction()
	{
		for(int j=0;j<n;j++)
		{
	
			for(int i=coin[j];i<amount;i++)	
			{
				int temp=T[i];
				T[i]=Math.min(T[i],1+T[i-coin[j]]);	
				if(temp!=T[i])
				C[i]=j;
			
			}
		}
		finalCoin=new int[T[amount-1]];
		int tempAmount=0;
		for(int i=0;i<T[amount-1];i++)
		{
		finalCoin[i]=coin[C[amount-1-tempAmount]];
		tempAmount=finalCoin[i];
		}
	}
	void display()
	{
			System.out.print("\n\n Minimum Coin Array:\n");
	for(int i=0;i<amount;i++)
	{
		if(T[i]>=Integer.MAX_VALUE)
		System.out.print(" T["+i+"]:NA");
	    else
		System.out.print(" T["+i+"]:"+T[i]);
	}
	System.out.print("\n\nCoin Position array:\n");
	for(int i=0;i<amount;i++)
	{
		System.out.print(" C["+i+"]:"+C[i]);
	}
	System.out.print("\n\n Required coin:\n");
	for(int i=0;i<finalCoin.length;i++)
	{
			System.out.print(" FinalCoin["+i+"]:"+finalCoin[i]);
	}
	}
	
}
class Main
{
	public static void main(String[] a)
	{
		double time;
	MakingChange M1=new MakingChange();
	 time=System.currentTimeMillis();
	M1.makingChangeFunction();
	time=(System.currentTimeMillis())-time;
	M1.display();
	System.out.println("Time Taken:"+time);
	}
	
	
	
}