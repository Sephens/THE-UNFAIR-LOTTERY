// from util library import all
import java.util.*;

// main class
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

        //sort the prizes in descending order
        Arrays.sort(prizes);
        reverse(prizes);

        
        // take the total prize and divide it among the total winners
        // int prizePerWinner = totalPrize / winners.length;
        // find the remaining prize
        // int remainingPrize = totalPrize % winners.length;
        // initialize a map to associate each winner with a list of prizes


        Map<String, List<Integer>> winnerToPrizesMap = new HashMap<>();
        for (String winner : winners) {
            winnerToPrizesMap.put(winner, new ArrayList<>());
        }


        // Distribute the prizes among the winners
        // int totalPrize = 0;
        for (int i = 0; i < prizes.length; i++) {
            String winner = getWinnerWithLowest(winnerToPrizesMap);
            winnerToPrizesMap.get(winner).add(prizes[i]);
        }

        // for (int i = 0; i < prizes.length; i++) {
        //     String winner = winners[i % winners.length];
        //     if (winnerToPrizesMap.get(winner).size() < prizePerWinner) {
        //         winnerToPrizesMap.get(winner).add(prizes[i]);
        //     } else {
        //         winnerToPrizesMap.get(winner).add(prizes[i]);
        //         remainingPrize -= prizes[i];
        //         if (remainingPrize < 0) {
        //             System.err.println("Error: No remaining prize.");
        //             return;
        //         }
        //     }
        // }



        // Print the prize distribution
        for (String winner : winnerToPrizesMap.keySet()) {
            List<Integer> prizesOfWinner = winnerToPrizesMap.get(winner);
            System.out.print(winner + ":");
            for (int i = 0; i < prizesOfWinner.size(); i++) {
                System.out.print(prizesOfWinner.get(i));
                if (i < prizesOfWinner.size() - 1) {
                    System.out.print(",");
                }
            }
            System.out.println();
        }
    }


        //method to perform a reverse
        private static void reverse(int[]array){
            int a = 0;
            int b = array.length -1;
            while (a < b) {
                int temp = array[a];
                array[a] = array[b];
                array[b] = temp;
                a++;
                b--;
        }
    }

    //method to get winner with Lowest prize
    private static String getWinnerWithLowest(Map<String, List<Integer>> winnerToPrizeMap){
        String winner = null;
        int lowestPrize = Integer.MAX_VALUE;
        for(String key : winnerToPrizeMap.keySet()){
            List<Integer> prizesOfWinner = winnerToPrizeMap.get(key);
            int total = 0;
            for(int prize : prizesOfWinner){
                total += prize;
            }

            if(total < lowestPrize){
                winner = key;
                lowestPrize = total;
            }
        }

        return winner;
    }
}
