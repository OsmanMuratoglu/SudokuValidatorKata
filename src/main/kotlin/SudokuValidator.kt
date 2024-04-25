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

    return checkGroups(board)

}

fun transposeMatrix(board: Array<Array<Int>>): Array<Array<Int>> {
    return Array(board[0].size) { j -> Array(board.size) { i -> board[i][j] } }
}

fun checkGroups(board: Array<Array<Int>>): Boolean {
    return checkGroups1(board) && checkGroups2(board) && checkGroups3(board)
}

fun checkGroups1(board: Array<Array<Int>>): Boolean {
    var sum = 0

    for (i in 1..<board.size) {
        for (j in 0..<3) {
            sum += board[i - 1][j]
        }
        if (i % 3 == 0) {
            return sum == 45
        }
    }

    return true
}

fun checkGroups2(board: Array<Array<Int>>): Boolean {
    var sum = 0

    for (i in 1..<board.size) {
        for (j in 3..<6) {
            sum += board[i - 1][j]
        }
        if (i % 3 == 0) {
            return sum == 45
        }
    }

    return true
}

fun checkGroups3(board: Array<Array<Int>>): Boolean {
    var sum = 0

    for (i in 1..<board.size) {
        for (j in 6..<9) {
            sum += board[i - 1][j]
        }
        if (i % 3 == 0) {
            return sum == 45
        }
    }

    return true
}

