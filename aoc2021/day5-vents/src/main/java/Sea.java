import java.util.ArrayList;

public class Sea {
    static int[][] sea;
    static int overlaps;

    /* This constructor creates an object sea with room room either for the test cases or the real puzzle. The static
    * variable overlap stores the number of overlapping lines. */
    public Sea() {
        sea = new int[999][999];
        //sea = new int[10][10];
        overlaps = 0;

    }

    /* The sea object can be printed. Only advised for the test cases. */
    private static void printSea() {
        for (int i = 0; i < sea[0].length; i++) {
            for (int j = 0; j < sea[0].length; j++) {
                System.out.printf("%d", sea[i][j]);
            }
            System.out.println();
        }
    }

    /* The lines are placed into the sea (array). To reduce the amount of code, I switch coordinates if the line travels
    upwards (towards 0) in the array, so I only have to deal with the downwards or right direction.
     */
    public int line(ArrayList<Vent> vents) {
        for (Vent v : vents) {
            if (v.start[0] == v.stop[0] || v.start[1] == v.stop[1]) { // Sift out diagonal lines.

                // The following lines switch coordinates if necessary.
                if (v.start[0] > v.stop[0]) {
                    int x = v.start[0];
                    v.start[0] = v.stop[0];
                    v.stop[0] = x;
                } else if (v.start[1] > v.stop[1]) {
                    int x = v.start[1];
                    v.start[1] = v.stop[1];
                    v.stop[1] = x;
                }

                /* If the x coordinates are the same, this part is executed. It means that the line travels down in the
                * array. The variable marker stores the initial value of y and is incremented till the stop value is
                * reached. On its way, it inrements every value by one. If a value becomes two, it means it intersects
                * with another line. In this case, and only in this case, we have a relevant overlap, so overlap is
                * increased by one.
                * The else clause does the same if the line travels in y direction.*/
                if (v.start[0] == v.stop[0]) {
                    int marker = v.start[1];
                    while (marker <= v.stop[1]) {
                        sea[marker][v.start[0]]++;
                        if (sea[marker][v.start[0]] == 2) {
                            overlaps++;
                        }
                        marker++;
                    }
                } else {
                    int marker = v.start[0];
                    while (marker <= v.stop[0]) {
                        sea[v.start[1]][marker]++;
                        if (sea[v.start[1]][marker] == 2) {
                            overlaps++;
                        }
                        marker++;
                    }
                }
            } else {
                diagonal(v); // Diagonal lines are now considered
            }
        }
        //printSea();
        return overlaps;
    }

    private void diagonal(Vent v) {

        /* The same as above. If the line travels from bottem right to top left, the coordinates are reversed to reduced
        * the amount of code.  The first if statement distinguishes between bottom-left to top-right (and vice versa)
        * versus top-left to bottom-right (and vice versa). The subsequent if statement makes the vice versa decision.
         */

        if ((v.start[0] < v.stop[0] && v.start[1] < v.stop[1]) || (v.start[0] > v.stop[0] && v.start[1] > v.stop[1])) {
            if (v.start[0] > v.stop[0]) {
                int x = v.start[0];
                int y = v.start[1];
                v.start[0] = v.stop[0];
                v.start[1] = v.stop[1];
                v.stop[0] = x;
                v.stop[1] = y;
            }

            /* Like in the code for straight lines, a marker is set, but now with both x and y coordinates of the start
            value. In every step of the while loop, both values are incremented until they reach the stop values.
            On their way, every value is increased by one. If a Two is detected, an overlap happenrd and the variable
            overlap is increased.
             */
            int[] marker = new int[]{v.start[0], v.start[1]};
            while (marker[0] <= v.stop[0] && marker[1] <= v.stop[1]) {
                sea[marker[1]][marker[0]]++;
                if (sea[marker[1]][marker[0]] == 2) {
                    overlaps++;
                }
                marker[0]++;
                marker[1]++;
            }
        } else {

            /* The same as above, but now for lines that travel from down to top. */
            if (v.start[0] > v.stop[0] && v.start[1] < v.stop[1]) {
                int x = v.start[0];
                int y = v.start[1];
                v.start[0] = v.stop[0];
                v.start[1] = v.stop[1];
                v.stop[0] = x;
                v.stop[1] = y;
            }

            int[] marker = new int[]{v.start[0], v.start[1]};
            while (marker[0] <= v.stop[0] && marker[1] >= v.stop[1]) {
                sea[marker[1]][marker[0]]++;
                if (sea[marker[1]][marker[0]] == 2) {
                    overlaps++;
                }
                marker[0]++;
                marker[1]--;
            }
        }
    }
}
