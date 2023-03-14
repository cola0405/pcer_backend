package com.pcer.entity.req;

import com.pcer.entity.Tag;
import lombok.Data;

import java.util.ArrayList;

@Data
public class UpdateTagsReq {
    ArrayList<Tag> tags;
}
