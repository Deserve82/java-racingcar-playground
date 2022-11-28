package domain;

public class Car {

    private final CarName name;
    private CarProgress progress;

    public Car(String name) {
        this.name = new CarName(name);
        this.progress = new CarProgress();
    }

    public int getProgress() {
        return progress.getProgress();
    }

    public String getName() {
        return name.getName();
    }

    public void increaseProgress(int value) {
        if (value >= 4) {
            this.progress.increaseProgress();
        }
    }
}
