package racingcar.domain;

public class Car {
    private static final int MOVE_CONDITION = 4;
    private final String name;
    private int position = 0;

    public Car(String name) {
        validateName(name);
        this.name = name;
    }

    private void validateName(String name) {
        if (name == null || name.isEmpty() || name.length() > 5) {
            throw new IllegalArgumentException("[ERROR] 자동차 이름은 1자 이상 5자 이하만 가능합니다.");
        }
    }

    public void move(int randomNumber) {
        if (randomNumber >= MOVE_CONDITION) {
            position++;
        }
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }

    public String getPositionSymbol() {
        return "-".repeat(position);
    }
}
