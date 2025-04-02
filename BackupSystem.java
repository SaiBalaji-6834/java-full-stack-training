package DAY7;
import java.io.*;
import java.util.*;

class BackupSystem {
    private static final String BACKUP_DIR = "backup/";
    private static final String META_FILE = "backup_metadata.dat";

    static void backup(String dirPath) throws IOException {
        File src = new File(dirPath);
        if (!src.exists() || !src.isDirectory()) return;
        List<String[]> metadata = new ArrayList<>();
        new File(BACKUP_DIR).mkdirs();

        for (File file : src.listFiles()) {
            File dest = new File(BACKUP_DIR + file.getName());
            copy(file, dest);
            metadata.add(new String[]{file.getName(), String.valueOf(file.length()), String.valueOf(file.lastModified())});
        }

        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(META_FILE))) {
            out.writeObject(metadata);
        }
    }

    static void recover() throws IOException, ClassNotFoundException {
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(META_FILE))) {
            @SuppressWarnings("unchecked")
            List<String[]> metadata = (List<String[]>) in.readObject();
            for (String[] data : metadata) copy(new File(BACKUP_DIR + data[0]), new File(data[0]));
        }
    }

    private static void copy(File src, File dest) throws IOException {
        try (FileInputStream in = new FileInputStream(src); FileOutputStream out = new FileOutputStream(dest)) {
            byte[] buffer = new byte[1024]; int len;
            while ((len = in.read(buffer)) > 0) out.write(buffer, 0, len);
        }
    }

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        backup("test_dir");
        recover();
    }
}
