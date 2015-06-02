package tes.diculc;

import java.util.Vector;

public class Fomula {
	protected Vector<FomulaParts> fomula;
	Fomula(){
		fomula = new Vector<FomulaParts>();
	}
	public int size(){
		if(fomula == null){
			return -1;
		}
		return fomula.size();
	}
	int touch = -1;


	Fomula(String stringFomula){
		fomula = new Vector<FomulaParts>();
		String[] fomAry = stringFomula.split(Const.SP, 0);
		for(String val: fomAry){
			int id = valueToId(val);
			if(id < 0){
				fomula.clear();
				return;
			}
			fomula.add(new FomulaParts(id, val));
		}
	}

	int valueToId(String Value){
		int id = -1;
		if(Value.contains(Const.DMARK)){
			return Const.DICE;
		}

		if(Value.contains(Const.KAKKOA) ||
			Value.contains(Const.KAKKOB) ||
			Value.contains(Const.TASU) ||
			Value.contains(Const.HIKU) ||
			Value.contains(Const.KAKERU) ||
			Value.contains(Const.WARU)
			){
			return Const.SIGN;
		}
		if(isNumber(Value)){
			return Const.NUMBER;
		}

		return id;
	}
/*
	void input(int id , String Value){
		switch (id) {
		case Const.NUMBER:
			if(fomula.size() < 1){
				fomula.add(new FomulaParts(Const.NUMBER, Value));
				touch = fomula.size();
				break;
			}
			if(fomula.lastElement().id == Const.NUMBER){
				fomula.lastElement().value += Value;
			}
			break;
		default:
			break;
		}
	}
*/
	public boolean isNumber(String val) {
		try {
			Integer.parseInt(val);
			return true;
		} catch (NumberFormatException nfex) {
			return false;
		}
	}
	public void add(int id, String value) {
		if(fomula.size() < 1){
			//初回登録
			if(id == Const.SIGN){
				if(!value.equals(Const.KAKKOA)){
					return;
				}
			}
			fomula.addElement(new FomulaParts(id, value));
			return;
		}
		int lastid = fomula.lastElement().id;
		if(lastid == Const.NUMBER){
			//数式末尾が数字
			if(id == Const.NUMBER){
				//数値なら続ける
				fomula.lastElement().value += value;
				return;
			}
			if(id == Const.DICE){
				//ダイスなら続ける
				fomula.lastElement().value += value;
				fomula.lastElement().id = Const.DICE;
				return;
			}
			if(id == Const.SIGN){
				//記号なら新規追加
				fomula.addElement(new FomulaParts(id, value));
				return;
			}
		}
		if(lastid == Const.DICE){
			//数式末尾がダイス
			if(id == Const.NUMBER){
				//数値なら後に続ける
				fomula.lastElement().value += value;
				return;
			}
			if(id == Const.SIGN){
				//記号なら新規追加
				fomula.addElement(new FomulaParts(id, value));
				return;
			}
		}
		if(lastid == Const.SIGN){
			//数式末尾が記号
			if(!fomula.lastElement().value.equals(Const.KAKKOA) &&
					!fomula.lastElement().value.equals(Const.KAKKOB) &&
					value.equals(Const.KAKKOA)){
				//記号直後の入力がかっこなら
				fomula.addElement(new FomulaParts(id, value));
				return;
			}
			if(id != Const.SIGN){
				fomula.addElement(new FomulaParts(id, value));
				return;
			}
			if(fomula.lastElement().value.equals(Const.KAKKOB)){
				fomula.addElement(new FomulaParts(id, value));
				return;
			}
		}
	}

	public String toString(){
		StringBuffer sb = new StringBuffer();
		for(FomulaParts fp : fomula){
			sb.append(fp.value);
			sb.append(Const.SP);
		}
		return sb.toString();
	}

	public boolean conteinsDice(){
		for(FomulaParts fp : fomula){
			if(fp.id == Const.DICE)
				return true;
		}
		return false;
	}
	public String CulcDice() {
		for(FomulaParts fp : fomula){
			if(fp.id == Const.DICE){
				fp.value = DiceRoller.roll(fp.value);
				fp.id = Const.NUMBER;
			}
		}
		return this.toString();
	}
	
	public String getResult(){
		int resultInt = 0;
		resultInt = culcFomula(fomula);
		return String.valueOf(resultInt);
	}

	private int culcFomula(Vector<FomulaParts> vec) {
		int vecSize = vec.size();
		for(int i = 0; i < vecSize; i++){
			FomulaParts fp = vec.get(i);
			if(fp.value.equals(Const.KAKKOA)){
				int closeIdx = i;
				for(int j = vec.size(); j - 1 > i; j--){
					FomulaParts fp2 = vec.get(j -1);
					if(fp2.value.equals(Const.KAKKOB)){
						closeIdx = j-1;
					}
				}
				Vector<FomulaParts> tmpVec = new Vector<FomulaParts>();
				for(int k = i + 1; k < closeIdx; k++){
					tmpVec.add(vec.get(k));
					
				}
				
			}
		}
		// TODO 自動生成されたメソッド・スタブ
		return 0;
	}

	private class FomulaParts{
		String value;
		int id;
		FomulaParts(int constId, String valueStr){
			id = constId;
			value = valueStr;
		}
	}
}
