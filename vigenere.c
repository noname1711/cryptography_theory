#include<stdio.h>
#include<string.h>
#include<conio.h>
#include<ctype.h>

void encipher(){
    unsigned int i, j;
    char input[50], key[10];
    printf("\nEnter plain text: ");
    scanf("%s", input);
    printf("Enter key value: ");
    scanf("%s", key);
    printf("Resultant cipher text: ");
    for(i =0, j=0; i< strlen(input); i++, j++){
        if(j >= strlen(key)){
            j = 0;
        }
        printf("%c", ((toupper(input[i]) + toupper(key[j]))%26) + 'A');
    }
    printf("\n");
}

void decipher(){
    unsigned int i, j;
    char input[50], key[10];
    int value;
    printf("\nEnter cipher text: ");
    scanf("%s", input);
    printf("Enter key value: ");
    scanf("%s", key);
    printf("Resultant plain text: ");
    for (i =0, j =0; i< strlen(input); i++, j++){
        if(j >= strlen(key)){
            j = 0;
        }
        printf("%c", ((toupper(input[i])+ 26- toupper(key[j]))% 26) + 'A');
    }
    printf("\n");
}

int main(){
    int choice;
    while(1){
        printf("\n1. Encrypt\n2. Decrypt\n3. Exit");
        printf("\nEnter your choice: ");
        scanf("%d", &choice);
        if(choice == 3){
            break;
        }
        else if (choice ==1 ){
            encipher();
        }
        else if (choice ==2){
            decipher();
        }
        else{
            printf("Invalid choice. Please choose a valid option.\n");
        }
    }
}