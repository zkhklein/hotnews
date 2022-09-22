package org.zkh.hotnews.provider.audience.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import org.zkh.hotnews.data.entity.Comment;
import org.zkh.hotnews.data.entity.Paper;
import org.zkh.hotnews.mapper.CommentMapper;
import org.zkh.hotnews.mapper.PaperMapper;
import org.zkh.hotnews.provider.audience.service.CommentDataService;
import org.zkh.hotnews.provider.audience.service.PaperViewDataService;

@Service
public class CommentDataServiceImpl extends ServiceImpl<CommentMapper, Comment> implements CommentDataService {
}
