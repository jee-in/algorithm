package ch02_basic.part1_array;

/********************************************
 * 1000 이하의 소수 나열하기
 * - 심화(1): 불필요한 계산 줄이기
 */

public class c07_PrimeNumber02 {
    public static void main(String[] args) {

        int divisionCounter = 0; // 나눗셈의 횟수
        int primeCounter = 0; // 찾은 소수의 개수 - 1 (소수 배열에 담겨 있는 마지막 소수의 인덱스)
        int[] prime = new int[500]; // 소수를 담을 배열 prime 생성. 배열의 크기는 넉넉하게 500으로 설정.

        prime[primeCounter++] = 2; // 유일하게 짝수 중에서 소수인 숫자 2를 소수 배열에 저장함

        // 알고리즘 개선(1) 홀수를 대상으로만 소수 여부를 확인
        for (int n = 3; n <= 1000; n += 2) { // 정수 n은 3부터 1000 사이의 홀수
            int i;
            // 알고리즘 개선(2) 소수로 나누어지는지 여부를 확인
            for (i = 1; i < primeCounter; i++) { // 홀수는 2로 나누어질 수 없으므로 n을 prime[0]로 나누어 볼 필요 없음
                divisionCounter++;
                if (n % prime[i] == 0)
                    break; // n이 n 이하의 소수로 나누어지면 안쪽 반복문(해당 n에 대한 소수 검증) 종료 -> n은 소수가 아님
            }
            // 알고리즘 개선(3) 홀수는 홀수보다 작은 소수로 나누어지지 않는다면 소수임
            if (primeCounter == i)
                prime[primeCounter++] = n;
        }

        // prime 배열의 요소 출력
        for (int i = 0; i < primeCounter; i++) {
            System.out.println(prime[i]);
        }

        System.out.println("나눗셈을 수행한 횟수: " + divisionCounter);
    }
}
