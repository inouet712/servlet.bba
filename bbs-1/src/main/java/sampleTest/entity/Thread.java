package sampleTest.entity;

import java.sql.Timestamp;

public class Thread  {
	
	 private int thread_id;
	
	 private String name;
	
	 private String content;
	
	 private Timestamp post_day;
	 
	 public Thread() {}
	
	 public Thread(int thread_id,String name, String content) {
		 this.thread_id = thread_id;
		 this.name = name;
		 this.content = content;
	 }
	 
	public int getThread_id() {
		return thread_id;
	}
	
	public void setThread_id(int thread_id) {
		this.thread_id = thread_id;
	}
	 
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getContent() {
		return content;
	}
	
	public void setContent(String content) {
		this.content = content;
	}
	
	public Timestamp getPost_day() {
		return post_day;
	}
	
	public Timestamp setPost_day(Timestamp post_day) {
		return this.post_day = post_day;
	}

}
