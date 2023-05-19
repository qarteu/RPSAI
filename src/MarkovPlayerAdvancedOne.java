import java.util.Arrays;

public class MarkovPlayerAdvancedOne implements Player{
    private int[][][] moves;
    private int prev ;
    private int prevP ;

    public MarkovPlayerAdvancedOne(){
       moves = new int[3][3][3];
       prev = -1;
       prevP = -1;

    }
    public int getMove() {
        return getMoveToBeat(getOpp());
    }

    @Override
    public void saveLastRoundData(int yourMove, int opponentMove, int outcome) {
        if (prev != -1 && prevP !=-1) {
            moves[prevP][prev][opponentMove]++;
        }
        prevP = prev;
        prev = opponentMove;
    }


    private int getOpp() {
        if (prev == -1 || prevP == -1)  return 0;
        int rock = moves[prevP][prev][RPS.ROCK];
        int paper = moves[prevP][prev][RPS.PAPER];

        int prob = (int) (Math.random() * (getRowSum(moves[prevP][prev]) + 1));
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
