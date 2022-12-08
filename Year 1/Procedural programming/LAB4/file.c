//
// Created by Dominykas Cernovas on 2022-12-08.
//
#include <stdio.h>
#include <stdlib.h>
#include "file.h"

void PrintList(node *head)
{
    while (head != NULL)
    {
        printf("NUMBER:%d ADDRESS:%p PREVADD:%p NEXTADD:%p\n", head->number, head, head->prev, head->next);
        head = head->next;
    }
}

void AddToEmpty(node **head, int data)
{
    node *temp = malloc(sizeof(node));
    temp->prev = NULL;
    temp->next = NULL;
    temp->number = data;
    *head = temp;

}

void Push(node **head, int data)
{
    node *temp, *tp;

    temp = malloc(sizeof(node));
    temp->prev = NULL;
    temp->next = NULL;
    temp->number = data;
    tp = *head;

    while (tp->next != NULL)
        tp = tp->next;

    tp->next = temp;
    temp->prev = tp;
}

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
        free(temp);
        temp = NULL;
    }else if(position == 1)             // If node is the first element
    {
        *head = temp->next;
        free(temp->prev);
        *head = NULL;
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

void CleanUp(node *head)
{
    node *next;

    while(head != NULL)
    {
        next = head->next;
        free(head);
        head = next;
    }
}
