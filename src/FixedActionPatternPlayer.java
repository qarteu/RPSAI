/***
 * This player plays the same sequence of moves in a repeated pattern.
 * The sequence is given by the int array passed as a constructor.
 * 
 * @author David
 *
 */
public class FixedActionPatternPlayer implements Player {
	private int[] actionPattern;
	private int index = 0;
	
	public FixedActionPatternPlayer(int[] actionPattern) {
		this.actionPattern = actionPattern;
	}
	
	@Override
	public int getMove() {
		int move = actionPattern[index];
		index = ++index%actionPattern.length;
		return move;
	}

	@Override
	public void saveLastRoundData(int yourMove, int opponentMove, int outcome) {
		// we don't do anything with the outcome
	}
}
