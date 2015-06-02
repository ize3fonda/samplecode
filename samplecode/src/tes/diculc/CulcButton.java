package tes.diculc;

import java.awt.Dimension;

import javax.swing.JButton;

public class CulcButton extends JButton{
	protected int id;
	protected String name;
	protected String label;
	//JButton button = new JButton();
	CulcButton(String text, int id){
		super(text);
		this.id = id;
		this.name = text;
		this.label = text;
		super.setMinimumSize(new Dimension(100, 50));

	}

	boolean isNumber(){
		return this.id == Const.NUMBER;
	}

	boolean isDice(){
		return this.id == Const.DICE;
	}

	boolean isSign(){
		return this.id == Const.SIGN;
	}

	boolean isFunc(){
		return this.id == Const.FUNC;
	}
}
