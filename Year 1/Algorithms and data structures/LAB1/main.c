#include <stdio.h>
#include "file.h"

int main() {
    node *head = NULL;

    PushBack(&head, 10);
    PushBack(&head, 9);
    PushBack(&head, 11);
    PushBack(&head, 1);

    PrintDeque(head);

    DeleteFront(&head);
    printf("Front Deleted:\n");
    PrintDeque(head);

    DeleteBack(&head);
    printf("Back Deleted:\n");
    PrintDeque(head);

    PushFront(&head, 99);
    PushBack(&head, 99);
    printf("PUSH FRONT AND BACK:\n");
    PrintDeque(head);

    DeleteBack(&head);
    DeleteFront(&head);

    printf("DELETE FRONT AND BACK:\n");
    PrintDeque(head);

    DeleteFront(&head);
    DeleteFront(&head);

    printf("DELETED DEQUE:\n");
    PrintDeque(head);

    CleanUp(&head);

    return 0;
}
