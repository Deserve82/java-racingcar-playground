package calculator;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

import calculator.domain.StringCalculator;
import org.junit.jupiter.api.Test;

class StringCalculatorTest {

    private StringCalculator calculator = new StringCalculator();

    @Test
    void test_string_calculator_with_comma() {
        assertThat(calculator.calculate("1,2")).isEqualTo(3);
    }

    @Test
    void test_string_calculator_with_colon() {
        assertThat(calculator.calculate("1:2")).isEqualTo(3);
    }

    @Test
    void test_string_calculator_with_colon_and_comma() {
        assertThat(calculator.calculate("1:2,3")).isEqualTo(6);
    }

    @Test
    void test_string_calculator_empty_string() {
        assertThat(calculator.calculate("")).isEqualTo(0);
    }

    @Test
    void test_string_calculator_one_value() {
        assertThat(calculator.calculate("3")).isEqualTo(3);
    }


    @Test
    void test_string_calculator_null_value() {
        assertThat(calculator.calculate(null)).isEqualTo(0);
    }

    @Test
    void test_string_calculator_custom_splitter() {
        assertThat(calculator.calculate("//;\n1;2;3")).isEqualTo(6);
    }

    @Test
    void test_string_calculator_negative_throw_exception() {
        assertThrows(RuntimeException.class, () -> calculator.calculate("-1,2,3"));
    }

    @Test
    void test_string_calculator_not_number_throw_exception() {
        assertThrows(RuntimeException.class, () -> calculator.calculate("a,2,3"));
    }
}
