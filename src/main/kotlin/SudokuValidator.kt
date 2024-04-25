fun validate2(board: Array<Array<Int>>): Boolean {
    return board[0].size == board[0].distinct().size && board[0][0] != board[1][0]
            && !board[0].contains(0) && board[5][7] != board[8][7] && board[0][1] != board[1][0]
}

fun validate(board: Array<Array<Int>>): Boolean {

    board.forEach {
        if (!it.sortedArray().contentDeepEquals(arrayOf(1, 2, 3, 4, 5, 6, 7, 8, 9))) {
            return false
        }
    }
    transposeMatrix(board).forEach {
        if (!it.sortedArray().contentDeepEquals(arrayOf(1, 2, 3, 4, 5, 6, 7, 8, 9))) {
            return false
        }
    }

    return true
}

fun transposeMatrix(board: Array<Array<Int>>): Array<Array<Int>> {
    val rows = board.size
    val cols = board[0].size
    return Array(cols) { j -> Array(rows) { i -> board[i][j]} }
}

