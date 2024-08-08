package ch04_StackAndQueue.part1_stack;

// int형 고정 길이 스택

public class InStack {
    
    private int[] stack; // 배열 본체를 참조하는 참조 변수
    private int capacity;
    private int pointer; // 스택이 비어 있을 때 값: 0, 스택이 가득 차 있을 때 값: capacity 값

    // 실행 시 예외 1) 스택이 비어 있음
    public class EmptyInStackException extends RuntimeException {
        public EmptyInStackException() {}
    }

    // 실행 시 예외 2) 스택이 가득 참
    public class OverflowInStackException extends RuntimeException {
        public OverflowInStackException() { }
    }

    // 생성자
    public InStack(int maxLen) {
        pointer = 0;
        capacity = maxLen;

        try {
            stack = new int[capacity]; // 스택 배열 생성
        } catch (OutOfMemoryError e) {
            capacity = 0;
        }
    }

    // 스택이 비어 있는지, 가득 차 있는지 여부는 메서드 밖에서도 확인 가능함
    // 하지만 프로그램 오류로 pointer의 값이 잘못될 수도 있으므로 메서드 안에서 if문으로 확인하여 프로그램의 안정성을 높임

    public int push(int x) throws OverflowInStackException {
        if (pointer >= capacity) throw new OverflowInStackException();
        return stack[pointer++] = x; // x 값이 저장된 stack[pointer] 값이 반환됨
    }

    public int pop() throws EmptyInStackException {
        if (pointer <= 0) throw new EmptyInStackException();
        return stack[--pointer];
    }

    public int peek() throws EmptyInStackException {
        if (pointer <= 0) throw new EmptyInStackException();
        return stack[pointer - 1]; // pop()과의 차이: pointer의 값을 변화시키지 않음
    }

    public void clear() {
        pointer = 0;
    }

    public int indexOf(int x) {
        for (int i = pointer - 1; i >= 0; i--) {
            if (stack[i] == x) return i;
        }
            return -1; // 찾는 값이 없으면 -1을 반환ß
    }

    public int getCapacity() {
        return capacity;
    }

    public int size() {
        return pointer;
    }

    public boolean isEmpty() {
        return pointer <= 0;
    }

    public boolean isFull() {
        return pointer >= capacity;
    }

    // 스택 안의 모든 데이터를 바닥에 있는 데이터부터 출력
    public void dump() {
        if (pointer <= 0) System.out.println("스택이 비었습니다.");
        else {
            for (int i = 0; i < pointer; i++) {
                System.out.print(stack[i] + " ");
            }
            System.out.println();
        }
    }
}
