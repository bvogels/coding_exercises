public class Zigzag {

    public String convert(String s, int numRows) {
        if (s.length() == 1 || numRows == 1) {
            return s;
        }
        int steps = 0; // Position in result
        int c = 0; // Character in s
        int distance = 1; // Distance factor to next char
        int offset = 0;
        int base = 0;
        int full = 0;
        char[] zigzag = new char[s.length()];
        while (c < numRows) {
            int pos = c;
            while (pos < s.length()) {
                zigzag[steps] = s.charAt(pos);
                steps++;
                if (numRows * 2 - 2 == offset + base && base != 0 && full + base == numRows * 2 - 2) {
                    pos += base;
                    full = 0;
                } else {
                    offset = numRows * 2 - distance * 2;
                    pos += offset;
                    full += offset;
                }
            }
            c++;
            distance++;
            if (distance == numRows) {
                distance = 1;
            }
            base += 2;
            full = 0;

        }
        return new String(zigzag);

    }
}
