import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

public class SeaTest {

    @Test
    public void straight_diagonal1() {
        Vent a = new Vent(0, 0, 0, 9);
        Vent b = new Vent(0, 9, 9, 0);
        ArrayList<Vent> vents = new ArrayList<>();
        vents.add(a);
        vents.add(b);
        Sea s = new Sea();
        int expected = 1;
        int actual = s.line(vents);
        assertEquals(actual,expected);
    }

    @Test
    public void straight_diagonal2() {
        Vent a = new Vent(0, 0, 0, 9);
        Vent b = new Vent(0, 0, 9, 9);
        ArrayList<Vent> vents = new ArrayList<>();
        vents.add(b);
        vents.add(a);
        Sea s = new Sea();
        int expected = 1;
        int actual = s.line(vents);
        assertEquals(actual,expected);
    }

    @Test
    public void straight_diagonal3() {
        Vent a = new Vent(0, 0, 0, 9);
        Vent b = new Vent(0, 0, 9, 9);
        Vent c = new Vent(0, 0, 9, 0);
        ArrayList<Vent> vents = new ArrayList<>();
        vents.add(a);
        vents.add(b);
        vents.add(c);
        Sea s = new Sea();
        int expected = 1;
        int actual = s.line(vents);
        assertEquals(actual,expected);
    }

    @Test
    public void straight_diagonal4() {
        Vent a = new Vent(0, 0, 0, 9);
        Vent b = new Vent(0, 0, 9, 9);
        Vent c = new Vent(0, 0, 9, 0);
        Vent d = new Vent(9, 0, 0, 9);
        ArrayList<Vent> vents = new ArrayList<>();
        vents.add(a);
        vents.add(b);
        vents.add(c);
        vents.add(d);
        Sea s = new Sea();
        int expected = 3;
        int actual = s.line(vents);
        assertEquals(actual,expected);
    }

    @Test
    public void cornercase1() {
        Vent a = new Vent(0, 0, 1, 1);
        Vent b = new Vent(1, 1, 2, 2);
        ArrayList<Vent> vents = new ArrayList<>();
        vents.add(a);
        vents.add(b);
        Sea s = new Sea();
        int expected = 1;
        int actual = s.line(vents);
        assertEquals(actual, expected);
    }

    @Test
    public void cornercase2() {
        Vent a = new Vent(2, 2, 1, 1);
        Vent b = new Vent(1, 1, 0, 0);
        ArrayList<Vent> vents = new ArrayList<>();
        vents.add(a);
        vents.add(b);
        Sea s = new Sea();
        int expected = 1;
        int actual = s.line(vents);
        assertEquals(actual, expected);
    }

    @Test
    public void cornercase3() {
        Vent a = new Vent(2, 2, 1, 1);
        Vent b = new Vent(1, 1, 0, 0);
        Vent c = new Vent(2, 2, 3, 3);
        ArrayList<Vent> vents = new ArrayList<>();
        vents.add(a);
        vents.add(b);
        vents.add(c);
        Sea s = new Sea();
        int expected = 2;
        int actual = s.line(vents);
        assertEquals(actual, expected);
    }

    @Test
    public void cornercase4() {
        Vent a = new Vent(2, 2, 1, 1);
        Vent b = new Vent(1, 1, 0, 0);
        Vent c = new Vent(2, 2, 3, 3);
        Vent d = new Vent(9, 9, 0, 0);
        ArrayList<Vent> vents = new ArrayList<>();
        vents.add(a);
        vents.add(b);
        vents.add(c);
        vents.add(d);
        Sea s = new Sea();
        int expected = 4;
        int actual = s.line(vents);
        assertEquals(actual, expected);
    }

    @Test
    public void cornercase5() {
        Vent a = new Vent(9, 0, 8, 0);
        Vent b = new Vent(8, 0, 7, 0);
        ArrayList<Vent> vents = new ArrayList<>();
        vents.add(a);
        vents.add(b);
        Sea s = new Sea();
        int expected = 1;
        int actual = s.line(vents);
        assertEquals(actual, expected);
    }

    @Test
    public void cornercase6() {
        Vent a = new Vent(8, 1, 9, 0);
        Vent b = new Vent(9, 9, 9, 0);
        ArrayList<Vent> vents = new ArrayList<>();
        vents.add(a);
        vents.add(b);
        Sea s = new Sea();
        int expected = 1;
        int actual = s.line(vents);
        assertEquals(actual, expected);
    }

    @Test
    public void cornercase7() {
        Vent a = new Vent(0, 0, 8, 8);
        Vent b = new Vent(8, 0, 0, 8);
        ArrayList<Vent> vents = new ArrayList<>();
        vents.add(a);
        vents.add(b);
        Sea s = new Sea();
        int expected = 1;
        int actual = s.line(vents);
        assertEquals(actual, expected);
    }

    @Test
    public void cornercase8() {
        Vent a = new Vent(9, 7, 8, 6);
        //Vent b = new Vent(8, 0, 0, 8);
        ArrayList<Vent> vents = new ArrayList<>();
        vents.add(a);
        //vents.add(b);
        Sea s = new Sea();
        int expected = 0;
        int actual = s.line(vents);
        assertEquals(actual, expected);
    }
}