package bean;

import java.util.ArrayList;

public class CardInfo implements Bean {

	private ArrayList cardList;

	public CardInfo() {}
	public void setCardList(ArrayList cardList){
		this.cardList = cardList;
	}
	public ArrayList getCardList() {
		return cardList;
	}
}
