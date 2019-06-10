import java.util.*;

class Item
{	public
	int Profit,Weight,i;
	void getItem(int i)
	{
		Scanner S=new Scanner(System.in);
		this.i=i;
		System.out.print("Enter item Profit and Weight "+i+":");
	Profit=S.nextInt();	
	Weight=S.nextInt();
	
	}
	void displayItem()
	{
		System.out.println("Item:"+i+" Profit:"+Profit+" Weight:"+Weight);
	}
	
}
class DynamicKnapsack
{
private	
Item I[],bag[];
int T[][],count;
int TotalWeight,MaxProfit;
int n;	
void getData()
{
	Scanner S=new Scanner(System.in);
	System.out.print("Enter Number of object:");
	n=S.nextInt();
	System.out.print("Enter Size of Bag in terms of Weight:");
	TotalWeight=S.nextInt();
	I=new Item[n+1];
	T=new int[n+1][TotalWeight+1];
	I[0]=new Item();
	bag=new Item[n+1];
	for(int i=1;i<=n;i++)
	{
	I[i]=new Item();	
	I[i].getItem(i);		
	}

}

	void findMaxProfit()
	{
		int i=0,j=0;
		for(i=1;i<n+1;i++)
		{
			for(j=1;j<TotalWeight+1;j++)
			{
				if(j<I[i].Weight)
				{
					T[i][j]=T[i-1][j];
				continue;
				}
				T[i][j]=Math.max(I[i].Profit+T[i-1][j-I[i].Weight],T[i-1][j]);
				
			}
			
		}

		itemsInBag(i-1,j-1);
    }

		void display()
		{
			int i,j;
			for(i=0;i<TotalWeight+1;i++)
			{
					System.out.print(" "+i);
			}
			System.out.print("\n");
			for(i=0;i<n+1;i++)
			{
					System.out.print(I[i].Weight);
				for(j=0;j<TotalWeight+1;j++)
				{
					System.out.print(" "+T[i][j]);
					
				}
				System.out.print("\n");
			}
				System.out.println("\nItems in Bag:");
			for(i=0;i<count;i++)
			{
			bag[i].displayItem();
			}
		}
		
		
		void itemsInBag(int i,int j)
		{
			if(T[i][j]!=0)
			{
				if(T[i][j]==T[i-1][j])
			{
				itemsInBag(i-1,j);
			}
			else
			{
				bag[count]=I[i];
				count++;
				itemsInBag(i-1,j-(I[i].Weight));
			}
			}
		}
		
}

class Main
{
	public static void main(String[] a)
	{
	double	time; 
	DynamicKnapsack D=new DynamicKnapsack();
	D.getData();
	 time=System.currentTimeMillis();
	D.findMaxProfit();
	time=(System.currentTimeMillis()-time);
	D.display();
	System.out.println("Time:"+time+"ms");
	
	}

}