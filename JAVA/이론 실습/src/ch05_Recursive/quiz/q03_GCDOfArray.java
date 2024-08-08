package ch05_Recursive.quiz;

/*********************************************************
 * q03. 배열의 모든 요소의 최대공약수를 구하기
*********************************************************/

import java.util.Scanner;
import java.util.Arrays;
import java.util.ArrayList;
import java.util.List;
import java.util.Collections;
import java.util.Set;
import java.util.HashSet;

public class q03_GCDOfArray {

    static int gcdArray(int[] a) {

        // 배열 a를 리스트 intList로 변환
        List<Integer> intList = new ArrayList<>();        
        for (int element : a) { 
            intList.add(element);        
        }  

        // intList 모든 요소의 최대공약수가 될 수 있는 후보 배열인 candidates의 초기값으로 intList 할당
        List<Integer> candidates = intList;
        Collections.sort(candidates); // 오름차순 정렬

        while(candidates.size() != 1) {

            int x = candidates.get(0); // 배열에서 가장 작은 값을 x에 할당
            List<Integer> tempList = new ArrayList<Integer>(); // x와 나머지 요소의 최대 공약수를 tempList에 모아둠

            for (int i = 1; i < candidates.size(); i++) { 

                int y = intList.get(i);
    
                while(y != 0) {
                    int temp = y;
                    y = x % y;
                    x = temp;
                }
                tempList.add(x);
            }
            // tempList 오름차순 정렬
            Collections.sort(tempList); // 오름차순 정렬
    
            // tempList 중복 요소 제거
            Set<Integer> set = new HashSet<Integer>(tempList);
            
            // candidates 배열 재할당
            candidates = new ArrayList<Integer>(set);
        }

        return candidates.get(0);
    }

    public static void main(String[] args) {
        Scanner stdIn = new Scanner(System.in);

        System.out.print("배열 a의 크기를 입력하세요: ");
        int length = stdIn.nextInt();

        int[] a = new int[length];

        for (int i = 0; i < length; i++) {
            System.out.print("a[" + i + "]: ");
            a[i] = stdIn.nextInt();
        }

        System.out.println("배열 a의 최대공약수는 " + gcdArray(a) + "입니다.");
    }

}
