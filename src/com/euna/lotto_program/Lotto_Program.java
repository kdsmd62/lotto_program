package com.euna.lotto_program;

import java.util.Scanner;

public class Lotto_Program {
    public static void main(String[] args) {
        //계정을 생성하고, 이름과 잔여횟수를 확인한다
        Scanner scanner = new Scanner(System.in);

        //객체 생성
        Lotto_char user1 = new Lotto_char();
        //유저 정보 입력
        user1.state_print(user1.user_create());
        //번호 생성
        user1.lotto_num_create();

    }
}