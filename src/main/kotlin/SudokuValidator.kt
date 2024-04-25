fun validate(board: Array<Array<Int>>) : Boolean
{
    return board.groupBy{it}.count() == 1
}
