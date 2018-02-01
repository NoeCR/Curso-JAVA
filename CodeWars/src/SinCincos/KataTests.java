package SinCincos;

import org.junit.Test;
import static org.junit.Assert.assertEquals;
import org.junit.runners.JUnit4;

public class KataTests {
    @Test
    public void exampleTests() {
      assertEquals(8, SinCincos.dontGiveMeFive(1,9));
      assertEquals(12, SinCincos.dontGiveMeFive(4,17));
    }
}