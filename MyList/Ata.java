package MyList;

public class Ata {
    public static void main(String[] args) {
        MyList<Object> liste = new MyList<>();

        // Başlangıçta listeyi kontrol etme
        System.out.println("Liste Durumu : " + (liste.isEmpty() ? "Boş" : "Dolu"));

        // Elemanları listeye ekleme
        liste.add(10);
        liste.add(20);
        liste.add(30);
        liste.add(40);
        liste.add(20);
        liste.add(50);
        liste.add(60);
        liste.add(70);

        // Listeyi kontrol etme
        System.out.println("Liste Durumu : " + (liste.isEmpty() ? "Boş" : "Dolu"));

        // Bulduğu ilk indeksi verir
        System.out.println("Indeks : " + liste.indexOf(20));

        // Bulamazsa -1 döndürür
        System.out.println("Indeks : " + liste.indexOf(100));

        // Bulduğu son indeksi verir
        System.out.println("Indeks : " + liste.lastIndexOf(20));

        // Listeyi Object[] dizisi olarak geri verir
        Object[] dizi = liste.toArray();
        System.out.print("Object dizisinin ilk elemanı :" + dizi[0]);

        // Liste veri türünde alt bir liste oluşturdu
        MyList<Object> altListem = liste.sublist(0, 3);
        System.out.println(altListem.toString());

        // Değerim listedeki olup olmadığını sorguladı
        System.out.println("Listemde 20 değeri : " + liste.contains(20));
        System.out.print("Listemde 120 değeri : " + liste.contains(120));

        // Listeyi tamamen boşaltır
        liste.clear();
        System.out.println(liste.toString()); // []
    }
}
