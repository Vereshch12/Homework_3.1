public class Data {
    private String login;
    private String password;
    private String confirmPasword;

    public Data(String login, String password, String confirmPasword) throws WrongLoginException, WrongPasswordException {
        checkRegistrationParameters(login, password, confirmPasword);
        this.login = login;
        this.password = password;
        this.confirmPasword = confirmPasword;
    }

    private static boolean checkSymbols(String line){
        for (int i = 0; i < line.length(); i++) {
            if (!((line.charAt(i) >= 'a' && line.charAt(i) <= 'z') ||
                    (line.charAt(i) >= 'A' && line.charAt(i) <= 'Z') ||
                    (line.charAt(i) >= '0' && line.charAt(i) <= '9') ||
                    line.charAt(i) == '_')) {
                return false;
            }
        }
        return line.length() <= 20 && line.length() >= 1;
    }

    public static void checkRegistrationParameters(String login, String password, String confirmPasword) throws WrongLoginException, WrongPasswordException {
        if (!checkSymbols(login)){
            throw new WrongLoginException("Неправильно задан логин");
        }
        if (!(checkSymbols(password) && password.equals(confirmPasword))){
            throw new WrongPasswordException("Неправильно задан пароль, либо пароли не совпадают");
        }
    }


}
