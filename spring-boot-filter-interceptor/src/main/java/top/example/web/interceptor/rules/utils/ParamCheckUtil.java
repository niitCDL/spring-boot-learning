package top.example.web.interceptor.rules.utils;

import top.example.web.interceptor.rules.CheckType;

import java.util.regex.Pattern;

public class ParamCheckUtil {

    private static final String EMAIL_REGEX = "^([\\w-\\.]+)@((\\[[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\.)|(([\\w-]+\\.)+))([a-zA-Z]{2,4}|[0-9]{1,3})(\\]?)$";

    private static final String PHONE_REGEX = "^((13[0-9])|(15[^4,\\D])|(18[0,5-9]))\\d{8}$";


    public static boolean verifyParam(Object verityVaule, boolean notNull, CheckType type, String value) {
        if (null == verityVaule) {
            return !notNull;
        }
        switch(type) {
            case INT_MAX:
                return verifyIntMax(verityVaule, value);
            case INT_MIN:
                return verifyIntMin(verityVaule, value);
            case EMAIL:
                return verifyByRegex(verityVaule, EMAIL_REGEX);
            case PHONE:
                return verifyByRegex(verityVaule, PHONE_REGEX);
            case REGULAR_MATCH:
                return verifyByRegex(verityVaule, value);
            default:
                return false;
        }
    }

    public static void main(String args[]) {
        System.out.println(CheckType.INT_MAX);


        String e1 = "dfasfdasfasd";
        String e2 = "4329438@qq.com";
        String e3 = "sdfsdfsdf@sdf.sdf";
        System.out.println(verifyByRegex(e1, EMAIL_REGEX));
        System.out.println(verifyByRegex(e2, EMAIL_REGEX));
        System.out.println(verifyByRegex(e3, EMAIL_REGEX));


        String p1 = "dfjasodfjo23";
        String p2 = "3423432";
        String p3 = "13545676789";
        String p4 = "34543454332";
        System.out.println(verifyByRegex(p1, PHONE_REGEX));
        System.out.println(verifyByRegex(p2, PHONE_REGEX));
        System.out.println(verifyByRegex(p3, PHONE_REGEX));
        System.out.println(verifyByRegex(p4, PHONE_REGEX));


    }

    public static boolean verifyByRegex(Object verityValue, String regex) {
        return Pattern.matches(regex,verityValue.toString());
    }

    public static boolean verifyIntMax(Object verityValue, String value) {
        return Integer.parseInt(verityValue.toString()) <= Integer.parseInt(value);
    }

    public static boolean verifyIntMin(Object verityValue, String value) {
        return Integer.parseInt(verityValue.toString()) >= Integer.parseInt(value);
    }
}
