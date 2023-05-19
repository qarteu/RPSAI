import java.util.Arrays;

public class PlayToBeatInFrequentPlays implements Player{
    int opponentLastMove;
    int[]turns = new int[3];
    int[] obs = {0,1,1,0,2,0,3};
    public PlayToBeatInFrequentPlays() {
        opponentLastMove = leastFreqPlayed(3);		// we'll start by trying to beat rock
    }
    @Override
    public int getMove() {
        //System.out.println(Arrays.toString(turns));
        return getMoveToBeat();
    }

    private int leastFreqPlayed(int n) {
        //create an observation or run your the RPS simulation that creates the observations
        int cr = 0;
        int cp = 0;
        int cs =  0;
        for (int i = 0; i < obs.length - (obs.length-n); i++) {
            if(obs[i]== RPS.ROCK) cr++;
            if(obs[i]== RPS.PAPER) cp++;
            if(obs[i]== RPS.SCISSORS) cs++;
        }
        //loop through observations  n amount turns and find least played
        //return least played so then you know what to play
        return Math.min(Math.min(cr, cp), cs);
    }

    private int getMoveToBeat() {
        if (opponentLastMove == RPS.ROCK) return RPS.PAPER;
        if (opponentLastMove == RPS.SCISSORS) return RPS.ROCK;
        return RPS.SCISSORS;
    }

    @Override
    public void saveLastRoundData(int yourMove, int opponentMove, int outcome) {
        opponentLastMove = opponentMove;
        turns[opponentMove]++;
    }
}
