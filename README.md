# BackendChallenge

Veritabanı olarak postgresql kullanılmıştır. Projede kullanılmak üzere Customer ve Order tabloları mevcuttur. Tablolar birbirlerine One-to-Many ilişkisiyle bağlanmıştır. Challenge ekinde bahsedilen 3 servis
için CustomerRepository ve OrderRepository içerisinde java sorgu kodları ve fonksiyonlar mevcuttur.


Customer Tablosu aşağıdaki nitelikleri barındırır;
- Id
- name
- age


Order Tablosu aşağıdaki nitelikleri barındırır;
- Id
- createDate
- totalPrice
- customerId

Projenin karşılaması gereken beklentiler şunlardır;
-  CRUD işlemleri
-  Bir servis olmalı ve parametre olarak verilen tarihten sonra oluşturulmuş siparişleri
 listelesin.
-  Bir servis olmalı ve bir kelime yada harf değerini parametre olarak alsın ve isminin
içerisinde bu değer geçen müşteri ve müşteriye ait sipariş id sini getirsin.
-  Bir servis olmalı ve siparişi olmayan müşterileri listesin

## Order @("/orders")
 
 @POST  
 Fonksiyon ismi: **create()**  
 Fonksiyon girdileri: createOrderDto  
 Fonksiyon çıktıları: true, "Order Created", order  
 Açıklama: Sipariş oluşturma fonksiyonudur. Her bir sipariş; id, oluşturulma tarihi ve müşteri id bilgileriyle birlikte Order tablosuna eklenir.  
   
 @PUT("/{id}")  
 Fonksiyon ismi: **update()**  
 Fonksiyon girdileri: updateOrderDto  
 Fonksiyon çıktıları: true, "Order Updated. Info: orderId", order   
 Açıklama: Sipariş güncelleme fonksiyonudur. Her bir sipariş; id, oluşturulma tarihi ve müşteri id bilgileriyle birlikte güncellenir.  
   
 @DELETE("/{id}")  
 Fonksiyon ismi: **delete()**  
 Fonksiyon girdileri: orderId  
 Fonksiyon çıktıları: true, "Order Deleted", orderId  
 Açıklama: Sipariş silme fonksiyonudur. Her bir sipariş, id bilgisi girilerek silinir.  
  
 @GET("/{id}")  
 Fonksiyon ismi: **getById()**  
 Fonksiyon girdileri: orderId  
 Fonksiyon çıktıları: true, "Order Shown", order  
 Açıklama: ID bilgisine göre tek bir siparişi gösteren fonksiyondur. Her bir sipariş, id bilgisi girilerek görüntülenir.  
  
 @GET  
 Fonksiyon ismi: **getAll()**  
 Fonksiyon girdileri:  -  
 Fonksiyon çıktıları: true, "All Orders Listed"  
 Açıklama: Tüm siparişleri görüntüleyen fonksiyondur. Parametre verilmeden kullanılır. Tüm siparişler ekranda listelenir.  
   
 @GET("/date")  
 @Param(?date=yyyy-MM-dd)  
 Fonksiyon ismi: **getOrdersAfterDate**  
 Fonksiyon girdileri: Date  
 Fonksiyon çıktıları: true, "All Orders Listed With After The Date", findByCreateDateAfter  
 Açıklama: Parametre olarak verilen tarihten sonra oluşturulmuş siparişleri listeleyen fonksiyondur. Verilen tarihten sonraki siparişler listelenir.
 
 ## Customer @(/customers)
 
 @POST  
 Fonksiyon ismi: **create()**  
 Fonksiyon girdileri: createCustomerDto  
 Fonksiyon çıktıları: true, "Customer Created", customer  
 Açıklama: Müşteri oluşturma fonksiyonudur. Her bir müşteri; id, isim ve yaş bilgileriyle birlikte Customer tablosuna eklenir.  
   
 @PUT("/{id}")  
 Fonksiyon ismi: **update()**  
 Fonksiyon girdileri: updateCustomerDto  
 Fonksiyon çıktıları: true, "Customer Updated. Info: name", customer   
 Açıklama: Müşteri güncelleme fonksiyonudur. Her bir müşteri; id, isim ve yaş bilgileriyle birlikte güncellenir.  
   
 @DELETE("/{id}")  
 Fonksiyon ismi: **delete()**  
 Fonksiyon girdileri: customerId  
 Fonksiyon çıktıları: true, "Customer Deleted", customerId  
 Açıklama: Müşteri silme fonksiyonudur. Her bir müşteri, id bilgisi girilerek silinir.  
  
 @GET("/{id}")  
 Fonksiyon ismi: **getById()**  
 Fonksiyon girdileri: customerId  
 Fonksiyon çıktıları: true, "Customer Shown", customer  
 Açıklama: ID bilgisine göre tek bir müşteriyi gösteren fonksiyondur. Her bir müşteri, id bilgisi girilerek görüntülenir.  
  
 @GET  
 Fonksiyon ismi: **getAll()**  
 Fonksiyon girdileri:  -  
 Fonksiyon çıktıları: true, "All Customers Listed"  
 Açıklama: Tüm müşterileri görüntüleyen fonksiyondur. Parametre verilmeden kullanılır. Tüm müşteriler ekranda listelenir.  
   
 @GET("/without-orders")  
 Fonksiyon ismi: **getCustomersWithoutOrders()**  
 Fonksiyon girdileri: -  
 Fonksiyon çıktıları: true, "CustomersShownWithoutOrders", findCustomersWithoutOrders  
 Açıklama: Hiç bir siparişi olmayan müşterileri listeler.  
   
 @GET("/withOrders/{word}")  
 Fonksiyon ismi: **getOrderIdByCustomerName()**  
 Fonksiyon girdileri: String word  
 Fonksiyon çıktıları: true, "", findWithOrdersByContainingWord  
 Açıklama: parametre olarak verilen harf veya kelimeler içeren müşterileri ve bu müşterilerin siparişlerini listeler. 
