package org.zkh.hotnews.api;

import org.zkh.hotnews.common.data.dto.PaperDTO;

/**
 * @author S9049660
 */
public interface PaperSendService {

    public Boolean sendPaper(PaperDTO paperDTO) throws Exception;

}
