/**
* @file NodeList.java
* @description Linked list'lerde tutulmasi icin gereken node'lardir
* @assignment Odev 2
* @date 13.05.2020
* @author Abdussamet KACI
*/ 
package DataStructures_Project2;

/**
 * @param <T>
 */
public class NodeList<T> {

    T data;
    NodeList<T> nextNode;
    int frequency; // data adedi

    public NodeList(T data) {
        this.data = data;
        this.frequency = 1;
    }
    
    // paramtere olarak verilen node'un frekansi ile karsilastirma yapar
    // eger daha az bir frekansa sahipse negatif
    // daha fazla frekansa sahipse pozitif
    // ikisi de ayni frekanslara sahiplerse sifir doner
    public int compareTo(NodeList<T> node){
        return this.frequency - node.frequency;
    }

}
