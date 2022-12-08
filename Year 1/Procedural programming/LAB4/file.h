//
// Created by Dominykas Cernovas on 2022-12-08.
//

#ifndef KETVIRTA_UDUOTIS_FILE_H
#define KETVIRTA_UDUOTIS_FILE_H

typedef struct node{
    struct node *prev;
    int number;
    struct node *next;
} node;
//Printing function
void PrintList(node *head);
void AddToEmpty(node **head, int data);
void Push(node **head, int data);
//Delete the smallest element
void DeleteSmallest(node **head, int n);
//Free all the data
void CleanUp(node *head);

#endif //KETVIRTA_UDUOTIS_FILE_H
