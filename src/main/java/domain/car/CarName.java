package domain.car;

import java.security.InvalidParameterException;

public class CarName {

    private final String name;

    public CarName(String name) {

        if (name == null ||  name.isEmpty()) {
            throw new InvalidParameterException("차량의 이름을 입력해 주세요.");
        }

        if (name.length() > 5) {
            throw new InvalidParameterException("이름은 5자 이상을 초과 할 수 없습니다.");
        }

        this.name = name;
    }

    public String getName() {
        return name;
    }
}
