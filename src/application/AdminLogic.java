package application;
import data.UserDB;
import data.AccountDB;
import data.HistoryDB;
import entity.User;
import entity.Account;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


public class AdminLogic {
    UserDB userDB = new UserDB();

    public String signUp(String name, String id, String pw) {
        Optional<User> opUser = userDB.getUserByUserId(id);
        if (opUser.isPresent()) {
            throw new IllegalArgumentException("아이디 중복");
        }
        User user = new User(name, id, pw, true);
        userDB.insertUser(user);
        return "정상적으로 회원가입 되었습니다!";
    }

    public User login(String id, String pw) {
        Optional<User> opUser = userDB.getUserByUserId(id);
        User user = opUser.orElseThrow(() -> new IllegalArgumentException("아이디 없음"));
        if (!user.getPassWord().equals(pw)) {
            throw new IllegalArgumentException("비밀번호 불일치");
        }
        return user;
    }

    public Optional<User> confirmId(String id) {
        Optional<User> opUser = userDB.getUserByUserId(id);
        if (opUser.isEmpty()) {
            return Optional.empty();
        }
        Optional<User> user = opUser;
        return user;
    }

    public String changeUserPw(String id, String pw) {
        Optional<User> user = confirmId(id);
        if (user.isEmpty()) {
            throw new IllegalArgumentException("아이디 없음");
        }
        String message = userDB.changeUserPassword(user, pw);
        return message;
    }

    public List<Account> getUserAccount(String id) {
        if ((Object) confirmId(id) == Optional.empty()) {
            return null;
        }

        AccountDB accountDB = new AccountDB();
        //getUserID는 AccountDB에서 userID만 받아오는 것
        List<Account> accounts = accountDB.stream()
                .filter(i -> i.getUserId().equals(id))
                .collect(Collectors.toList());

        return accounts;
    }

    public String chooseAccount(List<Account> accounts, String num) {
        int index = 0;
        Account[] accountArray = (Account[]) accounts.toArray();    //여기 주의 오류 위험
        for (Account account : accounts) {
            if (Integer.parseInt(num) == index) {
                break;
            }
            index++;
        }
        //getAccountNum은 Accoun애서 계좌번호를 받아온 것(String이어야 함)
        deleteAccount(accountArray[index].getAccountNum());

        return "삭제 완료";
    }
    public void deleteAccount(String accountNum) {
        HistoryDB historyDB = new HistoryDB();
        historyDB.deleteAccountHistory(accountNum);

    }

    public String findUserToAccount(String userAccount){
        AccountDB accountDB = new AccountDB();            //AccountDB에서 Account만 빼오는 것
        Account account = accountDB.stream().filter(a->a.getUserAccountNum().equal(userAccount));
    }
}

   /* public Optional<Account> confirmAccount(String userAccount){
        AccountDB accountDB = new AccountDB();
        for (Account account : accountDB) {
            if (account.getAccountNum().equals(userAccount)) {
                return account;
            }
        }
        return Optional.empty();
    }
    필요없어서 뺌 원래는 계좌번호 받아서 Account 출력하던 로직
    */