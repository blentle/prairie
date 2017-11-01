package top.blentle.prairie.core;

import top.blentle.prairie.core.exceptions.PrairieException;

/**
 * @author :  renhuan
 * @email : blentle.huan.ren@gmail.com
 * @time :  2017/10/11
 * @description :
 * @since : 1.0
 */
public interface Destroyable {

    /**
     * Invoked by a ParairieContext on destruction of hide service
     * @throws Exception in case of shutdown errors.
     */
    void destroy() throws PrairieException;
}
