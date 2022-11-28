package domain;

import domain.car.Car;
import domain.car.Cars;
import java.security.InvalidParameterException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import ui.OutputView;

public class RacingGame {

    private int count;
    private final Random random;
    private final Cars cars;

    private final OutputView outputView = new OutputView();

    public RacingGame(int count, List<String> carNames) {
        if (count < 1) {
            throw new InvalidParameterException("1번 이상 게임을 실행해야 합니다.");
        }

        this.random = new Random();
        this.count = count;
        this.cars = new Cars(getCars(carNames));
    }

    public RacingGame(int count, Cars cars) {
        this.count = count;
        this.cars = cars;
        this.random = new Random();
    }

    private List<Car> getCars(List<String> names) {
        List<Car> cars = new ArrayList<>();
        for (String name : names) {
            cars.add(new Car(name));
        }
        return cars;
    }

    public List<Car> getWinners() {
        return cars.getHighestProgressCars();
    }

    public int getCount() {
        return count;
    }

    public void play() {
        if (count < 1) {
            throw new RuntimeException("더 이상 플레이 할 수 없습니다.");
        }

        outputView.printResult();
        while (count > 0) {
            for (int i = 0; i < cars.getSize(); i++) {
                cars.increaseProgress(i, getRandomNumber());
                outputView.printProgress(cars.getCar(i));
            }
            count--;
            outputView.printNewLine();
        }
        outputView.printWinner(getWinners());
    }

    private int getRandomNumber() {
        return random.nextInt(9);
    }
}
