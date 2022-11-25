package presentation;

import application.UserLogic;
import entity.Account;
import entity.History;
import entity.User;

import java.util.List;
import java.util.Scanner;

public class UserUI {
    Scanner scanner = new Scanner(System.in);
    UserLogic userLogic = UserLogic.getInstance();
    User loginUser;
    String message = "";

    public String userApp(User user) {
        loginUser = user;
        while (true) {
            System.out.println(message);
            System.out.println(loginUser.getUserName() + " 님 환영합니다!");
            System.out.println("==== 조미김 은행 회원 페이지 ====");
            System.out.println("1. 입금하기");
            System.out.println("2. 출금하기");
            System.out.println("3. 계좌 정보 조회하기");
            System.out.println("4. 계좌 거래 내역 조회하기");
            System.out.println("5. 계좌 생성하기");
            System.out.println("0. 로그아웃");
            System.out.println("===================================");
            switch (scanAndGetString()) {
                case "1" -> depositMoney();
                case "2" -> withdrawMoney();
                case "3" -> showAccountInfo();
                case "4" -> showHistories();
                case "5" -> makeAccount();
                case "0" -> {
                    return "정상적으로 로그아웃 되었습니다!";
                }
            }
        }
    }

    private void depositMoney() {
        Account account = showAccountsAndScanIdxAndGetAccount();
        System.out.print("입금액을 입력하세요. : ");
        int money = scanAndGetParsedInt();
        if(money == -1) {
            setMessage("잘못된 입력입니다.");
            return;
        }
        userLogic.depositMoney(money, account);
        setMessage("정상적으로 처리되었습니다.");
    }

    private void withdrawMoney() {
        System.out.println("===========출금을 선택하셨습니다===========");
        Account account = showAccountsAndScanIdxAndGetAccount();
        System.out.println("해당 계좌의 잔액: " + account.getAccountBalance());
        System.out.println("출금할 금액을 입력해주세요 : ");
        int money = scanAndGetParsedInt();
        if(money == -1) {
            setMessage("잘못된 입력입니다.");
            return;
        }
        if(userLogic.validateWithdrawAndDoLogic(account, money)) {
            setMessage("정상적으로 처리되었습니다.");
        } else {
            setMessage("잔액이 부족합니다.");
        }
    }

    private void showAccountInfo() {
        System.out.println("===사용자 정보 페이지입니다.===");
        System.out.println("사용자 아이디 :" + loginUser.getUserID());
        System.out.println("사용자 이름 : " + loginUser.getUserName());
        System.out.println("사용자 계좌 정보입니다.");
        List<Account> accountList = userLogic.getMyAccounts(loginUser);
        for (int i = 0; i < accountList.size(); i++) {
            System.out.println((i+1) + ". " + accountList.get(i).getAccountNum() +
                    ", 잔액 : " + accountList.get(i).getAccountBalance());
        }
        System.out.print("뒤로 돌아가시려면 0을 입력해주세요: ");
        if(scanAndGetString().equals("0")) {
            return;
        }
        showAccountInfo();
    }

    private void showHistories() {
        Account account = showAccountsAndScanIdxAndGetAccount();
        System.out.println("요청하신 계좌의 거래 내역입니다.");
        List<History> HistoryList = userLogic.getAccountHistory(account.getAccountNum());
        for (int i = 0; i < HistoryList.size(); i++) {
            History history = HistoryList.get(i);
            System.out.println((i + 1) + ". 거래타입: " + history.getTradeType() +
                                         ", 거래시간: " + history.getTradeDate() +
                                         ", 거래 금액: " + history.getMoney() +
                                         ", 잔고: " + history.getMoney() + // TODO: 2022/11/25 잔고도 출력되도록
                                         ", 은행명: " + history.getBankName());
//                                       ", 계좌번호: " + history.getAccountNum(); TODO: 몇번계좌인지 이미선택했는데 나와야하나?

        }
        System.out.println("뒤로 가고싶으시면 0을 입력해주세요");
        if (! scanAndGetString().equals("0")) {
            showHistories();
        }
    }

    private void makeAccount() {
        System.out.println("현재 소유하고 계신 계좌 목록입니다.");
        List<Account> accountList = userLogic.getMyAccounts(loginUser);
        for (int i = 0; i < accountList.size(); i++) {
            System.out.println((i + 1) + ". " + accountList.get(i).getAccountNum());
        }
        System.out.print("계좌를 새로 생성하시려면 y 를 입력해주세요: ");
        if (scanAndGetString().equals("y")) {
            userLogic.makeAccount(loginUser);
            setMessage("요청이 정상적으로 처리되었습니다!");
            return;
        }
        message = "요청이 취소되었습니다!";
    }

    private Account showAccountsAndScanIdxAndGetAccount() {
        System.out.println("소유하고 계신 계좌 목록입니다.");
        List<Account> accounts = userLogic.getMyAccounts(loginUser);
        for (int i = 0; i < accounts.size(); i++) {
            System.out.println((i + 1) + ". " + accounts.get(i).getAccountNum());
        }
        System.out.print("처리를 진행할 계좌의 번호를 선택하세요 : ");
        int idx = scanAndGetParsedInt();
        if(idx == -1) {
            setMessage("잘못된 입력입니다.");
            userApp(loginUser);
        }
        Account account = null;
        try {
            account = accounts.get(idx - 1);
        } catch (Exception e) {
            setMessage("잘못된 입력입니다.");
            userApp(loginUser);
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
        int idx = 0;
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
