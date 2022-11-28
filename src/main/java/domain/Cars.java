package domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Cars {

    private final List<Car> carList;

    public Cars(List<Car> carList) {
        this.carList = carList;
    }

    public Cars() {
        this(new ArrayList<>());
    }

    public void addCar(Car car) {
        carList.add(car);
    }

    public List<Car> getCarList() {
        return carList;
    }

    public List<Car> getHighestProgressCars() {
        List<Car> cars = new ArrayList<>();
        int pivot = 0;

        for (Car car : carList) {
            int progress = car.getProgress();
            if (progress > pivot) {
                cars = new ArrayList<>(Collections.singletonList(car));
                pivot = progress;
            } else if (progress == pivot) {
                cars.add(car);
            }
        }

        return cars;
    }

    public void increaseProgress(int index, int value) {
        Car targetCar = carList.get(index);
        targetCar.increaseProgress(value);
    }
}
