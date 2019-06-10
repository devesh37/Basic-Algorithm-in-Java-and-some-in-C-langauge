import java.util.*;
import java.lang.*;
class Node
{
	int nodeName; 
	boolean visitedStatus; 
	Node(int i)
	{
		nodeName=i;
		visitedStatus=false;
	}
	
}
class MST 
{
	private
	int[] key,parent;
	int[][] distance;
	Node[] N;
	int n,u,v;
	public
	void get()
	{
		System.out.print("Enter Number of node:");
		Scanner S=new Scanner(System.in);
		String D=new String();
		n=S.nextInt();	
		N=new Node[n];
		distance=new int[n][n];
		key=new int[n];
		parent=new int[n];
		for(v=0;v<n;v++)
		{
			N[v]=new Node(v);
		  key[v]=Integer.MAX_VALUE;	
					parent[v]=-1;
			for(u=0;u<n;u++)
			{
				
					if(u==v)
					{
						distance[u][v]=0;
						continue;
					}
				System.out.print("Enter distance between node "+v+" and "+u+":");
					D=S.next();	
					//D=S.nextLine();	
					if(D.equals("inf"))
					{
						distance[u][v]=Integer.MAX_VALUE;
					}
					else
					{
						distance[u][v]=Integer.parseInt(D);
					}				
			}
		}
		
		System.out.print("Enter Starting node:");
		int j;
		while(true)
		{
	     j=S.nextInt();
          	if(j<n)
				{
				parent[j]=-1;	
				key[j]=0;
					break;
				}
				else
				{
					System.out.print("Enter Valid node:");
					
				}
		}
	
	}
	int findMinDistance()
	{
	 int minDistance=Integer.MAX_VALUE,minIndex=0,i; 
	 for(i=0;i<n;i++)
	 {
		if(key[i]<=minDistance&&(!N[i].visitedStatus))
		{
			minDistance=key[i];
			minIndex=i;
		}
	 }
	 return(minIndex);
	}
	void printMST()
	{	
	for(int i=1;i<n;i++)
	{
		
		
		System.out.print("|node"+parent[i]+"|-"+distance[i][parent[i]]+"-|node"+i+"|-");
		
	}	
	}
	void prim()
	{
		for(int i=0;i<n;i++)
		{
			
		u=findMinDistance();	
		N[u].visitedStatus=true;
		for(v=0;v<n;v++)
		{
			if((distance[u][v]!=0)&&(distance[u][v]<key[v])&&(N[v].visitedStatus==false))
			{
				{
					parent[v]=u;
					key[v]=distance[u][v];
					
				}
				
			}
		}
		}		
	}
}
class Main
{
	public static void main(String[] a)
	{
	double time;
	MST M1=new MST();
	M1.get();
	time=System.currentTimeMillis();
	M1.prim();
	time=(System.currentTimeMillis()-time);
	M1.printMST();
	System.out.println("\nTime:"+time);
	}
	
	
	
}