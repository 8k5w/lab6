public class DoublyCircularlyLinkedList<E> {
    private Node<E> header;
    private int size = 0;
    public void DoublyCircularlyLinkedList(){
        header = new Node<E>(null, null, null);
        header.setNext(header);

    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void rotate() {
        if (isEmpty() || header.next == header) {
            return;
        }

        header = header.next;
    }

    public void rotateBackward() {
        if (isEmpty() || header.next == header) {
            return;
        }

        header = header.prev;
    }

    private static class Node<E> {
        private E element;
        private Node<E> prev;
        private Node<E> next;
        public Node(E e,Node<E> p, Node<E> n){
            element=e;
            prev=p;
            next=n;
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

