import java.util.HashSet;

public class Duplicate {
    public boolean containsDuplicate(int[] nums) {
        HashSet<Integer> s = new HashSet<>();
        for (int i : nums) {
            if (s.add(i)) {
                continue;
            } else {
                return true;
            }
        }
        return false;
    }

}
