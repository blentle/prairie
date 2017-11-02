package top.blentle.prairie.core.system;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import top.blentle.prairie.core.event.Event;
import top.blentle.prairie.core.event.support.EventListener;
import top.blentle.prairie.core.util.Assert;

import java.io.File;

/**
 * @author :  renhuan
 * @email : blentle.huan.ren@gmail.com
 * @time :  2017/10/10
 * @description : a listener used to write a pid file in order to be shutdown by bash script or bat script
 * @since : 1.0
 */
public class TenorPidWriter implements EventListener {

    private static final Logger logger = LoggerFactory.getLogger(TenorPidWriter.class);

    private static final String DEFAULT_FILE_NAME = "tenor.pid";

    private final File file;

    public TenorPidWriter() {
        this(new File(DEFAULT_FILE_NAME));
    }

    public TenorPidWriter(File file) {
        Assert.isNull(file,"tenor pid file can't be null");
        this.file = file;
    }

    public TenorPidWriter(String fileName) {
        this(new File(fileName));
    }



    @Override
    public void onEvent(Event event) {
        //create pid file
        writePidFile(event);
    }

    @Override
    public boolean accept(Event event) {
        return false;
    }

    private void writePidFile(Event event) {
        File pidFile = this.file;
        new TenorPid().write(pidFile);
        pidFile.deleteOnExit();
    }
}
