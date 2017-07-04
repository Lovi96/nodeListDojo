/**
        * Created by lovi on 2017.07.04..
        */
public class Node {

    public String bookName;
    public int millionsSold;

    public Node next;

    public Node(String bookName, int millionsSold) {

        this.bookName = bookName;
        this.millionsSold = millionsSold;

    }

    public static void main(String[] args) {

        NodeList theNodeedList = new NodeList();


        theNodeedList.insertFirstNode("Don Quixote", 500);
        theNodeedList.insertFirstNode("A Tale of Two Cities", 200);
        theNodeedList.insertFirstNode("The Lord of the Rings", 150);
        theNodeedList.insertFirstNode("Harry Potter and the Sorcerer's Stone", 107);

        theNodeedList.display();

        System.out.println("Value of first in NodeedList " + theNodeedList.firstNode + "\n");

        // Removes the last Node entered

        theNodeedList.removeFirst();

        theNodeedList.display();

        System.out.println(theNodeedList.find("The Lord of the Rings").bookName + " Was Found");

        theNodeedList.removeNode("A Tale of Two Cities");

        System.out.println("\nA Tale of Two Cities Removed\n");

        theNodeedList.display();

    }

    public void display() {

        System.out.println(bookName + ": " + millionsSold + ",000,000 Sold");

    }

    public String toString() {

        return bookName;

    }

}

class NodeList {


    public Node firstNode;

    NodeList() {


        firstNode = null;

    }


    public boolean isEmpty() {

        return (firstNode == null);

    }

    public void insertFirstNode(String bookName, int millionsSold) {

        Node newNode = new Node(bookName, millionsSold);

        newNode.next = firstNode;

        firstNode = newNode;

    }

    public Node removeFirst() {

        Node NodeReference = firstNode;

        if(!isEmpty()) {


            firstNode = firstNode.next;

        } else {

            System.out.println("Empty NodeedList");

        }

        return NodeReference;

    }

    public void display() {

        Node theNode = firstNode;


        while(theNode != null) {

            theNode.display();

            System.out.println("Next Node: " + theNode.next);

            theNode = theNode.next;

            System.out.println();

        }

    }

    public Node find(String bookName) {

        Node theNode = firstNode;

        if(!isEmpty()) {

            while(theNode.bookName != bookName) {


                if(theNode.next == null) {


                    return null;

                } else {


                    theNode = theNode.next;

                }

            }

        } else {

            System.out.println("Empty NodeedList");

        }

        return theNode;

    }

    public Node removeNode(String bookName) {

        Node currentNode = firstNode;
        Node previousNode = firstNode;


        while(currentNode.bookName != bookName) {


            if(currentNode.next == null) {


                return null;

            } else {


                previousNode = currentNode;

                currentNode = currentNode.next;

            }

        }

        if(currentNode == firstNode) {


            firstNode = firstNode.next;

        } else {


            System.out.println("FOUND A MATCH");
            System.out.println("currentNode: " + currentNode);
            System.out.println("firstNode: " + firstNode);

            previousNode.next = currentNode.next;

        }

        return currentNode;

    }

}