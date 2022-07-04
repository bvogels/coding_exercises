import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.text.CharacterIterator;
import java.text.StringCharacterIterator;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Stack;

public class SyntaxChecker {
	
	/* These two maps define the legal combinations of brackets as well as their values
	 * for the first and the second part of the puzzle. Since they do not change they are
	 * defined as FINAL.
	 */

    final static Map<Character, Character> PAIRS = Map.of('(', ')',
            '[', ']',
            '{', '}',
            '<', '>');

    final static Map<Character, List<Integer>> VALUES = Map.of(')', Arrays.asList(3, 1),
            ']', Arrays.asList(57, 2),
            '}', Arrays.asList(1197, 3),
            '>', Arrays.asList(25137, 4));
    
    /* These two static variables keep score of the syntaxErrorValue for part one
     * and a List of Longs for the incomplete lines.
     * 
     */

    static int syntaxErrorScore = 0;
    static List<Long> incompleteLineValues = new ArrayList<>();


    /* Data is loaded from the file */
    
    public static void loadData(String file) throws IOException {
        File data = new File(file);
        FileReader fr = new FileReader(data);
        BufferedReader br = new BufferedReader(fr);
        String line;
        while ((line = br.readLine()) != null) {
            syntaxErrorScore += syntaxValidity(line);
        }
        fr.close();
    }

    /* Each line is processed separately.
     * The first while loop takes care of erroneous lines and calculates the value, thus increasing 
     * the syntaxErrorScore. A CharacterIterator iterates through the respective Strings in Order to avoid 
     * toCharArray. Each Character is pushed to a LIFO stack, as long as it is an opening bracket. If a 
     * closing bracket is detected, the top-most element from the stack is popped. It must match the current
     * character from the CharacterIterator. If not, the syntax is illegal, and the syntaxErrorScore is increased 
     * by the value associated with this character.
     */
    
    public static int syntaxValidity(String line) {
    	int lineError = 0;
    	long missingBracketsValue = 0;
        CharacterIterator it = new StringCharacterIterator(line);
        Stack<Character> brackets = new Stack<>();
        while (it.current() != CharacterIterator.DONE) {
            if (PAIRS.containsKey(it.current())) {
                brackets.push(it.current());
            } else {
                if (it.current() != PAIRS.get(brackets.pop())) {
                    lineError += VALUES.get(it.current()).get(0);
                    return lineError;
                }
            }
            it.next();
        }
        
        /* The remaining lines are take into account in this while loop. The preceding while loop terminates whenever an
         * illegal character is encountered, so the next while loop will only executed under the condition that the syntax of the
         * string is legal. It will also only executed if there are still characters on the stack, meaning not all open brackets
         * have been closed. The value of the closing brackets is calculated by popping each item from the stack. The value is
         * then stored in the incompleteLineValues array.
         */
        
        while (!brackets.isEmpty()) {
        	char closing = PAIRS.get(brackets.pop());
        	missingBracketsValue = (missingBracketsValue * 5) + VALUES.get(closing).get(1);        	
        }
        incompleteLineValues.add(missingBracketsValue);
        
        return 0;
    }
    
    /* This little method calculates the length and middle point of the array. Could be in the main function, though. */
    
    public static int middleValue() {
    	int s = incompleteLineValues.size();
    	return s/2+1;
    }

    public static void main(String[] args) throws IOException {
        String path = "src/main/resources/data";
        loadData(path);
        System.out.println("Sum of misplaced brackets: " + syntaxErrorScore);
    	Collections.sort(incompleteLineValues);
        System.out.println("Middle score: " + incompleteLineValues.get(middleValue()-1));
    


}}
