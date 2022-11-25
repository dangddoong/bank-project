package presentation;

import application.UserLogic;
import entity.Account;
import entity.User;

import java.util.List;
import java.util.Scanner;

public class UserUI {
    Scanner scanner = new Scanner(System.in);
    UserLogic userLogic = new UserLogic();
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
            switch (scanner.nextLine()) {
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
    }

    private void withdrawMoney() {

    }

    private void showAccountInfo() {
    }

    private void showHistories() {
    }

    private void makeAccount() {
        System.out.println("현재 소유하고 계신 계좌 목록입니다.");
        List<Account> accountList = userLogic.getMyAccounts(loginUser);
        for (int i = 0; i < accountList.size(); i++) {
            System.out.println((i+1) + ". " + accountList.get(i).getAccountNum());
        }
        System.out.println("계좌를 새로 생성하시려면 y 를 입력해주세요: ");
        if(scanner.nextLine().equals("y")) {
            userLogic.makeAccount(loginUser);
        }
        message = "정상적으로 처리되었습니다.";
    }
}
