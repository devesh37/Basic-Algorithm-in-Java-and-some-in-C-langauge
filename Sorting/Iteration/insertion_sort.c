#include<stdio.h>
#include<stdlib.h>
#include<time.h>
insertion_sort(int n)
{

int *a,i,temp,j,key;
clock_t s;
double t;
printf("For %d inputs",n);
a=calloc(n,sizeof(int));
printf("\n--insertion sort--\nbefore sorting:\n");
for(i=0;i<n;i++)
{
	a[i]=(rand()%10);
	printf(" %d",a[i]);
}

s=clock();

for(i=1;i<n;i++)
{

key=a[i];
j=i-1;
while(key<a[j]&&j>-1)
{
a[j+1]=a[j];
j--;
}
a[j+1]=key;
}
t=((double)(clock()-s))/CLOCKS_PER_SEC;

printf("\nAfter sorting:\n");
for(i=0;i<n;i++)
{
	printf(" %d",a[i]);
}

printf("\nTime taken=%f",t);


}




int main()
{
int n;
printf("Enter n:");
scanf("%d",&n);
insertion_sort(n);

}
