package aaron.coin_calculator.api;

import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import aaron.coin_calculator.resources.CoinCalculatorRequest;

@Path("/calculate")
@Produces(MediaType.TEXT_PLAIN)
public class CoinCalculator {

    @POST
    public String calculateCoins(CoinCalculatorRequest request) {
        // Check if request body is not empty
        if (request == null || request.getTargetAmount() == null || request.getCoinDenominations() == null 
                || request.getCoinDenominations().isEmpty()) {
            return "Invalid request";
        }

        // Create target amount and list of denominations variables
        BigDecimal targetAmount = request.getTargetAmount();
        List<BigDecimal> coinDenominations = request.getCoinDenominations();

        // Sort denominations in descending order
        Collections.sort(coinDenominations, Collections.reverseOrder());

        // Create list for coins to be returned after calculations
        List<BigDecimal> coinsUsed = new ArrayList<>(); 

        // Loop the list of available denominations from the biggest one (Greedy Algorithm)
        for (BigDecimal denomination : coinDenominations) {

            // Check if target amount is more than or equal to the current denomination
            while (targetAmount.compareTo(denomination) >= 0) {
                coinsUsed.add(denomination);
                targetAmount = targetAmount.subtract(denomination);
            }
        }

        // Reverse order of coins to ascending
        Collections.reverse(coinsUsed);

        // Return list of coins as a string
        return coinsUsed.toString();
    }
}

