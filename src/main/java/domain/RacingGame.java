package domain;

import domain.car.Car;
import domain.car.Cars;
import java.security.InvalidParameterException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class RacingGame {

    private int count;
    private final Random random;
    private final Cars cars;

    public RacingGame(int count, List<String> carNames) {
        if (count < 1) {
            throw new InvalidParameterException("1번 이상 게임을 실행해야 합니다.");
        }

        this.random = new Random();
        this.count = count;
        this.cars = new Cars(parseCarNamesToCarList(carNames));
    }

    public RacingGame(int count, Cars cars) {
        this.count = count;
        this.cars = cars;
        this.random = new Random();
    }

    private List<Car> parseCarNamesToCarList(List<String> names) {
        List<Car> cars = new ArrayList<>();
        for (String name : names) {
            cars.add(new Car(name));
        }
        return cars;
    }

    public List<Car> getWinners() {
        return cars.getHighestProgressCars();
    }

    public Cars getCars() {
        return this.cars;
    }

    public void play() {
        count--;
        for (int i = 0; i < cars.getSize(); i++) {
            cars.increaseProgress(i, getRandomNumber());
        }
    }

    public boolean isEnd() {
        return count == 0;
    }

    private int getRandomNumber() {
        return random.nextInt(9);
    }
}
