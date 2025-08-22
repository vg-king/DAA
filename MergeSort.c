#include <stdio.h>
#include <stdlib.h>

void merge(int arr[], int low, int mid, int high) {
    int i = low, j = mid + 1, k = low;
    int b[15000];
    while (i <= mid && j <= high) {
        if (arr[i] < arr[j]) {
            b[k++] = arr[i++];
        } else {
            b[k++] = arr[j++];
        }
    }
    while (i <= mid) {
        b[k++] = arr[i++];
    }
    while (j <= high) {
        b[k++] = arr[j++];
    }
    for (i = low; i <= high; i++) {
        arr[i] = b[i];
    }
}

void mergeSort(int arr[], int low, int high) {
    if (low < high) {
        int mid = low + (high - low) / 2;
        mergeSort(arr, low, mid);
        mergeSort(arr, mid + 1, high);
        merge(arr, low, mid, high);
    }
}

int main() {
  

    return 0;
}
