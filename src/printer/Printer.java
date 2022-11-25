package printer;

public class Printer {
    public static final String BLANK = "                                                    ";
    public static final String CLEAR = "\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n";

    public static final String ADMIN_LIST1 = "1. 사용자 비밀번호 수정";
    public static final String ADMIN_LIST2 = "2. 유저의 계좌 정보 삭제";
    public static final String ADMIN_LIST3 = "3. 계좌번호로 사용자 찾기";
    public static final String ADMIN_LIST4 = "4. 사용자 아이디로 계좌 찾기";
    public static final String ADMIN_LIST5 = "5. 은행 내 모든 계좌 조회";
    public static final String ADMIN_LIST6 = "6. 은행 내 모든 거래 내역 조회";

    public static final String USER_LIST1 = "1. 입금하기";
    public static final String USER_LIST2 = "2. 출금하기";
    public static final String USER_LIST3 = "3. 계좌 정보 조회하기";
    public static final String USER_LIST4 = "4. 계좌 거래 내역 조회하기";
    public static final String USER_LIST5 = "5. 타계좌 송금하기";
    public static final String USER_LIST6 = "6. 계좌 만들기";

    public static final String LIST_LOGOUT = "0. 로그아웃";


    public static void clearCmd() {
        System.out.println(CLEAR);
    }

    public static void println(String s){
        System.out.println(s);
    }

    public static void print(String s) {
        System.out.print(s);
    }
}
