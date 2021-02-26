package dao;

//10.29 移行 大川
import bean.Card;

public interface CardDao{

  public void addCard(bean.Card c);
  public Card getCardId(String creditnumber,String security_code);
  public boolean isUniqueCardId(String creditnumber);
  public void editCard(String card_id,Card card);
}
