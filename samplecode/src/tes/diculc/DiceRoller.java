package tes.diculc;

import java.util.Random;

public class DiceRoller {
	static String roll(String diceStr){
		String rtnStr = "";
		if(diceStr.equals(Const.DMARK)){
			rtnStr = rollnDm(2, 6);
			return rtnStr;
		}
		String[] tmp = diceStr.split(Const.DMARK, 0);
		if(tmp.length == 2){
			int n = 0;
			int m = 0;
			try {
				n = Integer.parseInt(tmp[0]);
				m = Integer.parseInt(tmp[1]);
			} catch (NumberFormatException nfex) {
				return rtnStr;
			}
			return rollnDm(n, m);
		}else if(tmp.length != 1){
			return rtnStr;
		}

		if(diceStr.startsWith(Const.DMARK)){
			int n = 1;
			int m = 0;
			try {
				m = Integer.parseInt(diceStr.replace(Const.DMARK, ""));
			} catch (NumberFormatException nfex) {
				return rtnStr;
			}
			return rollnDm(n, m);
		}
		if(diceStr.endsWith(Const.DMARK)){
			int n = 0;
			int m = 6;
			try {
				n = Integer.parseInt(diceStr.replace(Const.DMARK, ""));
			} catch (NumberFormatException nfex) {
				return rtnStr;
			}
			return rollnDm(n, m);
		}

		return rtnStr;
	}

	private static String rollnDm(int n, int m) {
		StringBuffer sb = new StringBuffer();
		sb.append("[");
		if(n < 1){
			sb.append("0");
			sb.append("]");
			return sb.toString();
		}
		Random rnd = new Random();
		int plus = 1;
		if(m == 10){
			plus = 0;
		}
		for(int i = 0; i < n; i++){
			if(m == 66){
				int a = rnd.nextInt(6) + plus;
				int b = rnd.nextInt(6) + plus;
				sb.append(String.valueOf(a * 10 + b));
				break;
			}
			if(m == 1010){
				int a = rnd.nextInt(10);
				int b = rnd.nextInt(10);
				sb.append(String.valueOf(a * 10 + b));
				break;
			}
			sb.append(String.valueOf(rnd.nextInt(m) + plus));
			if(n-i < 2){
				sb.append(",");
			}
		}
		sb.append("]");
		return sb.toString();
	}

	static int resultToInt(String resultStr){
		int rtn = 0;
		resultStr = resultStr.replace("[", "");
		resultStr = resultStr.replace("]", "");
		String[] tmp = resultStr.split(",", 0);
		for(String val: tmp){
			try {
				rtn += Integer.parseInt(val);
			} catch (NumberFormatException nfex) {
				// 何もしない
			}
		}
		return rtn;
	}
}
