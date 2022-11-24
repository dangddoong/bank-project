package data;

import entity.User;

import java.util.ArrayList;

public class UserDB {
    private ArrayList<User> userList = new ArrayList<>();

    // 유저 등록( DB에 넣기)
    public void insertUser(User user){
        userList.add(user);
    }

    //모든 유저 조회(은행은 모든 계좌의 목록을 조회할 수 있다... 를 구현하기 위해서)
    public ArrayList<User> getAllUser(){
        return userList;
    }

    //유저 1명 조회 - 계좌번호로 찾기 (개인별 서비스용 - 수정/삭제/거래내역 조회 등)
    public User getUserByAccountNum(String accountNum){
        for(User user : userList){
            if(user.getAccountNum().equals(accountNum)){
                return user;
            }
        }
        return null;
    }

    //유저 1명 조회 - 소유자 명으로 찾기 (개인별 서비스용 - 수정/삭제/거래내역 조회 등)
    public User getUserByUserName(String userId){
        for(User user : userList){
            if(user.getUserID().equals(userId)){
                return user;
            }
        }
        return null;
    }
    //
}
