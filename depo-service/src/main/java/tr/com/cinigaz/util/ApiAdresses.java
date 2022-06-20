package tr.com.cinigaz.util;



public class ApiAdresses {
    public static final class DepoControllerAdress {
        public static final String ANA = "depo";
        public static final String EKLE = "/ekle";
        public static final String TUMLISTE = "/tumliste";
        public static final String DEGISTIR = "/guncelle/{depoId}";
        public static final String SIL = "/sil/{depoId}";
        public static final String CEK = "/getir/{depoId}";
        public static final String IDCEK = "/getirid/{depoId}";
        public static final String ADICEK = "/depoadicek/{depoAdi}";

    }
}