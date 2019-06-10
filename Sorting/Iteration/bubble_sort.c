#include<stdio.h>
#include<stdlib.h>
#include<time.h>
bubble_sort(int n)
{
    int *a,i,j,temp;
    double t;
    clock_t s;
    a=calloc(n,sizeof(int));
    s=clock();
    printf("Before sorting:\n");
    for(i=0;i<n;i++)
    {
        a[i]=rand()%10;
        printf(" %d",a[i]);
    }
    printf("\n");
    s=(clock()-s);
    t=((double)s)/CLOCKS_PER_SEC;
    printf("Time taken=%f \nAfter sorting\n",t);
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

    for(i=0;i<n;i++)
    {
        printf(" %d",a[i]);
    }



}
int main()
{
    int n;
    printf("Enter n:");
    scanf("%d",&n);
    bubble_sort(n);
    return(0);
}
