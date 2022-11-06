/**
 * 로또 번호 생성 프로그램의 기능 구현
 * 유저 정보 입력
 * 유저 정보 출력
 * 로또 번호 생성
 */

package com.euna.lotto_program;

import java.util.Arrays;
import java.util.Scanner;

class Lotto_char {
    //프로그램에 필요한 변수 타입을 사전 정의 한다
    public String name;
    public String cnt;
    public int[][] lotto_num;

    /**
     * 콘솔 라인 출력
     */
    static void print_doubleline(){
        System.out.println("=====================================================");
    }
    static void print_line(){
        System.out.println("-----------------------------------------------------");
    }

    /**
     * @user_info : 생성된 유저 및 로또 번호 정보를 담는 메서드
     * @this : 해당 메서드가 입력받은 변수틀은 this 틀
     */
    void user_info(String name, String cnt) {
        this.name = name;
        this.cnt = cnt;
    }
    void user_info(int[][] lotto_num) {
        this.lotto_num = lotto_num;
    }
    //void user_info(int cnt) {}

    /**
     * @user_create() : 유저를 생성하는 메서드이며, 입력된 값은 user_info() 메서드에게 전달 및 반환처리한다.
     * 반환된 값은 시스템 정보창에 출력되도록 한다.
     */
    String[] user_create() {
        //입력 메세지와 함께, 유저의 이름을 입력받습니다.
        Scanner scanner = new Scanner(System.in);

        System.out.print("[시스템] 당신의 이름을 입력해주세요 : ");
        String userName = scanner.nextLine();
        print_doubleline();
        //생성된 유저의 번호 생성 횟수를 선언한다
        String userCnt = "5";

        //입력 및 선언한 값을 user_info()에 전달
        user_info(userName, userCnt);

        //유저별 객체 생성을 위해 반환 과정 정의
        String[] user = {userName, userCnt};
        return user;
    }

    /**
     * @state_print() : 유저 정보를 출력하고, 진행을 안내한다
     */
    void state_print(String[] user) {
        //입력된 유저의 이름과 잔여횟수를 출력한다
        System.out.printf("[시스템] %s 님 안녕하세요!\n", user[0]);
        System.out.printf("[시스템] %s 님은 %s 개의 번호를 생성하실 수 있어요.\n", user[0], user[1]);
        System.out.println();
    }

    void state_print(String[] user, int[][] lotto_num) {
        //생성된 로또번호와 잔여횟수를 출력한다
        Scanner scanner = new Scanner(System.in);
        Outer : for(int idx=0; idx<5; idx++){
            print_line();
            System.out.printf("%d번째 번호 : ", idx+1);
            for(int i=0; i<7; i++) {
                System.out.printf("%d ", lotto_num[idx][i]);
            }
            System.out.println();
            print_line();

            if(Integer.parseInt(user[1])-(idx+1) == 0){
                System.out.println("오늘의 번호생성이 종료되었어요. 생성하신 조합을 다시 한번 확인하시겠어요?");
                System.out.print("확인하시려면 Y(y), 종료하시려면 N(n) 를 입력해주세요 : ");
                String isCheck = scanner.nextLine();
                if(isCheck.equals("y") || isCheck.equals("Y")){
                    print_line();
                    for(int k=0; k<5; k++){
                        System.out.printf("%d번째 번호 : ", k+1);
                        for(int j=0; j<7; j++){
                            System.out.printf("%d ", lotto_num[k][j]);
                        }
                        System.out.println();
                    }
                    print_line();
                    print_doubleline();
                    System.out.printf("[시스템] %s 님의 당첨을 기원하며, 프로그램을 종료합니다. ", user[0]);
                } else if (isCheck.equals("n") || isCheck.equals("N")) {
                    print_doubleline();
                    System.out.printf("[시스템] %s 님의 당첨을 기원하며, 프로그램을 종료합니다. ", user[0]);
                } else {
                    print_doubleline();
                    System.out.println("[에러] 입력값이 유효하지 않아 프로그램이 종료됩니다.");
                }
                break Outer;
            }
            System.out.printf("[시스템] %s 님은 %d 개의 로또 번호를 더 생성하실 수 있어요\n", user[0], Integer.parseInt(user[1])-(idx+1));
            System.out.print("[시스템] 계속 하시려면 Y(y), 종료하시려면 N(n) 를 입력해주세요 : ");
            String isGoing = scanner.nextLine();
            if(isGoing.equals("y") || isGoing.equals("Y")){
                continue;
            } else if (isGoing.equals("n") || isGoing.equals("N")) {
                print_doubleline();
                System.out.println("[시스템] 끝내신다니 아쉬워요, 다음에 다시 만나요:)");
                break Outer;
            } else {
                print_doubleline();
                System.out.println("[에러] 입력값이 유효하지 않아 프로그램이 종료됩니다.");
                break Outer;
            }
        }

    }

    /**
     * @lotto_num_create() : 로또 번호를 생성하는 메서드이며, 입력된 값은 user_info() 메서드에게 전달 및 반환처리합니다.
     * 반환된 값은 시스템 정보창에 출력되도록 합니다.
     * */
    void lotto_num_create() {
        //random 함수를 이용하여 7개의 숫자 5조합을 생성하고 배열에 담는다
        Scanner scanner = new Scanner(System.in);

        int[][] tmpNum = new int[5][7];

        System.out.print("[시스템] 지금 바로 번호 생성을 시작하시려면 Y(y)를 입력해주세요 : ");
        String isCreate = scanner.nextLine();

        if(isCreate.equals("y") || isCreate.equals("Y")){
            for(int j=0; j<5; j++){
                for(int i=0; i<7; i++) {
                    tmpNum[j][i] = (int) (Math.random() * 45) + 1;

                }
            }
            String[] user = {this.name, this.cnt};
            state_print(user, tmpNum);
        } else {
            print_line();
            System.out.println("[에러] 입력값이 유효하지 않아 프로그램이 종료됩니다.");
        }
    }
}
