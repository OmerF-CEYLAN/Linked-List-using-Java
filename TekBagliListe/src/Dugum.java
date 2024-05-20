public class Dugum {
    private int veri;

    private Dugum sonraki;// veri tipi Dugum
    // çünkü her düğümden sonra gelen yine düğümdür

    public Dugum() {
        this.veri = 0; // yapılandırıcı metod
        this.sonraki = null;
    }

    public Dugum(int deger) {
        this.veri = deger;
        this.sonraki = null;
    }

    public void yazdir() {
        System.out.println(" " + this.veri);
    }

    public int getVeri() {
        return this.veri; // herhangi bir düğümün sakladığı veriyi öğrenmek için
    }

    public void setVeri(int deger) {
        this.veri = deger;
    }

    public Dugum getSonraki() {
        return this.sonraki;
    }

    public void setSonraki(Dugum ref) {
        this.sonraki = ref;
    }

}
