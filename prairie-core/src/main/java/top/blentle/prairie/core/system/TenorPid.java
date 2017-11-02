package top.blentle.prairie.core.system;

import top.blentle.prairie.core.util.Assert;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.management.ManagementFactory;

/**
 * @author :  renhuan
 * @email : blentle.huan.ren@gmail.com
 * @time :  2017/10/02
 * @description : tenor pid in system
 * @since : 1.0
 */
public class TenorPid {

    private final String pid;

    public TenorPid() {
        this.pid = getPid();
    }

    private String getPid() {
        String jvm = ManagementFactory.getRuntimeMXBean().getName();
        return jvm.split("@")[0];
    }

    public void write(File pidFile) throws IOException {
        Assert.isNull(this.pid, "No available pid");
        File folderWithAncestors = pidFile.getParentFile();
        if (folderWithAncestors != null) {
            folderWithAncestors.mkdirs();
        }
        try(FileWriter writer = new FileWriter(pidFile)) {
            writer .write(this.pid);
        }
    }
}
