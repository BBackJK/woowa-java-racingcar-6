package racingcar;

import camp.nextstep.edu.missionutils.Console;

import java.util.List;

public class Application {
    public static void main(String[] args) {
        println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String inputCarNames = Console.readLine();
        println("시도할 회수는 몇회인가요?");
        int playCount = getPlayCount();
        print("\n");
        println("실행 결과");

        GameManager manager = new GameManager(inputCarNames, playCount);
        List<String> finishedNames = manager.getFinishedOnStart();

        print("최종 우승자 : ");
        print(String.join(", ", finishedNames));
    }

    private static void println(String msg) {
        System.out.println(msg);
    }

    private static void print(String msg) {
        System.out.print(msg);
    }

    private static int getPlayCount() {
        try {
            String playNumber = Console.readLine();
            return Integer.parseInt(playNumber, 10);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException();
        }
    }
}
