//
// Created by Dominykas Cernovas on 2023-02-08.
//

#ifndef PIRMA_UDUOTIS_FILE_H
#define PIRMA_UDUOTIS_FILE_H

typedef struct deck{
    struct deck *prev;
    int number;
    struct deck *next;
} deck;

//Is deck empty
//Return code: 0 - empty; 1 - not empty.
int IsEmpty(deck *head);

//Is deck full
//Return code: 0 - is NOT full; 1 - is FULL.
int IsFull(deck *head);

//Returns first element.
int GetFirstElement(deck *head);

//Returns last element.
int GetLastElement(deck *head);

//Returns deck size.
int DeckSize(deck *head);

//Printing function
void PrintDeck(deck *head);

//Pushing function
void PushBack(deck **head, int data);
void PushFront(deck **head, int data);

//Delete the smallest element
int DeleteFront(deck **head);
int DeleteBack(deck **head);

//Free all allocated memory
void DeleteDeck(deck **head);

#endif //PIRMA_UDUOTIS_FILE_H
