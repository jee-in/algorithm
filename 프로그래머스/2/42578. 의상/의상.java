import java.util.*;

class Solution {    
    public int solution(String[][] clothes) {        
        Map<String, List<String>> typeMap = new HashMap<>();
        for (String[] clothInfo : clothes) {
            String cloth = clothInfo[0];
            String type = clothInfo[1];
            
            List<String> elems = typeMap.getOrDefault(type, new ArrayList<>());
            elems.add(cloth);
            typeMap.put(type, elems);
        }
        
        List<List<String>> clothList = new ArrayList<>(typeMap.values());
        
        int answer = 1;
        for (List<String> clothesOfType : clothList) {
            answer *= (clothesOfType.size() + 1);
        }
        
        return answer - 1;
    }
    
//     static void dfs(List<List<String>> clothList, int listSize, int depth, List<String> path) {
//         if (depth == listSize) {
//             return;
//         }
        
//         List<String> curr = clothList.get(depth);
//         for (int i = 0; i < curr.size() + 1; i++) {
//             if (i != curr.size()) {
//                 path.add(curr.get(i));
//             }
//             dfs(clothList, listSize, depth + 1, path);
//             if (i != curr.size()) {
//                 path.remove(curr.get(i));
//             }
//         }
//     }
}