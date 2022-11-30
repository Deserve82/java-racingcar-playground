package ui;

import domain.car.Car;
import domain.car.Cars;
import java.util.List;

public class OutputView {

    public void printStart() {
        System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).");
    }

    public void printTypeCount() {
        System.out.println("시도할 회수는 몇회인가요?");
    }

    public void printProgress(Cars cars) {
        for(Car car : cars.getCarList()) {
            StringBuilder sb = new StringBuilder();
            sb.append(car.getName()).append(" : ");

            for (int i = 0; i < car.getProgress(); i++) {
                sb.append("-");
            }
            System.out.println(sb);
        }
        System.out.println();
    }

    public void printResult() {
        System.out.println("실행 결과");
    }


    public void printWinner(List<Car> cars) {
        StringBuilder sb = new StringBuilder();
        for (int i=0; i<cars.size(); i++) {
            sb.append(cars.get(i).getName());
            if (i != cars.size() - 1) {
                sb.append(", ");
            }
        }

        sb.append("가 최종 우승했습니다.");
        System.out.println(sb);
    }
}
