package org.zkh.hotnews.provider.audience.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import org.zkh.hotnews.data.entity.AttitudeToPaper;
import org.zkh.hotnews.mapper.AttitudeToPaperMapper;
import org.zkh.hotnews.provider.audience.service.AttitudeToPaperDataService;

@Service
public class AttitudeToPaperDataServiceImpl  extends ServiceImpl<AttitudeToPaperMapper, AttitudeToPaper> implements AttitudeToPaperDataService {
}
