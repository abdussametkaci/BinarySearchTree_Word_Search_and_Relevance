/**
* @file Node.java
* @description Binary Search Tree yapisinda tutulacak node'lari tutmak icin 
* yazilmis programdir
* @assignment Odev 2
* @date 13.05.2020
* @author Abdussamet KACI abdussamet.kaci@stu.fsm.edu.tr
*/ 
package DataStructures_Project2;

/**
 * @param <T>
 */
public class Node<T extends Comparable<T>> {

    T data;
    Node<T> leftChild;
    Node<T> rightChild;
    SLinkedList<T> fileList; // datanin hangi dosyalarda gectigini tutar

    public Node(T data) {
        this.fileList = new SLinkedList<>();
        this.data = data;
    }

    @Override
    public String toString() {
        return data + "";
    }
}
