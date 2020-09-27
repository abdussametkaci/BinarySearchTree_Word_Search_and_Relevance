/**
 * @file BinarySearchTree.java
 * @description Bu program Binary Search Tree yapisini olusturmaktadir ve node
 * yapilarini ikili bir sekilde tutar. Bu projede agaca data olarak String eklenir
 * ve bu datalar agacta alfabetik siraya göre yerlestirilir
 * @assignment Odev 2
 * @date 13.05.2020
 * @author Abdussamet KACI
 */
package DataStructures_Project2;

/**
 * @param <T>
 */
public class BinarySearchTree<T extends Comparable<T>> {

    private Node<T> root;

    // yeni data  ve datanin bulundugu dosyayi ekler
    void insert(T newData, T fileName) {
        // eklenecek node olusturulur ve node'a datanın bulundugu dosyaların
        // bir listesini tutan bir linked liste eklenir
        Node<T> newNode = new Node<>(newData);
        newNode.fileList.addLast(fileName);

        if (isEmpty()) {
            root = newNode;
        } else {
            Node<T> temp = root;

            while (temp != null) {
                if (newData.compareTo(temp.data) > 0) {
                    if (temp.rightChild == null) {
                        temp.rightChild = newNode;
                        return;
                    }

                    temp = temp.rightChild;
                } else if (newData.compareTo(temp.data) < 0) {
                    if (temp.leftChild == null) {
                        temp.leftChild = newNode;
                        return;
                    }

                    temp = temp.leftChild;
                } else {
                    // eger data agacda var ise ekle methodu cagrilir ancak
                    // bu methodda ayni bir veri gelirse eger ekleme degil
                    // verinin frekansini artirir
                    temp.fileList.addLast(fileName); // frequency++
                    return;
                }
            }
        }
    }

    // agac uzerinde searching islemi yapar ve buldugun node'un icinde dosya
    // adlarini tutan linked list'i donderir
    SLinkedList<T> find(T searchData) {
        if (isEmpty()) {
            System.out.println("BinarySearchTree is empty !");
        } else {
            Node<T> temp = root;

            while (temp != null) {
                if (searchData.compareTo(temp.data) > 0) {
                    temp = temp.rightChild;
                } else if (searchData.compareTo(temp.data) < 0) {
                    temp = temp.leftChild;
                } else {
                    return temp.fileList;
                }
            }
        }

        return null;
    }

    // kendisine gonderilen bir veya birden fazla kelimeyi agactan bulur ve
    // o kelimenin icerisindeki linked list'in node'lari tek tek yeni bir 
    // linked list'e eklenir ve eger birden fazla kelime eklenirse ve eklenen
    // dosyalarda ayni ad geciyorsa frekanslari eklenir ve bu da alaka duzeyini verir
    void query(T... searchData) {
        // heap' e eklenecek olan lisnked list
        SLinkedList<T> relevanceList = new SLinkedList<>();
        // sorguyadaki kelimeler donulur
        for (T target : searchData) {
            // kelimenin linked list'i bulunur
            SLinkedList<T> linkedList = find(target);
            //linkedList.print();
            for (int i = 0; i < linkedList.size(); i++) {
                relevanceList.addLast(linkedList.getNode(i)); // yeni listeye eklenir
            }

        }

        //relevanceList.print();

        // yeni linked list'in boyutu kadar alan heap acilir
        MaxHeap heap = new MaxHeap(relevanceList.size());

        // linked list'teki her bir eleman heap'e eklenir
        for (int i = 0; i < relevanceList.size(); i++) {
            heap.insert(relevanceList.getNode(i));
        }

        heap.print(); // heap bastirilir

    }

    void inorder() {
        System.out.print("inorder : ");
        inorder(root);
        System.out.println();
    }
    
    // dersteki koddan farkli olarak her nodun icerdigi list node da bastilir
    private void inorder(Node<T> node) {
        if (node != null) {
            inorder(node.leftChild);
            System.out.println(node.data + " ");
            node.fileList.print();
            inorder(node.rightChild);
        }
    }

    // agac bos mu
    private boolean isEmpty() {
        return root == null;
    }

}
