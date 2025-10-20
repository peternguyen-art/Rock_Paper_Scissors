import java.util.Random;
/**
 * The rpsRandom class implements the {@link Strategy} interface.
 * This strategy chooses the computer’s move completely at random.
 *
 * Author: Peter Nguyễn
 * Version: 1.0
 * Date: October 2025
 */
public class RpsRandom implements Strategy{
    Random rand = new Random();
    String compMove;
    /**
     * Returns a random move: Rock, Paper, or Scissors.
     *
     * @param playerMove the player's most recent move (ignored in this strategy)
     * @return a random computer move ("R", "P", or "S")
     */
    @Override
    public String getMove(String playerMove) {
        String[] moves = {"R", "P", "S"};
        compMove = moves[rand.nextInt(3)];
        return compMove;
    }
}
