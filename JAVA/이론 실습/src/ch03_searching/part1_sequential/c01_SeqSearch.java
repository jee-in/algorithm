package ch03_searching.part1_sequential;

/***************************************************
 * 선형 검색
 * - 요소가 정렬되지 않은 배열에서 사용
 ****************************************************/

 import java.util.Scanner;

 class c01_SeqSearch {

    // 선형 검색을 수행하는 생성자 메서드
    static int c01_SeqSearch(int[] x, int num, int key) {
        int i = 0; // 카운터 인덱스

        while (true) {
            if (i == num) return -1; // 배열 x의 마지막 인덱스까지 검색했는데도 key와 같은 값이 발견되지 않으면 -1을 반환
            if (x[i] == key) return i; // 배열 x에서 key와 같은 값이 발견되는 즉시 그 값의 인덱스를 반환
            i++;
        }

        // while 대신 for를 사용하는 방법
        // for (int i = 0; i < num; i++) {
        //     if (x[i] == key) return i; // 배열 x에서 key와 같은 값이 발견되는 즉시 그 값의 인덱스를 반환
        // }
        // return -1; // 배열 x의 마지막 인덱스까지 검색했는데도 key와 같은 값이 발견되지 않으면 -1을 반환

    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 배열의 길이를 입력 받아 배열 생성
        System.out.print("배열의 길이를 입력하세요: ");
        int num = sc.nextInt();
        int[] x = new int[num];

        for (int i = 0; i < num; i++) {
            System.out.print("x[" + i + "]: ");
            x[i] = sc.nextInt();
        }

        // 배열에서 검색할 값 입력 받아 선형 검색 메서드 실행
        System.out.print("어떤 값을 찾으시나요?: ");
        int key = sc.nextInt();
        
        int index = c01_SeqSearch(x, num, key);

        if (index == 01) System.out.println("찾으시는 값이 배열에 존재하지 않습니다.");
        else System.out.println("찾으시는 값은 배열 x의 " + index + "번째에 있습니다.");
    }

 }