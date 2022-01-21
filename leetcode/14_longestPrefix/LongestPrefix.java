public class LongestPrefix {
    public String longestCommonPrefix(String[] strs) {
        if (strs.length <= 1) {
            return "";
        }
        int position = 0;
        while (position < strs[0].length()) {
            char letter = strs[0].charAt(position);
            for (String s : strs) {
                if (position == s.length() || s.charAt(position) != letter) {
                    if (position == 0) {
                        return "";
                    }
                    return strs[0].substring(0, position);
                }
            }
            position++;
        }
        return strs[0];
    }
}
