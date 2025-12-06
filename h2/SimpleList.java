package h2;

public class SimpleList {
    public static void main(String[] args) {
        
    }

    public Node head;

    public SimpleList() {
        this.head = new Node(Integer.MIN_VALUE);
    }

    public Node getFirst() {
        return head.next;
    }

    public Node getLastNode() {
        if(head.next == null)
            return null;
        Node bufferNode = head.next;
        while (bufferNode.next!=null)
            bufferNode = bufferNode.next;
        return bufferNode;
    }

    public void append(int newValue) {
        if(head.next == null) {
            head.next = new Node(newValue);
            return;
        }
        getLastNode().next = new Node(newValue);
    }

    public Node findFirst(int value) {
        if(head.next == null)
            return null;

        Node bufferNode = head.next;
        while (bufferNode!=null) {
            if (bufferNode.value == value)
                return bufferNode;
            bufferNode = bufferNode.next;
        }
        return null;
    }

    public boolean insertAfter(int preValue, int newValue) {
        Node buffferNode = findFirst(preValue);
        if(buffferNode == null)
            return false;
        buffferNode = new Node(newValue);
        buffferNode.next = findFirst(preValue).next;
        findFirst(preValue).next = buffferNode;
        return true;
    }

    public boolean delete(int value) {
        if(head.next == null)
            return false;

        Node bufferNode = head;
        while (bufferNode.next!=null) {
            if (bufferNode.next.value == value) {
                bufferNode.next = bufferNode.next.next;
                return true;
            }
            bufferNode = bufferNode.next;
        }
        return false;
    }
}
