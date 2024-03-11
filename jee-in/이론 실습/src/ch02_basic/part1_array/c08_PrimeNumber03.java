package ch02_basic.part1_array;

/********************************************
 * 1000 이하의 소수 나열하기
 * - 심화(2): 제곱근 이용
 */

public class c08_PrimeNumber03 {
    public static void main(String[] args) {

        // 넓이가 n으로 같은 정사각형과 직사각형이 있다.
        // 정사각형은 n 제곱근인 변을 갖게 된다.
        // 직사각형은 n 제곱근보다 큰 변 하나와 작은 변 하나를 갖게 된다.
        // 여기서 알 수 있는 점은?
        // 만약 n(직사각형의 넓이)이 n의 제곱근(정사각형 한 변의 길이) 이하의 어떤 소수로도 나누어지지 않는다면 n은 소수이다.

        int calCounter = 0; // 곱셈 또는 나눗셈의 횟수
        int primeCounter = 0; // 찾은 소수의 개수 - 1 (소수 배열에 담겨 있는 마지막 소수의 인덱스)
        int[] prime = new int[500]; // 소수를 담을 배열 prime 생성. 배열의 크기는 넉넉하게 500으로 설정.

        prime[primeCounter++] = 2; // 유일하게 짝수 중에서 소수인 숫자 2를 소수 배열에 저장함
        prime[primeCounter++] = 3; // 3은 가장 작은 소수인 2의 제곱보다 작으므로 미리 소수 배열에 저장함

        for (int n = 5; n <= 1000; n += 2) { // 정수 n은 3부터 1000 사이의 홀수
            boolean flag = false; // n이 n 제곱근보다 작은 소수로 나누어지면 flag는 true가 됨

            // 알고리즘 개선: n의 제곱근 이하의 수까지만 나눗셈을 진행함
            for (int i = 1; prime[i] * prime[i] <= n; i++) { // 홀수는 2로 나눠질 수 없으므로 n을 prime[0]으로 나누지 않음
                calCounter += 2; // for문 조건식에 있는 곱셈 연산과 if문 조건식에 있는 나눗셈 연산을 서게 위해 2를 더함
                if (n % prime[i] == 0) {
                    flag = true;
                    break; // n이 n 제곱근보다 작은 소수로 나누어지면 해당 n에 대한 소수 검증을 종료함 -> 소수가 아님
                }
            }
            if (!flag) { // n이 n 제곱근보다 작은 소수로 나누어지지 않는다면 n을 소수 배열에 저장함
                prime[primeCounter++] = n;
                calCounter++; // for문을 빠져나올 때 수행한 조건식에 있는 나눗셈 연산을 세기 위해 1을 더함
            }

            // prime 배열의 요소 출력
            for (int i = 0; i < primeCounter; i++) {
                System.out.println(prime[i]);
            }

            System.out.println("나눗셈을 수행한 횟수: " + calCounter);
        }
    }
}
