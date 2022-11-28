package domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

import domain.car.Car;
import domain.car.Cars;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class RacingGameTest {

    private RacingGame game;

    @BeforeEach
    void init() {
        Car a = new Car("a");
        a.increaseProgress(5);
        Car b = new Car("b");
        Cars cars = new Cars(Arrays.asList(a, b));

        game = new RacingGame(1, cars);
    }

    @Test
    void test_create_racing_game() {
        assertDoesNotThrow(() -> new RacingGame(4, Arrays.asList("test,test1,test2".split(","))));
    }

    @Test
    void test_check_winner() {

        List<Car> winners = game.getWinners();

        assertThat(winners.size()).isEqualTo(1);
        assertThat(winners.get(0).getName()).isEqualTo("a");
    }

    @Test
    void test_play() {

        game.play();

        assertThat(game.getCount()).isEqualTo(0);
    }
}
