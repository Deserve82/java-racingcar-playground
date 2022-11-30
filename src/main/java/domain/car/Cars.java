package domain.car;

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

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        for (Car car : carList) {
            builder.append(car.getName()).append(" : ").append(car.getProgress());
        }
        return builder.toString();
    }

    public List<Car> getCarList() {
        return carList;
    }

    public int getSize() {
        return carList.size();
    }

    public List<Car> getHighestProgressCars() {
        List<Car> cars = new ArrayList<>();
        CarProgress pivot = new CarProgress();

        for (Car car : carList) {
            if (car.isBigger(pivot)) {
                cars = new ArrayList<>(Collections.singletonList(car));
                pivot = car.getCarProgress();
            } else if (car.isSame(pivot)) {
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
