function solution(elements) {
    let set = new Set();
    
    for (let size = 1; size <= elements.length; size++) {
        for (let start = 0; start < elements.length; start++) {
            sum = 0;
            for (let i = start; i < start + size; i++) {
                sum += elements[i % elements.length];
            }
            set.add(sum)
        }
    }
    
    return set.size;
}