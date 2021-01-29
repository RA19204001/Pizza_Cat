// 内田1/27フラグの追加
package bean;

public class Message implements Bean {
	private String message;
	private boolean flag;

	// メッセージを保持する
	public void setMessage(String message){
		this.message=message;
	}

	public String getMessage(){
		return message;
	}

	// フラグを保持
	public void setFlag(boolean flag) {
		this.flag = flag;
	}
	public boolean getFlag() {
		return flag;
	}

	public Message() {}

}
