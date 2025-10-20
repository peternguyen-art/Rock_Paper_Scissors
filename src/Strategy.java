/**
 * The Strategy interface defines a contract for all computer move strategies
 * used in the Rock-Paper-Scissors game. Each strategy determines how
 * the computer chooses its next move based on the player’s move history.
 *
 * Implementations of this interface include:
 * <ul>
 *     <li>{@link RockPaperScissorsFrame.LeastUsed}</li>
 *     <li>{@link RockPaperScissorsFrame.MostUsed}</li>
 *     <li>{@link RockPaperScissorsFrame.LastUsed}</li>
 *     <li>{@link RpsRandom}</li>
 *     <li>{@link RpsCheat}</li>
 * </ul>
 *
 * Author: Peter Nguyễn
 * Version: 1.0
 * Date: October 2025
 */
public interface Strategy {
    /**
     * Determines the computer's next move based on the given player move.
     *
     * @param playerMove the player's most recent move ("R", "P", or "S")
     * @return the computer's move ("R", "P", or "S")
     */
    public String getMove(String playerMove);
}
