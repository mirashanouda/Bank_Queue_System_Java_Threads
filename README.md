**Name:** Mira Shanouda &nbsp; &nbsp; **SID:** 900193016 &nbsp; &nbsp; **Section:** 5:30 PM

GitHub Repo: https://github.com/mirashanouda/Bank_Queue_System_Java_Threads.git

**Assumptions:**
1. User input the customers type by num: 1 if reg and 2 if VIP which will be considered as priority.
2. Both the customer's arrival and the customer number in the queue and how many people ahead of him/her are considered the same as the index of it in the M customers.
3. Time duration of each teller handling a customer is 2-7 seconds.
4. The producer (ManageQueue) doesn't sleep and immediately input a customer in the queue if there is a space.
5. Customers priority is handled in the priority queue where VIP customers (priority 2) are put first in the queue and if the same priority, the first to arrive is considered.
6. ManageQueue is the producer and teller is the consumer

**Design:**
1. SharedQueue class for the shared buffer (Priority Queue)
    1. Arguments:
        1. Priority Queue of type Customer
        2. ArrayList of type Customer to store all M customers
        3. maxsize = N
    2. Methods:
        1. synchronized addToQueue() to add from the ArrayList of all customers to the Priority Queue **used by ManageQueue class**
        2. synchronized takeFromQueue() to remove customers form the Priority Queue **used by Teller class**
        3. synchronized continueWork() to check if there are still some customers to add to the priority queue.
2. ManageQueue (Producer): calls addToQueue.
3. Teller (Consumer):
    1. calls takeFromQueue.
    2. Sleeps for2-7 seconds to simulate a customer handling.
4. Customer: class to handel the customer number and priority.
5. ComparatorQueue:
    1. Implements a Comparator interface.
    2. Used to sort customers in the priority queue based on their priority (VIP/Regular)
 
