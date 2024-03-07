/***************************************************
 * 클래스에서 배열 구현하기
 * - 신체 검사 데이터(이름, 키, 시력) 조회하는 프로그램
 ****************************************************/

// 클래스: 서로 다른 여러 데이터형을 자유로이 조합하여 만들 수 있는 자료구조
//  - 필드
//  : 클래스가 가지고 있는 데이터 요소 (예) int형 필드, long형 필드, double형 필드 등
//  : 클래스 인스턴스 안의 필드는 멤버 접근 연산자(.)를 사용하여 접근함

// <클래스 예시>
// XYZ a; -> 클래스형 변수(참조 변수) a 선언
// a = new XYZ(); -> 클래스 인스턴스를 생성한 후, 이를 변수 a에 연결함

package ch02_BasicDataStructure.ch02_2_Class;

public class c01_ArrayToClass {

  // 클래스 상수 정의
  static final int VMAX = 21; // 시력 도수분포표 배열의 최대 인덱스,
                              // 즉 시력 도수 분포표의 모습은 다음과 같음
                              // vdist[0] 0.0 ~ 0.1
                              // vdist[1] 0.1 ~ 0.2
                              // ...
                              // vdist[20] 2.0 ~ 2.1

  // 멤버 클래스 정의
  // - 이름 배열, 키 배열, 시력 배열을 따로 만들 수 있지만
  // - 클래스를 이용하면 한 사람에 해당하는 이름, 키, 시력을 같이 저장할 수 있다는 장점이 있다.
  static class PhyscData {
    String name; // default: null
    int height; // default: 0
    double vision; // default: 0

    // 생성자
    PhyscData(String name, int height, double vision) {
      this.name = name;
      this.height = height;
      this.vision = vision;
    }
  }

  // 키의 평균값을 구하는 메서드
  static double avgHeight(PhyscData[] data) {
    double sum = 0;

    for (int i = 0; i < data.length; i++)
      sum += data[i].height;

    return sum / data.length;
  }

  // 시력의 분포를 구하는 메서드
  static void distVision(PhyscData[] data, int[] dist) {
    int i = 0;
    dist[i] = 0;
    for (i = 0; i < data.length; i++) {
      // PhyscData에서 시력이 0 이상 2.1 이하인 시력을 대상으로 시력 도수분포표를 구함
      if (data[i].vision >= 0.0 && data[i].vision <= VMAX / 10.0) {
        // 도수분포표의 인덱스는 계급의 시작 시력에 10을 곱한 값.
        // <예시>
        // dist[0]: 0.0 ~ 0.1
        // dist[1]: 0.1 ~ 0.2
        // ...
        // dist[20]: 2.0 ~ 2.1

        dist[(int) (data[i].vision * 10)]++; // 도수분포표 배열에서 해당 시력 계급의 도수에 +1을 함
      }
    }
  }

  public static void main(String[] args) {

    PhyscData[] x = {
        new PhyscData("김지민", 160, 1.0),
        new PhyscData("박민수", 170, 1.5),
        new PhyscData("이종원", 160, 0.3),
        new PhyscData("정지원", 160, 1.5),
        new PhyscData("최강민", 160, 0.9),
        new PhyscData("홍경민", 160, 2.0),
    };

    int[] vdist = new int[VMAX]; // 시력 도수분포표를 담을 배열 vdist 생성

    // 신체 검사 리스트 출력 시작
    System.out.println("====신체 검사 리스트=====");
    System.out.println("이름       키       시력");
    System.out.println("--------------------------");

    for (int i = 0; i < x.length; i++) {
      System.out.printf("%-8s%3d%10.1f\n", x[i].name, x[i].height, x[i].vision);
      // printf: 변수를 지정된 형식에 맞게 포맷팅하여 출력함
      // 이름) 8칸 생성 후 왼쪽 정렬
      // 키) 3칸 생성
      // 시력) 5칸 생성하되 1칸은 소수점 아래 1자리로 사용
    }

    System.out.printf("\n평균 키: %5.1fcm\n", avgHeight(x)); // 평균키

    distVision(x, vdist); // 시력의 도수분포표 생성

    System.out.println("\n시력 분포");

    for (int i = 0; i < VMAX; i++) {
      // 도수의 시각화를 위해 도수만큼 *을 반복 출력함 (JAVA8)

      System.out.printf("%3.1f ~: %2d명\n", i / 10.0, vdist[i]);
      // 출력 형식
      // 계급의 시작 시력) 4칸을 생성하되 한 칸은 소수점 아래 1자리로 사용
      // 도수) 2칸 생성
    }
  }
}