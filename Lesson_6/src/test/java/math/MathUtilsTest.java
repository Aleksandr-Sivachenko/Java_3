package math;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.NullAndEmptySource;

import java.util.stream.Stream;
public class MathUtilsTest {

    @ParameterizedTest
    @MethodSource("actualAndExpectedResultsProvider")
    void shouldReturnArrayAfterSearch(int[] parameters, int[] expected) {
        Assertions.assertArrayEquals(expected, MathUtils.findElementsAfterDigit(parameters,4));
    }

    private static Stream<Arguments> actualAndExpectedResultsProvider() {
        return Stream.of(
                Arguments.arguments(new int[] {1,2,3,4,5}, new int[] {5}),
                Arguments.arguments(new int[] {1,3,4,5,6,2,3,4,5,6,7}, new int[] {5,6,7}),
                Arguments.arguments(new int[] {2,3,4,23,1,3,4}, new int[] {})
        );
    }

    @ParameterizedTest
    @NullAndEmptySource
    @MethodSource("wrongParametersProvider")
    void shouldThrowRuntimeExceptionWhenValueNotFound(int[] parameters) {
        RuntimeException runtimeException = Assertions.assertThrows(
                RuntimeException.class,
                () -> MathUtils.findElementsAfterDigit(parameters,4)
        );
        Assertions.assertNotNull(runtimeException);
    }
    private static Stream<int[]> wrongParametersProvider() {
        return Stream.of(
                new int[] {1,2,3,5}
        );
    }

}
