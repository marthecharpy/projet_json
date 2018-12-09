package com.monprojetJson.posts;

import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class PostManager {
	private ArrayList<Post> posts;
	
	public PostManager() {
		this.posts = new ArrayList<Post>();
		
		URL url = null;
		try {
			url = new URL("https://my-json-server.typicode.com/marthecharpy/projet_json/posts");
		} catch (MalformedURLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		HttpURLConnection connection = null;
		int status = 0;
		try {
			connection = (HttpURLConnection) url.openConnection();
			connection.setRequestMethod("GET");
			status = connection.getResponseCode();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		if(status == 200) {
			InputStreamReader in = null;
			try {
				in = new InputStreamReader(
					connection.getInputStream()
				);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
						
			JSONParser parser = new JSONParser();
	        Object jsonParsed = null;
	        try{
	            jsonParsed = parser.parse(in);
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
			
			try {
				in.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			connection.disconnect();

			JSONArray root = (JSONArray) jsonParsed;
			for(int i=0; i<root.size(); i++){
				JSONObject postObject = (JSONObject) root.get(i);
				int id = Math.toIntExact((long) postObject.get("id"));
				String title = (String) postObject.get("title");
				String content = (String) postObject.get("content");
				
				this.posts.add(new Post(id, title, content));
			}
		}
	}
	
	public ArrayList<Post> getAllPosts() {
		return this.posts;
	}
	
	public Post getPostById(int id) {
		for(var post : this.posts) {
			if(post.getId() == id) {
				return post;
			}
		}
		
		return null;
	}
}