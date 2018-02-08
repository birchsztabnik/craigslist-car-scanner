package com.gmail.birchyboy.s;

import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.KeyEvent;

import javax.swing.ImageIcon;
import javax.swing.JCheckBox;
import javax.swing.JComponent;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;

import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class Main {
	public static void main(String args[])
	{
		URLInput ui = new URLInput();
		String url = "https://longisland.craigslist.org/search/cta?query=altima";
		Elements e = Crawler.get_elements(url);
		for(Element el : e)
		{
			System.out.println(Helpers.trim_url(el.outerHtml()));
		}
	}
}
