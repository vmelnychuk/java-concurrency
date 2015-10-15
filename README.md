## Java Concurrency project
This is java project for concurrency tasks
Actions:

    - Thread vs Runable (new Thread <-> new Runnable)
    - Callable vs Runable (new Callable <-> new Runnable)
    - Futures
        - isDone
            false is if not ready
        - get
            - exception if get(time, unit) when time is less then needed
            - wait until done if get()
    - ThreadLocal
    - volatile
    - synchronized
        - method
            - static
            - non-static
        - object, section
            - ClassObj
            - this
            - field
        - section
    - lock
        - locks
        - ReentrantLock
    - Lock vs synchronized
    - Semaphores
    - ExecutePool

Concurrency issues:

    - Synchronization
        - non-atomic operation, e.g. inc = get value -> add one -> store value
    - Deadlocks
    - Starvation