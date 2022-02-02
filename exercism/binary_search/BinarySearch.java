
import java.util.List;

public class BinarySearch {

    List<Integer> numbers;

    public BinarySearch(List<Integer> numbers) {
        this.numbers = numbers;
    }


    public int indexOf(int s) throws ValueNotFoundException {
        if (numbers.isEmpty()) {
            throw new ValueNotFoundException("Value not in array");
        }
        int left = 0;
        int right = numbers.size() - 1;
        while (left < right) {
            if (s > numbers.get(right / 2 + left / 2)) {
                left = right / 2 + left;
            } else {
                right = right / 2 + left / 2;
            }
        }
            if (numbers.get(right) == s) {
                return right;
            } else {
                throw new ValueNotFoundException("Value not in array");
            }
    }
}
