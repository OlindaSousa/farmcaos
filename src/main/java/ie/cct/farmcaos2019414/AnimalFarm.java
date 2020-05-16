package ie.cct.farmcaos2019414;

public class AnimalFarm {

	//attributes
	private String type;
	private Float weight;
	private Float priceCow = 500.0f;
	private Float pricePig = 250.0f;
	private Float priceCkn = 5.0f;
	
	
	//create constructor
	public AnimalFarm() {
		super();
	}

	/*
	*AnimalFarm("cows", 300)
	*/
	public AnimalFarm(String type, Float weight) {
		super();
		this.type = type;
		this.weight = weight;
		
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Float getWeight() {
		return weight;
	}

	public void setWeight(Float weight) {
		this.weight = weight;
	}

	public Float getPriceCow() {
		return priceCow;
	}

	public void setPriceCow(Float priceCow) {
		this.priceCow = priceCow;
	}

	public Float getPricePig() {
		return pricePig;
	}

	public void setPricePig(Float pricePig) {
		this.pricePig = pricePig;
	}

	public Float getPriceCkn() {
		return priceCkn;
	}

	public void setPriceCkn(Float priceCkn) {
		this.priceCkn = priceCkn;
	}
	
	
	
}
