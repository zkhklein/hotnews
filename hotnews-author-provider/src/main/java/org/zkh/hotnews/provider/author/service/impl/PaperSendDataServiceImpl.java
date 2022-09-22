package org.zkh.hotnews.provider.author.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import org.zkh.hotnews.data.entity.Paper;
import org.zkh.hotnews.mapper.PaperMapper;

import org.zkh.hotnews.provider.author.service.PaperSendDataService;

@Service
public class PaperSendDataServiceImpl extends ServiceImpl<PaperMapper, Paper> implements PaperSendDataService {
}
