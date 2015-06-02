package tes.diculc;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.swing.JTextField;

public class inputButtons {

	JTextField resultBox;
	Fomula fomula = new Fomula();
	inputButtons(JTextField textField){
		resultBox = textField;
	}

	protected CulcButton number0B;
	protected CulcButton number1B;
	protected CulcButton number2B;
	protected CulcButton number3B;
	protected CulcButton number4B;
	protected CulcButton number5B;
	protected CulcButton number6B;
	protected CulcButton number7B;
	protected CulcButton number8B;
	protected CulcButton number9B;


	protected CulcButton tasuB;
	protected CulcButton hikuB;
	protected CulcButton kakeruB;
	protected CulcButton waruB;
	protected CulcButton kakkoAB;
	protected CulcButton kakkoBB;

	public CulcButton getNumber0Button() {
		if(number0B == null){
			number0B = new CulcButton("0", Const.NUMBER);
		}
		return number0B;
	}
	public CulcButton getNumber1Button() {
		if(number1B == null){
			number1B = new CulcButton("1", Const.NUMBER);
		}
		return number1B;
	}
	public CulcButton getNumber2Button() {
		if(number2B == null){
			number2B = new CulcButton("2", Const.NUMBER);
		}
		return number2B;
	}
	public CulcButton getNumber3Button() {
		if(number3B == null){
			number3B = new CulcButton("3", Const.NUMBER);
		}
		return number3B;
	}
	public CulcButton getNumber4Button() {
		if(number4B == null){
			number4B = new CulcButton("4", Const.NUMBER);
		}
		return number4B;
	}
	public CulcButton getNumber5Button() {
		if(number5B == null){
			number5B = new CulcButton("5", Const.NUMBER);
		}
		return number5B;
	}
	public CulcButton getNumber6Button() {
		if(number6B == null){
			number6B = new CulcButton("6", Const.NUMBER);
		}
		return number6B;
	}
	public CulcButton getNumber7Button() {
		if(number7B == null){
			number7B = new CulcButton("7", Const.NUMBER);
		}
		return number7B;
	}
	public CulcButton getNumber8Button() {
		if(number8B == null){
			number8B = new CulcButton("8", Const.NUMBER);
		}
		return number8B;
	}
	public CulcButton getNumber9Button() {
		if(number9B == null){
			number9B = new CulcButton("9", Const.NUMBER);
		}
		return number9B;
	}


	public CulcButton getTasuButton() {
		if(tasuB == null){
			tasuB = new CulcButton(Const.TASU, Const.SIGN);
		}
		return tasuB;
	}
	public CulcButton getHikuButton() {
		if(hikuB == null){
			hikuB = new CulcButton(Const.HIKU, Const.SIGN);
		}
		return hikuB;
	}
	public CulcButton getKakeruButton() {
		if(kakeruB == null){
			kakeruB = new CulcButton(Const.KAKERU, Const.SIGN);
		}
		return kakeruB;
	}
	public CulcButton getWaruButton() {
		if(waruB == null){
			waruB = new CulcButton(Const.WARU, Const.SIGN);
		}
		return waruB;
	}
	public CulcButton getKakkoAButton() {
		if(kakkoAB == null){
			kakkoAB = new CulcButton(Const.KAKKOA, Const.SIGN);
		}
		return kakkoAB;
	}
	public CulcButton getKakkoBButton() {
		if(kakkoBB == null){
			kakkoBB = new CulcButton(Const.KAKKOB, Const.SIGN);
		}
		return kakkoBB;
	}

	public void setListener(CulcButton target) {
		ActionListener l = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				switch(target.id){
				case Const.NUMBER:
					fomula.add(Const.NUMBER, target.name);
					resultBox.setText(fomula.toString());
					break;
				case Const.SIGN:
					fomula.add(Const.SIGN, target.name);
					resultBox.setText(fomula.toString());
					break;
				case Const.DICE:
					fomula.add(Const.DICE, target.name);
					resultBox.setText(fomula.toString());
					break;
				case Const.FUNC:
					break;
				default:
					break;
				}
			}
		};
		target.addActionListener(l);
		return;
	}


	Map<String, CulcButton> map =null;// = new HashMap<String, CulcButton>();
	Map<String, CulcButton> getMap(){
		if(map == null){
			map = new HashMap<String, CulcButton>();
			map.put(getNumber1Button().name, getNumber1Button());

		}
		return map;
	}
	public List<CulcButton> getButtunList(){
		List<CulcButton> list  = new ArrayList<CulcButton>();
		list.add(getNumber1Button());
		list.add(getNumber2Button());
		list.add(getNumber3Button());
		list.add(getNumber4Button());
		list.add(getNumber5Button());
		list.add(getNumber6Button());
		list.add(getNumber7Button());
		list.add(getNumber8Button());
		list.add(getNumber9Button());
		list.add(getNumber0Button());
		list.add(getTasuButton());
		list.add(getHikuButton());
		list.add(getKakeruButton());
		list.add(getWaruButton());
		list.add(getKakkoAButton());
		list.add(getKakkoBButton());
		return list;
	}

}
