import com.amadeus.*;
import org.junit.Test;
import static org.junit.Assert.*;
import java.io.IOException;

public class AmadeusTest {
    @Test public void testTest() throws IOException {
        Amadeus amadeus = new Amadeus();
        assertNull("test should return a string", amadeus.test());
    }
}
