
package mru.tsc.application;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

import org.junit.jupiter.api.Test;

class AppTest {

    @Test
    void testMain() {
        String[] args = {};

        assertDoesNotThrow(() -> App.main(args));
    }

}
