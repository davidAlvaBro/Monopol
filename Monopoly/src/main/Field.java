package main;

import java.awt.Color;

public class Field {
	public static final double houseFactor = 1.82;
	private static int amountOfFields;
	private int stanPrice;
	private int price, priceForHouse, priceLandedOn, mortgagePrice, houseAmounts;
	private String propertyName, ownedBy;
	private boolean owned, mortgaged, buyable = false;
	public boolean forSale = false;
	//HUSK AT LAVE ET FOR LOOP DER TJEKKER OM DE INANOFFER, OG SÆTTER DEM AF IGEN EFTER DET ER DONE
	public boolean inAnOffer = false;
	public Color color; 
	//Remember to set this price when you set for sale
	public int priceForBuying;
	FieldProperties typeOfField;
	
	public Field(int price, int priceForHouse, String propertyName, FieldProperties typeOfField){
		this.typeOfField = typeOfField;
		
		if(typeOfField == FieldProperties.NormalField){
			if(amountOfFields <= 1){
				//brown
				color = new Color(139, 69, 19);
				this.price = 60;
				this.priceForHouse = 50;
				amountOfFields++;
				
			}else if(amountOfFields <= 4){
				//light blue
				color = new Color(0, 158, 238);
				this.price = 100;
				this.priceForHouse = 50;
				if(amountOfFields == 4){
					this.price = 120;
				}
				amountOfFields++;
			}else if(amountOfFields <= 7){
				//pink/magenta
				color = Color.magenta;
				this.price = 140;
				this.priceForHouse = 100;
				if(amountOfFields == 7){
					this.price = 140;
				}
				amountOfFields++;
			}else if(amountOfFields <= 10){
				//orange
				color = new Color(255, 140, 0);
				this.price = 180;
				this.priceForHouse = 100;
				if(amountOfFields == 10){
					this.price = 200;
				}
				amountOfFields++;
			}else if(amountOfFields <= 13){
				//red
				color = new Color(215, 54, 54);
				this.price = 220;
				this.priceForHouse = 150;
				if(amountOfFields == 13){
					this.price = 240;
				}
				amountOfFields++;
			}else if(amountOfFields <= 16){
				//Yellow
				color = Color.yellow;
				this.price = 260;
				this.priceForHouse = 150;
				if(amountOfFields == 16){
					this.price = 280;
				}
				amountOfFields++;
			}else if(amountOfFields <= 19){
				//green
				color = new Color(34, 139, 34);
				this.price = 300;
				this.priceForHouse = 200;
				if(amountOfFields == 19){
					this.price = 320;
				}
				amountOfFields++;
			}else if(amountOfFields <= 21){
				//blue
				color = new Color(0,0,139);
				this.priceForHouse = 200;
				if(amountOfFields == 20){
					this.price = 350;
				}else{
					this.price = 400;
				}
				amountOfFields++;
			}
			this.priceLandedOn = this.price/10 - 4;
			this.mortgagePrice = this.price/2;
			this.stanPrice = this.priceLandedOn;
			
		}else if(typeOfField == FieldProperties.Chance){
			color = Color.black;
		}else if(typeOfField == FieldProperties.CommunityChest){
			color = new Color(218, 165, 32);
		}else if(typeOfField == FieldProperties.Taxes){
			color = Color.red;
		}else if(typeOfField == FieldProperties.TrainStation){
			color = new Color(77, 77, 77);
			this.price = 200;
			this.priceLandedOn = 25;
			this.mortgagePrice = this.price/2;
			this.stanPrice = this.priceLandedOn;
		}
	
		this.propertyName = propertyName;
		
		ownedBy = "No one";
		owned = false;
		mortgaged = false;
		
		if(typeOfField == FieldProperties.NormalField || typeOfField == FieldProperties.TrainStation){
			buyable = true;
		}
		
		priceForBuying = this.price;
	}
	

	public int getStanPrice() {
		return stanPrice;
	}


	public void setStanPrice(int stanPrice) {
		this.stanPrice = stanPrice;
	}


	public Color getColor() {
		return color;
	}


	public void setColor(Color color) {
		this.color = color;
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
