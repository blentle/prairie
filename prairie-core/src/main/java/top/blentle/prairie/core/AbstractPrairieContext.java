package top.blentle.prairie.core;

import top.blentle.prairie.core.event.support.EventListener;
import top.blentle.prairie.core.exceptions.PrairieException;

import java.util.ArrayList;
import java.util.List;

/**
 * @author :  renhuan
 * @email : blentle.huan.ren@gmail.com
 * @time :  2017/10/1
 * @description : context that EndpointServer or EndpointClient invoke to expose service and request invoke
 * service
 * @since : 1.0
 */
public class AbstractPrairieContext implements Destroyable {

    private List<EventListener> listeners = new ArrayList<>();

    @Override
    public void destroy() throws PrairieException {
        //todo: to hide services and close socket
    }
}
