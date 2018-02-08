package com.gmail.birchyboy.s;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.KeyEvent;

import javax.swing.BorderFactory;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import java.awt.Component;
import javax.swing.*;
import static javax.swing.GroupLayout.Alignment.*;

public class Display extends JPanel {
	private static int WIDTH = 800;
	private static int HEIGHT = 500;

	public Display() {
		super(new GridLayout(1, 1));

		JTabbedPane tabbedPane = new JTabbedPane();
		ImageIcon options_icon = createImageIcon("images/options_icon.png");
		ImageIcon search_icon = createImageIcon("images/winged_money.png");


		////////////////////////////////////////////////////////////////// Adding the
		////////////////////////////////////////////////////////////////// tab panels
		JComponent search_panel = new JPanel(false);
		tabbedPane.addTab("Search", search_icon, search_panel, "Search");
		tabbedPane.setMnemonicAt(0, KeyEvent.VK_1);

		JComponent options_panel = new JPanel(false);
		tabbedPane.addTab("Options", options_icon, options_panel, "Options");
		tabbedPane.setMnemonicAt(1, KeyEvent.VK_2);
		/////////////////////////////////
		JPanel panel_finder = new JPanel();
		JLabel label_query = new JLabel("Find What:");
		JLabel label_filter = new JLabel("Filter (CSV):");
		JTextField text_query = new JTextField();
		JTextField text_filter = new JTextField();
		JCheckBox caseCheckBox = new JCheckBox("Match Case");
		JCheckBox wrapCheckBox = new JCheckBox("Wrap Around");
		JCheckBox wholeCheckBox = new JCheckBox("Whole Words");
		JCheckBox backCheckBox = new JCheckBox("Search Backwards");
		JButton findButton = new JButton("Find");
		JButton cancelButton = new JButton("Reset");

		// remove redundant default border of check boxes - they would hinder
		// correct spacing and aligning (maybe not needed on some look and feels)
		caseCheckBox.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));
		wrapCheckBox.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));
		wholeCheckBox.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));
		backCheckBox.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));

		GroupLayout layout = new GroupLayout(panel_finder);
		panel_finder.setLayout(layout);
		layout.setAutoCreateGaps(true);
		layout.setAutoCreateContainerGaps(true);

		layout.setHorizontalGroup(layout.createSequentialGroup().addComponent(label_query)
				.addGroup(layout.createParallelGroup(LEADING).addComponent(text_query)
						.addGroup(layout.createSequentialGroup()
								.addGroup(layout.createParallelGroup(LEADING).addComponent(caseCheckBox)
										.addComponent(wholeCheckBox))
								.addGroup(layout.createParallelGroup(LEADING).addComponent(wrapCheckBox)
										.addComponent(backCheckBox))))
				.addGroup(layout.createParallelGroup(LEADING).addComponent(findButton).addComponent(cancelButton)));

		layout.linkSize(SwingConstants.HORIZONTAL, findButton, cancelButton);

		layout.setVerticalGroup(layout.createSequentialGroup()
				.addGroup(layout.createParallelGroup(BASELINE).addComponent(label_query).addComponent(text_query)
						.addComponent(findButton))
				.addGroup(layout.createParallelGroup(LEADING)
						.addGroup(layout.createSequentialGroup()
								.addGroup(layout.createParallelGroup(BASELINE).addComponent(caseCheckBox)
										.addComponent(wrapCheckBox))
								.addGroup(layout.createParallelGroup(BASELINE).addComponent(wholeCheckBox)
										.addComponent(backCheckBox)))
						.addComponent(cancelButton)));
		//////////////////////////////////////
		//add the search panel
		search_panel.add(panel_finder);
		
		//add the tabbed panel so we can see it
		add(tabbedPane);

		search_panel.add(input_grid);
		tabbedPane.setTabLayoutPolicy(JTabbedPane.SCROLL_TAB_LAYOUT);
	}

	protected JComponent makeTextPanel() {
		JPanel panel = new JPanel(false);
		return panel;
	}

	/** Returns an ImageIcon, or null if the path was invalid. */
	protected static ImageIcon createImageIcon(String path) {
		java.net.URL imgURL = Display.class.getResource(path);
		if (imgURL != null) {
			return new ImageIcon(imgURL);
		} else {
			System.err.println("Couldn't find file: " + path);
			return null;
		}
	}

	/**
	 * Create the GUI and show it. For thread safety, this method should be invoked
	 * from the event dispatch thread.
	 */
	private static void createAndShowGUI() {
		// Create and set up the window.
		JFrame frame = new JFrame("sztabnik");
		frame.setSize(WIDTH, HEIGHT);
		frame.setResizable(false);
		// frame.setLayout(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		// Add content to the window.
		frame.add(new Display());

		// Display the window
		frame.setVisible(true);
	}

	public static void main(String[] args) {
		// Schedule a job for the event dispatch thread:
		// creating and showing this application's GUI.
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				// Turn off metal's use of bold fonts
				UIManager.put("swing.boldMetal", Boolean.FALSE);
				createAndShowGUI();
			}
		});
	}
}
