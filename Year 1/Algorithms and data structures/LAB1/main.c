// FOR TESTING

#include <stdio.h>
#include "deck.h"

int main() {
    deck *head = NULL;

    PushBack(&head,10);
    PushBack(&head, 11);
    PushBack(&head, 12);

    PrintDeck(head);

    printf("FIRST ELEMENT: %d\n", GetFirstElement(head));
    printf("LAST ELEMENT: %d\n", GetLastElement(head));

    printf("DECK SIZE: %d\n", DeckSize(head));

    printf("DELETE DECK\n");

    DeleteDeck(&head);

    printf("DECK SIZE: %d\n", DeckSize(head));

    return 0;
}
