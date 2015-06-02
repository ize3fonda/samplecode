package tes.diculc;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class CulcBody {

	static JTextField jt;
	static JFrame frame;
	static Fomula fomula;
	public static void main(String args[]){
		initialize();
		fomula = new Fomula();
	}

	private static void initialize() {
		jt = new JTextField();
		frame = new JFrame("タイトル");
		frame.setSize(new Dimension(320, 600));
		frame.setLayout(new BorderLayout());
		frame.add(jt, BorderLayout.NORTH);
		frame.add(getMainPanel(), BorderLayout.CENTER);
		frame.repaint();
		frame.setVisible(true);
	}

	static JPanel getMainPanel(){
		JPanel panel = new JPanel();
		inputButtons ib = new inputButtons(jt);
		int x =0 ;
		int y =0 ;
		panel.setLayout(new GridBagLayout());
		for(CulcButton comp: ib.getButtunList()){
			GridBagConstraints gb = new GridBagConstraints();
			gb.gridx = x;
			gb.gridy = y;
			ib.setListener(comp);
			panel.add(comp, gb);
			x++;
			if(x > 2){
				y++;
				x = 0;
			}
		}

		return panel;

	}
}
