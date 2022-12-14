//
// Created by Dominykas Cernovas on 2022-12-08.
//
#include <stdio.h>
#include <stdlib.h>
#include "file.h"

//Print list
void PrintList(node *head)
{
    node *last = head;
    while (head != NULL)
    {
        printf("NUMBER: %d\n", head->number);
        if(head->next != NULL)
            last = last->next;
        head = head->next;
    }
    printf("\nATBULAI\n");
    head = last;
    while (head != NULL)
    {
        printf("NUMBER: %d\n", head->number);
        head = head->prev;
    }
}

//Add node to existing doubly linked list
void Push(node **head, int data)
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

//Find and delete smallest node
void DeleteSmallest(node **head, int n)
{
    node *smallest, *temp, *temporaryHead;
    int position = 1;
    temporaryHead = *head;
    smallest = *head;

    // Finding which node has the smallest int
    for(int i = 1; temporaryHead != NULL; ++i)
    {
        temp = temporaryHead->next;
        if(smallest->number > temporaryHead->number)
        {
            smallest = temporaryHead;
            position = i;
        }
        temporaryHead = temp;
    }

    temporaryHead = NULL;

    temp = *head;

    // If node is in the middle
    if(position > 1 && position < n)
    {
        while (position > 1) {
            temp = temp->next;
            --position;
        }
        temporaryHead = temp->prev;
        temporaryHead->next = temp->next;
        temp->next->prev = temporaryHead;
        *head = temporaryHead;
        free(temp);
        temp = NULL;
    }else if(position == 1)             // If node is the first element
    {
        temporaryHead = temp->next;
        temporaryHead->prev = NULL;
        *head = temporaryHead;
        free(temp);
    }else                               // If node is the last element
    {
        while(temp->next != NULL)
            temp = temp->next;
        temporaryHead = temp->prev;
        temporaryHead->next = NULL;
        free(temp);
        temp = NULL;
    }
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
