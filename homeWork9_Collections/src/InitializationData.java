public class InitializationData {
    private static final String USER_LIST_STR = "user";
    private static final String MAIL_SET_STR = "someMail";
    private static final String MAIL_MAP_STR = "someMapMail";
    private static final String USER_MAP_STR = "someMapUser";
    private static final String USER_LIST_SET_MAP_STR = "userToLogin";
    public static final String MAIL_STRING = "@mail.com"; // public (use in main)
    private static final String ERROR_SIZE = "Error. Size incorrect. DataBase is cleaning";


    public Information creatingDataBase() {
        Information dataBase = new Information();
        int count = 0;
        for (int i = 0; i < 30; i++) {
            String listUser = USER_LIST_STR + count;
            String setUser = MAIL_SET_STR + count + MAIL_STRING;
            String setMapMail = MAIL_MAP_STR + count + MAIL_STRING;
            String setMapUser = USER_MAP_STR + count;
            count++;
            dataBase.list.add(listUser);
            dataBase.set.add(setUser);
            dataBase.map.put(setMapMail, setMapUser);
        }
        for (int i = 0; i < 10; i++) {
            String user = USER_LIST_SET_MAP_STR + count;
            count++;
            dataBase.list.add(user);
            dataBase.set.add(user);
            dataBase.map.put(user, user);
        }
        if (!sizeFlag(dataBase)) {
            System.out.println(ERROR_SIZE);
            cleanData(dataBase);
        }
        return dataBase;

    }

    private static boolean sizeFlag(Information dataBase) {
        boolean flagSize;
        flagSize = dataBase.list.size() == dataBase.set.size() && dataBase.set.size() == dataBase.map.size();
        return flagSize;
    }

    private static void cleanData(Information dataBase) {
        dataBase.set.clear();
        dataBase.list.clear();
        dataBase.map.clear();
    }
}
