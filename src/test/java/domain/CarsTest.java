package domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

import org.junit.jupiter.api.Test;


class CarsTest {

    @Test
    void test_create_cars() {
        assertDoesNotThrow(() -> new Cars());
    }

    @Test
    void test_add_car(){
        Car car = new Car("test");
        Cars cars = new Cars();

        cars.addCar(car);
        assertThat(cars.getCarList().get(0)).isEqualTo(car);
    }
}
