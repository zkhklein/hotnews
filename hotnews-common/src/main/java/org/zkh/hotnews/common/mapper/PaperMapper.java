package org.zkh.hotnews.common.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.zkh.hotnews.common.data.entity.Paper;
@Mapper
public interface PaperMapper extends BaseMapper<Paper> {
}
