import java.io.IOException;
import java.nio.file.*;

public class FileWatcher {
    public static void main(String[] args) throws IOException, InterruptedException {
        WatchService watcher = FileSystems.getDefault().newWatchService();
        Path dir = Paths.get("src/watchedFolder");
        dir.register(watcher, StandardWatchEventKinds.ENTRY_CREATE);
        System.out.println("Watching folder");
        while (true) {
            WatchKey key = watcher.take();
            for (WatchEvent<?> event : key.pollEvents()) {
                WatchEvent.Kind<?> kind = event.kind();
                Path file = (Path) event.context();
                if (kind == StandardWatchEventKinds.ENTRY_CREATE && file.toString().endsWith(".txt")) {
                    System.out.println("New file detected: " + file.getFileName());
                }
            }
            boolean valid = key.reset();
            if (!valid) {
                break;
            }
        }
    }
}
