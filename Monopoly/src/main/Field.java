package main;

public class Field {
	private int price, priceForHouse, priceLandedOn, mortgagePrice, buyHouse, houseAmounts;
	private String propertyName, ownedBy;
	private boolean owned, mortgaged, buyable = false;
	FieldProperties typeOfField;
	
	public Field(int price, int priceForHouse, String propertyName, FieldProperties typeOfField){
		this.price = price;
		this.priceForHouse = priceForHouse;
		this.propertyName = propertyName;
		this.typeOfField = typeOfField;
		
		priceLandedOn = price/10;
		mortgagePrice = price/2;
		buyHouse = priceForHouse/4;
		
		ownedBy = "No one";
		owned = false;
		mortgaged = false;
		if(typeOfField == FieldProperties.NormalField || typeOfField == FieldProperties.TrainStation){
			buyable = true;
		}
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public int getPriceForHouse() {
		return priceForHouse;
	}

	public void setPriceForHouse(int priceForHouse) {
		this.priceForHouse = priceForHouse;
	}

	public int getPriceLandedOn() {
		return priceLandedOn;
	}

	public void setPriceLandedOn(int priceLandedOn) {
		this.priceLandedOn = priceLandedOn;
	}

	public int getMortgagePrice() {
		return mortgagePrice;
	}

	public void setMortgagePrice(int mortgagePrice) {
		this.mortgagePrice = mortgagePrice;
	}

	public int getBuyHouse() {
		return buyHouse;
	}

	public void setBuyHouse(int buyHouse) {
		this.buyHouse = buyHouse;
	}

	public int getHouseAmounts() {
		return houseAmounts;
	}

	public void setHouseAmounts(int houseAmounts) {
		this.houseAmounts = houseAmounts;
	}

	public String getPropertyName() {
		return propertyName;
	}

	public void setPropertyName(String propertyName) {
		this.propertyName = propertyName;
	}

	public String getOwnedBy() {
		return ownedBy;
	}

	public void setOwnedBy(String ownedBy) {
		this.ownedBy = ownedBy;
	}

	public boolean isOwned() {
		return owned;
	}

	public void setOwned(boolean owned) {
		this.owned = owned;
	}

	public boolean isMortgaged() {
		return mortgaged;
	}

	public void setMortgaged(boolean mortgaged) {
		this.mortgaged = mortgaged;
	}

	public boolean isBuyable() {
		return buyable;
	}

	public void setBuyable(boolean buyable) {
		this.buyable = buyable;
	}

	public FieldProperties getTypeOfField() {
		return typeOfField;
	}

	public void setTypeOfField(FieldProperties typeOfField) {
		this.typeOfField = typeOfField;
	}
}
