#include<stdio.h>
#include <stdlib.h>
#include <time.h>
 void selection_sort(int n)
 {
    clock_t s;
    double t;
    int *a,i,j,temp;
    a=calloc(n,sizeof(int));
    printf("%d random number:\n",n);

    for(i=0;i<n;i++)
    {
        a[i]=(rand())%10;
    }
    for(i=0;i<n;i++)
    {
        printf(" %d",a[i]);
    }
 /*main logic*/
    s=clock();
    for(i=0;i<n;i++)
    {
        for(j=i+1;j<n;j++)
        {
            if(a[j]<a[i])
            {
            temp=a[j];
            a[j]=a[i];
            a[i]=temp;

            }

        }

    }
    t=((double)((clock())-s))/CLOCKS_PER_SEC;
    printf("\nTime=%f\n",t);
    printf("\nAfter sorting-->");
    for(i=0;i<n;i++)
    {
    printf(" %d",a[i]);
    }
    printf("\n");


 }



int main()
{
int n;
printf("Enter n:");
scanf("%d",&n);
selection_sort(n);
return(0);
}
