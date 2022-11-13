#include <stdio.h>
#define CAPACITY 500

// Funkciju prototipai--------------------------------------------------------------
int Input(int data[], int n, float *average);
void FindPlace(int data[], int n, float average, int *didesnis, int *mazesnis);

// MAIN-----------------------------------------------------------------------------
int main() {

    // Kintamieji
    int n = 0;
    float average;
    int didesnis, mazesnis;
    int data[CAPACITY];


    n = Input(data, n, &average);
    printf("Vidurkis - %.2f\n", average);

    FindPlace(data, n, average, &didesnis, &mazesnis);

    printf("Didesnis - %d\n", data[didesnis]);
    printf("Mazesnis - %d", data[mazesnis]);

    /*
        for (int i = 0; i < n; ++i) {                                    // Leidzia ivesti N duomenu ir juos validuoja
            printf("Veskite %d skaiciu: \t\t\t", i + 1);
            ivesti_skaiciai[i] = Validation();
            pakeisti_skaiciai[i] = (float) ivesti_skaiciai[i];           // Pakeicia int tipo duomenis i float
        }


        if(vieta_masyve == n - 1)                                        // Patikrina ar yra ir mazesnis ir didesnis skaicius uz vidurki masyve
        {
            printf("Artimiausi skaiciai ivestu skaiciu vidurkiui [%.2f]: %d\n", average,(int)pakeisti_skaiciai[vieta_masyve]);
            printf("Didesnio skaiciaus nei %d nebuvo.\n", (int)pakeisti_skaiciai[vieta_masyve]);
        }else if(pakeisti_skaiciai[vieta_masyve] == pakeisti_skaiciai[vieta_masyve - 1])                        // Jeigu vidurkis lygus skaiciui
        {
            printf("Artimiausi skaiciai ivestu skaiciu vidurkiui [%.2f]: %d ir %d\n", average,(int)pakeisti_skaiciai[vieta_masyve - 2],
                   (int)pakeisti_skaiciai[vieta_masyve + 1]);
        }else
        {
            printf("Artimiausi skaiciai ivestu skaiciu vidurkiui [%.2f]: %d ir %d\n", average,(int)pakeisti_skaiciai[vieta_masyve - 1],
                   (int)pakeisti_skaiciai[vieta_masyve + 1]);
        }*/


    printf("\nPrograma baige darba.\n");

    return 0;
}

// FUNKCIJOS------------------------------------------------------------------


int Input(int data[], int n, float *average)
{
    int sum = 0;
    printf("Iveskite sveika skaiciu N: \t");
    scanf("%d", &n);

    for(int i = 0; i < n; ++i)
    {
        printf("Iveskite %d skaiciu: ", i + 1);
        scanf("%d", &data[i]);
        sum += data[i];
    }
    *average = (float)sum / (float)n;

    return n;
}

void FindPlace(int data[], int n, float average, int *didesnis, int *mazesnis)
{
    *didesnis = 0;
    *mazesnis = 0;
    for(int i = 0; i < n; ++i)
    {
        if(((float)data[i] > average) && (data[*didesnis] < data[i]))
        {
            *didesnis = i;
        }
        if(((float)data[i] < average) && (data[*mazesnis] > data[i]))
        {
            *mazesnis = i;
        }
    }
}
