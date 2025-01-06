package aaron.coin_calculator;

import aaron.coin_calculator.api.CoinCalculator;
import io.dropwizard.core.Application;
import io.dropwizard.core.setup.Bootstrap;
import io.dropwizard.core.setup.Environment;

public class coin_calculatorApplication extends Application<coin_calculatorConfiguration> {

    public static void main(final String[] args) throws Exception {
        new coin_calculatorApplication().run(args);
    }

    @Override
    public String getName() {
        return "coin_calculator";
    }

    @Override
    public void initialize(final Bootstrap<coin_calculatorConfiguration> bootstrap) {
        // TODO: application initialization
    }

    @Override
    public void run(final coin_calculatorConfiguration configuration,
                    final Environment environment) {
        // TODO: implement application
        environment.jersey().register(new CoinCalculator());
        // environment.jersey().register(new TestAPI());

    }

}
