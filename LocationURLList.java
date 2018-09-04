package com.gmail.birchyboy.s;

import java.util.HashMap;
import java.util.HashSet;

public class LocationURLList {
	HashMap<String,HashSet<String>> urls;
	
	public LocationURLList() {
		urls = new HashMap<String,HashSet<String>>();
	}
	
	public void add_state(String state)
	{
		if(!urls.containsKey(state))
		{
			urls.put(state,new HashSet<String>());
		}
	}
	
	/**
	 * 
	 * @param state state to grab url list from
	 * @requires state to be present in urls
	 */
	public void add_URL(String state, String url)
	{
		urls.get(state).add(url);
	}
	
	/**
	 * @requires state to be present in urls
	 */
	public HashSet<String> get_state_set(String state)
	{
		return urls.get(state);
	}
}