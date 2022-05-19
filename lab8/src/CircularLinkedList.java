/**
 * Class represents a Circular Linked List where the last node points back to the head of the list
 *
 * @author prio
 * @version 1.0
 * @since today's lab
 */
public class CircularLinkedList {
    /**
     *
     *  Head and tail of the circular linked list
     */
    private Node head = null;
    private Node tail = null;


    /**
     * Adds a node with the given value to the list or creates the list if the list is empty
     * @param value
     */
    public void addNode(int value) {
        Node newNode = new Node(value);

        if (head == null) {
            head = newNode;
        } else {
            tail.nextNode = newNode;
        }

        tail = newNode;
        tail.nextNode = head;
    }

    /**
     * Checks if the list contains a certain node with the searchValue
     * @param searchValue
     * @return isFound :: Boolean
     */
    public boolean containsNode(int searchValue) {
        Node currentNode = head;

        if (head == null) {
            return false;
        } else {
            do {
                if (currentNode.value == searchValue) {
                    return true;
                }
                currentNode = currentNode.nextNode;
            } while (currentNode != head);
            return false;
        }
    }

    /**
     * Deletes the first found node with the given value
     * If there is only one node the method clears the list
     * @param valueToDelete
     */
    public void deleteNode(int valueToDelete) {
        Node currentNode = head;
        if (head == null) {
            return;
        }
        do {
            Node nextNode = currentNode.nextNode;
            if (nextNode.value == valueToDelete) {
                if (tail == head) {
                    head = null;
                    tail = null;
                } else {
                    currentNode.nextNode = nextNode.nextNode;
                    if (head == nextNode) {
                        head = head.nextNode;
                    }
                    if (tail == nextNode) {
                        tail = currentNode;
                    }
                }
                break;
            }
            currentNode = nextNode;
        } while (currentNode != head);
    }

    /**
     * Returns the next node in the circular list or null if the list is empty
     * @param currentNode
     * @return Node
     */
    public Node getNextNode(Node currentNode){
        if(currentNode == null){
            return null;
        }

        return currentNode.nextNode;
    }

}