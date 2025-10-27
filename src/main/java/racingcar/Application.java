package racingcar;

import racingcar.domain.Car;
import racingcar.domain.RacingGame;
import racingcar.view.InputView;
import racingcar.view.ResultView;

import java.util.ArrayList;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        String[] carNames = InputView.inputCarNames();
        List<Car> cars = createCars(carNames);

        int tryCount = InputView.inputTryCount();
        RacingGame racingGame = new RacingGame(cars);

        System.out.println("실행 결과");
        for (int i = 0; i < tryCount; i++) {
            racingGame.playRound();
            ResultView.printRoundResult(cars);
        }

        List<String> winners = findWinners(cars);
        ResultView.printWinners(winners);
    }

    private static List<Car> createCars(String[] names) {
        List<Car> cars = new ArrayList<>();
        for (String name : names) {
            cars.add(new Car(name.trim()));
        }
        return cars;
    }

    private static List<String> findWinners(List<Car> cars) {
        int maxPosition = cars.stream()
                .mapToInt(Car::getPosition)
                .max()
                .orElse(0);

        List<String> winners = new ArrayList<>();
        for (Car car : cars) {
            if (car.getPosition() == maxPosition) {
                winners.add(car.getName());
            }
        }
        return winners;
    }
    }

