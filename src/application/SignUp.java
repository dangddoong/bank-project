package src.application;
import java.util.Scanner;


public class SignUp {
    Scanner scanner = new Scanner(System.in);

    public void SignUp() {
        System.out.println("----------화원가입창입니다============");

        System.out.print("아이디를 입력해주세요 : ");
        String id = scanner.nextLine();

        String pw = Validation();

        System.out.print("이름을 입력해주세요 : ");
        String name = scanner.nextLine();

        //디비에 넣을 정보

        System.out.println("========화원가입이 완료되었습니다========");
    }

    public String Validation(){

        System.out.print("비밀번호를 입력해주세요 : ");
        String pw = scanner.nextLine();

        System.out.print("비밀번호를 다시 입력해주세요 : ");
        String pwValidation = scanner.nextLine();

        if(pw != pwValidation){
            Validation();
        }
        return pw;
    }
}
