#include<stdio.h>
#include<time.h>
#include<stdlib.h>
int main()
{
int *a,i,key,n;
double t;
clock_t s;
printf("Enter no. of n:");
scanf("%d",&n);
a=calloc(n,sizeof(int));
for(i=0;i<n;i++)
{
a[i]=rand();
printf(" %d",a[i]);
}
printf("\nEnter key:");
scanf("%d",&key);
s=clock();
for(i=0;i<=n;i++)
{
if(i==n)
{
printf("Element not found!!");
break;
}
if(key==a[i])
{
printf("\nElement found at %d!",i);
break;
}


}

t=((double)(clock()-s))/CLOCKS_PER_SEC;
printf("Total time:%f",t);
return(0);
}


