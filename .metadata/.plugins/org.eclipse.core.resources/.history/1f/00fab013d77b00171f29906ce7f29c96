package com.lin.utils;

public class MessageQueue {
	private Message head;
	private Message lest;
	public MessageQueue() {
		head = new Message();
		head.next = null;
		lest = new Message();
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
		Message message = this.head.next;
		this.head.next = message.next;
		return message;
	}
}
