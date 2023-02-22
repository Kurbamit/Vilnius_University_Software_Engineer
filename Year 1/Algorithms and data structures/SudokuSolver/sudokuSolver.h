//
// Created by Dominykas Cernovas on 2023-02-16.
// V1.0

#ifndef ANTRA_UDUOTIS_SUDOKUSOLVER_H
#define ANTRA_UDUOTIS_SUDOKUSOLVER_H

#define N 9

int printTable(int grid[N][N]);
int canPlace(int grid[N][N], int row, int col, int number);
int sudokuSolver(int grid[N][N], int row, int col);

#endif //ANTRA_UDUOTIS_SUDOKUSOLVER_H
