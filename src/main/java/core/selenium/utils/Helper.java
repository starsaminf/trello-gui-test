package core.selenium.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Helper class.
 */
public final class Helper {
    /**
     * Constructor.
     */
    private Helper() {

    }

    /**
     * This method return a date using the format yyyy-MM-dd HH:mm:ss.
     * @return simpleDateFormat
     */
    public static String getTime() {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return simpleDateFormat.format(new Date());
    }
}

