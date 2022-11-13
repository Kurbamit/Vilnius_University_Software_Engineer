#include <stdio.h>
#define CAPACITY 255

void changeString(const char string[], char newString[]);
void Output(const char readFile[], const char outputFile[]);

int main() {

    char readFile[CAPACITY];
    char outputFile[CAPACITY];

    // Input file's name
    printf("Iveskite teksto failo varda: ");
    scanf("%s", readFile);

    // Output file's name
    printf("Iveskite teksto faila i kuri bus isvedamas atsakymas: ");
    scanf("%s", outputFile);

    Output(readFile, outputFile);

    printf("\nPrograma baige darba.\n");
    return 0;
}

// Scanning file
void Output(const char readFile[], const char outputFile[])
{
    char newString[CAPACITY];
    char string[CAPACITY];
    FILE *input, *output;
    input = fopen(readFile, "r");
    if(input == NULL)
    {
        printf("Nepavyko atidaryti duomenu failo.\n");
        return;
    }
    output = fopen(outputFile, "w");
    if(output == NULL)
    {
        printf("Nepavyko sukurti rezultatu failo.\n");
        return;
    }

    while(fscanf(input, "%s", string) != EOF)
    {
        changeString(string, newString);
        fprintf(output, "%s ", newString);
    }
    fclose(input);
}

// ---------------------------------------------------------------
void changeString(const char string[], char newString[])
{
    while(*string != '\0')
    {
        // changing newString first letter
        *newString++ = *string;

        // Counting how many same letters
        int n = 1;
        while (*(++string) == *(newString - 1 )) ++n;

        // If more than one letter, change string.
        if (n != 1)
        {
            *newString++ = '$';
            // How many digits in number.
            int count = sprintf(newString, "%d", n );
            newString += count;
        }
    }
    // Adding last symbol in string
    *newString = '\0';
}
