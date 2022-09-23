package org.zkh.hotnews.common.data.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import org.zkh.hotnews.common.data.service.AttitudeToPaperDataService;
import org.zkh.hotnews.common.data.entity.AttitudeToPaper;
import org.zkh.hotnews.common.mapper.AttitudeToPaperMapper;

@Service
public class AttitudeToPaperDataServiceImpl extends ServiceImpl<AttitudeToPaperMapper, AttitudeToPaper> implements AttitudeToPaperDataService {
}
