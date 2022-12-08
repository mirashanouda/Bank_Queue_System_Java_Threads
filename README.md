# Bank_Queue_System_Java_Threads

 * Java doesn't support multiple inheritance,
   so we can't inherit form the Thread class and another class at the same time

 Another way of creating classes
 * Runnable r = new MyThread(); // where my thread is a class extends Runnable
 * Thread task = new Thread(r);
 * task.start();

 * Runnable: multiple threads share the same objects.
 * Thread: Each thread creates a unique object and gets associated with it.
 *
 *
 * Design:
 *  1. data class for the buffer
 *  2. user input the customers type by num: 1 if reg and 2 if VIP
 *      2.1. exception handling
 *  3. ManageQueue is the producer and teller is the consumer
 *  4. shared buffer
 *      4.1. size == number of tellers
 *      4.2. input in the queue new date
 *
 * thoughts:
 * the shared buffer is priority queue
 * I am inserting who are coming into this queue and VIP should be given higher priority
