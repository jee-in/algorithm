function solution(id_list, report, k) {
    let answer = Array(id_list.length).fill(0);
    
    let receivers = Array.from({length: id_list.length}, (_, index) => new Set());
    
    for (let i = 0; i < report.length; i++) {
        const record = report[i].split(" ");
        const sender = record[0];
        const receiver = record[1];
        
        receivers[id_list.findIndex(x => x == receiver)].add(id_list.findIndex(x => x == sender));
    }
    
    for (let i = 0; i < receivers.length; i++) {
        if (receivers[i].size >= k) {
            for (const receiver of receivers[i]) {
                answer[receiver] += 1;
            }
        }
    }
    
    return answer;
}