#include <stdio.h>
#include <stdlib.h>

typedef struct node{
    struct node *prev;
    int number;
    struct node *next;
} node;

node *createList(struct node *head, int n);
node *addToEmpty(node *head, int data);
node *addAtEnd(node *head, int data);
node *deleteSmallest(node *head, int n);
void cleanUp(node *head);

int main()
{
    node *head = NULL;
    node *ptr;
    int n;

    printf("Enter number of the nodes: ");
    scanf("%d", &n);

    head = createList(head, n);
    printf("\nN: %d\n\n", n);

    ptr = head;
    while(ptr != NULL)
    {
        printf("NUMBER:%d ADDRESS:%p PREVADD:%p NEXTADD:%p\n", ptr->number, ptr, ptr->prev, ptr->next);
        ptr = ptr->next;
    }
    head = deleteSmallest(head, n);
    printf("\n\n");
    ptr = head;
    while(ptr != NULL)
    {
        printf("NUMBER:%d ADDRESS:%p PREVADD:%p NEXTADD:%p\n", ptr->number, ptr, ptr->prev, ptr->next);
        ptr = ptr->next;
    }

    cleanUp(head);

    return 0;
}

node *createList(struct node *head, int n)
{
    int data;

    if(n <= 0)
        return head;

    printf("Enter number of the 1 node: ");
    scanf("%d", &data);

    head = addToEmpty(head, data);

    for(int i = 1; i < n; ++i)
    {
        printf("Enter number of the %d node: ", i + 1);
        scanf("%d", &data);
        head = addAtEnd(head, data);
    }
    return head;
}

node *addToEmpty(node *head, int data)
{
    node *temp = malloc(sizeof(node));
    temp->prev = NULL;
    temp->next = NULL;
    temp->number = data;
    head = temp;

    return head;
}

node *addAtEnd(node *head, int data)
{
    node *temp, *tp;

    temp = malloc(sizeof(node));
    temp->prev = NULL;
    temp->next = NULL;
    temp->number = data;
    tp = head;

    while (tp->next != NULL)
        tp = tp->next;

    tp->next = temp;
    temp->prev = tp;

    return head;
}

node *deleteSmallest(node *head, int n)
{
    node *smallest, *temp, *temporaryHead;
    int position = 1;
    temporaryHead = head;
    smallest = head;

    // Which one is the smallest one
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

    temp = head;

    // IF node is in the middle
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
        head = head->next;
        free(head->prev);
        head->prev = NULL;
    }else                               // If node is the last element
    {
        while(temp->next != NULL)
            temp = temp->next;
        temporaryHead = temp->prev;
        temporaryHead->next = NULL;
        free(temp);
        temp = NULL;
    }

    return head;
}

void cleanUp(node *head)
{
    node *next;

    while(head != NULL)
    {
        next = head->next;
        free(head);
        head = next;
    }
}
