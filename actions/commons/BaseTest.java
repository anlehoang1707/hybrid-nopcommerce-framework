package commons;

import java.util.Random;

public class BaseTest {
    public int generateRandom() {
        return new Random().nextInt(99999);
    };
}
