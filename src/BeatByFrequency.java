import java.util.ArrayList;
import java.util.Arrays;

public class BeatByFrequency implements Player{
int[]turns = new int[3];
int total = 0;
    @Override
    public int getMove() {
        System.out.println(Arrays.toString(turns));
        int output = getMoveToBeat(getOpMove());
        System.out.println("Move to beat: " +  output);
        return output;
   }

    private int getMoveToBeat(int prev) {
        if (prev == RPS.ROCK) return RPS.PAPER;
        if (prev == RPS.SCISSORS) return RPS.ROCK;
        return RPS.SCISSORS;
    }

    public int getOpMove(){
        int prob =(int) (Math.random() * total) + 1;
            if (turns[RPS.ROCK] >= prob) return RPS.ROCK;
            else if (turns[RPS.SCISSORS] + turns[RPS.ROCK] >= prob) return RPS.PAPER;
            else return RPS.SCISSORS;
    }

    @Override
    public void saveLastRoundData(int yourMove, int opponentMove, int outcome) {
        total++;
        turns[opponentMove]++;
    }
}
