package ie.cct.farmcaos2019414;

import java.util.ArrayList;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

//add annotation @RestController
@RestController
public class FarmcaosCAController {

	private ArrayList<AnimalFarm> animals;

	public FarmcaosCAController() {
		animals = new ArrayList<>();
	}

	// aula 3Abril 1:37:38 entender a necessidade deste method
	@GetMapping("no-content")
	@ResponseStatus(code = HttpStatus.NO_CONTENT)
	public void emptyContent() {
	}

	/*
	 * add new item on AnimalFarm on Postman to add the animal using JSON {
	 * "type":"cow", "weight": 300 }
	 */
	@PostMapping("add-item")
	public SuccessResponse addItem(@RequestBody AnimalFarm item) {
		this.animals.add(item);
		return new SuccessResponse("Animal " + item.getType() + " added");
	}

	@PostMapping("add-item-type")
	public SuccessResponse addItemt(@RequestBody AnimalFarm item) {

		if (item.getType().contains("Cow")) {
			this.animals.add(item);
			return new SuccessResponse("Animal " + item.getType().contains("Cow") + " added");
		}

		else if (item.getType().contains("Pig")) {
			this.animals.add(item);
			return new SuccessResponse("Animal " + item.getType().contains("Pig") + " added");

		} else if (item.getType().contains("Chicken")) {
			this.animals.add(item);
			return new SuccessResponse("Animal " + item.getType().contains("Chicken") + " added");

		} else {
			throw new ErrorException("Please select an Animal Type valid: Cow, Pig or Chicken ");
		}

	}

	/*
	 * return a list of all animal add on AnimalFarm revisar para somente retornar o
	 * item type
	 */
	@GetMapping("list-animal")
	public String listAnimal() {
		if (animals.size() == 0) {
			throw new NotFoundException("No items found in the warehouse");
		}

		for (AnimalFarm item : animals) {

			return (item.getType());
		}
		return null;

	}

	@GetMapping("average-weight-ttl")
	public Float averageWeight() {

		if (animals.size() == 0) {
			throw new NotFoundException("No items found in the warehouse");
		}

		Float weight = 0.0f;
		for (AnimalFarm item : animals) {
			weight += item.getWeight();
		}
		weight = weight / animals.size();
		return weight;

	}

	@GetMapping("average-weight-type")
	public SuccessResponse averageWeightType() {

		if (animals.size() == 0) {
			throw new NotFoundException("No items found in the warehouse");
		}

		int Cow = 0;
		int Pig = 0;
		int Chicken = 0;

		Float weightCow = 0.0f;
		Float weightPig = 0.0f;
		Float weightCkn = 0.0f;
		Float weightTtl = 0.0f;

		for (AnimalFarm item : animals) {
			if (item.getType().contains("cow")) {
				weightCow += item.getWeight();
				Cow++;
				weightCow = weightCow / Cow;
			} else if (item.getType().contains("pig")) {
				weightPig += item.getWeight();
				Pig++;
				weightPig = weightPig / Pig;
			} else if (item.getType().contains("chicken")) {
				weightCkn += item.getWeight();
				Chicken++;
				weightCkn = weightCkn / Chicken;
			}

		}

		weightTtl = (weightCow + weightPig + weightCkn) / animals.size();
		return new SuccessResponse("Average Cow: " + weightCow + " Average  Pig: " + weightPig + " Average Chicken: "
				+ weightCkn + " Avg ttl: " + weightTtl);
	}

	@GetMapping("weight-toSell")
	public SuccessResponse animalToSell() {

		int Cow = 0;
		int Pig = 0;
		int Chicken = 0;
		int ttlAnimalSell = 0;

		if (animals.size() == 0) {
			throw new NotFoundException("No items found in the warehouse");
		}

		for (AnimalFarm item : animals) {

			if (item.getType().contains("cow") & item.getWeight() >= 300.0f) {
				Cow++;

			} else if (item.getType().contains("pig") & item.getWeight() >= 100.0f) {
				Pig++;

			} else if (item.getType().contains("chicken") & item.getWeight() >= 0.5f) {
				Chicken++;
			}

		}

		ttlAnimalSell = Cow + Pig + Chicken;
		return new SuccessResponse("Available to sell: " + Cow + " Cows, " + Pig + " Pigs and " + Chicken
				+ " Chickens. Total animals availble to sell: " + ttlAnimalSell);

	}

	@GetMapping("value-farm")
	public SuccessResponse valueFarm() {

		if (animals.size() == 0) {
			throw new NotFoundException("No items found in the warehouse");
		}

		Float valueFarm = 0.0f;

		for (AnimalFarm item : animals) {

			if (item.getType().contains("cow") & item.getWeight() >= 300.0f) {
				valueFarm += item.getPriceCow();

			} else if (item.getType().contains("pig") & item.getWeight() >= 100.0f) {
				valueFarm += item.getPricePig();

			} else if (item.getType().contains("chicken") & item.getWeight() >= 0.5f) {
				valueFarm += item.getPriceCkn();
			}

		}

		return new SuccessResponse("The value of farm: " + valueFarm);
	}

	// http://localhost:8080/currentValue?cow=350&pig=120&chicken=1
	@GetMapping("value-farm-param")
	public SuccessResponse valueFarmParam(@RequestParam(required = true) Float cow,
			@RequestParam(required = true) Float pig, @RequestParam(required = true) Float chicken) {

		if (animals.size() == 0) {
			throw new NotFoundException("No items found in the warehouse");
		}

		Float valueFarm = 0.0f;

		for (AnimalFarm item : animals) {

			if (item.getType().contains("cow") & item.getWeight() >= 300.0f) {
				valueFarm += cow;

			} else if (item.getType().contains("pig") & item.getWeight() >= 100.0f) {
				valueFarm += pig;

			} else if (item.getType().contains("chicken") & item.getWeight() >= 0.5f) {
				valueFarm += chicken;
			}

		}

		return new SuccessResponse("The value of farm: " + valueFarm);
	}

}
