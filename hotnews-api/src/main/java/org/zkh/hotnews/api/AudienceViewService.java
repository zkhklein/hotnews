package org.zkh.hotnews.api;

import org.zkh.hotnews.common.data.dto.AttitudeToPaperDTO;
import org.zkh.hotnews.common.data.dto.PaperDTO;

public interface AudienceViewService {
    public String viewPaperContent(Long paperId) throws Exception;
    public String viewPaperTitle(Long paperId) throws Exception;
    public String viewPaperAuthor(Long paperId) throws Exception;
    public String viewPaperLikeNum(Long paperId) throws Exception;
    public String viewPaperDislikeNum(Long paperId) throws Exception;
    public String viewPaperCommentNum(Long paperId) throws Exception;
    public String viewAttitudeToPaper(Long paperId,Long userId) throws Exception;
    public Boolean doLikePaper(AttitudeToPaperDTO attitudeToPaperDTO) throws Exception;

    public Boolean doDislikePaper(AttitudeToPaperDTO attitudeToPaperDTO) throws Exception;
}
