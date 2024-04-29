import java.util.Scanner;

public class 한국이그리울땐서버에접속하지_9996 {
 
    static void StringSearch(int num, String pattern, String[] texts) {
        // 패턴 문자열을 "*"을 기준으로 두 문자열로 분리하여 배열 parts에 저장
        String[] parts = pattern.split("\\*");
        String front = parts[0]; // 패턴 문자열에서 "*" 앞 부분
        String back = parts[1]; // 패턴 문자열에서 "*" 뒷 부분

        // texts 배열에 담겨 있는 num 개의 파일명을 차례대로 검사
        for (int i = 0; i < num; i ++) {
            String text = texts[i]; // 파일명 하나 추출

            // 파일명 앞 부분에서 검색
            int fSearchResult = frontSearch(front, text); 
            if (fSearchResult == -1 || text.length() <= 1) {
                System.out.println("NE");
            } else {
                // 파일명 뒷 부분도 검색
                int bSearchResult = backSearch(back, text, fSearchResult);
                if (bSearchResult == -1) {
                    System.out.println("NE");
                } else {
                    System.out.println("DA");
                }
            }
        }
    }

    // 파일명에 패턴 문자열 앞 부분이 있는지 검색하는 메서드
    static int frontSearch(String front, String text) {
        int patFrontP = 0; // 패턴 앞 부분 문자열인 front의 인덱스 포인터
        int txtFrontP = 0; // 파일명 문자열의 포인터 (방향: 앞 > 뒤)

        while (patFrontP != front.length() && txtFrontP != text.length()) {
            if (front.charAt(patFrontP) == text.charAt(txtFrontP)) {
                patFrontP++;
                txtFrontP++;
            } else return -1; // 파일명에서 패턴 문자열과 일치하지 않는 문자가 나타나면 바로 -1 반환
        }
        // 패턴 문자열의 마지막 요소까지 검사한 결과, 파일명에서 패턴 문자열과 일치하는 문자열을 찾은 경우
        if (patFrontP == front.length()) { 
            return txtFrontP - 1; // 배열에서 찾은 패턴 문자열의 마지막 인덱스를 반환
        }
        return -1;
    }

    // 파일명에 패턴 문자열 뒷 부분이 있는지 검색하는 메서드
    static int backSearch(String back, String text, int fSearchResult) {
        int patBackP = back.length() - 1;
        int txtBackP = text.length() - 1;

        while (patBackP != -1  && txtBackP > fSearchResult) { // 파일명 뒷 부분은 StringFrontSearch에서 확인한 문자열 이후부터를 의미함
            if (back.charAt(patBackP) == text.charAt(txtBackP)) {
                patBackP--;
                txtBackP--;
            } else return -1;
        }
        if (patBackP == -1) {
            return txtBackP + 1;
        }
        return -1;
    }
    
    public static void main(String[] args) {
        Scanner stdIn = new Scanner(System.in);
        
        int num = Integer.parseInt(stdIn.nextLine()); // 파일명 개수
        String pattern = stdIn.nextLine(); // 패턴 문자열

        // num 개의 파일명을 배열 texts에 저장
        String[] texts = new String[num];
        for (int i = 0; i < num; i++) {
            String text = stdIn.nextLine();
            texts[i] = text;
        }
        stdIn.close();

        // 파일명 검사
        StringSearch(num, pattern, texts);
    }
}