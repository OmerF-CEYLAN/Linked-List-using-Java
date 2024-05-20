public class TBListe {
    private Dugum ilk;// listenin başlangıcı tutan değişken

    public TBListe() {
        this.ilk = null; // yapıcı metod constructer
    }

    // listenin başına eleman ekleme
    public void basaEkle(int deger) {
        Dugum yeni = new Dugum(deger);// Dugum yeni = new Dugum(); 2
                                      // yeni.setVeri(deger); adımlı hali
        yeni.setSonraki(this.ilk);// yeşil bağlantı, yeninin sonrakisi ilk oldu
        this.ilk = yeni;// mavi bağlantı, listenin ilk düğümü yeni düğüm oldu
    }

    public void basaEkle(Dugum yeni) {
        yeni.setSonraki(this.ilk);
        this.ilk = yeni;
    }

    // listenin sonuna eleman ekleme
    public void sonaEkle(int deger) {
        Dugum yeni = new Dugum(deger);
        if (this.ilk == null) {
            this.ilk = yeni;
            return;
        }
        Dugum temp = this.ilk;
        while (temp.getSonraki() != null) {
            temp = temp.getSonraki();
        }
        // döngü çıkışında temp en son düğüm üzerine konumlanmıştır
        temp.setSonraki(yeni);
    }

    // listedeki eleman sayısını hesaplama

    public int listeElemanSayısı() {
        int sayac = 0;
        Dugum temp = this.ilk;
        while (temp != null) {
            sayac++;
            temp = temp.getSonraki();
        }
        return sayac;
    }

    // listedeki tüm elemanların değerlerini ekrana yazma
    public void listele() {
        Dugum temp = this.ilk;
        if (temp == null) {
            System.out.println("Liste boş");
            return;
        }
        while (temp != null) {
            temp.yazdir();
            temp = temp.getSonraki();
        }
        System.out.println("------------------");

    }

    // Listede bir değeri arar ve bulunduğunda o düğümü geri döndürür

    public Dugum elemanBul(int deger) {
        Dugum temp = this.ilk;
        Dugum bulunan = null;
        while (temp != null) {
            if (temp.getVeri() != deger) {
                temp = temp.getSonraki();
            } else {
                bulunan = temp;
                break;
            }
        }
        return bulunan;
    }

    // ödev1 aranan değerden listede kaç tane olduğunu geri döndüren fonksiyonu
    // kodlayınız

    public int kacTaneVar(int deger) {
        Dugum temp = this.ilk;
        int sayac = 0;
        while (temp != null) {
            if (temp.getVeri() == deger) {
                sayac++;
            }
            temp = temp.getSonraki();
        }
        return sayac;
    }

    // değeri, listede herhangi bir indekse ekleyen fonksiyon
    public void arayaEkle(int deger, int indis) {
        if ((this.ilk == null) || (indis == 1)) {// liste boş ise başa ekleyecek
            this.basaEkle(deger);
            return;
        }
        Dugum yeni = new Dugum(deger);
        Dugum temp = this.ilk;
        int sayac = 1;

        while (temp.getSonraki() != null) {
            if (sayac + 1 == indis) {
                break;
            }
            sayac++;
            temp = temp.getSonraki();
        }
        yeni.setSonraki(temp.getSonraki());// yeşil bağlantı
        temp.setSonraki(yeni);// mavi bağlantı

    }
    // ödev2 araya ekle fonksiyonunun sona ekle fonksiyonu kulllanacak şekilde
    // revize edilmesi
    
    // ödev3 sıralıEkle fonksiyonu değerleri sayısal olarak sıralı ekleyecek şekilde
    // yazılacak(indis parametresi olmayan)

    public void siraliEkle(int deger){

        Dugum temp = this.ilk;
        Dugum yeni = new Dugum(deger);
        if(this.ilk == null || deger >= this.ilk.getVeri()){
            yeni.setSonraki(this.ilk);
            this.ilk = yeni;
        }
        else{
            while(temp.getSonraki() != null){
                if(deger >= temp.getSonraki().getVeri()){
                    yeni.setSonraki(temp.getSonraki());
                    temp.setSonraki(yeni);
                    break;
                }else if(deger < temp.getSonraki().getVeri()){
                    yeni.setSonraki(temp.getSonraki().getSonraki());
                    temp.getSonraki().setSonraki(yeni);
                    break;
                }
                
            }
            
            
        }
    }

    



    // ödev 4 verilen değeri listeden silen(birden fazla var ise hepsini siler)
    public int hepsiniSil(int deger) {
        int sayac = 0;
        if (this.ilk == null) {
            return -1;
        }
        if (this.ilk.getVeri() == deger) {
            this.ilk = this.ilk.getSonraki();
            sayac++;
        }
        Dugum temp = this.ilk;
        while (temp.getSonraki() != null) {
            if(temp.getSonraki().getVeri() == deger){
                temp.setSonraki(temp.getSonraki().getSonraki());
                sayac++;
            }else
            temp = temp.getSonraki();
        }
        System.out.println(sayac + "  tane veri listeden silindi");
        return 0;
    }




    // verilen değeri listeden silen fonksiyon(birden fazlaysa ilk bulduğunu siler)
    // 1. liste boş olabilir
    // 2. listenin ilk elemanı silinirse liste başı değişecektir
    // 3. silinecek değer listede yoktur silme işlemi gerçekleşmez
    // 4. değer listede vardır ve silinir
    // silme işlemi başarılı ise fonksiyon geriye 0 döndürsün
    // liste boi ise -1 döndürsün
    // eleman bulunmazsa (dolayısıyla silinmezse) -2 döndürsün
    public int elemanSil(int deger) {
        if (this.ilk == null) {
            return -1;
        }
        if (this.ilk.getVeri() == deger) {
            this.ilk = this.ilk.getSonraki();
            return 0;
        }
        Dugum temp = this.ilk;
        while (temp.getSonraki().getVeri() != deger) {
            if (temp.getSonraki().getSonraki() == null) {
                return -2; // aranan eleman yok silinemez
            }
            temp = temp.getSonraki();
        }
        temp.setSonraki(temp.getSonraki().getSonraki());
        return 0;
    }
}
