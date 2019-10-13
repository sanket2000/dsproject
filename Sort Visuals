#include<stdio.h>
#include<stdlib.h>
#include<time.h>

#define KGRN  "\x1B[32m"
#define KWHT  "\x1B[37m"
#define N 45

int a[N];

void display(int k1, int k2, int k3, int t) {
    system("clear");
    for(int i = 0; i<N; i++) {
        printf("%3d ",a[i]);
        for(int j = 0; j<a[i]; j++)
            if(k1 == i || k2==i || k3==i) {
                //textcolor(4);
                printf(" %sS",KGRN);
            } else
                printf(" %s*",KWHT);
        printf("\n");
    }
    //sleep();
    int d = t*1000000;
    for(int i = 0; i < d; i++) {}
}

void swap(int p, int q) {
    int t = a[p];
    a[p] = a[q];
    a[q] = t;
}

void bSort() {
    for(int i = 0; i < N; i++) {
        for(int j = 0; j < N - 1 - i; j++) {
            if(a[j] > a[j+1]) {
                swap(j, j+1);
                display(j, j+1, -1, 6);
            }
        }
    }
}

void insertionSort() {
    int i, j, temp;
    for(i = 1; i < N; i++) {
        temp = a[i];
        j = i - 1;
        while(a[j] > temp && j >= 0) {
            a[j+1] = a[j];
            j--;
            display(j+1, i, -1, 3);
        }
        a[j+1] = temp;
    }
}

void merge(int beg, int mid, int end) {
    int i, j, index = 0;
    int temp[end - beg + 1];
    i = beg;
    j = mid + 1;
    while(i <= mid && j <= end) {
        if(a[i] < a[j]) {
            temp[index] = a[i];
            i++;
            display(i, j, -1, 20);
        }else {
            temp[index] = a[j];
            j++;
            display(i, j, -1, 20);
        }
        index++;
    }
    while(j <= end) {
        temp[index] = a[j];
        j++;
        index++;
        display(j, -1, -1, 20);
    }
    while(i <= mid) {
        temp[index] = a[i];
        i++;
        index++;
        display(i, -1, -1, 20);
    }
    index = 0;
    for(i = beg; i <= end; i++, index++) {
        a[i] = temp[index];
        display(i, -1, -1, 30);
    }
}

void mergeSort(int beg, int end) {
    if(beg < end) {
        int mid = (beg + end) / 2;
        mergeSort(beg, mid);
        mergeSort(mid + 1, end);
        merge(beg, mid, end);
    }
}

int partition(int low, int high) {
    int i, j, x;
    i = low;
    x = a[low];
    j = high;
    while(i <= j) {
        while(a[i] <= x && i <= high) {
            i++;
            system("clear");
            display(i, -1, -1, 10);
        }
        while(a[j] > x) {
            j--;
            system("clear");
            display(j, -1, -1, 10);
        }
        if(i < j) {
            swap(i, j);
            display(i, j, -1, 10);
        }
    }
    a[low] = a[j];
    a[j] = x;
    display(j, -1, -1, 50);
    return j;
}

void quickSort(int low, int high) {
    int j;
    if(low < high) {
        j = partition(low, high);
        quickSort(low, j-1);
        quickSort(j+1, high);
    }
}

int issorted() {
    int i, count=0;
    for(i = 0; i < N-1; i++) {
        if(a[i] < a[i+1])
            count++;
    }
    if(count == (N-1))
        return 1;
    return 0;
}

void randomsort() {
    while(!issorted()) {
        int i;
        i = rand() % N;
        if(i == N-1)
            i--;
        if(a[i] > a[i+1]) {
            swap(i, i+1);
            display(i, i+1, -1, 7);
        }
    }
}

int main() {
    int i, j;
	system("clear");
	printf("cleared\n");
	///display(-1);
	system("clear");
	printf("1.BestCase\n2.WorstCase\n3.TypicalCase(random number array)");
	scanf("%d",&i);
	srand(time(NULL));
	switch(i) {
        case 1:
            for(i = 0; i < N; i++)
                a[i] = i;
            break;

        case 2:
            for(i = 0; i < N; i++)
                a[i] = N - i - 1;
            break;

        case 3:
            for(i = 0; i < N; i++) {
                a[i] = rand() % N;
                for(j = 0; j < i; j++) {
               	    if(a[j] == a[i]) {
                	i--;
                	break;
                    }
                }
            }
	}
    display(-1, -1, -1, 0);
	printf("1.BSort\n2.InsertionSort\n3.MergeSort\n4.QuickSort\n5.Randomsort");
	scanf("%d",&i);
	switch(i) {
        case 1:
            bSort();
            break;

        case 2:
            insertionSort();
            break;

        case 3:
            mergeSort(0, N-1);
            break;

        case 4:
            quickSort(0, N-1);
            break;

        case 5:
            randomsort();
	}
	display(-1, -1, -1, 0);
}
