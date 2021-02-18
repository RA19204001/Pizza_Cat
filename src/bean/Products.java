/*
 * 作成日： 2021/02/02
 * 作成者： 内田 悠貴
 * <クラス概要説明>
 *
 *
 */
//浅倉　/2/17
package bean;

import java.util.ArrayList;

public class Products implements Bean {
	private ArrayList addList;
	private ArrayList list;
	private ArrayList optionList;
	private ArrayList sideList;

	public ArrayList getSideList() {
		return sideList;
	}

	public void setSideList(ArrayList sideList) {
		this.sideList = sideList;
	}

	public ArrayList getOptionList() {
		return optionList;
	}

	public void setOptionList(ArrayList optionList) {
		this.optionList = optionList;
	}

	public Products() {}

	public ArrayList getList() {
		return list;
	}
	public void setList(ArrayList list) {
		this.list = list;
	}

	public ArrayList getAddList() {
		return addList;
	}
	public void setAddList(ArrayList addList) {
		this.addList = addList;
	}

}
