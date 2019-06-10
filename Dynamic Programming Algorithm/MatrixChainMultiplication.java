import java.util.*;
class MatrixChainMultiplication
{
int P[],length,n,M[][],S[][];
	void get_length()
	{
	Scanner S=new Scanner(System.in);
	System.out.print("Enter the value of length of p set:");
	length=S.nextInt();
	n=length;
	P=new int[length];
	for(int i=0;i<length;i++)
	{
			System.out.print("Enter Element["+i+"]:");
			P[i]=S.nextInt();	
	}
	}
		
	void print_order(int i,int j)
	{
		if(i==j)
		{
			System.out.print("A"+i);
		}
		else
		{
			System.out.print("(");
			print_order(i,S[i][j]);
			System.out.print("*");
			print_order(S[i][j]+1,j);
			System.out.print(")");
		}
		
		
	}

	void Matrix_chain()
	{ 
	int min,temp;
		M=new int[length][length];
			S=new int[length][length];
		for(int l=2;l<n;l++)
		{
			for(int i=1;i<n-l+1;i++)
			{
				int j=i+l-1;
				M[i][j]=222222222;
				for(int k=i;k<j;k++)
				{
				min=M[i][k]+M[k+1][j]+(P[i-1]*P[k]*P[j]);	
				if(min<M[i][j])
				{
				M[i][j]=min;
				S[i][j]=k;
				}
			    }
			
				
		}
	
		}
	display();
	}
	
	void display()
	{
	System.out.println("Minimum Multiplication cost matrix:");	
	for(int i=1;i<n;i++)
	{
		for(int j=1;j<n;j++)
		{
			System.out.print(" "+M[i][j]);
		}
		System.out.println("");
	}
	System.out.println("Minimum Scalar Multiplication cost matrix:");	
	for(int i=1;i<n;i++)
	{
		for(int j=1;j<n;j++)
		{
			System.out.print(" "+S[i][j]);
		}
		System.out.println("");
	}	
	System.out.println("Multiplication order:");	
	print_order(1,length-1);	
	}	
	
}
class MatrixChainMultiplicationMain
{
	public static void main(String[] a)
	{
		double time;
		MatrixChainMultiplication M1=new MatrixChainMultiplication();
		M1.get_length();
		time=System.currentTimeMillis();
		M1.Matrix_chain();		
		time=System.currentTimeMillis()-time;
		System.out.print("\nTotal Time taken:"+time+"ms");
	}
	
	
}