public class BeatLastWinningMovePlayer implements Player{
private int lastWinningMove;
//1 if you win
    //0


    @Override
    public int getMove() {
        return getMoveToBeat(lastWinningMove);
    }

     private int getMoveToBeat(int prev) {
            if (prev == RPS.ROCK) return RPS.PAPER;
            if (prev == RPS.SCISSORS) return RPS.ROCK;
            return RPS.SCISSORS;
        }

    @Override
    public void saveLastRoundData(int yourMove, int opponentMove, int outcome) {
        if(outcome == RPS.TIE){
            this.lastWinningMove = yourMove;
        }else if(outcome == RPS.OPPONENT){
            this.lastWinningMove = opponentMove;
        }else{
            lastWinningMove =yourMove;
        }
        //this.lastWinningMove = outcome==RPS.TIE ? yourMove : outcome == RPS.OPPONENT ? opponentMove : yourMove;
    }
}
