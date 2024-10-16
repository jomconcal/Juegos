package aplicacionBeta;

import javax.swing.*;

public class Cronometro extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public Cronometro() {

		this.sec = 0;
		this.min = 0;
		this.hor = 0;

		this.cronometro = new JLabel("00:00:00");

		this.add(cronometro);

	}

	private int sec, min, hor;
	private JLabel cronometro;

	public void avanzaCronometro() {

		
		for(;hor<24;){
			
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			sec++;
			if (sec == 60) {
				min++;
				sec = 0;
				if (min == 60) {
					hor++;
				}
			}
			if (hor < 10) {
				if (min < 10) {
					if (sec < 10) {
						cronometro.setText("0" + Integer.toString(hor) + ":0" + Integer.toString(min) + ":0"
								+ Integer.toString(sec));
					}else {
						cronometro.setText("0" + Integer.toString(hor) + ":0" + Integer.toString(min) + ":"
								+ Integer.toString(sec));
					}
				}else {
					if(sec<10) {
						cronometro.setText("0" + Integer.toString(hor) + ":" + Integer.toString(min) + ":0"
								+ Integer.toString(sec));
					}else {
						cronometro.setText("0" + Integer.toString(hor) + ":" + Integer.toString(min) + ":"
								+ Integer.toString(sec));
					}
				}
			}else {
				if (min < 10) {
					if (sec < 10) {
						cronometro.setText(Integer.toString(hor) + ":0" + Integer.toString(min) + ":0"
								+ Integer.toString(sec));
					}else {
						cronometro.setText(Integer.toString(hor) + ":0" + Integer.toString(min) + ":"
								+ Integer.toString(sec));
					}
				}else {
					if(sec<10) {
						cronometro.setText(Integer.toString(hor) + ":" + Integer.toString(min) + ":0"
								+ Integer.toString(sec));
					}else {
						cronometro.setText(Integer.toString(hor) + ":" + Integer.toString(min) + ":"
								+ Integer.toString(sec));
					}
				}
			}
		}
	}

}
