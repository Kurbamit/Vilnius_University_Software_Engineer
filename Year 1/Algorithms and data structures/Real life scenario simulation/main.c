#include <stdio.h>
#include <stdlib.h>
#include <stdbool.h>
#include <time.h>
#include "deck.h"

const char * PARAMS_FILE_NAME = "params.txt";
const char * OUTPUT_FILE_NAME = "output.txt";

int acceptanceProductivity, firstProductivity, secondProductivity,
    newPersonProbability, simulationTime;
bool errors = false;

void loadParams(){
    FILE *myFile = fopen(PARAMS_FILE_NAME, "r");

    if(myFile == NULL)
    {
        printf("File can not be opened.\n");
        errors = true;
        return;
    }
    fscanf(myFile, "%d", &acceptanceProductivity);
    if(acceptanceProductivity < 1)
    {
        printf("Acceptance productivity can not be less than 1.\n");
        errors = true;
        return;
    }
    fscanf(myFile, "%d", &firstProductivity);
    if(firstProductivity < 1)
    {
        printf("First worker's productivity can not be less than 1.\n");
        errors = true;
        return;
    }
    fscanf(myFile, "%d", &secondProductivity);
    if(secondProductivity < 1)
    {
        printf("Second worker's productivity can not be less than 1.\n");
        errors = true;
        return;
    }
    fscanf(myFile, "%d", &newPersonProbability);
    if(newPersonProbability < 1 || newPersonProbability > 100)
    {
        printf("New person's probability has to be in range [1-100]\n");
        errors = true;
        return;
    }
    fscanf(myFile, "%d", &simulationTime);
    if(simulationTime < 1)
    {
        printf("Simulation time can not be less than 1.\n");
        errors = true;
        return;
    }
    fclose(myFile);
    errors = false;
}

bool loadToFile(int documentNumber, int documentSortingCounter, int additionalTime, double percent)
{
    FILE * myFile = fopen(OUTPUT_FILE_NAME, "w");
    if(myFile == NULL)
        return false;

    fprintf(myFile, "Iš viso priimta dokumentų: %d\n", documentNumber);
    fprintf(myFile, "Kiek laiko užtruko: %d\n", documentSortingCounter);
    fprintf(myFile, "Papildomas dabo laikas: %d\n", additionalTime);
    fprintf(myFile, "Darbuotojų užimtumas (procentais): %.2f", percent);

    fclose(myFile);
    return true;
}

int main() {

    srand(time(NULL));

    int documentNumber = 0;

    // Sorting simulation
    int documentSortingCounter = 0;
    int time = 0;
    int worker1 = 0, worker2 = 0;
    int line = 0;

    // Calculation variables
    int additionalTime = 0;
    int fullTime = 0;
    double percent = 0;

    deck *documents = NULL;

    // Load parameters
    loadParams();
    if(errors)
        exit(0);

    // Main simulation loop for counting how many people came
    while(!errors && time < simulationTime)
    {
        // Simulation time
        ++time;

        int random = rand() % 100;
        if(random < newPersonProbability)
        {
            PushFront(&documents, 1);
            if(worker1 > 0 && worker2 > 0)
            {
                ++line;
            }else if(worker1 > 0 && worker2 == 0 && line != 0)
            {
                --line;
                worker2 = 5;
            }else if(worker1 == 0 && worker2 > 0 && line != 0)
            {
                --line;
                worker1 = 5;
            }else if(worker1 == 0 && worker2 == 0 && line != 0)
            {
                --line;
                worker1 = 5;
            }else if(worker1 > 0 && worker2 == 0)
            {
                worker2 = 5;
            }else
            {
                worker1 = 5;
            }
        }

        if(worker1 > 0)
            --worker1;
        if(worker2 > 0)
            --worker2;
    }
    documentNumber = DeckSize(documents);
    // ---------------------------------------------------------------
    // How long documents were sorted
    do{
        DeleteFront(&documents);
        documentSortingCounter += firstProductivity;
        if(IsEmpty(documents) == 0)
            break;
        DeleteBack(&documents);
        documentSortingCounter += secondProductivity;
    }while(IsEmpty(documents) != 0);
    // Free allocated memory
    DeleteDeck(&documents);

    // ---------------------------------------------------------------

    // FINAL COUNTING
    fullTime = documentNumber * acceptanceProductivity + documentSortingCounter;
    additionalTime = simulationTime - fullTime;
    if(additionalTime < 0)
    {
        additionalTime *= -1;
    }else{
        additionalTime = 0;
    }
    percent = ((double)fullTime / simulationTime) * 100;

    // ---------------------------------------------------------------

    if(!loadToFile(documentNumber, documentSortingCounter, additionalTime, percent))
        printf("Nepavyko įkelti į failą.\n");

    return 0;
}
