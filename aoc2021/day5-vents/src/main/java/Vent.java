import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


public class Vent {
    int[] start;
    int[] stop;
    static List<Vent> listOfVents = new ArrayList<>();

    /* A vent object is created and store in a list of vents. */
    public Vent(int x1, int y1, int x2, int y2) {
        this.start = new int[]{x1, y1};
        this.stop = new int[]{x2, y2};
        listOfVents.add(this);
    }

    public static void main(String[] args) {
        Sea s = new Sea();
        String filename = "src/main/java/data";
        try {
            Readfile.input(filename);
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("Overlaps: " + s.line((ArrayList<Vent>) listOfVents));

    }
}
