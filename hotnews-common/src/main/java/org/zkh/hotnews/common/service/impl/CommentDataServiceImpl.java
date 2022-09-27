package org.zkh.hotnews.common.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import org.zkh.hotnews.common.service.CommentDataService;
import org.zkh.hotnews.common.data.entity.Comment;
import org.zkh.hotnews.common.mapper.CommentMapper;

@Service
public class CommentDataServiceImpl extends ServiceImpl<CommentMapper, Comment> implements CommentDataService {
}
