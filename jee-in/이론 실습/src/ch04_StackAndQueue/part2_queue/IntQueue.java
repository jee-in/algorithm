package ch04_StackAndQueue.part2_queue;

// 링 버퍼로 큐 만들기
public class IntQueue {
    
    private int[] que;
    private int capacity; // 큐의 크기
    private int front; // 데이터가 나오는 쪽. 현재 데이터 중 논리적 맨 앞 요소의 인덱스. 
    private int rear; // 데이터가 들어가는 쪽. 현재 데이터 중 논리적 맨 뒤 요소의 인덱스 + 1
    private int num; // 현재 데이터 수. 큐가 비어 있을 때: 0, 큐가 가득 찼을 때: capacity

    // 실행 시 예외 1) 큐가 비어 있음
    public class EmptyIntQueueException extends RuntimeException {
        public EmptyIntQueueException() {}
    }

    // 실행 시 예외 2) 큐가 가득 참
    public class OverflowInStackException extends RuntimeException {
        public OverflowInStackException() {}
    }

    // 생성자
    public IntQueue(int maxLen) {
        num = front = rear = 0;
        capacity = maxLen;

        try {
            que = new int[capacity]; // 큐를 위한 배열 생성
        } catch (OutOfMemoryError e) {
            capacity = 0;
        }
    }

    // 인큐
    public int enque(int x) throws OverflowInStackException {
        if (num >= capacity) 
            throw new OverflowInStackException();
        que[rear++] = x;
        num++;

        // 배열의 마지막 요소에 인큐했다면, rear를 0으로 처리
        if (rear == capacity)
            rear = 0;
        
        return x;
    }

    // 디큐
    public int deque() throws EmptyIntQueueException {
        if (num <= 0) 
            throw new EmptyIntQueueException();
        int x = que[front++];
        num--;

        // 배열의 마지막 요소를 디큐했다면, front를 0으로 처리
        if (front == capacity)
            front = 0;
        
        return x;
    }

    // peek
    public int peek() throws EmptyIntQueueException {
        if (num <= 0)
            throw new EmptyIntQueueException();
        return que[front];
    }

    // clear
    public void clear() {
        num = front = rear = 0;
    }

    // 큐에서 x를 검색하여 인덱스 반환. 찾지 못하면 -1 반환
    public int indexOf(int x) {
        for (int i = 0; i < num; i++) {
            int idx = (i + front) % capacity; // 큐가 링 형태임을 고려하여 나머지를 구함
            if (que[idx] == x)
                return idx;
        }
        return -1;
    }

    // 큐의 용량
    public int getCapacity() {
        return capacity;
    }

    // 큐에 쌓여 있는 데이터 개수
    public int size() {
        return num;
    }

    // 큐가 비어있는지 여부
    public boolean isEmpty() {
        return num <= 0;
    }

    // 큐가 가득 찼는지 여부
    public boolean isFull() {
        return num >= capacity;
    }

    // 큐 안의 모든 데이터를 front에서 rear 순서로 출력
    public void dump() {
        if (num <= 0)
            System.out.println("큐가 비어 있습니다.");
        else {
            for (int i = 0; i < num; i++)
                System.out.print(que[i + front] % capacity + " ");
            System.out.println();

        }
    }


}
