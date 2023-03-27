import java.util.*;

public class UnfairLotteryDistributionSoln {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Read the prizes and return an array of substrings
        System.out.print("Enter the values of this week's prizes separated using commas: ");
        String[] prizeInput = scanner.nextLine().split(",");
        int[] prizes = new int[prizeInput.length];
        // iterate through the prizes array and convert them to integers
        for (int i = 0; i < prizeInput.length; i++) {
            prizes[i] = Integer.parseInt(prizeInput[i]);
        }

        // Read the winners and return an array of substrings
        System.out.print("Enter the names of this week's winners separated using commas: ");
        String[] winners = scanner.nextLine().split(",");

        // Distribute the prizes among the winners
        int totalPrize = 0;
        for (int prize : prizes) {
            totalPrize += prize;
        }
        // take the total prize and divide it among the total winners
        int prizePerWinner = totalPrize / winners.length;
        // find the remaining prize
        int remainingPrize = totalPrize % winners.length;
        // initialize a map to associate each winner with a list of prizes
        Map<String, List<Integer>> winnerToPrizesMap = new HashMap<>();
        for (String winner : winners) {
            winnerToPrizesMap.put(winner, new ArrayList<>());
        }
        for (int i = 0; i < prizes.length; i++) {
            String winner = winners[i % winners.length];
            if (winnerToPrizesMap.get(winner).size() < prizePerWinner) {
                winnerToPrizesMap.get(winner).add(prizes[i]);
            } else {
                winnerToPrizesMap.get(winner).add(prizes[i]);
                remainingPrize -= prizes[i];
                if (remainingPrize < 0) {
                    System.err.println("Error: No remaining prize.");
                    return;
                }
            }
        }

        // Print the prize distribution
        for (String winner : winners) {
            List<Integer> winnerPrizes = winnerToPrizesMap.get(winner);
            System.out.print(winner + ":");
            for (int i = 0; i < winnerPrizes.size(); i++) {
                System.out.print(winnerPrizes.get(i));
                if (i < winnerPrizes.size() - 1) {
                    System.out.print(",");
                }
            }
            System.out.println();
        }
    }
}
