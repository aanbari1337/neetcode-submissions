class Solution {
  public boolean isValidSudoku(char[][] board) {
    Map<Integer, Set<Character>> rows = new HashMap<>();
    Map<Integer, Set<Character>> cols = new HashMap<>();
    Map<String, Set<Character>> boxes = new HashMap<>();

    for (int row = 0; row < 9; row++) {
        for (int col = 0; col < 9; col++) {

            char value = board[row][col];

            if (value == '.')
                continue;

            String boxKey = (row / 3) + "," + (col / 3);

            Set<Character> rowSet =
                    rows.computeIfAbsent(row, r -> new HashSet<>());

            Set<Character> colSet =
                    cols.computeIfAbsent(col, c -> new HashSet<>());

            Set<Character> boxSet =
                    boxes.computeIfAbsent(boxKey, b -> new HashSet<>());

            if (rowSet.contains(value)
                    || colSet.contains(value)
                    || boxSet.contains(value)) {
                return false;
            }

            rowSet.add(value);
            colSet.add(value);
            boxSet.add(value);
        }
    }

    return true;
}
}
