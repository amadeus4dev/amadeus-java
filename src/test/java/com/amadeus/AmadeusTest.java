import com.amadeus.Amadeus;
import org.junit.Test;
import java.io.IOException;

import static org.junit.Assert.assertNull;

public class AmadeusTest {
  @Test public void testGet() throws IOException {
    Amadeus amadeus = new Amadeus();
    assertNull("test should return a string", amadeus.get());
  }
}
