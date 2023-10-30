package racingcar;

import camp.nextstep.edu.missionutils.Randoms;

public class MovingCar implements Car {

    private final String name;
    private int moveCount = 0;

    public MovingCar(String name) {
        if (name == null || name.length() > 5) {
            throw new IllegalArgumentException();
        }
        this.name = name;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public void move() {
        int random = Randoms.pickNumberInRange(0, 9);
        if ( random >= 4 ) {
            moveCount+=1;
        }
    }

    @Override
    public int getMoveCount() {
        return this.moveCount;
    }
}
