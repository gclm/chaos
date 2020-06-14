package club.gclmit.chaos.starter.properties;

import club.gclmit.chaos.storage.model.Storage;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * <p>
 *  storage 配置
 * </p>
 *
 * @author gclm
 */
@ConfigurationProperties("chaos.storage")
public class ChaosStorageProperties extends Storage {

    /**
     * 是否保存日志到数据库中
     */
    private boolean db = true;

    public boolean getDb() {
        return db;
    }

    public void setDb(boolean db) {
        this.db = db;
    }
}