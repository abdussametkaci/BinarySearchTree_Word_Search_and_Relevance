/**
* @file main.java
* @description Bu programda kullanıcidan bir klasor secilmesi istenir ve klasor
* icindeki tum dosyalar dolasilarak icindeki kelimelerbir Binary Search Tree'ye
* aktarilir ve o kelimelerin bir dosyada kac defa gectigi bilgisi tutulmaktadir
* sonra girilen bir sorguda kelimelerin alaka duzeylerine gore heap yapısında
* tutulmaktadır ve alaka duzeylerine gore ekrana bastirilmaktadir
* @assignment Odev 2
* @date 13.05.2020
* @author Abdussamet KACI abdussamet.kaci@stu.fsm.edu.tr
*/ 
package DataStructures_Project2;

import java.io.File;
import javax.swing.JFileChooser;

public class main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        BinarySearchTree<String> bst = new BinarySearchTree<>();

        // Kullanicidan bir klasor secilmesi istenir
        
        JFileChooser fileChooser = new JFileChooser();
        // hem klasor hem de dosya secilebilir
        fileChooser.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
        int r = fileChooser.showSaveDialog(null);
        String path = ""; 
        if (r == JFileChooser.APPROVE_OPTION) {
            // save tusuna basildiginda yol secilmis olur
            path = fileChooser.getSelectedFile().getAbsolutePath();
        }

        System.out.println("path = " + path);

        
        // klasorun icindeki dosyalarda gezinilir
        File folder = new File(path);
        MyFileReader fr;
        for (final File f : folder.listFiles()) {
            // kendim yazmis oldugum dosya okuyucu nesnesi tanimlanir
            fr = new MyFileReader(f);

            String word; // okunan kelime
            
            // okunan kelime null olmadigi surece okunur
            while (!"".equals(word = fr.readString())) {
                // okunan kelime kucuk harfe donusturulur
                word = word.toLowerCase();
                //System.out.println(word + ", " + f.getName());
                // okunan kelime ve bulundugu dosya BST'ye eklenir
                bst.insert(word, f.getName());
            }
        }
        
        // agac inorder yapida bastirilir
        bst.inorder();
        
        // sorgular test edilir
        bst.query("data");
        bst.query("data", "structures");
        bst.query("binary", "data");

    }

}
