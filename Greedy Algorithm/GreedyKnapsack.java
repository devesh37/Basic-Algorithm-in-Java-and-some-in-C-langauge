import java.util.*;

class Item
{	public
	float Profit,Weight,F,i;
	void getItem(int i)
	{
		Scanner S=new Scanner(System.in);
		this.i=i;
		System.out.print("Enter item Profit and Weight "+i+":");
		Profit=S.nextFloat();
		Weight=S.nextFloat();
		F=Profit/Weight;
	}
	void displayItem()
	{
		System.out.println("Item:"+i+" Profit:"+Profit+" Weight"+Weight+" Profit/Weight:"+F);
	}
	
}
class GreedyKnapsack
{
private	
Item I[],bag[];
float TotalWeight,MaxProfit;
int n;	
void getData()
{
	Scanner S=new Scanner(System.in);
	System.out.print("Enter Number of object:");
	n=S.nextInt();
	System.out.print("Enter Size of Bag in terms of Weight:");
	TotalWeight=S.nextFloat();
	I=new Item[n];
	for(int i=0;i<n;i++)
	{
	I[i]=new Item();	
	I[i].getItem(i);		
	}
		
}
	void display()
	{
	for(int i=0;i<n;i++)
		{
		I[i].displayItem();
		System.out.println();
		}

	
	}

	static void swap(Item I1,Item I2)
	{
		float F,profit,weight,i;
		profit=I1.Profit;
		weight=I1.Weight;	
		F=I1.F;
		i=I1.i;
		I1.Profit=I2.Profit;	
		I1.F=I2.F;
		I1.Weight=I2.Weight;
		I1.i=I2.i;
		I2.Profit=profit;	
		I2.F=F;
		I2.Weight=weight;
		I2.i=i;
	}
	
	
	void sortItem()
{
	//swap(I1[i],I1[i+1]);		
	for(int i=0;i<n;i++)
	{
		for(int j=0;j<n-i-1;j++)
		{
			if(I[j].F<I[j+1].F)
			{
				swap(I[j],I[j+1]);
			}
		}
	}
	

}


	void findMaxProfit()
	{
		int i=0;
		float m=TotalWeight;
		sortItem();
	for(i=0;i<n;i++)
	{
	if(m>0&&I[i].Weight<=m)
	{
	MaxProfit=I[i].Profit+MaxProfit;
	m=m-I[i].Weight;
	}
	else
	{
		
		break;
	}
	}
	if(i>n)
	i--;

	if(m>0)
	{
	MaxProfit=MaxProfit+m*I[i].F;
	}
    System.out.println("Max Profit:"+MaxProfit+"Remaining Weight:"+m+"i:"+(++i));
	}


}


class Main
{
	public static void main(String[] a)
	{
double time;
	GreedyKnapsack G1=new GreedyKnapsack();
    G1.getData();
	G1.display();
 time=System.currentTimeMillis();
	G1.findMaxProfit();
	 time=System.currentTimeMillis()-time;
	System.out.println("Taken Time:"+time);
	}
	
	
	
}