package dev.swanhtet.graph;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
@CrossOrigin(origins = "http://127.0.0.1:5500/templates/studentList.html")
class HeapsortController {

	private List<int[]> steps = new ArrayList<>();
	private int[] originalArray;
	private boolean sortingStarted = false;

	@PostMapping("/ArrayReceiver")
	public int[] ArrayReceiver(@RequestBody int[] array){
		originalArray = array.clone();
		return originalArray;
	}

	@GetMapping("/heapsort/steps")
	public List<int[]> getHeapsortSteps() {
		if (!sortingStarted) {
			sortingStarted = true;
			heapsort(originalArray.clone());
		}
		return steps;
	}

	private void heapsort(int[] arr) {
		int n = arr.length;
		steps.add(arr.clone()); // Initial step

		// Build a max heap.
		for (int i = n / 2 - 1; i >= 0; i--) {
			heapify(arr, n, i);
			steps.add(arr.clone());
		}

		// Extract elements one by one
		/*for (int i = n - 1; i > 0; i--) {
			int temp = arr[0];
			arr[0] = arr[i];
			arr[i] = temp;
			heapify(arr, i, 0);
			steps.add(arr.clone());
		}*/
	}

	private void heapify(int[] arr, int n, int i) {
		int largest = i;
		int left = 2 * i + 1;
		int right = 2 * i + 2;

		if (left < n && arr[left] > arr[largest]) {
			largest = left;
		}

		if (right < n && arr[right] > arr[largest]) {
			largest = right;
		}

		if (largest != i) {
			int temp = arr[i];
			arr[i] = arr[largest];
			arr[largest] = temp;
			heapify(arr, n, largest);
		}
	}
}
