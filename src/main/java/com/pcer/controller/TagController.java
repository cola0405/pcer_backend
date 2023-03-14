package com.pcer.controller;

import com.pcer.entity.Tag;
import com.pcer.entity.req.UpdateTagsReq;
import com.pcer.entity.res.R;
import com.pcer.entity.res.RD;
import com.pcer.service.TagService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.ArrayList;

@RestController
@RequestMapping("/tag")
public class TagController {

    @Resource
    TagService tagService;

    @PostMapping("/update")
    public R updateTags(@RequestBody UpdateTagsReq req){
        tagService.updateTags(req);
        return R.success();
    }

    @GetMapping("/list")
    public RD getTagList(){
        ArrayList<Tag> tagList = tagService.getTagList();
        return RD.success().putData("tagList", tagList);
    }


}
