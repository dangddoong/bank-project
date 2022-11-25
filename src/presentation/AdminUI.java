package presentation;

import application.AdminLogic;
import entity.Account;
import entity.History;
import entity.User;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class AdminUI {
    Scanner scanner = new Scanner(System.in);
    AdminLogic adminLogic = AdminLogic.getInstance();
    User loginUser;
    String message = "";

    public String adminApp(User user) {
        loginUser = user;
        while (true) {
            System.out.println(message);
            System.out.println(loginUser.getUserName() + " 관리자님 환영합니다!");
            System.out.println("==== 조미김 은행 관리자 페이지 ====");
            System.out.println("1. 사용자 정보 수정");
            System.out.println("2. 유저의 계좌 정보 삭제");
            System.out.println("3. 계좌번호로 사용자 찾기");
            System.out.println("4. 소유자명으로 계좌 찾기");
            System.out.println("5. 은행 내 모든 계좌 조회");
            System.out.println("6. 은행 내 모든 거래 내역 조회");
            System.out.println("0. 로그아웃");
            System.out.println("===================================");
            switch (scanner.nextLine()) {
                case "1" -> changeUserPassword();
                case "2" -> deleteAccount();
                case "3" -> findUserByAccountNumber();
                case "4" -> findAccountsByUserId();
                case "5" -> findAllAccounts();
                case "6" -> findAllHistories();
                case "0" -> {
                    return "정상적으로 로그아웃 되었습니다!";
                }
                default -> message = "잘못된 입력입니다.";
            }
        }
    }

    private void changeUserPassword() {
        System.out.println("변경하려는 유저 id 입력해주세요");
        String userId = scanner.nextLine();
        System.out.println("새로운 비밀번호를 입력해주세요");
        String newPassword = scanner.nextLine();
        adminLogic.changeUserPw(userId, newPassword);
    }

    private void deleteAccount() {
        System.out.print("찾으려는 계좌의 유저 아이디를 입력해주세요: ");
        String id = scanner.nextLine();
        try{
            List<Account> userAccounts = adminLogic.getUserAccounts(id);
            System.out.println("해당 유저의 계좌는 다음과같습니다.");
            int index = 1;
            for (Account userAccount : userAccounts) {
                System.out.println(index + " : " + userAccount.getAccountNum());
            }
            System.out.print("삭제를 원하는 계좌의 순서 번호 입력해주세요: ");
            String idx = scanner.nextLine();
            Account account = userAccounts.get(Integer.parseInt(idx) - 1);
            adminLogic.deleteAccount(account);
            System.out.println("삭제 완료됐습니다.");
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
        finally {
            System.out.println("뒤로 돌아가려면 아무키나 눌러주세요");
            if (!scanner.nextLine().isEmpty()) {
                return;
            }
        }
    }

    private void findUserByAccountNumber() {
        System.out.println("찾으시려는 유저의 계좌 번호를 입력해주세요: ");
        String accountNumber = scanner.nextLine();
        User user = adminLogic.findUserByAccount(accountNumber);
        System.out.println("계좌버호의 소유자는 : " + user + "님입니다.");
        System.out.println("뒤로가려면 0");
        String s = scanner.nextLine();
    }

    private void findAccountsByUserId() {
        System.out.println("찾으려는 계좌의 유저 아이디를 입력해주세요: ");
        String userId = scanner.nextLine();
        try {
            System.out.println(userId + "님의 계좌 목룍입니다.");
            List<Account> accountList = adminLogic.getUserAccounts(userId);
            for (Account account : accountList) {
                System.out.println(account.toString());
            }
        }catch (Exception e){
            System.out.println(e.getMessage());
        }finally {
                System.out.println("뒤로 돌아가려면 아무키나 눌러주세요");
                if (!scanner.nextLine().isEmpty()) {
                    return;
            }
        }

    }

    private void findAllAccounts() {
        System.out.println("은행 내 모든 계좌 리스트입니다.");
        ArrayList<Account> accounts = adminLogic.getAllAcounts();
        for (Account account : accounts) {
            System.out.println("account = " + account.toString());
        }
        System.out.println("zero to back");

    }

    private void findAllHistories() {
        System.out.println("은행 내 모든 거래내역 리스트입니다.");
        ArrayList<History> histories = adminLogic.getAllHistories();
        for (History history : histories) {
            System.out.println(histories.toString());
        }
        System.out.println("zero to back");
    }

}

//1
//사용자 id와 변경할 비밀번호 필요


// 2
//id가 없으면 null 반환, 있으면 List<Acount> 반환, 이후 인덱스와 계좌번호리스트를 띄우는 UI 필요
//UI에서 번호 입력시 List<Account>와 함께 번호를 반환 <= 리스트로 변경 가능하기 때문에 선택번호와 인덱스 맞춰줄 것
