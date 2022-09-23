package org.zkh.hotnews.api;

import org.zkh.hotnews.common.data.dto.PaperDTO;

public interface AudienceViewService {
    public PaperDTO viewPaper(Long paperId) throws Exception;

    public Integer likePaper(Long paperId, Long userId) throws Exception;

    public Integer dislikePaper(Long paperId, Long userId) throws Exception;
}
