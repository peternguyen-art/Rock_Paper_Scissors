import java.util.Random;

public class rpsRandom implements Strategy{
    Random rand = new Random();
    String compMove;

    @Override
    public String getMove(String playerMove) {
        String[] moves = {"R", "P", "S"};
        compMove = moves[rand.nextInt(3)];
        return compMove;
    }
}
