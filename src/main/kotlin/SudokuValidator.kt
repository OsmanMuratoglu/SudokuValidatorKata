fun validate(board: Array<Array<Int>>) : Boolean
{
   return board[0].size == board[0].distinct().size

}
