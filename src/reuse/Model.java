package reuse;

import java.io.Serializable;

public class Model implements Serializable
{
    private byte[] content;
    private String filename;
    private static final long serialVersionUID = 1420672609912364060L;
    public Model(byte[] content, String filename) 
    {
        super();
        this.content = content;
        this.filename = filename;
    }
    
    public byte[] getContent() {
        return content;
    }

    public void setContent(byte[] content) {
        this.content = content;
    }

    public String getFilename() {
        return filename;
    }

    public void setFilename(String filename) {
        this.filename = filename;
    }
    
}
