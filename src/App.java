import application.AdminLogic;
import application.UserLogic;
import entity.Account;
import entity.User;
import presentation.AdminUI;
import presentation.UserUI;

import java.util.Scanner;

import static printer.Printer.*;

public class App {
    static Scanner scanner = new Scanner(System.in);
    static String message = "";
    static UserLogic userLogic = UserLogic.getInstance();
    static AdminLogic adminLogic = AdminLogic.getInstance();
    static UserUI userUI = new UserUI();
    static AdminUI adminUI = new AdminUI();

    public static void main(String[] args) {
        initData();
        while (true) {
            clearCmd();
            println(BLANK + message);
            println(BLANK + HEADER_HOME);
            println(BLANK + LIST_HOME1);
            println(BLANK + LIST_HOME2);
            println(BLANK + LIST_HOME0);
            println(BLANK + FOOTER);
            print(BLANK + ENTER_TASK_NUM);
            switch (scanner.nextLine()) {
                case "1" -> signUp();
                case "2" -> login();
                case "0" -> System.exit(0);
                default -> message = MESSAGE_WRONG_INPUT;
            }
        }
    }

    static void initData() {
        User user = new User("sparta", "sparta", "르탄이", false);

        userLogic.signUp("김철수", "cheolsoo", "cheolsoo");
        userLogic.signUp("강민희", "minhee", "cheolsoo");
        userLogic.signUp("이민수", "minsoo", "minsoo");
        Account account = userLogic.signUp(user.getUserName(), user.getUserID(), user.getPassWord());
        adminLogic.signUp("슈퍼르탄이", "admin_sparta", "admin_sparta");
        adminLogic.signUp("은행 지점장", "admin_bank", "admin_bank");
        userLogic.depositMoney(5000, account);
        userLogic.validateWithdrawAndDoLogic(account, 500);
        userLogic.makeAccount(user);
        userLogic.makeAccount(user);
        userLogic.depositMoney(30000, account);
        userLogic.depositMoney(2000, account);
        userLogic.validateWithdrawAndDoLogic(account, 5000);
        userLogic.depositMoney(7000, account);
        userLogic.validateWithdrawAndDoLogic(account, 20000);
    }

    static void signUp() {
        clearCmd();
        println(BLANK + HEADER_SIGN_UP);
        print(BLANK + ENTER_NAME);
        String name = scanner.nextLine();
        print(BLANK + ENTER_ID);
        String id = scanner.nextLine();
        print(BLANK + ENTER_PW);
        String pw = scanner.nextLine();
        if (id.startsWith(ADMIN_PREFIX)) {
            try {
                adminLogic.signUp(name, id, pw);
                message = MESSAGE_SUCCESS_SIGNUP;
            } catch (Exception e) {
                if (e.getMessage().equals(EXCEPTION_DOUBLE_ID)) {
                    message = MESSAGE_DOUBLE_ID;
                } else {
                    message = MESSAGE_WRONG_INPUT;
                }
            }
        } else {
            try {
                userLogic.signUp(name, id, pw);
                message = MESSAGE_SUCCESS_SIGNUP;
            } catch (Exception e) {
                if (e.getMessage().equals(EXCEPTION_DOUBLE_ID)) {
                    message = MESSAGE_DOUBLE_ID;
                } else {
                    message = MESSAGE_WRONG_INPUT;
                }
            }
        }
    }

    static void login() {
        clearCmd();
        println(BLANK + HEADER_LOGIN);
        print(BLANK + ENTER_ID);
        String id = scanner.nextLine();
        print(BLANK + ENTER_PW);
        String pw = scanner.nextLine();
        if (id.startsWith(ADMIN_PREFIX)) {
            try {
                User user = adminLogic.login(id, pw);
                adminUI.adminApp(user);
                message = MESSAGE_SUCCESS_LOGOUT;
            } catch (Exception e) {
                if (e.getMessage().equals(EXCEPTION_NO_ID)) {
                    message = MESSAGE_NO_ID;
                } else if (e.getMessage().equals(EXCEPTION_WRONG_PW)) {
                    message = MESSAGE_WRONG_PW;
                } else {
                    message = MESSAGE_WRONG_INPUT;
                }
            }
        } else {
            try {
                User user = userLogic.login(id, pw);
                userUI.userApp(user);
                message = MESSAGE_SUCCESS_LOGOUT;
            } catch (Exception e) {
                if (e.getMessage().equals(EXCEPTION_NO_ID)) {
                    message = MESSAGE_NO_ID;
                } else if (e.getMessage().equals(EXCEPTION_WRONG_PW)) {
                    message = MESSAGE_WRONG_PW;
                } else {
                    message = MESSAGE_WRONG_INPUT;
                }
            }
        }
    }
}
