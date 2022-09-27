package org.zkh.hotnews.common.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import org.zkh.hotnews.common.service.PaperDataService;
import org.zkh.hotnews.common.data.entity.Paper;
import org.zkh.hotnews.common.mapper.PaperMapper;

@Service
public class PaperDataServiceImpl extends ServiceImpl<PaperMapper, Paper> implements PaperDataService {
}
