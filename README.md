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
