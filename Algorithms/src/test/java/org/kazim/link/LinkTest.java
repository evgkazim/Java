package org.kazim.link;

import org.junit.jupiter.api.Test;
import org.kazim.link.queue.LinkQueue;
import org.kazim.link.stack.LinkStack;

public class LinkTest {

    @Test
    void link_queue() {
        LinkQueue linkQueue = new LinkQueue();
        linkQueue.insert(20);
        linkQueue.insert(40);
        linkQueue.displayQueue();
        linkQueue.insert(60);
        linkQueue.insert(80);
        linkQueue.displayQueue();
        linkQueue.remove();
        linkQueue.remove();
        linkQueue.displayQueue();
    }

    @Test
    void link_stack() {
        LinkStack linkStack = new LinkStack();
        linkStack.push(20);
        linkStack.push(40);
        linkStack.displayStack();
        linkStack.push(60);
        linkStack.push(80);
        linkStack.displayStack();
        linkStack.pop();
        linkStack.pop();
        linkStack.displayStack();
    }
}
