package com.example.javadata.topic;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Service
public class TopicService {

    @Autowired
    private  TopicRepository topicRepository ;

    private List<Topic> topics = new ArrayList<>( Arrays.asList(
            new Topic("spring","Spring Framework","Spring Framework Descriptions"),
                new Topic("java","Advance Java","Java Descriptions"),
                new Topic("javascript","Javasript Framework","Javascript Framework Descriptions")

        ));

    public List<Topic> getTopics() {

       // return topics;
        List<Topic> topics = new ArrayList<>() ;
        topicRepository.findAll()
                .forEach(topics::add);
        return topics ;

    }
    public Optional<Topic> getTopic(String id){

        //return topics.stream().filter(t -> t.getId().equals(id)).findFirst().get() ;
        return  topicRepository.findById(id) ;
    }

    public void addTopic(Topic topic)
    {
        //topics.add(topic);
        topicRepository.save(topic);
    }

    public void updateTopic(String id ,Topic topic) {

//        for(int i=0 ; i<topics.size() ; i++){
//            Topic t = topics.get(i) ;
//            if(t.getId().equals(id)){
//                topics.set(i,topic);
//                System.out.println("updated");
//                return;
//            }
//        }

        topicRepository.save(topic);

    }

    public void deleteTopic(String id) {

//        topics.removeIf(t->t.getId().equals(id)) ;
//        System.out.println("deleted");

        topicRepository.deleteById(id);
    }
}
