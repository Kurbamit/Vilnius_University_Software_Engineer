//
// Created by Dominykas Cernovas on 2023-02-08.
//

#ifndef PIRMA_UDUOTIS_FILE_H
#define PIRMA_UDUOTIS_FILE_H

typedef struct node{
    struct node *prev;
    int number;
    struct node *next;
} node;
//Printing function
void PrintDeque(node *head);
//Pushing function
void PushBack(node **head, int data);
void PushFront(node **head, int data);
//Delete the smallest element
void DeleteFront(node **head);
void DeleteBack(node **head);
//Free all allocated memory
void CleanUp(node **head);

#endif //PIRMA_UDUOTIS_FILE_H
