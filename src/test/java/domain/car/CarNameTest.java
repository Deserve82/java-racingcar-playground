package domain.car;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

import domain.car.CarName;
import java.security.InvalidParameterException;
import org.junit.jupiter.api.Test;

class CarNameTest {

    @Test
    void test_create_car_name_test() {
        assertDoesNotThrow(() -> {
            new CarName("test");
        });
    }

    @Test
    void test_car_name_is_over_5() {
        assertThrows(InvalidParameterException.class, () -> {
            new CarName("testAnddd");
        });
    }

}
