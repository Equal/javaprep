//This one was surprisingly difficult. I don't know if that bodes well.
//On my first try I did not do the final reversal, so I returned Node 8, instead of Node 9.
//On my second try, I put the prev.null statement in the while loop, so the entire list was only ever 3 Nodes long

public class LinkedListReverse {

  static class LinkedListNode<T> {
    T value;
    LinkedListNode<T> next = null;
  }

  static LinkedListNode<Integer> reverse(LinkedListNode<Integer> linkedList) {
    if (linkedList.next == null) {
        return linkedList;
    }
    LinkedListNode<Integer> prev = linkedList; //Unnecessary variable, but I like the naming better
    LinkedListNode<Integer> current = linkedList.next;
    LinkedListNode<Integer> next = current.next;
    prev.next = null;
    while (next != null) {
        current.next = prev;
        prev = current;
        current = next;
        next = current.next;
    }
    current.next = prev;
    return current;
  }

  public static void main(String[] args) {
    LinkedListNode<Integer> head = new LinkedListNode<Integer>();
    head.value = 0;
    LinkedListNode<Integer> current = head;
    for (int i = 1; i < 10; i++) {
      LinkedListNode<Integer> next = new LinkedListNode<Integer>();
      next.value = i;
      current.next = next;
      current = next;
    }
    current = reverse(head);
    while (current != null) {
      System.out.println(current.value);
      current = current.next;
    }
  }
}
