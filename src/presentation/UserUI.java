package presentation;

import application.UserLogic;
import data.AccountDB;
import data.HistoryDB;
import entity.User;
import entity.History;
import entity.Account;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

public class UserUI {
    Scanner scanner = new Scanner(System.in);
    UserLogic userLogic = new UserLogic();
    User loginUser;

    public String userApp(User user) {
        loginUser = user;
        while (true) {
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
        System.out.println("===========출금을 선택하셨습니다===========");
        System.out.println("==========고객님의 계좌정보 입니다==========");
        List<Account> accounts = userLogic.findAccountInfo(loginUser);

        int index = 0;
        for (Account account : accounts) {
            System.out.print(index + " : " + account.getAccountNum());
            index++;
        }
        System.out.print("출금할 계좌의 순서번호를 입력해주세요 : ");
        String num = scanner.nextLine();

        System.out.printf("출금할 금액을 입력해주세요 : ");
        String money = scanner.nextLine();
        try {
            History history = userLogic.createWithdrawHistory(accounts.get(Integer.parseInt(num) -1) , money);
            System.out.println("입급에 성공하셨습니다.");
            System.out.print("현재 잔액 : ");

        }catch(Exception e){
            String string = e.getMessage();
            System.out.println("잔액이 부족합니다");

        }
        finally {
            while(true) {
                System.out.println("돌아가시려면 0번을 눌러주세요");
                String in = scanner.nextLine();
                if(in == "0"){
                    return;
                }
            }
        }

    }

    private void showAccountInfo() {
    }

    private void showHistories() {
    }

    private void makeAccount() {

    }
}
