package aaron.coin_calculator.api;

import aaron.coin_calculator.resources.CoinCalculatorRequest;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Collections;

import org.junit.jupiter.api.Test;

public class CoinCalculatorTest {

    // Valid input example 1
    @Test
    void testValidInputExample1() {
        // Arrange
        CoinCalculator calculator = new CoinCalculator();
        CoinCalculatorRequest request = new CoinCalculatorRequest();
        request.setTargetAmount(new BigDecimal("7.03"));
        request.setCoinDenominations(Arrays.asList(
            new BigDecimal("0.01"),
            new BigDecimal("0.5"),
            new BigDecimal("1"),
            new BigDecimal("5"),
            new BigDecimal("10")
        ));

        // Act
        String result = calculator.calculateCoins(request);

        // Assert
        assertEquals("[0.01, 0.01, 0.01, 1, 1, 5]", result, "Should return correct coins");
    }

    // Valid input example 2
    @Test
    void testValidInputExample2() {
        // Arrange
        CoinCalculator calculator = new CoinCalculator();
        CoinCalculatorRequest request = new CoinCalculatorRequest();
        request.setTargetAmount(new BigDecimal("103"));
        request.setCoinDenominations(Arrays.asList(
            new BigDecimal("1"),
            new BigDecimal("2"),
            new BigDecimal("50")
        ));

        // Act
        String result = calculator.calculateCoins(request);

        // Assert
        assertEquals("[1, 2, 50, 50]", result, "Should return correct coins");
    }

    // Null request body
    @Test
    void testInvalidRequest_NullRequest() {
        // Arrange
        CoinCalculator calculator = new CoinCalculator();

        // Act
        String result = calculator.calculateCoins(null);

        // Assert
        assertEquals("Invalid request", result, "Should return 'Invalid request' for null input");
    }

    // Empty denominations list
    @Test
    void testInvalidRequest_EmptyDenominationsList() {
        // Arrange
        CoinCalculator calculator = new CoinCalculator();
        CoinCalculatorRequest request = new CoinCalculatorRequest();
        request.setTargetAmount(new BigDecimal("5.00"));
        request.setCoinDenominations(Collections.emptyList());

        // Act
        String result = calculator.calculateCoins(request);

        // Assert
        assertEquals("Invalid request", result, "Should return 'Invalid request' for empty denominations list");
    }

    // Target amount not reachable
    @Test
    void testTargetNotReachable() {
        // Arrange
        CoinCalculator calculator = new CoinCalculator();
        CoinCalculatorRequest request = new CoinCalculatorRequest();
        request.setTargetAmount(new BigDecimal("3.00"));
        request.setCoinDenominations(Arrays.asList(
            new BigDecimal("5"),
            new BigDecimal("10")
        ));

        // Act
        String result = calculator.calculateCoins(request);

        // Assert
        assertEquals("[]", result, "Should return empty list when target is unreachable");
    }

    // Target amount is the exact match of the highest denominator
    @Test
    void testExactMatch() {
        // Arrange
        CoinCalculator calculator = new CoinCalculator();
        CoinCalculatorRequest request = new CoinCalculatorRequest();
        request.setTargetAmount(new BigDecimal("5.00"));
        request.setCoinDenominations(Arrays.asList(
            new BigDecimal("0.5"),
            new BigDecimal("1"),
            new BigDecimal("5")
        ));

        // Act
        String result = calculator.calculateCoins(request);

        // Assert
        assertEquals("[5]", result, "Should return exact match for target amount");
    }

    // Target amount is zero
    @Test
    void testZeroTarget() {
        // Arrange
        CoinCalculator calculator = new CoinCalculator();
        CoinCalculatorRequest request = new CoinCalculatorRequest();
        request.setTargetAmount(BigDecimal.ZERO);
        request.setCoinDenominations(Arrays.asList(
            new BigDecimal("0.5"),
            new BigDecimal("1"),
            new BigDecimal("5")
        ));

        // Act
        String result = calculator.calculateCoins(request);

        // Assert
        assertEquals("[]", result, "Should return empty list for zero target");
    }
    
}
