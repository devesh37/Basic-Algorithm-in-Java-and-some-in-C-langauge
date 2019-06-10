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
class Stack
{
	private
	int n,top;
	Node E[];
	boolean Empty;
	public
	
	Stack(int n)
	{
		this.n=n;
		top=-1;
		E=new Node[n];
		Empty=true;
	}
	
	void push(Node Temp)
	{
		if(top<n)
		{
		top++;
		E[top]=Temp;
	    Empty=false;
		}
		else
		{
		System.out.println("Stack is Full!");
		}
	}
	
	Node pop()
	{
	if(!(top==-1))
	return(E[top--]);
	else
	{
	System.out.println("Stack is Empty!");		
    Empty=true;
	return(null);
	}
	}
	
	boolean isEmpty()
	{
		return(Empty);
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
	    DFS(v);
		time=System.currentTimeMillis()-time;
	}
	
	void DFS(int start)
	{
		int i,j,u;
		Stack S=new Stack(n);
		Node temp;
		N[start].visited=true;
		u=start;	
		S.push(N[u]);
		while(!S.isEmpty())
	{
	for(i=0;i<n;i++)
	{
		if(adjMatrix[u][i]!=0&&(!N[i].visited))
		{	
		N[i].visited=true;
		S.push(N[i]);	
	 	System.out.println(N[i].nodeName+" is visited!");
		}
	
	
	}
	temp=S.pop();
	}
	
	
	
	
	
	
}
}
class Main
{
	public static void main(String[] a)
	{
	Graph G1=new Graph();
	G1.get();
	System.out.println("Time Taken:"+G1.time+"ms");
	
	}
	
	
	
}