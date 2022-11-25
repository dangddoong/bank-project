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

    //            입금
    private void depositMoney() {
        int deposit;
        int idx;

        System.out.println("\n계좌목록\n");
        List<Account> accounts = userLogic.findAccountInfo(loginUser);
        for (int i = 0; i < accounts.size(); i++) {
            System.out.println((i + 1) + ". " + accounts.get(i).getAccountNum());
        }

        System.out.print("\n입금 계좌를 선택하세요. : ");
        idx = Integer.parseInt(scanner.nextLine());
        while (idx <= 0) {
            System.out.print("\n잘못된 계좌입니다. 다시 입력하세요. : ");
            idx = Integer.parseInt(scanner.nextLine());
        }
        Account account = accounts.get(idx - 1);

        System.out.print("\n입금액을 입력하세요. : ");
        deposit = Integer.parseInt(scanner.nextLine());
        while (deposit <= 0) {
            System.out.print("\n잘못된 금액입니다. 다시 입력하세요. : ");
            deposit = Integer.parseInt(scanner.nextLine());
        }

        userLogic.depositMoney(deposit, account);
        System.out.println("\n입금 완료\n");
        System.out.println("현재 잔액 : " + account.getAccountBalance() + "원");
        message = "";
    }

    //           출금
    private void withdrawMoney() {
        System.out.println("===========출금을 선택하셨습니다===========");
        System.out.println("==========고객님의 계좌정보 입니다==========");
        List<Account> accounts = userLogic.findAccountInfo(loginUser);

        int index = 0;
        for (Account account : accounts) {
            System.out.print(index + " : " + account.getAccountNum());
            index++;
        }
        System.out.println("출금 계좌를 선택해주세요 : ");
        String num = scanner.nextLine();

        System.out.println("출금할 금액을 입력해주세요 : ");
        String money = scanner.nextLine();
        try {
            History history = userLogic.createWithdrawHistory(accounts.get(Integer.parseInt(num) - 1), money);
            System.out.println("입급에 성공하셨습니다.");
            System.out.print("현재 잔액 : " + history.getMoney() + "원");

        } catch (Exception e) {
            String string = e.getMessage();
            System.out.println("잔액이 부족합니다");

        } finally {
            while (true) {
                System.out.println("돌아가시려면 0번을 눌러주세요");
                String in = scanner.nextLine();
                if (in == "0") {
                    return;
                }
            }
        }

    }

    private void showAccountInfo() {
        System.out.println("사용자 정보입니다");
        System.out.println("사용자 아이디 :" + loginUser.getUserID());
        System.out.println("사용자 이름 : " + loginUser.getUserName());
        System.out.println("사용자 계좌 정보입니다.");
        List<Account> accountList = userLogic.getMyAccounts(loginUser);
        for (int i = 0; i < accountList.size(); i++) {
            System.out.println((i+1) + ". " + accountList.get(i).getAccountNum() +
                    ", 잔액 : " + accountList.get(i).getAccountBalance()) ;
        }
        System.out.println("0을 입력하시면 원래 화면으로 돌아갑니다.");
        if(scanner.nextLine().equals("0")) {
            return;
        }
        showAccountInfo();
    }

    private void showHistories() {
        System.out.println("현재 소유하고 계신 계좌 목록입니다.");
        List<Account> accountList = userLogic.getMyAccounts(loginUser);
        for (int i = 0; i < accountList.size(); i++) {
            System.out.println((i+1) + ". " + accountList.get(i).getAccountNum());
        }
        try {
            System.out.println("계좌 거래 내역 조회 할 계좌의 순서번호를 입력해주세요.");
            int accountChoiceNum = Integer.parseInt(scanner.nextLine());
            String accountNum = accountList.get(accountChoiceNum - 1).getAccountNum();
            System.out.println("요청하신 계좌의 거래 내역입니다.");
            List<History> HistoryList = userLogic.getAccountHistory(accountNum);
            for (int i = 0; i < HistoryList.size(); i++) {
                History history = HistoryList.get(i);
                System.out.println((i + 1) + ". 거래시간: " + history.getTradeDate() + ", 계좌번호: " + history.getAccountNum() + ", 거래타입: " + history.getTradeType() + ", 잔고: " + history.getMoney() + ", 은행명: " + history.getBankName());
            }
        }catch (Exception e){
            System.out.println("잘못 입력하셨습니다.");
        }finally {
            System.out.println("원래 화면으로 돌아가고 싶으시면 아무 키나 입력해주세요.");
            scanner.nextLine();
            }
        }


    private void makeAccount() {
        System.out.println("현재 소유하고 계신 계좌 목록입니다.");
        List<Account> accountList = userLogic.getMyAccounts(loginUser);
        for (int i = 0; i < accountList.size(); i++) {
            System.out.println((i + 1) + ". " + accountList.get(i).getAccountNum());
        }
        System.out.println("계좌를 새로 생성하시려면 y 를 입력해주세요: ");
        if (scanner.nextLine().equals("y")) {
            userLogic.makeAccount(loginUser);
            message = "정상적으로 처리되었습니다.";
            return;
        }
        message = "생성 취소";
    }
}
