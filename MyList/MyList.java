package MyList;

import java.util.Arrays;

class MyList<T> {
    private Object[] dizi; // Generic türde bir dizi
    private int size; // Dizideki mevcut eleman sayısı

    // Boş constructor: Varsayılan dizi boyutu 10
    public MyList() {
        dizi = new Object[10]; // Dizi başlangıçta 10 elemanlık olacak
        size = 0; // Başlangıçta dizide hiç eleman yok
    }

    // Kapasite belirterek constructor: Dizinin başlangıç boyutunu capacity olarak alır
    public MyList(int capacity) {
        if (capacity < 1) {
            throw new IllegalArgumentException("Kapasite 1'den küçük olamaz.");
        }
        dizi = new Object[capacity]; // Verilen kapasiteye göre dizi oluşturulur
        size = 0; // Başlangıçta dizide hiç eleman yok
    }

    // Dizinin boyutunu döndürür: Eleman sayısını verir
    public int size() {
        return size;
    }

    // Dizinin kapasitesini döndürür
    public int getCapacity() {
        return dizi.length;
    }

    // Dizinin sonuna eleman ekler. Eğer dizi doluysa, kapasiteyi 2 katına çıkarır.
    public void add(T data) {
        // Eğer dizi doluysa, kapasiteyi 2 katına çıkartıyoruz
        if (size == dizi.length) {
            dizi = Arrays.copyOf(dizi, dizi.length * 2); // Diziyi iki katına çıkarıyoruz
        }
        dizi[size] = data; // Yeni elemanı diziye ekliyoruz
        size++; // Eleman sayısını bir arttırıyoruz
    }

    // get(int index): Verilen indisteki değeri döndürür. Geçersiz indis girilirse null döner
    public T get(int index) {
        if (index >= 0 && index < size) {
            return (T) dizi[index]; // Geçerli indeksteki veriyi döndürüyoruz
        }
        return null; // Geçersiz indeks ise null döndürüyoruz
    }

    // remove(int index): Verilen indisteki veriyi siler ve sonrasındaki verileri kaydırır.
    public T remove(int index) {
        if (index >= 0 && index < size) {
            T removed = (T) dizi[index]; // Silinen elemanı alıyoruz
            System.arraycopy(dizi, index + 1, dizi, index, size - index - 1); // Elemanları kaydırıyoruz
            dizi[--size] = null; // Son elemanı null yapıyoruz
            return removed; // Silinen veriyi döndürüyoruz
        }
        return null; // Geçersiz indeks için null döndürüyoruz
    }

    // set(int index, T data): Verilen indisteki veriyi yenisi ile değiştirir.
    public T set(int index, T data) {
        if (index >= 0 && index < size) {
            T old = (T) dizi[index]; // Eski değeri alıyoruz
            dizi[index] = data; // Yeni veriyi ekliyoruz
            return old; // Eski veriyi döndürüyoruz
        }
        return null; // Geçersiz indeks için null döndürüyoruz
    }

    // String toString(): Sınıfa ait dizideki elemanları listeleyen metot
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("[");
        for (int i = 0; i < size; i++) {
            sb.append(dizi[i]);
            if (i < size - 1) sb.append(", ");
        }
        sb.append("]");
        return sb.toString();
    }

    // indexOf(T data): Parametrede verilen nesnenin listedeki indeksini verir.
    public int indexOf(T data) {
        for (int i = 0; i < size; i++) {
            if (dizi[i].equals(data)) {
                return i; // Nesne bulunduğu indeks döndürülür
            }
        }
        return -1; // Nesne bulunamazsa -1 döndürülür
    }

    // lastIndexOf(T data): Parametrede verilen nesnenin listedeki son indeksini verir.
    public int lastIndexOf(T data) {
        for (int i = size - 1; i >= 0; i--) {
            if (dizi[i].equals(data)) {
                return i; // Nesne bulunduğu son indeksi döndürülür
            }
        }
        return -1; // Nesne bulunamazsa -1 döndürülür
    }

    // isEmpty(): Liste boş mu değil mi kontrol eder.
    public boolean isEmpty() {
        return size == 0;
    }

    // toArray(): Listedeki öğeleri, aynı sırayla bir array haline getirir.
    public Object[] toArray() {
        return Arrays.copyOf(dizi, size);
    }

    // clear(): Listedeki bütün öğeleri siler, boş liste haline getirir.
    public void clear() {
        Arrays.fill(dizi, null); // Tüm diziyi null yapar
        size = 0; // Eleman sayısını sıfırlıyoruz
    }

    // sublist(int start, int finish): Parametrede verilen indeks aralığına ait bir liste döner.
    public MyList<T> sublist(int start, int finish) {
        if (start < 0 || finish >= size || start > finish) {
            throw new IndexOutOfBoundsException("Geçersiz indeks aralığı.");
        }
        MyList<T> sublist = new MyList<>(finish - start + 1);
        for (int i = start; i <= finish; i++) {
            sublist.add((T) dizi[i]);
        }
        return sublist;
    }

    // contains(T data): Parametrede verilen değerin dizide olup olmadığını kontrol eder.
    public boolean contains(T data) {
        return indexOf(data) != -1; // Nesne varsa true, yoksa false döndürür
    }
}