public class App {
    public static void main(String[] args) throws Exception {
        /*
         * Dugum d1 = new Dugum();
         * d1.yazdir();
         * 
         * Dugum d2 = new Dugum(5);
         * d2.yazdir();
         * 
         */

        TBListe myList = new TBListe();

        myList.listele();

        myList.basaEkle(10);
        myList.basaEkle(20);
        myList.sonaEkle(40);
        myList.basaEkle(5);
        myList.sonaEkle(30);

        Dugum dugum=new Dugum(50);
        myList.basaEkle(dugum);

        Dugum dugum2=new Dugum(60);
        myList.basaEkle(dugum2);


        myList.listele();

        int sil = 80;
        int sonuc = myList.elemanSil(sil);
        if(sonuc ==0){
            System.out.println("Silindi");
        }
        else if(sonuc == -1){
            System.out.println("Liste boş");
        }
        else if(sonuc == -2){
            System.out.println("Listede silenecek olan bulunamadı");
        }

        TBListe anotherList = new TBListe();

        anotherList.basaEkle(10);
        anotherList.basaEkle(10);
        anotherList.basaEkle(10);
        anotherList.basaEkle(10);
        anotherList.basaEkle(10);
        anotherList.basaEkle(10);
        anotherList.basaEkle(15);
        
        System.out.println(anotherList.kacTaneVar(15)); 


 


        System.out.println("-------------------------");
        
        anotherList.hepsiniSil(10);

    }
}
