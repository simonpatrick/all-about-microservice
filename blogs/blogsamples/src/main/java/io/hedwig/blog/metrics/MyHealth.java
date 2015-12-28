package io.hedwig.blog.metrics;

import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthIndicator;
import org.springframework.stereotype.Component;

import java.util.Random;

@Component
public class MyHealth implements HealthIndicator {
    private int randomInt =new Random().nextInt(10);
    @Override
    public Health health() {
        int errorCode = check(); // perform some specific health check
        if (errorCode <= 0) {
            return Health.down().withDetail("Error Code", errorCode).build();
        }
        return Health.up().build();
    }

    private int check(){
        return randomInt-1;
    }
}