function solution(people, limit) {
    var answer = 0;
    
    people.sort((a, b) => a - b);
    let left = 0;
    let right = people.length - 1;
    
    while (left <= right) {
        if (people[left] + people[right] <= limit) {
            left++;
        }
        
        answer++;
        right--;
    }
    
    return answer;
}