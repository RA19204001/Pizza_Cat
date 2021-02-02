/*
 * 作成日： 2021/02/02
 * 作成者： 内田 悠貴
 * <クラス概要説明>
 *
 *
 */
package bean;

import java.util.ArrayList;

public class Products implements Bean {

	private ArrayList list;

	public Products() {}

	public ArrayList getList() {
		return list;
	}
	public void setList(ArrayList list) {
		this.list = list;
	}

}
