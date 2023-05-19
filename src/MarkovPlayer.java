import java.util.logging.LoggingPermission;

public class MarkovPlayer implements Player {
    private int[][] moves;
    private int prev;

    public MarkovPlayer() {
        moves = new int[3][3];
        prev = -1;

    }

    @Override
    public int getMove() {
        return getMoveToBeat(getOpp());
    }

    @Override
    public void saveLastRoundData(int yourMove, int opponentMove, int outcome) {
        if (prev != -1) {
            moves[prev][opponentMove]++;
        }
        if (outcome == RPS.OPPONENT) prev = outcome;
        else prev = yourMove;
    }

    private int getOpp() {
        if (prev == -1) return 0;
        int rock = moves[prev][RPS.ROCK];
        int paper = moves[prev][RPS.PAPER];

        int prob = (int) (Math.random() * (getRowSum(moves[prev]) + 1));
        if (prob <= rock) return RPS.ROCK;
        else if (prob <= rock + paper) return RPS.PAPER;
        return RPS.SCISSORS;

    }

    private int getMoveToBeat(int prev) {
        if (prev == RPS.ROCK) return RPS.PAPER;
        if (prev == RPS.SCISSORS) return RPS.ROCK;
        return RPS.SCISSORS;
    }

    private int getRowSum(int[] arr) {
        int sum = 0;
        for (int val : arr) {
            sum += val;
        }
        return sum;
    }
}
