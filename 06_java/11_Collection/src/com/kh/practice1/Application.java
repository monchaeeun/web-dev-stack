package com.kh.practice1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class Application {

	public static void main(String[] args) {
		// 1등 당첨 기준 : 로또 번호 6개가 정확히 일치 1~45
		// 둘 다 랜덤!
		// - 로또번호는 1번만 정해지면 됨
		// - 내 번호는 맞출 때까지!!

		// 만약 2등 당첨! 보너스 번호가 일치 + 5개가 같은 경우
		// 만약 3등 당첨 5개만 같은 경우
		// 만약 4등 당첨! 4개만 같은 경우
		// 만약 5등 당첨! 3개만 같은 경우
		List<Integer> lotto = new ArrayList<>();
		int count = 0;
		int num2 = 0;
		int num3 = 0;
		int num4 = 0;
		int num5 = 0;
		int[] countNum = {num2,num3,num4,num5};

		// 로또 번호 생성
		while (lotto.size() < 6) {
			int random = (int) (Math.random() * 45) + 1;
			if (!lotto.contains(random)) {
				lotto.add(random);
			}
		}
		Collections.sort(lotto);
		
		while (lotto.size() < 7) {
			int random = (int) (Math.random() * 45) + 1;
			if (!lotto.contains(random)) {
				lotto.add(random);
			}
		}
		
		//보너스 넘버 로또번호
		List<Integer> realLotto =  lotto.subList(0, 6);
		
		
		
		
		while (true) {
			++count;
			// 내 로또 번호 생성
			List<Integer> list = new ArrayList<>();
			while (list.size() < 6) {
				int random = (int) (Math.random() * 45) + 1;
				if (!list.contains(random)) {
					list.add(random);
				}
			}
			Collections.sort(list);
			
			//보너스 넘버 내 번호 
			int bonus = 0;
			while (bonus == 0) {
				int random = (int) (Math.random() * 45) + 1;
				if (!list.contains(random)) {
					bonus = random;
				}
			}

			//당첨 체크
			boolean result = list.equals(realLotto);
			int check = 0;
			
			for (int i = 0; i < list.size(); i++) {
				if (list.contains(realLotto.get(i))) {
					check++;
				}
			}
			System.out.println(lotto);
			System.out.println(list);
			System.out.println();
			
			
			if (result) {
				System.out.println("1등 당첨! " + count + "회 만에 끝났습니다!");
				for(int i = 0; i < countNum.length; i++)
				{
					System.out.println((i+2) + "등 횟수 : "+ countNum[i] + " 회");
				}
				break;
			} else if (bonus == lotto.getLast() && check == 5) {
				countNum[0]++;
				System.out.println("2등 당첨! " + count + "회 만에 끝났습니다!");
				
			} else if (check == 5) {
				countNum[1]++;
				System.out.println("3등 당첨! " + count + "회 만에 끝났습니다!");
				
			} else if (check == 4) {
				countNum[2]++;
				System.out.println("4등 당첨! " + count + "회 만에 끝났습니다!");
			} else if (check == 3) {
				countNum[3]++;
				System.out.println("5등 당첨! " + count + "회 만에 끝났습니다!");
			}

			else {
				list.clear();
			}
		}
		
	}
	
}
