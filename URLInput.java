package com.gmail.birchyboy.s;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashSet;
import java.util.Scanner;

public class URLInput {
	File url_txt;
	File prefs_txt;
	HashSet<String> state_list;
	public URLInput()
	{
		url_txt = new File("resources/urls.txt");
		prefs_txt = new File("resources/prefs.txt");
		state_list = new HashSet<String>();
		get_prefs();
	}
	
	private void get_prefs()
	{
		try {
			Scanner sc = new Scanner(prefs_txt);
			while(sc.hasNextLine())
			{
				String s = sc.nextLine();
				if(s.charAt(s.length()-1)=='+')
				{
					state_list.add(s.substring(0, s.length()-1));
				}
			}
			sc.close();
		}
		catch(FileNotFoundException e)
		{
			System.out.println("ERROR: prefs.txt could not be found.");
			e.printStackTrace();
		}
	}
	
	public void get_list(LocationURLList lurll)
	{
		try {
			Scanner sc = new Scanner(url_txt);
			String temp = "";
			String recent_state="";
			while(sc.hasNextLine())
			{
				temp=sc.nextLine();
				
				//State detected, add to list
				if(temp.charAt(0)=='*' && temp.charAt(temp.length()-1)=='*')
				{
					recent_state = temp.substring(1, temp.length()-1);
					lurll.add_state(recent_state);
				}
				//just a url
				else
				{
					lurll.add_URL(recent_state, temp);
				}
			}
			sc.close();
			return ;
		}
		catch(FileNotFoundException e)
		{
			System.out.println("ERROR: urls.txt could not be found.");
			e.printStackTrace();
		}
	}
}
