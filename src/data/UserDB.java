package data;

import entity.User;

import java.util.ArrayList;

import static printer.Printer.EXCEPTION_NO_ID;


public class UserDB {
    private static final UserDB userDB = new UserDB();

    public static UserDB getInstance() {
        return userDB;
    }

    private final ArrayList<User> userList = new ArrayList<>();

    public void insertUser(User user) {
        userList.add(user);
    }

    public User getUserByUserId(String userId){
        User findUser = new User();
        for (User user : userList) {
            if (user.getUserID().equals(userId)) {
                findUser = user;
                break;
            }
        }
        return findUser;
    }

    public ArrayList<User> getAllUsers() {
        return userList;
    }
}

/*
    //모든 유저 조회(은행은 모든 계좌의 목록을 조회할 수 있다... 를 구현하기 위해서)
    public ArrayList<User> getAllUser(){
        return userList;
    }

    //유저 1명 조회 - 소유자 명으로 찾기 (개인별 서비스용 - 수정/삭제/거래내역 조회 등)
    public User getUserByUserName(String userName){
        for(User user : userList){
            if(user.getUserID().equals(userName)){
                return user;
            }
        }
        return null;
    }

 */