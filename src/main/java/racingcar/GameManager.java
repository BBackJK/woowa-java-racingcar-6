package racingcar;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class GameManager {

    private final List<Car> carList;

    private final int playCount;

    public GameManager(String inputCarNames, int playCount) {
        this.carList = Arrays.stream(inputCarNames.split(",")).map(MovingCar::new).collect(Collectors.toUnmodifiableList());
        this.playCount = playCount;
    }

    public List<String> getFinishedOnStart() {
        this.start();
        int maxMoveCount = this.getMaxTotal();
        return this.finished(maxMoveCount);
    }

    private void start() {
        IntStream.range(0, playCount)
                .forEach(count -> {
                    this.carList.forEach(car -> {
                        car.move();
                        StringBuilder sb = new StringBuilder(car.getName());
                        sb.append(" : ");
                        int moveCount = car.getMoveCount();
                        sb.append("-".repeat(Math.max(0, moveCount)));
                        println(sb.toString());
                    });
                    print("\n");
                });
    }

    private int getMaxTotal() {
        return this.carList.stream()
                .map(Car::getMoveCount)
                .max(Comparator.comparing(integer -> integer)).orElseThrow(IllegalArgumentException::new);
    }

    private List<String> finished(int maxMoveCount) {
        return this.carList.stream().filter(car -> car.getMoveCount() == maxMoveCount).map(Car::getName).toList();
    }

    private void print(String msg) {
        System.out.print(msg);
    }

    private void println(String msg) {
        System.out.println(msg);
    }
}
