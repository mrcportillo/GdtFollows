package Exceptions;

import org.apache.commons.io.IOUtils;
import java.io.IOException;
import java.io.InputStream;

/**
 * Created by mrc on 25/03/16.
 */
public class ExpiredSessionException extends Throwable {

    public ExpiredSessionException(InputStream errorStream) throws IOException {
        super(IOUtils.toString(errorStream));
    }
}
