package tr.com.cinigaz.util;

public class ApiAdresses {

    public static final class UrunControllerAdress {
        public static final String ANA = "urun";
        public static final String EKLE = "/ekle";
        public static final String TUMLISTE = "/tumliste";
        public static final String DEGISTIR = "/guncelle/{urunId}";
        public static final String SIL = "/sil/{urunId}";
        public static final String CEK = "/getir/{urunId}";
        public static final String ADICEK = "/urunadicek/{urunAdi}";
        public static final String URUNKODUCEK = "/urunkodu/{urunKodu}";
        public static final String URUNCEK = "/uruncek/{urunTipId}";
        public static final String URUNTIPIDCEK = "/uruntipid/{urunTipId}";

        /*public static final String DEPODANURUNCEK = "/depodanuruncek/{depoId}"; // ürün bu depo da var mı diye bakılcak

* */
    }
}