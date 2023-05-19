/***
 * This player has a fixed probability for each type of move.
 * 
 * @author David
 *
 */
public class WeightedRandomPlayer implements Player {
	private double prock, ppaper;
	
	public WeightedRandomPlayer(double prob_rock, double prob_paper) {
		prock = prob_rock;
		ppaper = prob_paper;
	}
	
	@Override
	public int getMove() {
		double r = Math.random();
		if (r < prock) return RPS.ROCK;
		if (r < prock+ppaper) return RPS.PAPER;
		return RPS.SCISSORS;
	}

	@Override
	public void saveLastRoundData(int yourMove, int opponentMove, int outcome) {
		// we don't do anything with the outcome
	}

}
