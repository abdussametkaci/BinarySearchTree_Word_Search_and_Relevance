/**
 * @file NodeList.java
 * @description Linked List veri yapisini olusturmak amaciyla yazilmistir
 * icerisinde nodeList tutar sirali bir sekilde
 * @assignment Odev 2
 * @date 13.05.2020
 * @author Abdussamet KACI abdussamet.kaci@stu.fsm.edu.tr
 */
package DataStructures_Project2;

/**
 * @param <T>
 */
public class SLinkedList<T> {

    private NodeList<T> head;

    // linked list'in sonuna nodeList ekler ve eger ayni dataya sahip bir nodeList
    // eklenmek istenirse ekleyecegimiz nodun freakansi kadar ekleme yapilir
    void addLast(NodeList<T> newNode) {
        if (isEmpty()) {
            head = newNode;
        } else {
            NodeList<T> temp = head;

            while (temp.nextNode != null) {
                if (temp.data.equals(newNode.data)) {
                    temp.frequency += newNode.frequency;
                    return;
                }

                temp = temp.nextNode;
            }

            if (temp.data.equals(newNode.data)) {
                temp.frequency += newNode.frequency;
                return;
            }

            temp.nextNode = newNode;
        }
    }

    void addLast(T newData) {
        addLast(new NodeList<>(newData));
    }

    
    void print() {
        NodeList<T> temp = head;

        while (temp != null) {
            System.out.print(temp.data + ", " + (temp.frequency) + " -> ");
            temp = temp.nextNode;
        }

        System.out.println("null");
    }

    // bos mu diye kontrol eder
    boolean isEmpty() {
        return head == null;
    }

    // linked list'in eleman sayisini dondurur
    int size() {
        NodeList<T> temp = head;
        int count = 0;

        while (temp != null) {
            count++;
            temp = temp.nextNode;
        }

        return count;
    }

    // istenilen indeksteki datayi getirir
    T getData(int index) {
        return getNode(index).data;
    }

    // istenilen indexteki nodeList'i getirir
    NodeList<T> getNode(int index) {
        NodeList<T> temp = head;

        if (isEmpty()) { // eger liste bossa yoktur
            return null;
        }

        for (int i = 0; i < index; i++) { // indesk degeri kadar ilerlenir ve degeri bulmus oluruz
            temp = temp.nextNode;
        }
        
        NodeList<T> founded = new NodeList<>(temp.data);
        founded.frequency = temp.frequency;
        return founded;
    }
}
