package coding.exception;

/**
 * Created by zhangyu on 2017/11/5.
 */
public class ConfigException extends Exception{
    public ConfigException() {
        super();
    }

    public ConfigException(String message) {
        super(message);
    }

    public ConfigException(String message, Throwable cause) {
        super(message, cause);
    }

    public ConfigException(Throwable cause) {
        super(cause);
    }

    protected ConfigException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
