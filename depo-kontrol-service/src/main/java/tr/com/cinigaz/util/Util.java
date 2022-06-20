package tr.com.cinigaz.util;

public final class Util {
    public static String setValuesIfNullForString(String gelen, String eklenen ) {
        if (gelen == null) {
            return "";
        } else {
            return gelen+eklenen;
        }
    }
}
