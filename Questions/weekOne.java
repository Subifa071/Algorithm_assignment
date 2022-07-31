package Questions;
// A Linked List node

public class weekOne {
    static int size;

    weekOne(){
        size = 0;
    }
    static class Node{
        int size;
    int data;
    Node next;
    

    // Utility function to create a new node.
    Node(int key)
    {
        data = key;
        next = null;
    }
}
    static Node head;
    static Node temp;

    /* Function to print nodes in
    a given linked list */
    static void printList(Node node)
    {
        while(node != null)
        {
            System.out.print(node.data + " ");

            node = node.next;
            size++;
        }
        System.out.println();
    }

    // The main function that
// takes an array of lists
// arr[0..last] and generates
// the sorted output
    static Node mergeKLists(Node arr[], int last)
    {

        // Traverse form second list to last
        for (int i = 1; i <= last; i++)
        {
            while(true)
            {

                // head of both the lists,
                // 0 and ith list.
                Node head_0 = arr[0];
                Node head_i = arr[i];

                // Break if list ended
                if (head_i == null)
                    break;

                // Smaller than first element
                if(head_0.data >= head_i.data)
                {
                    arr[i] = head_i.next;
                    head_i.next = head_0;
                    arr[0] = head_i;
                }
                else
                {

                    // Traverse the first list
                    while (head_0.next != null)
                    {

                        // Smaller than next element
                        if (head_0.next.data >= head_i.data)
                        {
                            arr[i] = head_i.next;
                            head_i.next = head_0.next;
                            head_0.next = head_i;
                            break;
                        }

                        // go to next node
                        head_0 = head_0.next;

                        // if last node
                        if (head_0.next == null)
                        {
                            arr[i] = head_i.next;
                            head_i.next = null;
                            head_0.next = head_i;
                            head_0.next.next = null;
                            break;
                        }
                    }
                }
            }
        }
        return arr[0];
    }
    static int GetNth(Node head, int n)
    {
        int count = 0;
        if (head == null) // edge case - if head is null
            return -1;
        // if count equal too n return node.data
        if (count == n)
            return head.data;

        // recursively decrease n and increase
        // head to next pointer
        return GetNth(head.next, n - 1);
    }



    public static int getSize(){
        return size;
    }

    // Driver program to test
// above functions
    public static void main (String[] args)
    {

        // Number of linked lists
        int k = 3;

        // Number of elements in each list
        int n = 4;

        // an array of pointers storing the
        // head nodes of the linked lists

        Node[] arr = new Node[k];

        arr[0] = new Node(2);
        arr[0].next = new Node(4);
        arr[0].next.next = new Node(7);
        arr[0].next.next.next = new Node(5);
        arr[0].next.next.next = new Node(10);


        arr[1] = new Node(3);
        arr[1].next = new Node(2);
        arr[1].next.next = new Node(7);
        arr[1].next.next.next = new Node(9);

        arr[2] = new Node(12);
        arr[2].next = new Node(5);
        arr[2].next.next = new Node(6);
        arr[2].next.next.next = new Node(9);

        // Merge all lists
        head = mergeKLists(arr, k - 1);
        printList(head);
        System.out.println("size of the list is : "+getSize());
        int median = getSize()/2;
        System.out.println("median of the list is : "+GetNth(head, median));

    }



}