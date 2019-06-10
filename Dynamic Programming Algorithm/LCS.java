import java.util.*;
class LCS
{
    private	
	     String S1,S2;
		int C[][],m,n;
	public
	void get_string()
	{
	System.out.print("\nEnter S1 string:");
	Scanner S=new Scanner(System.in);
	S1=S.nextLine();
	System.out.print("\nEnter S2 string:");
	S2=S.nextLine();
	m=S1.length()+1;
	n=S2.length()+1;
	C=new int[m][n];
	}
	void longest_common_subsequence()
	{
		for(int i1=1,i2=0;i2<S1.length();i1++,i2++)
		{
			for(int j1=1,j2=0;j2<S2.length();j1++,j2++)
			{
				if(S1.charAt(i2)==S2.charAt(j2))
				{
					C[i1][j1]=1+C[i1-1][j1-1];
				}
				else
				{	
						C[i1][j1]=Math.max(C[i1][j1-1],C[i1-1][j1]);
				}
			}
		}
	}
	void display()
	{
		int i;
		
	for(i=0;i<m;i++)	
	{
		for(int j=0;j<n;j++)
		System.out.print(" "+C[i][j]);
		System.out.print("\n");
		
	}
	
		
		
	}
	


}




class LCSMain
{
	public static void main(String[] a)
	{
		double time;
		LCS L1=new LCS();
		L1.get_string();
		time=System.currentTimeMillis();
		L1.longest_common_subsequence();
		time=System.currentTimeMillis()-time;
		L1.display();
		System.out.println("Time Taken:"+time+" ms");
	}
	
	
	
}