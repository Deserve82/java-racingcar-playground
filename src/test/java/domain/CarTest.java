package domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.security.InvalidParameterException;
import org.junit.jupiter.api.Test;

class CarTest {

    @Test
    void test_create_car_test() {
        assertDoesNotThrow(() -> {
            new Car("test");
        });
    }

    @Test
    void test_car_name_cannot_be_over_5() {
        assertThrows(InvalidParameterException.class, () -> {
            new Car("testAndTest");
        });
    }

    @Test
    void test_car_progress_increase() {
        Car car = new Car("test");
        car.increaseProgress(4);
        assertThat(car.getProgress()).isEqualTo(1);
    }

    @Test
    void test_car_progress_increase_under_5() {
        Car car = new Car("test");
        car.increaseProgress(3);
        assertThat(car.getProgress()).isEqualTo(0);
    }
}
