import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class Readfile {
    public static void input(String file) throws IOException {
        File data = new File(file);
        FileReader fr = new FileReader(data);
        BufferedReader br = new BufferedReader(fr);
        String line;
        while ((line = br.readLine()) != null) {
            String[] values = line.split("[,\s]");
            new Vent(Integer.parseInt(values[0]), Integer.parseInt(values[1]), Integer.parseInt(values[3]), Integer.parseInt(values[4]));
        }
        fr.close();
    }
}
