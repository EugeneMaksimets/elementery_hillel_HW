package eugene_maksimets;

import eugene_maksimets.utils.StringBuilder;

public class Main {

    public static void main(String[] args) {
        String str = "someMail";
        char[] arr = {'a', 'b', 'c', 'd', 'e', 'f'};
        char[] arr2 = {};
        String str2 = "   ";
        char[] arr3 = null;

        System.out.println(InfoFieldsValidation.mailValidation(str + "@gmail.com"));
        System.out.println(InfoFieldsValidation.mailValidation(str + "@correct.com"));
        System.out.println(InfoFieldsValidation.mailValidation(str + "@anotherCorrect.ru"));
        System.out.println(InfoFieldsValidation.mailValidation(str + "@inco/rrect.ru"));
        System.out.println(InfoFieldsValidation.phoneValidator("+380986717294"));
        System.out.println(InfoFieldsValidation.birthDayValidation("25.07.1995"));
        System.out.println(InfoFieldsValidation.birthDayValidation("32.07.1995"));
        System.out.println(StringBuilder.buildString(str, arr));
        System.out.println(StringBuilder.buildString(str2, arr2));
        System.out.println(StringBuilder.buildString(str, arr3));
    }
}

