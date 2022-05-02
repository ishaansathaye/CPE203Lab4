import java.util.*;

/**
 * A class that represents the community and simulates
 * the running of the lottery.
 */
public final class CommunityLSim {

    ArrayList<CommunityMember> communityMembers;
    Random random = new Random();
    //you will need to add more instance variables
    private Set<Integer> membersEachYear;
    private Game lottoGame;
    //PP
	private static final double POORLY_PAID_PERCENTAGE = 0.6;
	private final int NUM_POORLY_PAID_EACH_YEAR;
	private final int POORLY_PAID_START;
	private final int POORLY_PAID_END;
    private static final double POORLY_PAID_SCHOLARSHIP_PERCENTAGE = 0.3;
    private final int NUM_POORLY_PAID_SCHOLARSHIP;
    //WP
	private static final double WELL_PAID_PERCENTAGE = 0.4;
	private final int NUM_WELL_PAID_EACH_YEAR;
	private final int WELL_PAID_START;
	private final int WELL_PAID_END;
    private static final double WELL_PAID_SCHOLARSHIP_PERCENTAGE = 0.7;
    private final int NUM_WELL_PAID_SCHOLARSHIP;

    /**
     * Creates a new Community with the specified number of people
     * @param numP The number of people in the community
     */
    public CommunityLSim( int numP) {
        lottoGame = new Game();
        membersEachYear = new HashSet<Integer>();
        //create the players
        this.communityMembers = new ArrayList<>();

        for (int i = 0; i < numP; i++) {
            if (i < numP /2.0)
                this.communityMembers.add(new CommunityMember(CMemberKind.POORLY_PAID, (float)(99+Math.random())));
            else
                this.communityMembers.add(new CommunityMember(CMemberKind.WELL_PAID, (float)(100.1+Math.random())));
        }

        //PP
        int totalPP = numP / 2;
        POORLY_PAID_START = 0;
        POORLY_PAID_END = totalPP - 1;
        NUM_POORLY_PAID_EACH_YEAR = (int) (totalPP * POORLY_PAID_PERCENTAGE);

        NUM_POORLY_PAID_SCHOLARSHIP = (int) (totalPP * POORLY_PAID_SCHOLARSHIP_PERCENTAGE);

        //WP
        int totalWP = numP - (numP / 2);
        WELL_PAID_START = POORLY_PAID_END + 1;
        WELL_PAID_END = numP - 1;
        NUM_WELL_PAID_EACH_YEAR = (int) (totalWP * WELL_PAID_PERCENTAGE);

        NUM_WELL_PAID_SCHOLARSHIP = (int) (totalWP * WELL_PAID_SCHOLARSHIP_PERCENTAGE);

    }

    public int getSize() {
        return this.communityMembers.size();
    }

    public CommunityMember getPlayer(int i) {
        return this.communityMembers.get(i);
    }

    /**
     * Give each community member some pocket change.
     * Give POORLY_PAID community members 0.03f, and give
     * WELL_PAID community members 0.1f.
     */
    // TODO: Implement this method.
    public void addPocketChange() {

        for (CommunityMember member : this.communityMembers) {
            if (member.getKind() == CMemberKind.POORLY_PAID) {
                member.addMoney(0.03f);
            } else {
                member.addMoney(0.1f);
            }
        }

    }

    // TODO: Write a method that computes a new list of lottery players,
    //  choosing from the list of community members.
    //  You will likely want to change this method signature.
    private void reDoWhoPlays() {

        membersEachYear.clear();
        randomUniqIndx(NUM_POORLY_PAID_EACH_YEAR, POORLY_PAID_START, POORLY_PAID_END, membersEachYear);
        randomUniqIndx(NUM_WELL_PAID_EACH_YEAR, WELL_PAID_START, WELL_PAID_END, membersEachYear);

    }

    /* generate some random indices for who might play the lottery
        in a given range of indices */

    /**
     * Generate a number of random indices within an interval
     * @param numI The number of random unique indices to generate
     * @param startRange The lower bound of the interval, inclusive
     * @param endRange The upper bound of the interval, exclusive
     */
    // TODO: Implement this method. You will likely want to change this
    //  method signature.
    private void randomUniqIndx(int numI, int startRange, int endRange, Set<Integer> membersList) {

        int temp = 0;

        while (temp < numI) {
            int randomNum = this.random.nextInt(startRange, endRange);
            if (!membersList.contains(randomNum)) {
                membersList.add(randomNum);
                temp++;
            }
        }
    }

    public void simulatePlay() {
        for (Integer temp: membersEachYear) {
            communityMembers.get(temp).getLottoNumbers();
        }
    }

    private void result()
	{
		for(Integer temp: membersEachYear) {
			float winnings = lottoGame.monetaryResult(communityMembers.get(temp).getLottoNumbers());
			communityMembers.get(temp).addMoney(winnings);

            //if 
			if (winnings < 0.0) {
				redistribute(Math.abs(winnings));
            }
		}
	}

    private void redistribute(float amount) {

        Set<Integer> scholarshipGroup = new HashSet<>();
        randomUniqIndx(NUM_POORLY_PAID_SCHOLARSHIP, POORLY_PAID_START, POORLY_PAID_END, scholarshipGroup);
        randomUniqIndx(NUM_WELL_PAID_SCHOLARSHIP, WELL_PAID_START, WELL_PAID_END, scholarshipGroup);
        
        //Finding the person that receives the "scholarship"
        int chosenIndex = random.nextInt(NUM_POORLY_PAID_SCHOLARSHIP + NUM_WELL_PAID_SCHOLARSHIP);
        Integer[] scholarshipGroupArray = scholarshipGroup.toArray(new Integer[scholarshipGroup.size()]);
        int memberIndex = scholarshipGroupArray[chosenIndex];
        communityMembers.get(memberIndex).addMoney(amount);

    }

    private float maxMoney(){
		float maxMoney = communityMembers.get(0).getMoney();

		for(CommunityMember cm: communityMembers) {
			
            if (cm.getMoney() > maxMoney) {

				maxMoney = cm.getMoney();

            }
        }

		return maxMoney;
	}

    private float minMoney(){
		float minMoney = communityMembers.get(0).getMoney();

		for(CommunityMember cm: communityMembers) {
			
            if (cm.getMoney() < minMoney) {

				minMoney = cm.getMoney();

            }
        }

		return minMoney;
	}

    public void simulateYears(int numYears) {
        // Simulate the lottery (see steps below)
        for (int year=0; year < numYears; year++) {
            // TODO Add pocket change for all community members, whether or not they're playing.
            // TODO Re-compute the players who are playing the lottery in the current year.
            // TODO Simulate the lottery for those players.
            System.out.println("After year " + year + ":");
            addPocketChange();
            reDoWhoPlays();
            simulatePlay();
            lottoGame.winningLotNumber();
            result();

            // 4. Update everyone's money for that year.
            for (CommunityMember cm : this.communityMembers) {
                cm.updateMoneyEachYear();
            }
            System.out.println("The person with the most money has: " + maxMoney());
            System.out.println("The person with the least money has: " + minMoney());
        }
    }

}
