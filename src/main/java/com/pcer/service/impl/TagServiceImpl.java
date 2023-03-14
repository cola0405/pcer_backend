package com.pcer.service.impl;

import com.pcer.entity.Tag;
import com.pcer.dao.TagDao;
import com.pcer.entity.req.UpdateTagsReq;
import com.pcer.service.TagService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.HashMap;

@Service
public class TagServiceImpl implements TagService {

    @Resource
    TagDao tagDao;

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void updateTags(UpdateTagsReq req) {
        ArrayList<Tag> newList = req.getTags();
        ArrayList<Tag> oldList = tagDao.getTagList();
        HashMap<Integer, String> oldTagMap = new HashMap<>();
        HashMap<Integer, String> newTagMap = new HashMap<>();

        for(Tag tag : oldList){
            oldTagMap.put(tag.getId(), tag.getName());
        }
        for(Tag tag : newList){
            newTagMap.put(tag.getId(), tag.getName());
        }

        for(Tag tag : newList){
            if (tag.getId() == 0){
                // new tag
                tagDao.insert(tag);
            }else if (oldTagMap.containsKey(tag.getId())
                    && !oldTagMap.get(tag.getId()).equals(tag.getName())){
                // update update
                tagDao.updateById(tag);
            }
        }

        // delete tag
        for(Tag tag : oldList){
            if (!newTagMap.containsKey(tag.getId())){
                tagDao.delete(tag.getId());
            }
        }
    }

    @Override
    public ArrayList<Tag> getTagList() {
        return tagDao.getTagList();
    }
}
