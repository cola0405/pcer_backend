package com.pcer.util;

import com.pcer.dao.TagDao;
import com.pcer.entity.Tag;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.HashMap;

@Component
public class MapTool {
    @Resource
    TagDao tagDao;

    public HashMap<String, Integer> getTag2Id(){
        ArrayList<Tag> tagList = tagDao.getTagList();
        HashMap<String, Integer> tag2Id= new HashMap<>();
        for(Tag tag : tagList){
            tag2Id.put(tag.getName(), tag.getId());
        }
        return tag2Id;
    }
}
