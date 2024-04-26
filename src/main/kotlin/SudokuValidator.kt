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

    return hasValidBoxes(board)
}

fun transposeMatrix(board: Array<Array<Int>>): Array<Array<Int>> {
    return Array(board[0].size) { j -> Array(board.size) { i -> board[i][j] } }
}

/*
fun checkGroups(board: Array<Array<Int>>): Boolean {
    return checkGroups1(board) && checkGroups2(board) && checkGroups3(board)
}
*/

/*
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
*/

fun hasValidBoxes(board: Array<Array<Int>>): Boolean {
    var sum = 0
    for (i in 0..<8) {
        for (j in 0..<3) {
            for (k in 0..<3) {
                println(board[findBoxWithId(i)[0] + j][findBoxWithId(i)[1] + k])
                sum += board[findBoxWithId(i)[0] + j][findBoxWithId(i)[1] + k]
            }
        }
        if (sum != 45) {
            return false
        } else {
            sum = 0
        }
    }
    return true
}


// id = anfangskoordinate von box
fun findBoxWithId(id: Int): Array<Int> {
    return arrayOf((id) / 3 * 3, (id) % 3 * 3)
}

