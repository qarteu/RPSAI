public class OpponentLastMovePlayer implements  Player{
    private int opponentLastMove;
    @Override
    public int getMove() {
        return opponentLastMove;
    }
    @Override
    public void saveLastRoundData(int yourMove, int opponentMove, int outcome) {
        this.opponentLastMove = opponentMove;

    }
}
