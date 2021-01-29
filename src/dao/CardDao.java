package dao;

//10.29 移行 大川
import bean.Card;

public interface CardDao{

  public void addCard(bean.Card c);
  public Card getCardId(String creditnumber,String security_code);
}
