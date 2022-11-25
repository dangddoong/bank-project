package data;

import entity.Account;
import java.util.ArrayList;

public class AccountDB {
//    private int maxAccountID = 0;
    //account가 있을때마다 max 를 하나씩 증가시키는 부분.
    // 만약에 admin 에서 계좌 개수를 카운트하기로 한다면? 그때 구현할게요. 어렵진 않은데 충돌방지로 일단 킵...

    // admin 계좌처리는 머리가 도저히 안돌아가서 내일 좀 하겠습니다.

    private ArrayList<Account> accountList = new ArrayList<>();

    public void insertAccount(Account account){
        accountList.add(account);
    }

    // 계좌 삭제
    public void deleteAccount(Account account){
        accountList.remove(account);
    }

    public ArrayList<Account> getAllAccount(){
        return accountList;
    }

    //유저 1명 조회 - 계좌번호로 찾기 (개인별 서비스용 - 수정/삭제/거래내역 조회 등)
    public Account getAccountByAccountNum(String accountNum){
        for(Account account : accountList){
            if(account.getAccountNum().equals(accountNum)){
                return account;
            }
        }
        return null;
    }

    //유저 1명 조회 - 소유자 명으로 찾기 (개인별 서비스용 - 수정/삭제/거래내역 조회 등)
    public Account getAccountByUserName(String userName){
        for(Account account : accountList){
            if(account.getUserName().equals(userName)){
                return account;
            }
        }
        return null;
    }

//test



}
