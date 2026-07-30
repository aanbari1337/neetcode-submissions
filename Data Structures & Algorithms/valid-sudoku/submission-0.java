class Solution {
   public boolean isValidSudoku(char[][] board) {

        Map<Integer, HashSet> rows = new HashMap<>();
        Map<Integer, HashSet> cols = new HashMap<>();
        Map<String, HashSet> squares = new HashMap<>();

        for (int i = 0; i < 9; i++){
            for (int j = 0; j < 9; j++) {

                var item = board[i][j];
                if(item == '.') continue;

                String key = i / 3 + String.valueOf(j / 3);
                if(rows.computeIfAbsent(i, k -> new HashSet()).contains(item)
                    || cols.computeIfAbsent(j, k -> new HashSet()).contains(item)
                        || squares.computeIfAbsent(key, k -> new HashSet()).contains(item)
                ) return false;

                rows.get(i).add(item);
                cols.get(j).add(item);
                squares.get(key).add(item);
            }
        }

        return true;
    }
}
