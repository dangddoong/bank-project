package presentation;

import application.UserLogic;
import entity.Account;
import entity.History;
import entity.User;

import java.util.List;
import java.util.Scanner;

import static printer.Printer.*;

public class UserUI {
    Scanner scanner = new Scanner(System.in);
    UserLogic userLogic = UserLogic.getInstance();
    User loginUser;
    String message;

    public void userApp(User user) {
        loginUser = user;
        message = "";
        while (true) {
            clearCmd();
            println(BLANK + message);
            println(BLANK + BLANK_HALF + loginUser.getUserName() + HEADER_USER_WELCOME);
            println(BLANK + HEADER_USER);
            println(BLANK + USER_LIST1);
            println(BLANK + USER_LIST2);
            println(BLANK + USER_LIST3);
            println(BLANK + USER_LIST4);
            println(BLANK + USER_LIST5);
            println(BLANK + USER_LIST0);
            println(BLANK + FOOTER);
            print(BLANK + ENTER_TASK_NUM);
            switch (scanAndGetString()) {
                case "1" -> depositMoney();
                case "2" -> withdrawMoney();
                case "3" -> showAccountInfo();
                case "4" -> showHistories();
                case "5" -> makeAccount();
                case "0" -> {
                    return;
                }
                default -> setMessage(MESSAGE_WRONG_INPUT);
            }

        }
    }

    private void depositMoney() {
        clearCmd();
        println(BLANK + HEADER_DEPOSIT);
        Account account = showAccountsAndScanIdxAndGetAccount();
        if (account == null) {
            setMessage(MESSAGE_WRONG_INPUT);
            return;
        }
        System.out.print(BLANK + ENTER_MONEY);
        int money = scanAndGetParsedInt();
        if (money == -1) {
            setMessage(MESSAGE_WRONG_INPUT);
            return;
        }
        userLogic.depositMoney(money, account);
        setMessage(MESSAGE_SUCCESS_LOGIC);
    }

    private void withdrawMoney() {
        clearCmd();
        println(BLANK + HEADER_WITHDRAW);
        Account account = showAccountsAndScanIdxAndGetAccount();
        if (account == null) {
            setMessage(MESSAGE_WRONG_INPUT);
            return;
        }
        println(BLANK + ACCOUNT_BLANCE + account.getAccountBalance());
        print(BLANK + ENTER_MONEY);
        int money = scanAndGetParsedInt();
        if (money == -1) {
            setMessage(MESSAGE_WRONG_INPUT);
            return;
        }
        if (userLogic.validateWithdrawAndDoLogic(account, money)) {
            setMessage(MESSAGE_SUCCESS_LOGIC);
        } else {
            setMessage(MESSAGE_WRONG_INPUT);
        }
    }

    private void showAccountInfo() {
        clearCmd();
        println(BLANK + HEADER_SHOW_ACCOUNT_INFO);
        println(BLANK + USER_ID + loginUser.getUserID());
        println(BLANK + USER_NAME + loginUser.getUserName());
        println(BLANK + ACCOUNT_LIST);
        List<Account> accountList = userLogic.getMyAccounts(loginUser);
        for (int i = 0; i < accountList.size(); i++) {
            println(BLANK + (i + 1) + ". " + accountList.get(i).getAccountNum() + BALANCE + accountList.get(i).getAccountBalance());
        }
        println(BLANK + FOOTER);
        print(BLANK + ENTER_ANYKEY_TO_BACK);
        scanAndGetString();
        setMessage(MESSAGE_SUCCESS_LOGIC);
    }

    private void showHistories() {
        clearCmd();
        Account account = showAccountsAndScanIdxAndGetAccount();
        if (account == null) {
            setMessage(MESSAGE_WRONG_INPUT);
            return;
        }
        clearCmd();
        println(BLANK + HISTORY_LIST);
        List<History> HistoryList = userLogic.getAccountHistory(account.getAccountNum());
        for (int i = 0; i < HistoryList.size(); i++) {
            History history = HistoryList.get(i);
            System.out.println(BLANK + (i + 1) + ". 거래타입: " + history.getTradeType() +
                    ", 거래시간: " + history.getTradeDate() +
                    ", 거래 금액: " + history.getMoney() +
                    ", 계좌 잔고: " + history.getAccountBalance() +
                    ", 은행명: " + history.getBankName());
        }
        println(BLANK + FOOTER);
        print(BLANK + ENTER_ANYKEY_TO_BACK);
        scanAndGetString();
        setMessage(MESSAGE_SUCCESS_LOGIC);
    }

    private void makeAccount() {
        clearCmd();
        println(BLANK + HEADER_MAKE_ACCOUNT);
        println(BLANK + ACCOUNT_LIST);
        List<Account> accountList = userLogic.getMyAccounts(loginUser);
        for (int i = 0; i < accountList.size(); i++) {
            System.out.println(BLANK + (i + 1) + ". " + accountList.get(i).getAccountNum());
        }
        println(BLANK + FOOTER);
        if(userLogic.getMyAccounts(loginUser).size() == 5){
            setMessage(MESSAGE_NO_MORE_ACCOUNT);
            return;
        }
        print(BLANK + ENTER_Y_TO_MAKE_ACCOUNT);
        if (scanAndGetString().equals("y")) {
            userLogic.makeAccount(loginUser);
            setMessage(MESSAGE_SUCCESS_LOGIC);
            return;
        }
        setMessage(MESSAGE_STOP_LOGIC);
    }

    private Account showAccountsAndScanIdxAndGetAccount() {
        System.out.println(BLANK + ACCOUNT_LIST);
        List<Account> accounts = userLogic.getMyAccounts(loginUser);
        for (int i = 0; i < accounts.size(); i++) {
            System.out.println(BLANK + (i + 1) + ". " + accounts.get(i).getAccountNum());
        }
        System.out.println(BLANK + FOOTER);
        System.out.print(BLANK + ENTER_ACCOUNT);
        int idx = scanAndGetParsedInt();
        if (idx == -1) {
            setMessage(MESSAGE_WRONG_INPUT);
            return null;
        }
        Account account;
        try {
            account = accounts.get(idx - 1);
        } catch (Exception e) {
            setMessage(MESSAGE_WRONG_INPUT);
            return null;
        }
        return account;
    }

    private void setMessage(String s) {
        message = s;
    }

    private String scanAndGetString() {
        return scanner.nextLine();
    }

    public int scanAndGetParsedInt() {
        String s = scanner.nextLine();
        int idx;
        try {
            idx = Integer.parseInt(s);
            if (idx <= 0) {
                return -1;
            }
        } catch (Exception e) {
            return -1;
        }
        return idx;
    }
}
