/**
 * The rpsCheat class implements the {@link Strategy} interface.
 * This strategy “cheats” by always selecting the move that beats
 * the player’s current choice.
 *
 * Author: Peter Nguyễn
 * Version: 1.0
 * Date: October 2025
 */
public class RpsCheat implements Strategy {
    /**
     * Returns the move that beats the player's current choice.
     *
     * @param playerMove the player's most recent move ("R", "P", or "S")
     * @return the winning move for the computer ("R", "P", or "S")
     */
    @Override
    public String getMove(String playerMove)
    {
        return switch (playerMove) {
            case "R" -> "P";
            case "P" -> "S";
            case "S" -> "R";
            default -> "X";
        };
    }
}
