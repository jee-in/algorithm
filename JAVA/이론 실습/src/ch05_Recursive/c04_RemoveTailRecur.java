package ch05_Recursive;

class c04_RemoveTailRecur {

    // 재귀 호출을 사용하지 않고 비재귀적으로 구현하는 방법(1)
    // - while 문을 이용하여 메서드의 끝 쪽에서 실행되는 꼬리 재귀(tail recursion) 제거
    // - 단, 이 꼬리 재귀만 제거할 수 있고 처음에 나오는 재귀는 제거할 수 없음

    static void recur(int n) {
        while (n > 0) {
            recur(n - 1);
            System.out.println(n);
            n = n - 2;
        } 
    }

    /* 비교: 순수 재귀
        static void recursive(int n) {
        if (n > 0) {
            recursive(n - 1);
            System.out.println(n);
            recursive(n - 2); // 의미: 인수를 n-2로 업데이트하고 메서드의 처음으로 돌아간다.
            }
        }
     */

}
