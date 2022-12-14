//Dominykas Černovas
//Programų sistemos  1 kursas 3 grupė
//Ketvirtoji užduotis
//Sudaryti dvipusį sąrašą,
//Parašyti procedūrą, kuri ištrina mažiausią
//Elementą
#include <stdio.h>
#include "file.h"


int main()
{
    node *head = NULL;
    int numberOfItems = 4;

    //Creating doubly linked list
    Push(&head, 3);
    Push(&head, 2);
    Push(&head, 4);
    Push(&head, 5);

    PrintList(head);

    //Deleting the smallest element from the list
    DeleteSmallest(&head, numberOfItems);

    printf("\n\n");
    printf("Deleted smallest element: \n");
    PrintList(head);

    // Free all the pointers
    CleanUp(&head);

    return 0;
}

