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

        return String.format("Result for fibonacci with n = '%d' is %d", n, fib(n));
    }

    private long fib(int n) {
        if (n <= 1) {
            return n;
        }

        long previous = 0;
        long current = 1;

        for (int i = 2; i <= n; i++) {
            long next = previous + current;
            previous = current;
            current = next;
        }

        return current;
    }

}
