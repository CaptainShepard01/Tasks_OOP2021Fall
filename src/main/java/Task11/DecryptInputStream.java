package Task11;

import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;

public class DecryptInputStream extends FilterInputStream
{

    protected DecryptInputStream(InputStream in)
    {
        super(in);
    }

    public int read(int z) throws IOException
    {
        int c = super.read();
        if(c == -1) return -1;
        return (c^z) & 0xFF; /* Only use lowest 8 bits */
    }
}
