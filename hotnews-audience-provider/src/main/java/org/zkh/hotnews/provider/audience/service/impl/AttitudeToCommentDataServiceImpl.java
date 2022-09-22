package org.zkh.hotnews.provider.audience.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import org.zkh.hotnews.data.entity.AttitudeToComment;
import org.zkh.hotnews.data.entity.Paper;
import org.zkh.hotnews.mapper.AttitudeToCommentMapper;
import org.zkh.hotnews.mapper.PaperMapper;
import org.zkh.hotnews.provider.audience.service.AttitudeToCommentDataService;

/**
 * @author S9049660
 */
@Service
public class AttitudeToCommentDataServiceImpl  extends ServiceImpl<AttitudeToCommentMapper, AttitudeToComment> implements AttitudeToCommentDataService {
}
