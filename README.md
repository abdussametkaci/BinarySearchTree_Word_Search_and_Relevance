# DataStructures_Project2
Bu projede, Java dilini kullanarak, belirli bir klasör içerisinde bulunan ve yazı içermekte olan birden
fazla dosya için anahtar kelime/kelimeler aranmasına imkân tanıyan ve aramanın dosya düzeyinde ne
kadar alakalı olduğunu basit bir toplama işlemiyle döndüren bir algoritma geliştirilmiştir. 
Bu algoritmanın, içerisinde 'Binary Search Tree' ve 'Max Heap' gibi veri yapılarını barındırmaktadır.

## İsterler
• “dosyalar” klasöründe birden fazla dosya (txt, html gibi yazı içeren dosyalar) bulunmaktadır.
Her bir dosyayı kelime kelime okuyarak, bu dosyanın içerdiği kelimeleri ikili arama ağacında
(BST) sözlük sırasını göz önüne alarak saklayan ve her bir kelimeden hangi dosyada kaç tane
olduğu bilgisini (frequency) hesaplayan bir yapı tasarlamanmıştır.

• Bir dosyadaki kelimeler okundukça, okunan kelime BST yapısına sözlük sırasına göre eklenmektedir
ve bu kelimeye karşılık gelen tekli bağlantılı listede bu dosya bilgisi (dosya ismi ve frekans)
saklanmaktadır. Ağaca (BST) ekleme işlemleri okuma sırasında yapılmaktadır. Önce bütün dosyayı
okuma işlemini yapıp bu bilgileri ayrı bir yerde saklama yoluna gidilmemektedir. Bir dosya
okuması bitince, bu dosyadaki bütün kelimelerin BST yapısına eklenme işlemleri bitmiş
olmaktadır. Bu şekilde diğer dosyalar da eklenip BST yapısı istenilen şekilde
tamamlanmaktadır.

• Ağaç üzerindeki bir düğümün yapısı aşağıdaki gibidir. Data okunan kelimeyi göstermekte iken
ilgili listenin ilk elemanı ise bu kelimenin a.html dosyasında 2 kere geçtiğini göstermektedir.

![image](https://user-images.githubusercontent.com/61049743/94340332-95088000-0009-11eb-81a8-f4297bf27511.png)

• Bütün dosyalar okunup BST’ye sözlük sırasına göre ekleme işlemleri tamamlandıktan sonra ise
aşağıdaki gibi bir yapı oluşmaktadır.

![image](https://user-images.githubusercontent.com/61049743/94340362-c4b78800-0009-11eb-8935-596506dfcfc8.png)

• Buraya kadar yapılanlar, kelime arama sorguları için gerekli altyapıyı oluşturmamızı sağladı.
Oluşturulan ağacı kelime sıklığı ağacı olarak isimlendirebiliriz. Bundan sonraki işlemler ise bu
altyapıyı kullanarak kelime veya kelimelerin aranmasını ve bunların dosya bazlı alaka
düzeylerinin hesaplanmasını içermektedir.

• Dosyanın alaka düzeyi, aranan kelimelerin dosyada geçme sıklıkları toplamı olarak
kabul edilmektedir. Örneğin, aranan anahtar kelimenin “data structures” olduğunu düşünelim.
“data” kelimesi bir dosyada 3 kere geçmiş, “structures” kelimesi ise 5 kere geçmişse, “data
structures” aramasının alaka düzeyi bu dosya için 3+5 = 8 olacaktır.

• Bir sorguyu (aranan kelime veya kelimeler) işlemek için, her dosyanın alaka düzeyi kelime sıklığı
ağacı kullanılarak hesaplanmaktadır ve hesaplanan alaka değerlerine göre sıralanacak bir Heap
oluşturulmaktadır (Min Heap veya Max Heap farketmez ama tercihim Max Heap oldu). Sonrasında ise, bu oluşturulan Heap kullanılarak, o sorgu için bulunan
sonuçlar en alakalı dosyadan en alakasız dosyaya doğru sıralı bir şekilde çıktı olarak verilmektedir. Yani Heap Sorting algoritması yazılmıştır.

Örnek:
Verilen klasör içerisinde metin içeren 3 adet doküman olduğunu düşünelim:

Doc1: “In computer science, a data structure is a particular way of storing and organizing
data in a computer so that it can be used efficiently. Data structures provide a means
to manage huge amounts of data efficiently.”

Doc2: “Computer data is in what is called binary format. This means that it is always a 0 or a
1. It only has these two states and must be in one of them. Bit is a data unit which
must be in one of the two binary states described above. It is the smallest data unit
that exists.”

Doc3: “Binary numbers and arithmetic let you represent any amount you want using just two
digits: 0 and 1. Here are some examples: Decimal 1 is binary 0001, Decimal 3 is binary
0011”

Query 1: data

Doc1 (4), Doc2 (3)

Query 2: data structures

Doc1 (5), Doc2 (3)

Query 3: binary data

Doc2 (5), Doc1 (4), Doc3 (3)
