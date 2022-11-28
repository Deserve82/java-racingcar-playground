package ui;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class InputView {
    private Scanner sc = new Scanner(System.in);

    public List<String> getCarsNames() {
        String names = sc.nextLine();
        return Arrays.asList(names.split(","));
    }

    public int getCount() {
        return sc.nextInt();
    }
}
