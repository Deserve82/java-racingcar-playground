package domain.car;

public class Car {

    private final CarName name;
    private final CarProgress progress;

    public Car(String name) {
        this.name = new CarName(name);
        this.progress = new CarProgress();
    }

    public Car(String name, int progress) {
        this.name = new CarName(name);
        this.progress = new CarProgress(progress);
    }

    public int getProgress() {
        return progress.getProgress();
    }

    public CarProgress getCarProgress() {
        return progress;
    }

    public boolean isSame(CarProgress progress) {
        return this.progress.isSame(progress);
    }

    public boolean isBigger(CarProgress progress) {
        return this.progress.isBigger(progress);
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
