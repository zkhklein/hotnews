package org.zkh.hotnews.provider.audience.service.impl;

import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.zkh.hotnews.api.AudienceViewService;
import org.zkh.hotnews.common.data.dto.PaperDTO;

/**
 * @author S9049660
 */
@Service
public class AudienceViewServiceImpl implements AudienceViewService {
    @Override
    @Cacheable(cacheNames = "paper",key = "#paperId")
    public PaperDTO viewPaper(Long paperId) throws Exception {

        return null;
    }

    @Override
    @CachePut(cacheNames = "paper",key = "#paperId")
    public Integer likePaper(Long paperId, Long userId) throws Exception {
        return null;
    }

    @Override
    @CachePut(cacheNames = "paper",key = "#paperId")
    public Integer dislikePaper(Long paperId, Long userId) throws Exception {
        return null;
    }
}
