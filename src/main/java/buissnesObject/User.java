package buissnesObject;

    public enum User {

        PROTON_LOGIN("automationTest@protonmail.com", "test123456"),
        ANOTHER_PROTON_LOGIN("qwerty", "qwerty");

        private final String userName;
        private final String userPassword;

        User(String userName, String userPassword) {
            this.userName = userName;
            this.userPassword = userPassword;
        }


           public String getUSERNAME() {
        return userName;
    }

    public String getUSERPASSWORD() {
        return userPassword;
    }
}
