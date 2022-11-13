#include <stdio.h>
#include <string.h>
#include <stdlib.h>
#include <math.h>
#include <stdbool.h>
#define CAPACITY 100

// Funkciju protipai
bool Validation(char input[]);
void InputFileName(char name[]);
int Calculator(char input[], int num1, double num2);

// MAIN
int main() {

    // KINTAMIEJI
    char file_name[CAPACITY] = "in.txt";
    char input[CAPACITY];

    // Kintamasis, skirtas duomenu validacijos While ciklui.
    int cont = 1;

    // Ilgio skaiciavimams skirti kintamieji
    int lenght = 0;
    double number, mod;
    int whole;
    int temporary;

    FILE * myFile;

    printf("Si programa nuskaito faila, kuriame turi buti\n"
           "realus skaicius, kurio sveikoji dalis yra tokiuose\n"
           "reziuose: [10;1000]. O trupmenine dalis negali buti\n"
           "ilgesne nei 3 skaitmenys.\n\n");

    // VALIDACIJA
    while(cont)
    {
        myFile = fopen(file_name, "r");
        fscanf(myFile, "%s", input);

        // Jeigu netinkami duomenys, praso ivesti kita faila.
        if(!(Validation(input)))
        {
            cont = 1;
            InputFileName(file_name);
        }
        else
        {
            cont = 0;
        }
    }

    // Atrenka sveikaja dali ir trupmenine dali.
    number = atof(input);
    whole = number;
    mod = modff(number, &temporary);

    // Suskaiciuoja skaiciaus ilgi ir isveda ji i ekrana.
    lenght = Calculator(input, whole, mod);
    printf("%d", lenght);

    return 0;
}

// Duomenu validacija
bool Validation(char input[])
{
    int whole;
    int is_float = 0;
    int is_char = 0;
    for(int i = 0; i < strlen(input); ++i)
    {
        if(!(input[i] >= '0' && input[i] <= '9'))
        {
            if(input[i] == ',' || input[i] == '.')                  // Tikrina ar yra kablelis ir pavercia ji i taska.
            {
                input[i] = '.';
                ++is_float;
            }else                                                   // Tikrina ar yra simboliu.
            {
                ++is_char;
                printf("Netinkami duomenys.\nFaile yra simbolis.\n");
                return false;
            }
        }
    }

    double number = atof(input);
    whole = number;
    if(whole < 10 || whole > 1000)                                  // Tikrina ar skaicius atitinka rezius [10;1000]
    {
        printf("Netinkami duomenys.\nSveikoji skaiciaus dalis neatitinka reziu [10;1000].\n");
        return false;
    }

    if(is_float)                                                    // Tikrina ar trupmenine dalis yra tinkamo ilgio
    {
        for(int i = 0; i < strlen(input); ++i)
        {
            if(input[i] == '.')
            {
                if(strlen(input) - i > 4)
                {
                    printf("Netinkami duomenys.\nDaugiau nei 3 skaiciai po kablelio.\n");
                    return false;
                }
                else
                {
                    printf("Duomenys nuskaityti teisingai.\n");
                    return true;
                }
            }
        }
    }
    printf("Netinkami duomenys.\nSkaicius yra sveikas.\n");         // Isspausdina pranesima, jeigu skaicius yra sveikas
}

// Funkcija, skirta ivesti kitam duomenu failui.
void InputFileName(char name[])
{
    printf("Iveskite kito failo pavadinima: ");
    scanf("%s", &name);
}

// Suskaiciuoja skaiciaus ilgi.
int Calculator(char input[], int num1, double num2)
{
    int counter1 = 0;
    int total = 0;
    while (num1 > 0)
    {
        num1 /= 10;
        ++counter1;
    }
    for (int i = 0; i < strlen(input); ++i)
    {
        if(input[i] == '.')
        {
            total = counter1 + strlen(input) - i - 1;
            return total;
        }
    }
}
