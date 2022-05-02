// import java.lang.reflect.Method;
// import java.lang.reflect.Modifier;
// import java.util.function.Predicate;
// import java.util.stream.Collectors;
// import java.util.Arrays;
import java.util.HashSet;
// import java.util.List;
import java.util.Set;
// import java.util.ArrayList;
// import java.util.LinkedList;

// import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
// import static org.junit.Assert.assertFalse;
// import static org.junit.Assert.assertNotEquals;
// import static org.junit.Assert.assertTrue;
// import static org.junit.Assert.fail;
import org.junit.Test;

public class TestCases {

    @Test
    public void testWinningLotNumber() {

        Game game = new Game();
        game.winningLotNumber();
        assertEquals(5, game.getWinningNumbers().size());

    }

    @Test
    public void testMatches() {

        Game game = new Game();
        Set<Integer> numbers = new HashSet<Integer>();
        numbers.add(1);
        numbers.add(9);
        numbers.add(8);
        numbers.add(4);
        numbers.add(2);
        game.setWinningNumbers(numbers);
        Set<Integer> playerNumbers = new HashSet<Integer>();
        playerNumbers.add(2);
        playerNumbers.add(7);
        playerNumbers.add(15);
        playerNumbers.add(4);
        playerNumbers.add(9);
        assertEquals(3, game.matches(playerNumbers));
    
    }

    @Test
    public void testMonetaryResult() {

        Game game = new Game();
        Set<Integer> numbers = new HashSet<Integer>();
        numbers.add(1);
        numbers.add(9);
        numbers.add(8);
        numbers.add(4);
        numbers.add(2);
        game.setWinningNumbers(numbers);
        Set<Integer> playerNumbers = new HashSet<Integer>();
        playerNumbers.add(2);
        playerNumbers.add(7);
        playerNumbers.add(15);
        playerNumbers.add(4);
        playerNumbers.add(9);

        assertEquals(10.86f, game.monetaryResult(playerNumbers), 0.001);

    }
    
}
