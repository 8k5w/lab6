public class DoublyLinkedList<E> {
    private Node<E> header;
    private Node<E> trailer;
    private int size = 0;

    public DoublyLinkedList() {
        header = new Node<E>(null, null, null);
        trailer = new Node<E>(null, header, null);
        header.setNext(trailer);
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public E first() {
        if (isEmpty()) return null;
        return header.getNext().getElement();
    }

    public E last() {
        if (isEmpty()) return null;
        return trailer.getPrev().getElement();
    }

    public void addBetween(E e, Node<E> predecessor, Node<E> successor) {
        Node<E> newest = new Node<E>(e, predecessor, successor);
        predecessor.setNext(newest);
        successor.setPrev(newest);
        size++;

    }

    public Node findMiddleNode() {
        Node slow = header.next;
        Node fast = header.next;

        while (fast != trailer && fast.next != trailer) {
            slow = slow.next;
            fast = fast.next.next;
        }

        return slow;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        DoublyLinkedList clonedList = new DoublyLinkedList();

        Node current = header;
        while (current != null) {
            clonedList.addFirst(current.element);
            current = current.next;
        }

        return clonedList;
    }

    public int size_() {
        int count = 0;
        Node current = header.next;

        while (current != trailer) {
            count++;
            current = current.next;
        }

        return count;
    }

    public void addFirst(E e) {
        addBetween(e, header, header.getNext());
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }

        if (!(obj instanceof DoublyLinkedList)) {
            return false;
        }

        DoublyLinkedList<?> otherList = (DoublyLinkedList<?>) obj;

        if (this.size != otherList.size) {
            return false;
        }

        Node<E> currentNode = this.header;
        Node<?> otherNode = otherList.header;

        while (currentNode != null) {
            if (!currentNode.element.equals(otherNode.element)) {
                return false;
            }

            currentNode = currentNode.next;
            otherNode = otherNode.next;
        }

        return true;
    }

    public E remove(Node<E> node) {
        Node<E> predecessor = node.getPrev();
        Node<E> successor = node.getNext();
        predecessor.setNext(successor);
        successor.setPrev(predecessor);
        size--;
        return node.getElement();
    }

    public E removeLast() {
        if (isEmpty()) return null;
        return remove(trailer.getPrev());
    }

    public E removeFirst() {
        if (isEmpty()) return null;
        return remove(header.getNext());
    }

    private static class Node<E> {
        private E element;
        private Node<E> prev;
        private Node<E> next;

        public Node(E e, Node<E> p, Node<E> n) {
            element = e;
            prev = p;
            next = n;
        }

        public E getElement() {
            return element;
        }

        public Node<E> getPrev() {
            return prev;
        }

        public Node<E> getNext() {
            return next;
        }

        public void setPrev(Node<E> prev) {
            this.prev = prev;
        }

        public void setNext(Node<E> next) {
            this.next = next;
        }
    }





}



