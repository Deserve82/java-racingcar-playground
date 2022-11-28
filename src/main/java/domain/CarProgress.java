package domain;

import java.security.InvalidParameterException;

public class CarProgress {
    private Integer progress;

    public CarProgress(int progress) {
        if (progress < 0) {
            throw new InvalidParameterException("진행도는 0 미만일 수 없습니다.");
        }

        this.progress = progress;
    }

    public CarProgress() {
        this(0);
    }

    public void increaseProgress() {
        this.progress += 1;
    }

    public int getProgress() {
        return progress;
    }
}
