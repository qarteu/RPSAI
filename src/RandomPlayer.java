/***
 * This player moves at random with equal probability of each move.
 * 
 * @author David
 *
 */
public class RandomPlayer implements Player {

	public RandomPlayer() {
		
	}
	
	@Override
	public int getMove() {
		int n = (int)(Math.random()*3);
		if (n == 0) return RPS.ROCK;
		if (n == 1) return RPS.PAPER;
		return RPS.SCISSORS;
	}

	@Override
	public void saveLastRoundData(int yourMove, int opponentMove, int outcome) {
		// we don't do anything with the outcome because we always throw ROCK.
	}

}
