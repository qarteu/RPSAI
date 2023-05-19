/***
 * This player always plays rock.
 * 
 * @author David
 *
 */
public class AlwaysRockPlayer implements Player {


	public AlwaysRockPlayer() {
		
	}
	@Override
	public int getMove() {
		return RPS.ROCK;
	}

	@Override
	public void saveLastRoundData(int yourMove, int opponentMove, int outcome) {
		// we don't do anything with the outcome because we always throw ROCK.
	}

}
