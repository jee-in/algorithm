package ch03_searching.part1_sequential;

/***************************************************
 * 보초법(sentinel)으로 선형 검색
 * - 선형 검색에서 종료 조건을 검사하는 비용을 반으로 줄이는 방법
 ****************************************************/

 import java.util.Scanner;

 class c02_SeqSearchSentinel {

    // 선형 검색을 수행하는 생성자 메서드
    static int c01_SeqSearchSentinel(int[] x, int num, int key) {
        int i = 0; // 카운터 인덱스

        // 배열의 마지막에 key와 같은 값을 요소로 추가 -> (i == num)이라는 조건식을 계산할 필요가 없어짐
        x[num] = key;

        while (true) {
            // if (i == num) return -1; // 불필요한 if문이 됨
            if (x[i] == key) break; // 배열 x에서 key와 같은 값이 발견되는 즉시 반복문 종료
            i++;
        }
        return (i == num)? -1 : i;

    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 배열의 길이를 입력 받아 배열 생성
        System.out.print("배열의 길이를 입력하세요: ");
        int num = sc.nextInt();
        int[] x = new int[num + 1];

        for (int i = 0; i < num; i++) {
            System.out.print("x[" + i + "]: ");
            x[i] = sc.nextInt();
        }

        // 배열에서 검색할 값 입력 받아 선형 검색 메서드 실행
        System.out.print("어떤 값을 찾으시나요?: ");
        int key = sc.nextInt();
        
        int index = c01_SeqSearchSentinel(x, num, key);

        if (index == 01) System.out.println("찾으시는 값이 배열에 존재하지 않습니다.");
        else System.out.println("찾으시는 값은 배열 x의 " + index + "번째에 있습니다.");
    }

 }