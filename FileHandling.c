#include<stdio.h>

int main()
{
    FILE *fb;
    int b;
    fb = fopen("file.txt","r");
    
    


   

    while (!feof(fb))
    {
        if (fscanf(fb,"%d",&b)!=1)
        {
            break;
        }
        printf("The value of reading file is = %d\n",b);
        
    }
    
    fclose(fb);
    fb = fopen("file.txt","w");
    fprintf(fb,"%d",b);
    
    return 0;
}