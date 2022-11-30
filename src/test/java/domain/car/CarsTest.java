package domain.car;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

import domain.car.Car;
import domain.car.Cars;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
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

    @Test
    void test_get_highest_progress_test() {
        Car a = new Car("a", 1);
        Cars cars = new Cars(Collections.singletonList(a));

        List<Car> highestCars = cars.getHighestProgressCars();

        assertThat(highestCars.size()).isEqualTo(1);
        assertThat(highestCars.get(0)).isEqualTo(a);
    }

    @Test
    void test_get_highest_progress_test_with_more_than_two() {
        Car a = new Car("a", 1);
        Car b = new Car("b", 1);
        Cars cars = new Cars(Arrays.asList(a, b));

        List<Car> highestCars = cars.getHighestProgressCars();

        assertThat(highestCars.size()).isEqualTo(2);
    }

    @Test
    void test_get_highest_progress_test_with_more_than_two_2() {
        Car a = new Car("a", 0);
        Car b = new Car("b", 1);
        Cars cars = new Cars(Arrays.asList(a, b));

        List<Car> highestCars = cars.getHighestProgressCars();

        assertThat(highestCars.size()).isEqualTo(1);
        assertThat(highestCars.get(0)).isEqualTo(b);
    }

    @Test
    void test_increase_progress_with_index() {
        Car a = new Car("a", 0);
        Car b = new Car("b", 0);
        Car c = new Car("c", 0);
        Cars cars = new Cars(Arrays.asList(a, b, c));

        cars.increaseProgress(0, 8);
        cars.increaseProgress(1, 2);
        cars.increaseProgress(1, 1);

        assertThat(cars.getCarList().get(0).getProgress()).isEqualTo(1);
        assertThat(cars.getCarList().get(1).getProgress()).isEqualTo(0);
        assertThat(cars.getCarList().get(2).getProgress()).isEqualTo(0);
    }
}
