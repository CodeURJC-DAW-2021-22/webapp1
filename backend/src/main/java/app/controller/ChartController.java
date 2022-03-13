package app.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ChartController {
	
	@GetMapping("/chart")
	public List<Integer> calculateChart() {
		List<Integer> counts = Arrays.asList(15, 25, 25, 10, 5, 20);
		return counts;
	}
}