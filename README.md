# Kan Bağışı Projesi
JSF + Maven + JPA + Primefaces

# Özet
Kan Bağışı uygulaması ile kan bağışı yapmak isteyen kişiler uygulamaya gerekli bilgileri girip kayıt olduktan sonra ihtiyaç 
sahipleri için uygun kanı bulmalarında onlara yardımcı olabilirler.
Aynı zamanda kan ihtiyacı olan kişiler kolaylıkla bir arama formu kullanarak uygun kanı bağışlayan kişilerin bilgilerini 
görebilirler.

# Kullanılan Teknolojiler
Uygulama maven tabanlıdır. JPA + JSF ortak entegrasyonu sağlanarak geliştirilmiştir.Tasarım ve validation kısımlarında 
Primefaces componentinden faydalanılmıştır.

# Kullanılan Programlar
Uygulamayı şuan için localde çalıştırabilirsiniz.Bunun için öncelikle localde çalışmak için bilgisayarınıza server(wamp,xampp..) kurun. Daha sonra java ee geliştirmek için uygun eclipse ide kurmanız gerekmekte. Son olarak kurduğunuz eclipse ide'ye apache tomcat server kurulumu yapmanız gerekmekte.

# Uygulamanın Çalıştırılması
Projeyi indirdikten sonra eclipse ile import ederek uygulamayı eclipse de görebilirsiniz.
Java Resources/properties/META-INF/persistence.xml dosyasında gerekli veritabanı konfigurasyonunu kendinize göre ayarlayın. Bunun için mysqlde yeni bir veritabanı oluşturmanız gerekmekte. Benim oluşturdugum veritabanı ismi 'kanbagis'. Siz persistence.xml'de bunu kendi veritabınınızla değiştirin. Sonrasında WebContent/bagisci/index.php dosyasına run-server diyerek tomcat üzerinden localde çalıştırabiliriz.

# Bilgilendirme
Uygulama resimlerine kanbagisiResimleri klasörü altından erişebilirsiniz.
