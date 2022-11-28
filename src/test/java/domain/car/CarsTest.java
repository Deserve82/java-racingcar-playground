package domain.car;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

import domain.car.Car;
import domain.car.Cars;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


class CarsTest {

    private Car a;
    private Car b;
    private Car c;
    private Cars cars;

    @BeforeEach
    void init() {
        a = new Car("a");
        b = new Car("b");
        c = new Car("c");
        cars = new Cars(Arrays.asList(a, b, c));
    }

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
        a.increaseProgress(5);

        List<Car> highestCars = cars.getHighestProgressCars();

        assertThat(highestCars.size()).isEqualTo(1);
        assertThat(highestCars.get(0)).isEqualTo(a);
    }

    @Test
    void test_get_highest_progress_test_with_more_than_two() {
        a.increaseProgress(5);
        b.increaseProgress(4);

        List<Car> highestCars = cars.getHighestProgressCars();

        assertThat(highestCars.size()).isEqualTo(2);
    }

    @Test
    void test_get_highest_progress_test_with_more_than_two_2() {
        b.increaseProgress(4);
        b.increaseProgress(7);
        c.increaseProgress(4);

        List<Car> highestCars = cars.getHighestProgressCars();

        assertThat(highestCars.size()).isEqualTo(1);
        assertThat(highestCars.get(0)).isEqualTo(b);
    }

    @Test
    void test_increase_progress_with_index() {
        cars.increaseProgress(0, 8);
        cars.increaseProgress(1, 2);
        cars.increaseProgress(1, 1);

        assertThat(cars.getCarList().get(0).getProgress()).isEqualTo(1);
        assertThat(cars.getCarList().get(1).getProgress()).isEqualTo(0);
        assertThat(cars.getCarList().get(2).getProgress()).isEqualTo(0);
    }
}
