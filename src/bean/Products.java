/*
 * 作成日： 2021/02/02
 * 作成者： 内田 悠貴
 * <クラス概要説明>
 *
 *
 */
//浅倉 /2/17
//浅倉 2/18
package bean;

import java.util.ArrayList;

public class Products implements Bean {
	private ArrayList addList;
	private ArrayList list;
	private ArrayList optionList;
	private ArrayList sideList;
	private ArrayList hidepizzaList;
	private ArrayList hidesideList;
	private ArrayList hideoptionList;

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

	public ArrayList getHidepizzaList() {
		return hidepizzaList;
	}

	public void setHidepizzaList(ArrayList hidepizzaList) {
		this.hidepizzaList = hidepizzaList;
	}

	public ArrayList getHidesideList() {
		return hidesideList;
	}

	public void setHidesideList(ArrayList hidesideList) {
		this.hidesideList = hidesideList;
	}

	public ArrayList getHideoptionList() {
		return hideoptionList;
	}

	public void setHideoptionList(ArrayList hideoptionList) {
		this.hideoptionList = hideoptionList;
	}

}
