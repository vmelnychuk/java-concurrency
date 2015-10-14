## Java Concurrency project
This is java project for concurrency tasks
Actions:

    - Thread vs Runable (new Thread <-> new Runnable)
    - Callable vs Runable (new Callable <-> new Runnable)
    - Futures
        - isDone
        - get
            - null
            - wait until done
    - ThreadLocal
    - volatile
    - synchronized
    - lock
    - Lock vs synchronized
    - Semaphores
    - ExecutePool

Concurrency issues:

    - Synchronization
        - non-atomic operation, e.g. inc = get value -> add one -> store value
    - Deadlocks
    - Starvation