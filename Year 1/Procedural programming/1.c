//
//  main.c
//  Pirma Uzduotis
//
//  Created by Dominykas Cernovas on 2022-09-07.
//

#include <stdio.h>
#include <stdlib.h>
#include <ctype.h>
#include <stdbool.h>

// Pagrindine funkcija
int main()
{
    // Kintamieji
    int ivedamas_skaicius = 1;          // Ivedamo skaiciaus pradine reiksme 1, kad pagrindinis ciklas galetu veikti
    int skaitmenu_suma = 0;             // Skaitmenu sumos pradine reiksme 0, nes prie jos bus pridedamos liekanos
    int kiek_yra = 0;                   // Sio kintamojo pagalba yra sekamas tinkamas atrinktu duomenu skaicius
    int laikinas_kintamasis, liekana;   // Pagalbiniai kintamieji
    int ar_testi = 1;                   // Kintamasis, kurio pagalba programa yra kartojama dar karta

    printf("\nSi programa suskaiciuoja kiek sekoje\nyra skaiciu, kuriu skaitmenu suma yra lygine\nUzbaigti seka galite irasydami 0\n\n");
    
    // Pagrindinis programos ciklas
    while(ar_testi == 1)
    {
        while(ivedamas_skaicius != 0)
        {
            printf("Veskite sekos nari: \t\t");

            // VALIDACIJA --------------------------------------------------
            while(scanf("%d", &ivedamas_skaicius) != 1 || (getchar() != '\n'))
            {
                while(getchar() != '\n');
                printf("Netinkama ivestis.\nVeskite sveika skaiciu:\t\t");
            }
            
            // SKAICIAVIMAI -------------------------------------------------
                laikinas_kintamasis = ivedamas_skaicius;
                while(laikinas_kintamasis > 0)                                  // Algoritmas, kuris skaiciuoja skaitmenu suma
                {
                    liekana = laikinas_kintamasis % 10;
                    skaitmenu_suma = skaitmenu_suma + liekana;
                    laikinas_kintamasis = laikinas_kintamasis / 10;
                }
            
            if(skaitmenu_suma % 2 == 0 && skaitmenu_suma != 0)                  // Algoritmas, kuris patikrina ar gautas skaicius yra                                                                      lyginis
            {
                kiek_yra++;
            }
            skaitmenu_suma = 0;                                                 // Skaitmenu suma yra pakeiciama i nuli, kad kita karta                                                                    galetu vel veikti
        }
        
        // SPAUSDINIMAS ATRINKUS DUOMENIS ------------------------------------
        printf("\nAtrinkti duomenys: \t\t%d\n\n", kiek_yra);
        printf("Jei norite pradeti is naujo - 1, jei ne - 0: ");
        ar_testi = 5;
        scanf("%d", &ar_testi);
        if(ar_testi == 1)
        {
            ivedamas_skaicius = 1;
            kiek_yra = 0;                                                       // Atrinktu duomenu skaicius pakeiciamas i 0
        }
    }
    
    printf("\nPrograma baige darba\n\n\n");
    
    return 0;
}
