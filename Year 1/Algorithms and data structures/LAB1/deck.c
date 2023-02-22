//
// Created by Dominykas Cernovas on 2023-02-08.
// Updated 02-22
//
#include <stdlib.h>
#include <stdio.h>
#include "deck.h"

int IsEmpty(deck *head)
{
    if(head == NULL)
    {
        return 0;
    }else
    {
        return 1;
    }
}

int IsFull(deck *head)
{
    deck *test = malloc(sizeof(deck));
    if(test == NULL)
    {
        return 1;
    }else
    {
        free(test);
        return 0;
    }
}

int GetFirstElement(deck *head)
{
    return head->number;
}

int GetLastElement(deck *head)
{
    while(head->next != NULL)
        head = head->next;
    return head->number;
}

int DeckSize(deck *head)
{
    if(head == NULL)
        return 0;

    int length = 0;
    while(head->next != NULL)
    {
        head = head->next;
        ++length;
    }
    return ++length;
}

void PrintDeck(deck *head)
{
    deck *last = head;
    while (head != NULL)
    {
        printf("NUMBER: %d\n", head->number);
        if(head->next != NULL)
            last = last->next;
        head = head->next;
    }
}

void PushBack(deck **head, int data)
{
    deck *temp, *temporaryHead;
    if(*head == NULL)
    {
        temp = malloc(sizeof(deck));
        temp->prev = NULL;
        temp->next = NULL;
        temp->number = data;
        *head = temp;
        return;
    }

    temp = malloc(sizeof(deck));
    temp->prev = NULL;
    temp->next = NULL;
    temp->number = data;
    temporaryHead = *head;

    while (temporaryHead->next != NULL)
        temporaryHead = temporaryHead->next;

    temporaryHead->next = temp;
    temp->prev = temporaryHead;
}

void PushFront(deck **head, int data)
{
    deck *temp, *temporaryHead;

    if(*head == NULL)
    {
        temp = malloc(sizeof(deck));
        temp->prev = NULL;
        temp->next = NULL;
        temp->number = data;
        *head = temp;
        return;
    }

    temp = malloc(sizeof(deck));
    temp->prev = NULL;
    temp->number = data;
    temporaryHead = *head;
    temporaryHead->prev = temp;
    temp->next = temporaryHead;
    *head = temp;
}

int DeleteBack(deck **head)
{
    deck *temp, *temporaryHead = NULL;
    int pop = GetLastElement(*head);
    temp = *head;

    //If there is one element left, delete all deque
    if(temp->next == NULL && temp->prev == NULL)
    {
        DeleteDeck(head);
        return pop;
    }

    while(temp->next != NULL)
        temp = temp->next;

    temporaryHead = temp->prev;
    temporaryHead->next = NULL;

    free(temp);
    temp = NULL;
    return pop;
}

int DeleteFront(deck **head)
{
    deck *temp, *temporaryHead;
    int pop = GetFirstElement(*head);
    temporaryHead = NULL;
    temp = *head;

    //If there is one element left, delete all deque
    if(temp->next == NULL && temp->prev == NULL)
    {
        DeleteDeck(head);
        return pop;
    }

    temporaryHead = temp->next;
    temporaryHead->prev = NULL;
    *head = temporaryHead;
    free(temp);
    return pop;
}

void DeleteDeck(deck **head)
{
    deck *current = *head;
    deck *next = NULL;

    while(current != NULL)
    {
        next = current->next;
        free(current);
        current = next;
    }
    *head = NULL;
}
