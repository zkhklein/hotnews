package org.zkh.hotnews.provider.audience.service.impl;

import org.springframework.stereotype.Service;
import org.zkh.hotnews.api.AudienceViewService;
import org.zkh.hotnews.data.dto.PaperDTO;

@Service
public class AudienceViewServiceImpl implements AudienceViewService {
    @Override
    public PaperDTO viewPaper(Long paperId) throws Exception {
        return null;
    }

    @Override
    public Integer likePaper(Long paperId, Long userId) throws Exception {
        return null;
    }

    @Override
    public Integer dislikePaper(Long paperId, Long userId) throws Exception {
        return null;
    }
}
