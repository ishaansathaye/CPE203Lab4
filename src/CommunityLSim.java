import java.util.*;

/**
 * A class that represents the community and simulates
 * the running of the lottery.
 */
public final class CommunityLSim {

    ArrayList<CommunityMember> communityMembers;
    Random random = new Random();
    //you will need to add more instance variables

    /**
     * Creates a new Community with the specified number of people
     * @param numP The number of people in the community
     */
    public CommunityLSim( int numP) {
        //create the players
        this.communityMembers = new ArrayList<>();

        for (int i = 0; i < numP; i++) {
            if (i < numP /2.0)
                this.communityMembers.add(new CommunityMember(CMemberKind.POORLY_PAID, (float)(99+Math.random())));
            else
                this.communityMembers.add(new CommunityMember(CMemberKind.WELL_PAID, (float)(100.1+Math.random())));
        }

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

    }

    // TODO: Write a method that computes a new list of lottery players,
    //  choosing from the list of community members.
    //  You will likely want to change this method signature.
    private void reDoWhoPlays() {

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
    public void randomUniqIndx(int numI, int startRange, int endRange) {

    }

    public void simulateYears(int numYears) {
        // Simulate the lottery (see steps below)
        for (int year=0; year < numYears; year++) {
            // TODO Add pocket change for all community members, whether or not they're playing.
            // TODO Re-compute the players who are playing the lottery in the current year.
            // TODO Simulate the lottery for those players.

            // 4. Update everyone's money for that year.
            for (CommunityMember cm : this.communityMembers) {
                cm.updateMoneyEachYear();
            }
        }
    }

}
