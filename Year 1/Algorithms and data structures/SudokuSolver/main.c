#include <stdio.h>
#include "sudokuSolver.h"


int main() {
    int table[N][N] = { { 3, 0, 6, 5, 0, 8, 4, 0, 0 },
                      { 5, 2, 0, 0, 0, 0, 0, 0, 0 },
                      { 0, 8, 7, 0, 0, 0, 0, 3, 1 },
                      { 0, 0, 3, 0, 1, 0, 0, 8, 0 },
                      { 9, 0, 0, 8, 6, 3, 0, 0, 5 },
                      { 0, 5, 0, 0, 9, 0, 6, 0, 0 },
                      { 1, 3, 0, 0, 0, 0, 2, 5, 0 },
                      { 0, 0, 0, 0, 0, 0, 0, 7, 4 },
                      { 0, 0, 5, 2, 0, 6, 3, 0, 0 } };
    printTable(table);
    printf("\n\n");
    if(sudokuSolver(table, 0, 0) == 1)
    {
        printTable(table);
    }else
    {
        printf("Not possible");
    }

    return 0;
}
