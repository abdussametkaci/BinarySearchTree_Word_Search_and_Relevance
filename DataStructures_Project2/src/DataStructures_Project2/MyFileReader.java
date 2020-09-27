/**
* @file MyFileReader.java
* @description Bu programda daha basit bir sekilde dosya islemleri yapmak icin
* yazilmistir. Temel olarak karakter okuma ve kelime okuma yapilabilmektedir
* @assignment Odev 2
* @date 13.05.2020
* @author Abdussamet KACI
*/ 
package DataStructures_Project2;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class MyFileReader {
    
    FileReader fr;
    File f;
    // verilen path de dosya acar
    public MyFileReader(String file){
        try {
            f = new File(file);
            fr = new FileReader(f);
        } catch (FileNotFoundException ex) {
            
        }
    }
    
     public MyFileReader(File file){
        try {
            fr = new FileReader(file);
        } catch (FileNotFoundException ex) {
            
        }
    }
    
     // doysadan bir adet karakter dondurur
     // eger okunacak karakter kalmadıysa \0 karakteri doner
    char read(){
        int fileReaded;
        try {
            if((fileReaded = fr.read()) != -1){
                return (char)fileReaded;
            }
        } catch (IOException ex) {
            
        }
        
        try {
            fr.close();
        } catch (IOException ex) {
           
        }
        
        return '\0';
    }
    
    // dosyadan her cagirildiginda bir kelime okur
    // kelimeyi alfa numerik olarak kabul ettim yani hem karakter hem de rakam
    // okunacak kelime kalmadıgında null doner
    String readString(){
        String readString = "";
        char readChar;
        while((readChar = read()) != '\0'){
            if(isAlphaNum(readChar)){
                readString += readChar;
            } else if(readChar == ' ' || readChar == '\n'){
                return readString;
            }
        }
        
        return readString;
        
    }
    
    // karakterin alfa numerik olup olmadigini kontrol eder
    boolean isAlphaNum(char c){
        if((('a' <= c && c <= 'z') || ('A' <= c && c <= 'Z')) || ('0' <= c && c <= '9')){
            return true;
        }
        
        return false;
    }
    
    
}
