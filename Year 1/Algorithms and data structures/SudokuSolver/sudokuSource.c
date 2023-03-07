//
// Created by Dominykas Cernovas on 2023-02-16.
//
#include <stdio.h>
#include "sudokuSolver.h"

void printTable2(int grid[N][N])
{
    int counter = 0;
    for(int i = 0; i < N; ++i)
    {
        for(int j = 0; j < N; ++j)
        {
            if(j == 3 || j == 6)
                printf("| ");
            printf("%d ", grid[i][j]);
        }
        if(i == 2 || i == 5)
        {
            printf("\n");
            for(int temp = 0; temp < N * 2 + 3; ++temp)
                printf("―");
        }
        printf("\n");
    }
}

void printTable(int grid[N][N])
{
    for(int i = 0; i < N; ++i)
    {
        for(int j = 0; j < N; ++j)
            printf("%d ", grid[i][j]);
        printf("\n");
    }
}

int canPlace(int grid[N][N], int row, int col, int number)
{
    // Check number in columns
    for(int i = 0; i < N - 1; ++i)
    {
        if(grid[row][i] == number)
            return 0;
    }

    // Check number in rows
    for(int i = 0; i < N - 1; ++i)
    {
        if(grid[i][col] == number)
            return 0;
    }

    // Check number in box
    int startRow = row - row % 3;
    int startCol = col - col % 3;
    for(int i = 0; i < 3; ++i)
    {
        for(int j = 0; j < 3; ++j)
            if(grid[i + startRow][j + startCol] == number)
                return 0;
    }
    return 1;
}

int sudokuSolver(int grid[N][N], int row, int col)
{
    // Check if we reached 8th row
    // and 9th column.
    if(row == N - 1 && col == N)
        return 1;

    // Check if we reached end of
    // the row.
    if(col == 9)
    {
        ++row;
        col = 0;
    }

    if(grid[row][col] > 0)
        return sudokuSolver(grid, row, col + 1);

    for(int number = 1; number <= N; ++number)
    {
        if(canPlace(grid, row, col, number) == 1)
        {
            grid[row][col] = number;

            if(sudokuSolver(grid, row, col + 1) == 1)
                return 1;
        }
        grid[row][col] = 0;
    }
    return 0;
}
