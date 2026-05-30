class Solution {
    public boolean isValidSudoku(char[][] board) {
        HashSet<String> seen = new HashSet<>();

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                char currentVal = board[i][j];

                // If the cell is empty, just keep moving
                if (currentVal == '.') {
                    continue;
                }

                // Create unique string identifiers for the row, column, and 3x3 box
                String rowKey = currentVal + " found in row " + i;
                String colKey = currentVal + " found in col " + j;
                String boxKey = currentVal + " found in box " + (i / 3) + "-" + (j / 3);

                // HashSet.add() returns false if the element already exists in the set
                if (!seen.add(rowKey) || !seen.add(colKey) || !seen.add(boxKey)) {
                    return false;
                }
            }
        }
        return true;
    }
}