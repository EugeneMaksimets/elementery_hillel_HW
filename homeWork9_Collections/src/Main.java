import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Main {

    private static Information dataBase;
    private static Information updateDataBase;
    private static final String NEW_USER_STRING = "newUser";
    private static final String ERROR_MAIL = " you cannot use this mail";

    public static void main(String[] args) {
        InitializationData initializationData = new InitializationData();
        dataBase = initializationData.creatingDataBase();
        updateDataBase = addUserInDataBase(listNum(), dataBase);
        print();
    }

    private static List<Integer> listNum() {
        int num = 0;
        List<Integer> arrayListWithNum = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            num += 1;
            arrayListWithNum.add(num);
        }
        return arrayListWithNum;
    }

    private static Information addUserInDataBase(List<? extends Number> arrayListNum, Information dataBase) {
        int count = 0;
        for (int i = 0; i < arrayListNum.size(); i++) {
            String newUser = NEW_USER_STRING + arrayListNum.get(count).toString();
            String newMail = newUser + InitializationData.MAIL_STRING;
            count++;
            if (mailFlag(newMail)) {
                System.out.println(newMail + ERROR_MAIL);
            } else {
                dataBase.list.add(newUser);
                dataBase.set.add(newMail);
                dataBase.map.put(newMail, newUser);
            }

        }
        return dataBase;
    }

    private static boolean mailFlag(String newMail) {
        boolean result = false;
        Iterator<String> iterator = dataBase.set.iterator();
        while (iterator.hasNext()) {
            String nextStr = iterator.next();
            if (nextStr.equals(newMail)) {
                result = true;
            }
        }
        return result;
    }

    public static void print() {

        System.out.println(updateDataBase.map.get("newUser1@mail.com"));
        System.out.println(updateDataBase.list.size());
        System.out.println(updateDataBase.set.size());
        System.out.println(updateDataBase.map.size());
        System.out.println(updateDataBase.list);
        System.out.println(updateDataBase.set);
        System.out.println(updateDataBase.map);
    }

}
