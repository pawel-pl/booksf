package worksapp;

import java.util.PriorityQueue;
import java.util.Queue;

public class QueueImmut<E> extends PriorityQueue<E>{

	/**
	 * 
	 */
	private static final long serialVersionUID = 7399227568280705564L;

	
	public Queue<E> enqueue(E o) {
		
		Queue<E> q = new PriorityQueue<E>();
		q.addAll(this);
		q.add(o);
		
		return q;
	}

}
