//
// Created by Dominykas Cernovas on 2023-02-08.
//
#include <stdlib.h>
#include <stdio.h>
#include "file.h"

//Print list
void PrintDeque(node *head)
{
    node *last = head;
    while (head != NULL)
    {
        printf("NUMBER: %d\n", head->number);
        if(head->next != NULL)
            last = last->next;
        head = head->next;
    }
}

//Add node to existing doubly linked list
void PushBack(node **head, int data)
{
    node *temp, *temporaryHead;
    if(*head == NULL)
    {
        temp = malloc(sizeof(node));
        temp->prev = NULL;
        temp->next = NULL;
        temp->number = data;
        *head = temp;
        return;
    }

    temp = malloc(sizeof(node));
    temp->prev = NULL;
    temp->next = NULL;
    temp->number = data;
    temporaryHead = *head;

    while (temporaryHead->next != NULL)
        temporaryHead = temporaryHead->next;

    temporaryHead->next = temp;
    temp->prev = temporaryHead;
}

void PushFront(node **head, int data)
{
    node *temp, *temporaryHead;

    if(*head == NULL)
    {
        temp = malloc(sizeof(node));
        temp->prev = NULL;
        temp->next = NULL;
        temp->number = data;
        *head = temp;
        return;
    }

    temp = malloc(sizeof(node));
    temp->prev = NULL;
    temp->number = data;
    temporaryHead = *head;
    temporaryHead->prev = temp;
    temp->next = temporaryHead;
    *head = temp;
}

void DeleteBack(node **head)
{
    node *temp, *temporaryHead = NULL;

    temp = *head;

    //If there is one element left, delete all deque
    if(temp->next == NULL && temp->prev == NULL)
    {
        CleanUp(head);
        return;
    }

    while(temp->next != NULL)
        temp = temp->next;

    temporaryHead = temp->prev;
    temporaryHead->next = NULL;

    free(temp);
    temp = NULL;
}

//Push front function
void DeleteFront(node **head)
{
    node *temp, *temporaryHead;

    temporaryHead = NULL;
    temp = *head;

    //If there is one element left, delete all deque
    if(temp->next == NULL && temp->prev == NULL)
    {
        CleanUp(head);
        return;
    }

    temporaryHead = temp->next;
    temporaryHead->prev = NULL;
    *head = temporaryHead;
    free(temp);
}

//Free all allocated memory
void CleanUp(node **head)
{
    node *current = *head;
    node *next = NULL;

    while(current != NULL)
    {
        next = current->next;
        free(current);
        current = next;
    }
    *head = NULL;
}
