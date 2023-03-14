package com.pcer.service;

import com.pcer.entity.Tag;
import com.pcer.entity.req.UpdateTagsReq;

import java.util.ArrayList;

public interface TagService {
    void updateTags(UpdateTagsReq req);
    ArrayList<Tag> getTagList();
}
