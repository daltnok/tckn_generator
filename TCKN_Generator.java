/*
TC kimlik numarasının son rakamı çift olmak zorundadır.
0 rakamı ile başlayamaz. ilk 10 rakamın toplamının birler basamağı, 11. rakamı vermektedir.
Ayrıca; 1, 3, 5, 7 ve 9. rakamın toplamının 7 katı ile 2, 4, 6 ve 8. rakamın toplamının
9 katının toplamının birler basamağı 10. rakamı; 1, 3, 5, 7 ve 9. rakamın toplamının
8 katının birler basamağı 11. rakamı vermektedir.

 */
public class TCKN_Generator {

    int[] rakamlar;

    public TCKN_Generator() {
        // Class çağırıldığı an itibariyle consturctor içindeki tüm kodlar çalıştırılır.
        // Bu örneğimizde de, class çağırıldığı an, basamakoluştur ve sonikihesapla metodlarımızı çağırıyoruz.
        // böylelikle, main içinde türettiğimiz class içinde, tek tek mehtod call ihtiyacımız kalmıyor.
        basamakOlustur();
        sonIkiHesapla();
    }

    @Override
    public String toString() {
        String sonuc = "";
        for (int herbiri : this.rakamlar) {
            sonuc += herbiri + "";
        }
        return "Üretilen TCKN: " + sonuc;
    }

    public static void main(String[] args) {
        TCKN_Generator tcknGenerator = new TCKN_Generator();
//        System.out.println(Arrays.toString(tcknGenerator.rakamlar));
        System.out.println(tcknGenerator);
    }


    public void basamakOlustur() {
        this.rakamlar = new int[11];
        for (int i = 0; i < 9; i++) {
            this.rakamlar[i] = (int) randomNumberGenerator(i);
        }

    }

    public static double randomNumberGenerator(int basamak) {
        int ilk = 0;
        if (basamak == 0) {
            ilk = 1;
        }
        int son = 9;

        return Math.random() * (son - ilk) + ilk;
    }

    public void sonIkiHesapla() {
        int tekler = 0, ciftler = 0, onuncu = 0, toplam = 0;
        for (int i = 0; i < 9; i++) {
            if (i % 2 == 0) {
                tekler += (this.rakamlar[i]) * 7;
            } else {
                ciftler += (this.rakamlar[i]) * 9;
            }
            toplam += rakamlar[i];
        }
        onuncu = tekler + ciftler;
        int onuncurakam = onuncu % 10;
        this.rakamlar[9] = onuncurakam;
        this.rakamlar[10] = (toplam + onuncurakam) % 10;
    }


    public static double randomNumberGeneratorWithBoolean(boolean ilksayi) {
        int ilk = 0;
        if (ilksayi) {
            ilk = 1;
        }
        int son = 9;

        return Math.random() * (son - ilk);
    }



}
