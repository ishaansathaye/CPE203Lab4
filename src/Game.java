import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class Game {

    private Set<Integer> winningNumbers;
    Random random = new Random();
    private float money;

    public Game() {

        winningNumbers = new HashSet<Integer>();

    }

    public void winningLotNumber() {

        winningNumbers.clear();
        int min = 1;
        int max = 42;
        while (this.winningNumbers.size() < 5) {
			int randomNum = this.random.nextInt(min, max + 1);
			this.winningNumbers.add(randomNum);
		}

    }

    public Set<Integer> getWinningNumbers() {
        return this.winningNumbers;
    }

    public void setWinningNumbers(Set<Integer> winningNumbers) {
        this.winningNumbers = winningNumbers;
    }

    public int matches(Set<Integer> numbers) {
        int matches = 0;
        for (Integer num : numbers) {
            if (this.winningNumbers.contains(num)) {
                matches++;
            }
        }
        return matches;
    }

    public float monetaryResult(Set<Integer> numbers) {

        this.money = -1;

        int numMatches = this.matches(numbers);

        if (numMatches == 2) {
            this.money += 1.0f;
            this.money += 1.0f;
        } else if (numMatches == 3) {
            this.money += 1.0f;
            this.money += 10.86f;
        } else if (numMatches == 4) {
            this.money += 1.0f;
            this.money += 197.53;
        } else if (numMatches == 5) {
            this.money += 1.0f;
            this.money += 212534.83f;
        }

        return this.money;
    
    }

    public void setMoney(float money) {
        this.money = money;
    }

    public float getMoney() {
        return this.money;
    }
    
}
