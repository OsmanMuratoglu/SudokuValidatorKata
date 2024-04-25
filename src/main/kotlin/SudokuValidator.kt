fun validate(board: Array<Array<Int>>): Boolean {
    return board[0].size == board[0].distinct().size && board[0][0] != board[1][0]
            && !board[0].contains(0) && board[5][7] != board[8][7]

}
