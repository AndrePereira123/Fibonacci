package FibonacciAPI.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class AppApplication {

	public static void main(String[] args) {
		SpringApplication.run(AppApplication.class, args);
	}

	@GetMapping("/app")
    public String hello(@RequestParam(value = "name", defaultValue = "World") String name) {
      return String.format("Hello %s!", name);
    }

	@GetMapping("/fib")
    public String fibonacci(@RequestParam(value = "n") int n) {
        if (n < 0) {
            return "n must be greater than or equal to 0";
        }

        try {
            long value = fib(n);
            return String.format("Result for fibonacci with n = '%d' is %d", n, value);
        } catch (ArithmeticException ex) {
            return "Result exceeds maximum 64-bit signed integer value (9,223,372,036,854,775,807)";
        }
    }

    private long fib(int n) {
        if (n <= 1) {
            return n;
        }

        long previous = 0L;
        long current = 1L;

        for (int i = 2; i <= n; i++) {
            // check for overflow before addition
            if (Long.MAX_VALUE - current < previous) {
                throw new ArithmeticException("overflow");
            }
            long next = previous + current;
            previous = current;
            current = next;
        }

        return current;
    }

}
