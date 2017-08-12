package lin.utils;

import java.util.HashMap;

public class MessageQueue {
	private Message head;
	private Message lest;
	private static HashMap<String, MessageQueue> queueMap;
	static {
		queueMap = new HashMap<String, MessageQueue>();
	}
	private MessageQueue() {
		this.head = new Message();
		this.head.next = null;
		this.lest = new Message();
	}
	
	public static MessageQueue getMessageQueue(String key) {
		MessageQueue mq = null;
		if(MessageQueue.queueMap.get(key) != null) {
			mq = queueMap.get(key);
		}else {
			mq = new MessageQueue();
			MessageQueue.queueMap.put(key, mq);
		}
		return mq;
	}
	
	public void add(Message message) {
		if(this.head.next == null) {
			this.head.next = message;
			lest = message;
		}else {
			lest.next = message;
			lest = message;
		}
	}
	public Message read() {
		Message message = null;
		if(this.head.next != null) {
			message = this.head.next;
			this.head.next = message.next;
		}
		return message;
	}
}
