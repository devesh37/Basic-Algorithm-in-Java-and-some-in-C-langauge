import java.util.*;
class Node
{
	int nodeName;
	static int count;
	boolean visited;
	Node()
	{
	nodeName=count;
	count++;
	visited=false;
	}
}

class Queue
{   private
	Node E[];
	int n,front,back;
	boolean empty;
	public
	void display()
	{
		for(int i=front;i<=back&&(!isEmpty());i++)
		{
			if(E[i]!=null)
			System.out.print(E[i].nodeName+"|");
		}
		
	}
	Node frontOfQueue()
	{
		if(!isEmpty())
		{
			return(E[front]);
		}
		else
		{
			return(null);
		}
    }
	Queue(int n)
	{
		this.n=n;
		E=new Node[n];
		front=0;
		back=-1;
		empty=true;
	}
	boolean isEmpty()
	{
		return(empty);
	}
	
	void insert(Node P)
	{
	if(back!=n)
	{
	back++;
	E[back]=P;	
	empty=false;
	}
	else
	{
	System.out.println("Queue is full");	
	}
	}
	Node delete()
	{ 
	   if(!isEmpty())
	   {
		if(front==back)
		{
			empty=true;
		}
		Node temp=E[front];
		front++;
		return(temp);
	   }
	   else
	{
		System.out.println("Queue is Empty");
		return(null);
	}
	}
	
}
class Graph
{	
	private
	Node N[];
	int adjMatrix[][],n,v;
	public
	double time;
	void get()
	{   int i,j;
		Scanner S=new Scanner(System.in);
		System.out.print("Enter Number of nodes:");
		n=S.nextInt();
		N=new Node[n];
		adjMatrix=new int[n][n];
		for(i=0;i<n;i++)
		{
			N[i]=new Node();
			for(j=0;j<n;j++)
			{
				if(i!=j)
				{
					System.out.print("Enter adjecent Status B/W node"+i+" and node"+j+":");
					adjMatrix[i][j]=S.nextInt();
				}

			}
		}
		v=n+1;
		while(v>=n)
		{
		System.out.print("Enter Valid Starting node:");
		v=S.nextInt();		
		}
		time=System.currentTimeMillis();
	    BFS(v);
		time=System.currentTimeMillis()-time;
	}
	
	void BFS(int start)
	{
		int i,j,u;
		Queue Q=new Queue(n);
		Node temp;
		N[start].visited=true;
		u=start;	
		Q.insert(N[u]);
		while(!Q.isEmpty())
	{
	for(i=0;i<n;i++)
	{
		if(adjMatrix[u][i]!=0&&(!N[i].visited))
		{	
				Q.insert(N[i]);
				N[i].visited=true;
		}	
	}
	temp=Q.delete();
	u=temp.nodeName;
	System.out.println("Node-"+temp.nodeName+"is Visited!");
	}
}
}
class Main
{
	public static void main(String[] a)
	{
	Graph G1=new Graph();
	G1.get();
	System.out.println("Time Taken:"+G1.time);
	
	}
	
	
	
}