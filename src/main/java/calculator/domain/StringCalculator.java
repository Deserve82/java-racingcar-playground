package calculator.domain;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class StringCalculator {

    private String splitter = ",|:";

    public int calculate(String input) {

        if (input == null || input.isEmpty()) {
            return 0;
        }

        input = addCustomParser(input);

        List<Integer> parsedList = parseStringListToIntegerList(input.split(splitter));
        checkHasNegative(parsedList);
        return parsedList.stream().mapToInt(Integer::intValue).sum();
    }

    private void checkHasNegative(List<Integer> parsedList) {
        Optional<Integer> value = parsedList.stream().filter(val -> val < 0).findFirst();
        if (value.isPresent()) {
            throw new RuntimeException("음수는 사용 할 수 없습니다.");
        }
    }

    private List<Integer> parseStringListToIntegerList(String[] list) {
        return Arrays.stream(list).map(Integer::parseInt)
                .collect(Collectors.toList());
    }

    private String addCustomParser(String input) {
        Matcher m = Pattern.compile("//(.)\n(.*)").matcher(input);
        if (m.find()) {
            String customDelimiter = m.group(1);
            splitter = splitter + "|" + customDelimiter;
            input = m.group(2);
        }

        return input;
    }
}
