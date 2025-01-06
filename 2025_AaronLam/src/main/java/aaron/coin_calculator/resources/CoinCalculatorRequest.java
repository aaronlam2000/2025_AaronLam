package aaron.coin_calculator.resources;

import java.math.BigDecimal;
import java.util.List;

public class CoinCalculatorRequest {
    private BigDecimal targetAmount;
    private List<BigDecimal> coinDenominations;

    // Constructors (optional)
    public CoinCalculatorRequest() {}

    public CoinCalculatorRequest(BigDecimal targetAmount, List<BigDecimal> coinDenominations) {
        this.targetAmount = targetAmount;
        this.coinDenominations = coinDenominations;
    }

    // Getters and Setters
    public BigDecimal getTargetAmount() {
        return targetAmount;
    }

    public void setTargetAmount(BigDecimal targetAmount) {
        this.targetAmount = targetAmount;
    }

    public List<BigDecimal> getCoinDenominations() {
        return coinDenominations;
    }

    public void setCoinDenominations(List<BigDecimal> coinDenominations) {
        this.coinDenominations = coinDenominations;
    }
}