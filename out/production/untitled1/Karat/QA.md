### topic
1.OOD
2.Front End
3.Design General
4.Database
5.General Programming
6.java 

1. A song service uses consistent hashing to distribute songs. Is this okay to use?

   -Answer: Yes, using consistent hashing is a suitable approach for distributing songs in a song service. Consistent hashing helps in evenly distributing the load across multiple servers, minimizing the disruption when servers are added or removed. This is particularly useful in systems where the dataset (like songs) is large and the service needs to scale dynamically.

2. A service has 1000 documents and gets 1000 requests; how many servers and databases do you need to support this service?

   -Answer: The number of servers and databases needed depends on the specifics of the request types, the document sizes, the server specifications, and the expected response times. If the requests are read-heavy and the documents are not overly large, a single database could suffice, possibly replicated for redundancy and read efficiency. Server needs could range from one to several depending on the complexity of the requests and the required processing power. For high availability and load balancing, at least two servers would be recommended.

3. Given 3 examples, select which type of consistency.

   -Answer: Without specific examples, it’s difficult to choose a type of consistency. In general, types of consistency include:

   Eventual Consistency: Good for distributed systems where latency is a concern but immediate consistency is not critical.
   Strong Consistency: Ensures that any read receives the most recent write for a given data point.
   Causal Consistency: Less restrictive than strong consistency but ensures that causally related updates are seen by all processes in causal order.

4. For an app, what are pros/cons of storing hints on device vs on server?
   -Answer:

   Pros of storing on device:
   
   Faster access times as data is retrieved locally.
   Reduced server load and bandwidth usage.
   Can function offline.
   Cons of storing on device:
   
   Increased storage use on the device.
   Potentially outdated data if not synchronized regularly.
   Security risk if sensitive data is stored locally.
   Pros of storing on server:
   
   Centralized management and updates.
   Saves local storage space on devices.
   Enhanced security measures can be implemented more robustly.
   Cons of storing on server:
   
   Requires internet connection for access.
   Higher server loads and bandwidth usage.
   Potentially slower access times due to network latency.

5. If you want to launch an app globally, how do you scale the backend?
   -Answer: To scale an app globally:

   Implement load balancing to distribute traffic evenly across servers.
   Use a Content Delivery Network (CDN) to serve static content closer to users.
   Utilize cloud services for elastic scaling according to demand.
   Ensure data consistency across multiple regions using replication strategies.
   Optimize databases and use caching solutions to improve response times.

6. If you build a log analysis system, what considerations are needed to estimate the number of servers needed for next year?
   -Answer:

   Data Growth: Estimate how much new data will be generated based on current trends.
   Query Load: Anticipate the increase in query load and complexity.
   Performance Requirements: Set benchmarks for processing times and storage capabilities.
   Redundancy and Reliability: Plan for fault tolerance and disaster recovery.
   Future Proofing: Consider potential expansions or new features that may increase system load.

7. Thread/process区别

8. heap/stack区别

9. composition/inheritance区别

10. 多线程/线程池

11. 在搭建一个比较复杂的系统的时候你可能会使用什么样的OOD设计原则为什么？


12. 系统报错给了一个图CPU%指数增长到爆memory一条水平线问为什么怎么debug？


### 7. Difference Between Threads and Processes

- **Processes**:
   - A process is a system's independent unit for resource allocation and scheduling.
   - Each process has its own complete set of variables and an independent execution environment (including memory space).
   - Inter-process communication (IPC) requires specific mechanisms such as pipes, signals, sockets, etc.
   - Stronger independence, higher switching costs, and the operating system needs to save and restore more context information.

- **Threads**:
   - A thread is an entity within a process and is the unit of CPU scheduling and execution. It represents the smallest executable unit within the base of a process.
   - Threads within the same process share the process's memory space and resources.
   - Communication between threads can be directly through reading and writing process data.
   - Lower switching costs, shared memory simplifies communication, but increases synchronization complexity.

### 8. Difference Between Heap and Stack

- **Heap (Heap Memory)**:
   - The heap is used for dynamic memory allocation, controlled by the programmer and released as needed.
   - Lifetime is controlled by the programmer, which can lead to memory leaks.
   - The size of memory blocks allocated can be adjusted dynamically.
   - Access is relatively slower and can lead to memory fragmentation.

- **Stack (Stack Memory)**:
   - The stack is used for automatic management of function calling parameters, return addresses, and local variables.
   - Lifetime is automatically controlled; memory is automatically freed when the function call ends.
   - Memory can only be allocated and revoked in sequence.
   - Faster access, high efficiency in memory allocation and revocation.

### 9. Difference Between Composition and Inheritance

- **Inheritance**:
   - Inheritance is a mechanism in object-oriented programming where a new class receives the characteristics of one or more classes.
   - Mainly used to represent an "is-a" relationship, easy to extend, but excessive use can lead to complex structures and high coupling.

- **Composition**:
   - Composition involves embedding one or more objects into another object to achieve functionality reuse and independent management.
   - Used to represent a "has-a" relationship, more flexible, easier to modify and extend, and reduces class coupling.

### 10. Multithreading vs. Thread Pools

- **Multithreading**:
   - Direct creation of threads to execute tasks, suitable for scenarios with short lifespan and small task volume.
   - The overhead of creating and destroying threads is relatively large, difficult to manage a large number of threads.

- **Thread Pools**:
   - Pre-create a certain number of threads, placed in a thread pool, and pull threads from the pool to execute tasks as they arrive.
   - Improves resource utilization, reduces the overhead of thread creation, effectively controls the maximum number of concurrent threads, enhancing system stability.

### 11. OOD Design Principles for Building a Complex System

In designing a complex system, you might use the following Object-Oriented Design (OOD) principles:
- **Single Responsibility Principle**: Ensures each class has only one reason to change.
- **Open/Closed Principle**: Software entities should be open for extension but closed for modification.
- **Liskov Substitution Principle**: Subclass objects should be able to replace their superclass objects in use.
- **Dependency Inversion Principle**: High-level modules should not depend on low-level modules; both should depend on abstractions.
- **Interface Segregation Principle**: Using multiple specialized interfaces is better than using a single general interface.
- **Composite/Aggregate Reuse Principle**: Prefer object composition over inheritance for reuse.

### 12. System Error with CPU% Exponential Growth and Memory Flat Line

If a system's CPU usage suddenly spikes while memory usage remains flat, possible reasons include:
- **Infinite loops** or **high complexity computations** causing high CPU usage.
- **External system call failures** or slow responses, triggering frequent retries.
- **Resource lock waiting** or **deadlocks**.

**Debugging Methods**:
- **Performance Profiling**: Use tools like VisualVM, JProfiler, or system native tools to analyze CPU usage.
- **Log Inspection**: Check system logs for anomalies or error records.
- **Code Review**: Review recently changed code, especially those involving loops and recursion.
- **Thread Analysis**: Examine currently running threads and their states to determine if any threads are occupying the CPU for extended periods or waiting for resources.

Using these methods, you can identify the root cause of the issue and take appropriate corrective measures.
