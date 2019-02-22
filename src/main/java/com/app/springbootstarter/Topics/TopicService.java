package com.app.springbootstarter.Topics;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class TopicService {
	
	private List<Topic> topics=new ArrayList<Topic>(Arrays.asList(
			new Topic(1,"Java","Java Topic"),
			new Topic(2,"Spring","Spring Topic"),
			new Topic(3,"Linux","Linux Topic"),
			new Topic(4,"OS","OS Topic"),
			new Topic(5,"Hibernate","Hibernate Topic")));
	
	public List<Topic> getAllTopics(){
		return this.topics;
	}

	public Topic getTopic(int id) {
		return topics.stream().filter(a -> (a.getId() == id)).findFirst().get();
	}

	public void addTopic(Topic topic) {
		this.topics.add(topic);
		System.out.println("Topic Added");
	}
	
	public void updateTopic(Topic topic) {
		this.topics.stream().filter(a -> a.getId() == topic.getId()).forEach(a-> {
			a.setName(topic.getName());
			a.setDescription(topic.getDescription());
		});
		System.out.println("Topic Updated");
	}

	public void deleteTopic(int id) {
//		Topic topic =this.topics.stream().filter(a-> a.getId() == id).findFirst().get();
//		if(topic != null) {
//			this.topics.remove(topic);
//		}
		this.topics.removeIf(a-> a.getId()== id);
		System.out.println("Topic Deleted");
	}

}
