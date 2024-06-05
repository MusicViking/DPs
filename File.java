//Structural Pattern

public interface File {
    String getContent();
}

class RemoteFile implements File {
    private String url;

    public RemoteFile(String url) {
        this.url = url;
    }

    @Override
    public String getContent() {
        // Simulate downloading content from remote server
        return "Downloaded content from " + url;
    }
}

class RemoteFileProxy implements File {
    private RemoteFile remoteFile;
    private String cachedContent;

    public RemoteFileProxy(String url) {
        this.remoteFile = new RemoteFile(url);
    }

    @Override
    public String getContent() {
        if (cachedContent == null) {
            cachedContent = remoteFile.getContent();
        }
        return cachedContent;
    }
}