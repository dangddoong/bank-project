package data;

import entity.Account;

import java.util.ArrayList;

public class AccountDB {

    int maxAccountID = 0;
    //account가 있을때마다 max 를 하나씩 증가시키는 부분.
    ArrayList<Account> accountList = new ArrayList();
}
