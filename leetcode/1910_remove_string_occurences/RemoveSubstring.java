public class RemoveSubstring {
    public String removeOccurrences(String s, String part) {

        /* This is the stopping condition. When there is no occurence of 'part'
        left in the string, the remainder is returned.
         */
        if (!s.contains(part)) {
            return s;
        }
        /* The index of the first occurrence of 'part' is determined. */
        int i = s.indexOf(part);

        /* If part does not consist of the first or the last character of s,
        the string is devided in a portion before and after 'part' (first and last).
        The two parts are concatenated and fed back into removeOccurences().
         */
        if (i != 0 && i + part.length() != s.length()) {
            String first = s.substring(0, i);
            String last = s.substring(i + part.length());
            return removeOccurrences(first.concat(last), part);
        }
        /* If the first char is involved, the string beginning from the end
        of 'part' is input to the method.
         */
        else if (i == 0) {
            String last = s.substring(part.length());
            return removeOccurrences(last, part);
        }
        /* If the last char is involved, the string minus 'part' is input to the method
         */
        else if (i + part.length() == s.length()) {
            String first = s.substring(0, s.length() - part.length());
            return removeOccurrences(first, part);
        }
        /* This return statement is never reached. It is because Java expects a return
        statement for all program paths.
         */
        return s;
    }
}
