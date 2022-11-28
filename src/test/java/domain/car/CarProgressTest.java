package domain.car;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

import domain.car.CarProgress;
import org.junit.jupiter.api.Test;

public class CarProgressTest {
    @Test
    void test_car_progress() {
        assertDoesNotThrow(() -> {
            new CarProgress(0);
        });
    }

    @Test
    void test_increase_progress() {
        CarProgress carProgress = new CarProgress();

        carProgress.increaseProgress();

        assertThat(carProgress.getProgress()).isEqualTo(1);
    }

}
