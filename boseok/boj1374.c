#include<stdio.h>
void mergeSort(int start[], int end[], int low, int high);
void merge(int start[], int end[], int low, int mid, int high);
int main()
{
    int n,start[100000],end[100000],room[100000];
    int i,j,tm,ptr,cnt=0;

    FILE *fp=fopen("input.txt","r");

    fscanf(fp,"%d\n",&n);
    for(i=0;i<n;i++){
        fscanf(fp,"%d %d %d\n",&room[i],&start[i],&end[i]);
    }
    mergeSort(start,end,0,n-1);
    for(i=0;i<n;i++)
    {
        tm=999999;
        ptr=-1;
        if(start[i]==-1)
            i++;
        for(j=i+1;j<n;j++)
        {
            if(end[i]<start[j]&&tm>start[j]-end[i])
            {
                tm=start[j]-end[i];
                ptr=j;
            }
        }
        if(ptr!=-1)
            start[ptr]=-1;
    }
    for(i=0;i<n;i++)
    {
        if(start[i]>-1)
            cnt++;
    }
    printf("%d",cnt);
}
void mergeSort(int start[], int end[], int low, int high) {                        //병합정렬 할 시에 최소 단위로 나누는 파트
    int mid;
    if(low<high)
    {
        mid = (low+high)/2;
        mergeSort(start, end, low, mid);
        mergeSort(start, end, mid+1, high);
        merge(start, end, low, mid, high);
    }
}
void merge(int start[], int end[], int low, int mid, int high) {                   //최소 단위로 나눈것을 다시 정렬하면서 합치는 부분
    int i = low, j = mid+1, k = low;
    int tmps[high],tmpe[high]; 

    while(i<=mid && j<=high) {
        if(start[i] <= start[j])
        {
            tmpe[k]=end[i];
            tmps[k++] = start[i++];            
        } 
        else 
        {
            tmpe[k]=end[j];
            tmps[k++]=start[j++];
        }
    }
    while(i<=mid)
    {
        tmpe[k]=end[i];
        tmps[k++] = start[i++];
    } 
    while(j<=high) 
    {
        tmpe[k]=end[j];
        tmps[k++]=start[j++];
    }
    for(i=low; i<=high; i++)
    { 
        start[i]=tmps[i];
        end[i]=tmpe[i];
    }
}