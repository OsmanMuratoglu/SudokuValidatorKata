fun validate(board: Array<Array<Int>>): Boolean {
    return board[0].size == board[0].distinct().size && board[0][0] != board[1][0]
}
