package com.apostit.ruletka.client;

import java.util.HashMap;

/**
 * Конвертирование
 */
public class Converter {

    static HashMap<String, String> map = new HashMap<String, String>();

    static {
        map.put("XS", "40-42");
        map.put("S", "42-44");
        map.put("M", "44-46");
        map.put("L", "48-50");
        map.put("XL", "52-54");
        map.put("XXL", "54-56");
        map.put("XXXL", "56-58");
    }

    public static String[] getCountries() {
        return new String[]{"США", "Европа", "Россия"};
    }

    public static String go(String from, String to, String src) {
        return map.get(src);
    }

    public static String[] getKinds() {
        return new String[]{"Мужская одежда", "Мужская обувь", "Женская одежда", "Женская обувь"};
    }

    public static String[] getSizes() {
        return new String[]{"XS", "S", "M", "L", "XL", "XXL", "XXXL"};
    }
}
