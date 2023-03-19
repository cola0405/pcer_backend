package com.pcer.util;

import com.pcer.dao.TagDao;
import com.pcer.entity.Tag;
import com.sun.javafx.stage.StagePeerListener;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.HashMap;

@Component
public class MapTool {
    @Resource
    TagDao tagDao;

    HashMap<String, Integer> tag2Id;

    public Integer tag2Id(String tagName){
        if (tag2Id == null){
            ArrayList<Tag> tagList = tagDao.getTagList();
            tag2Id = new HashMap<>();
            for(Tag tag : tagList){
                tag2Id.put(tag.getName(), tag.getId());
            }
        }

        return tag2Id.get(tagName);
    }
}
