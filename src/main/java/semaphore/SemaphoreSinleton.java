package semaphore;

import java.util.concurrent.Semaphore;

public class SemaphoreSinleton {
    private Semaphore semaphore;
    private static final SemaphoreSinleton ourInstance = new SemaphoreSinleton();

    public static SemaphoreSinleton getInstance() {
        return ourInstance;
    }

    private SemaphoreSinleton() {
    }

    public Semaphore getSemaphore() {
        return semaphore;
    }

    public void setSemaphore(Semaphore semaphore) {
        this.semaphore = semaphore;
    }
}
