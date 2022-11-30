import domain.RacingGame;
import java.util.List;
import ui.InputView;
import ui.OutputView;

public class Main {

    public static void main(String[] args) {
        InputView inputView = new InputView();
        OutputView outputView = new OutputView();

        outputView.printStart();
        List<String> cars = inputView.getCarsNames();

        outputView.printTypeCount();
        int count = inputView.getCount();

        outputView.printResult();
        RacingGame game = new RacingGame(count, cars);
        while (!game.isEnd()) {
            game.play();
            outputView.printProgress(game.getCars());
        }
        outputView.printWinner(game.getWinners());
    }
}
