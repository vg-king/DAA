
#include <stdio.h>
#include <stdlib.h>
#include <time.h>

typedef struct {
    int weight;
    int value;
    double ratio;
    int index; 
} Item;

int cmpDescRatio(const void *a, const void *b){
    const Item *ia = (const Item*)a;
    const Item *ib = (const Item*)b;
    if (ib->ratio > ia->ratio) return 1;  
    if (ib->ratio < ia->ratio) return -1;
    return 0;
}

double fractionalKnapsack(Item *items, int n, int capacity){
    qsort(items, n, sizeof(Item), cmpDescRatio);
    double totalValue = 0.0;
    int remaining = capacity;
    for(int i=0; i<n && remaining>0; i++){
        if(items[i].weight <= remaining){
            remaining -= items[i].weight;
            totalValue += items[i].value;
            printf("Item#%d full w=%d v=%d r=%.2f\n", items[i].index, items[i].weight, items[i].value, items[i].ratio);
        } else {
            double frac = (double)remaining / items[i].weight;
            double addVal = items[i].value * frac;
            totalValue += addVal;
            printf("Item#%d fraction=%.2f w_used=%d of %d addValue=%.2f\n", items[i].index, frac, remaining, items[i].weight, addVal);
            remaining = 0;
        }
    }
    return totalValue;
}

int main(){
    int n, capacity;
    int *weights = NULL, *values = NULL;
    FILE *fp = fopen("knapsack_input.txt", "r");
    if(fp){
        if(fscanf(fp, "%d", &n) != 1){
            fprintf(stderr, "Invalid file format (n).\n");
            fclose(fp);
            return 1;
        }
        weights = (int*)malloc(n * sizeof(int));
        values  = (int*)malloc(n * sizeof(int));
        for(int i=0;i<n;i++) if(fscanf(fp, "%d", &weights[i]) != 1){fprintf(stderr,"Invalid weight\n"); fclose(fp); return 1;}
        for(int i=0;i<n;i++) if(fscanf(fp, "%d", &values[i])  != 1){fprintf(stderr,"Invalid value\n"); fclose(fp); return 1;}
        if(fscanf(fp, "%d", &capacity) != 1){fprintf(stderr, "Invalid capacity\n"); fclose(fp); return 1;}
        fclose(fp);
        printf("Read input from knapsack_input.txt\n");
    } else {
        printf("Enter number of items: ");
        if(scanf("%d", &n) != 1) return 1;
        if(n <= 0){ printf("Nothing to do.\n"); return 0; }
        weights = (int*)malloc(n * sizeof(int));
        values  = (int*)malloc(n * sizeof(int));
        printf("Enter weights:\n");
        for(int i=0;i<n;i++){ scanf("%d", &weights[i]); if(weights[i] <= 0){ printf("Weight must be > 0. Setting to 1.\n"); weights[i] = 1; } }
        printf("Enter values:\n");
        for(int i=0;i<n;i++) scanf("%d", &values[i]);
        printf("Enter capacity: ");
        scanf("%d", &capacity);
    }

    if(capacity <= 0){
        printf("Capacity is zero or negative. Max value = 0.00\n");
        free(weights); free(values);
        return 0;
    }

    Item *items = (Item*)malloc(n * sizeof(Item));
    for(int i=0;i<n;i++){
        items[i].weight = weights[i];
        items[i].value = values[i];
        items[i].index = i;
        items[i].ratio = (double)values[i] / items[i].weight; // weight > 0 guaranteed
    }

    clock_t start = clock();
    double maxVal = fractionalKnapsack(items, n, capacity);
    clock_t end = clock();

    double elapsed_ns = (double)(end - start) * 1e9 / CLOCKS_PER_SEC;
    printf("Max value = %.2f\n", maxVal);
    printf("Time(ns) %.0f\n", elapsed_ns);

    free(items);
    free(weights);
    free(values);
    return 0;
}