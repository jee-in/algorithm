
/********************************************
 * 1000 이하의 소수 나열하기
 * - 기본: 일차적인 방법
 ****************************************** */

public class c06_PrimeNumber01 {
    public static void main(String[] args) {

        int counter = 0; // 나눗셈의 횟수
        
        for (int n = 2; n <= 1000; n++) { // 정수 n은 2부터 1000까지의 수
            int i;
            for (i = 2; i < n; i++) { // 정수 i는 2부터 (n-1)까지의 수
                // n을 2부터 n-1까지 나누기
                counter++;
                if (n % i == 0) break; // n이 i로 나누어지면 안쪽 반복문(해당 n에 대한 소수 검증)을 종료 -> n은 소수가 아님
            }
            if (n == i) System.out.println(n); // n이 2부터 (n-1)까지 나눠지지 않았다면 n을 출력 -> n은 소수
        }

        System.out.println("나눗셈을 수행한 횟수: " + counter);
    }
}
