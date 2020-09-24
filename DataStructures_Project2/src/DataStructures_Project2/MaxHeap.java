/**
 * @file MaxHeap.java
 * @description Bu program Max Heap yapisini olusturmaktadir. 
 * @assignment Odev 2
 * @date 13.05.2020
 * @author Abdussamet KACI abdussamet.kaci@stu.fsm.edu.tr
 */
package DataStructures_Project2;

public class MaxHeap {

    private NodeList[] heap; // Node list tutar her bir elemani
    private int size;

    public MaxHeap(int capacity) {
        this.heap = new NodeList[capacity];
    }

    private int parent(int i) {
        return (i - 1) / 2;
    }

    private void swap(int i, int j) {
        NodeList temp = heap[i];
        heap[i] = heap[j];
        heap[j] = temp;
    }

    void insert(NodeList newData) {
        if (size < heap.length) {
            heap[size] = newData;
            int current = size++;

            while (heap[current].compareTo(heap[parent(current)]) > 0) {
                swap(current, parent(current));
                current = parent(current);
            }
        } else {
            System.out.println("heap is full !");
        }
    }

    void heapify() {
        int lastIndex = size - 1;

        for (int i = parent(lastIndex); i >= 0; i--) {
            maxHeap(i);
        }
    }

    private void maxHeap(int i) {
        int left = 2 * i + 1;
        int right = 2 * i + 2;

        int max = i;

        if (left < size && heap[max].compareTo(heap[left]) < 0) {
            max = left;
        }
        if (right < size && heap[max].compareTo(heap[right]) < 0) {
            max = right;
        }

        if (max != i) {
            swap(max, i);
            maxHeap(max);
        }
    }

    // icerisindeki max heap yapisinda saklanmis olan array siralanir
    // daha sonra ekrana bastirilir
    void print() {
        heapSort();
        for (NodeList element : heap) {
            System.out.print(element.data + "(" + element.frequency + "), ");
        }
        System.out.println();
    }

    // heap sort ile array siralanir
    // i'ninci eleman sifirinci eleman yani en buyuk sayi ile swap yapilir
    // sonra maxheap ilgili indexten itibaren yapılarak buyuk en büyük sayi basa gelir
    void heapSort() {
        for (int i = size - 1; i >= 0; i--) {
            swap(i, 0);
            maxHeap(i);
        }
    }

}
