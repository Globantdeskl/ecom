package decorator;

interface BeverageBase {
	

	double getCost();

	default String getDescription() {
		String description = "";
		return description;
	}

}

class BlackTea implements BeverageBase {

	public String description = "";

	public BlackTea() {
		description = "Black tea from teabag";
	}

	@Override
	public double getCost() {
		return 5;
	}
}

class GreenTea implements BeverageBase {

	public String description = "";

	public GreenTea() {
		description = "Green leaf tea";
	}

	@Override
	public double getCost() {
		return 8;
	}
}

class Espresso implements BeverageBase {

	public String description = "";

	public Espresso() {
		description = "Small portion of strong coffee";
	}

	@Override
	public double getCost() {
		return 12;
	}
}

//////////////////////////////////////////////////////////////////

interface CondimentsDecoratorBase extends BeverageBase {

}

class MilkCondiment implements CondimentsDecoratorBase {

	private BeverageBase beverage;

	public String description = "";

	public MilkCondiment(BeverageBase beverage) {
		this.beverage = beverage;
		description = this.beverage.getDescription() + " + Milk";
	}

	@Override
	public double getCost() {
		return beverage.getCost() + 3;
	}
}

class ChocolateCondiment implements CondimentsDecoratorBase {

	private BeverageBase beverage;

	public String description = "";

	public ChocolateCondiment(BeverageBase beverage) {
		this.beverage = beverage;
		description = this.beverage.getDescription() + " + Chocolate";
	}

	@Override
	public double getCost() {
		return beverage.getCost() + 4;
	}
}

class SugarCondiment implements CondimentsDecoratorBase {

	private BeverageBase beverage;

	public String description = "";

	public SugarCondiment(BeverageBase beverage) {
		this.beverage = beverage;
		description = beverage.getDescription() + " + Sugar";
	}

	@Override
	public double getCost() {
		return beverage.getCost() + 1;
	}
}

////////////////////////////////////////////////////////////////////////

public class Decorator {

	static void printBeverage(BeverageBase beverage) {
		System.out.println("Beverage: " + beverage.getDescription() + ", Cost: " + beverage.getCost());
	}

	public static void main(String args[]) throws Exception {
		BeverageBase espresso = new Espresso();
		BeverageBase blackTea = new BlackTea();
		BeverageBase greenTea = new GreenTea();

		printBeverage(espresso);
		printBeverage(blackTea);
		printBeverage(greenTea);

		System.out.println("========================");

		BeverageBase capuccino = new SugarCondiment(new MilkCondiment(new Espresso()));
		printBeverage(capuccino);

		BeverageBase greenTeaWithSugar = new SugarCondiment(new GreenTea());
		printBeverage(greenTeaWithSugar);

	}
}
