#include<stdio.h>
#include<time.h>
#include<stdlib.h>

int BinarySearch(int *a,int key,int l,int r)
{
int m;
m=(l+r)/2;
if(m==0)
{
return(0);
}
if(a[m]==key)
{
printf("Element found at %d",m);
return(1);
}
else if(a[m]<key)
{
BinarySearch(a,key,m+1,r);
}
else
{
BinarySearch(a,key,l,m-1);
}
}

void BubbleSort(int *a,int n)
{
int i,temp,j;

for(i=0;i<n;i++)
{
for(j=0;j<(n-i-1);j++)
{
if(a[j]>a[j+1])
{
temp=a[j+1];
a[j+1]=a[j];
a[j]=temp;
}
}
}
}

int main()
{
int *a,i,key,n;
double t;
printf("Enter no. of n:");
scanf("%d",&n);
a=calloc(n,sizeof(int));

printf("Random %d element:\n",n);
for(i=0;i<n;i++)
{
a[i]=rand();
printf(" %d",a[i]);
}

BubbleSort(a,n);

for(i=0;i<n;i++)
{
printf(" %d",a[i]);
}
printf("\nEnter Key:");
scanf("%d",&key);
clock_t s=clock();
if(!BinarySearch(a,key,0,n-1))
{
printf("Element not found");
}
t=((double)(clock()-s))/CLOCKS_PER_SEC;
printf("Total time:%f",t);
return(0);
}
