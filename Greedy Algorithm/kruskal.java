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
class Edge
{
	final int inf=Integer.MAX_VALUE;
	int source,destination,weight;
	Edge(int i,int j,int k)
	{
		source=i;
		destination=j;
		weight=k;
	}
	void display()
	{
		System.out.println("Source:"+source+" Destination:"+destination+" Weight:"+weight);
	}	
		static void swap(Edge E1,Edge E2)
	{
	int i,j,k;	
		i=E1.source;
		j=E1.destination;
		k=E1.weight;
		E1.source=E2.source;
		E1.destination=E2.destination;
		E1.weight=E2.weight;
		E2.source=i;
		E2.destination=j;
		E2.weight=k;
	}

	
}

class MST 
{
	private
	int[][] distance;
		final int inf=Integer.MAX_VALUE;
	Node[] N;
	Edge[] E,set;
	int n,u,v,edges,count,edgeSet[],setcount;
	public
	void get()
	{	int i,j;
		System.out.print("Enter Number of Node:");
		Scanner S=new Scanner(System.in);
		n=S.nextInt();
		N=new Node[n];
		distance=new int[n][n];
		for(i=0;i<n;i++)
		{
			N[i]=new Node(i);
			for(j=i;j<n;j++)
			{
				if(i==j)
				{
					distance[i][j]=0;
				}
				else
				{
					System.out.print("Enter distance B/W node "+i+" and "+j+":");
					distance[i][j]=distance[j][i]=S.nextInt();
					if(distance[i][j]<inf)
					{
					edges++;
					}
				}
			}
		}
		
		E=new Edge[edges];
		edgeSet=new int[2*edges];
		set=new Edge[edges];
		int k=0;

		for(i=0;i<2*edges;i++)
		{
			edgeSet[i]=-1;
		}
		for(i=0;i<edges;i++)
		{
		  for(j=i+1;j<edges;j++)
			{
				if(distance[i][j]<inf)
				{
				E[k]=new Edge(i,j,distance[i][j]);
				k++;
				}
				
			}
			
		}	
		
	kruskal();
	}
	
	void sortEdge()
	{
		int i,j,k;
		for(i=0;i<n;i++)
		{ 
			k=0;
			for(j=0;j<n-i-1;j++)
			{
				if(E[j+1].weight<E[j].weight)
				{
							Edge.swap(E[j+1],E[j]);
				k=1;
				}
		    }
			if(k==0)
				break;
			
		}
		
	}
	
	void insertIntoMST(Edge temp)
	{
		int i,j;
	boolean source=false,destination=false;
	if(count==0)
		{
				set[count]=temp;
				insertIntoSet(set[count].source);
				insertIntoSet(set[count].destination);
		      
	    count++;
		}
		else {
		
			for(i=0;i<=setcount;i++)
			{
				if(temp.source==edgeSet[i])
				{
					source=true;
					break;
				}
			}
				for(i=0;i<=setcount;i++)
			{
				if(temp.destination==edgeSet[i])
				{
					destination=true;
					break;
				}
			}
			
			if(!(source&&destination))
			{
				set[count]=temp;
							if(!source)
			{
					insertIntoSet(temp.source);
			}
			if(!destination)
			{
						insertIntoSet(temp.destination);
		
			}
			count++;
			}
		
		
		}
	}
	
	
	void printMST()
	{
		for(int i=0;i<count;i++)
		{
			System.out.println("|"+set[i].source+"|"+"-"+set[i].weight+"->|"+set[i].destination+"|");	
		}
	}
	
	void insertIntoSet(int temp)
	{
	edgeSet[setcount]=temp;
				++setcount;	
	}

	void kruskal()
	{
	
		sortEdge();
		for(int i=0;i<edges;i++)
		{
		insertIntoMST(E[i]);	
		}
		System.out.print("Set of node={null");
		for(int i=0;edgeSet[i]!=-1&&i<2*edges;i++)
		{
			System.out.print(","+edgeSet[i]);
		}
		System.out.println("}");
		
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
	M1.printMST();
	time=System.currentTimeMillis()-time;
	System.out.println("\nTime:"+time+" ms");
	}

}