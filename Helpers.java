package com.gmail.birchyboy.s;

import java.awt.GridLayout;

import javax.swing.ImageIcon;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Helpers {

	public static String trim_url(String s)
	{
		return s.substring(s.indexOf("//")+2,s.indexOf(".html")+5);
	}

}
