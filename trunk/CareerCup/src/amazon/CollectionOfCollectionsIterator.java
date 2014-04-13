package amazon;


import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class CollectionOfCollectionsIterator implements Iterator<Object> {

	private Collection<Collection<Object>> _collOfColl = null;
	private Iterator<Collection<Object>> mainIt = null;
	private Iterator<Object> innerIt = null;
	private Iterator<?> removeIt = null;

	/**
	 * Constructor takes in the collection of collections that should be
	 * iterated
	 * 
	 * @param collofColl
	 *            collection of collections
	 */
	public CollectionOfCollectionsIterator(Collection<Collection<Object>> collofColl) {

		if (collofColl == null) {
			_collOfColl = Collections.emptyList();
		} else {
			_collOfColl = collofColl;
		}
		mainIt = _collOfColl.iterator();
		innerIt = new EmptyIterator();
	}

	/**
	 * Returns true if the iteration has more elements
	 */
	public boolean hasNext() {

		boolean innerHasNext = false;
		while (!(innerHasNext = innerIt.hasNext()) && mainIt.hasNext()) {
			Collection<Object> nextColl = mainIt.next();
			if (nextColl != null) {
				innerIt = nextColl.iterator();
			} else {
				innerIt = new NullElementIterator();
			}
		}

		return innerHasNext;
	}

	/**
	 * Returns the next element in the iteration
	 */
	public Object next() {

		if (!hasNext()) {
			throw new NoSuchElementException();
		}
		if (innerIt instanceof NullElementIterator) {
			removeIt = mainIt;
		} else {
			removeIt = innerIt;
		}

		return innerIt.next();
	}

	/**
	 * Removes from the underlying collection the last element returned by the
	 * iterator
	 */
	public void remove() {

		if (removeIt == null) {
			System.out.println("The next() method hasn't been executed since last call to remove()");
			return;
		}
		removeIt.remove();
		removeIt = null;
	}

	private class EmptyIterator implements Iterator<Object> {

		public void remove() {
		}

		public Object next() {
			throw new NoSuchElementException();
		}

		public boolean hasNext() {
			return false;
		}

	}

	private class NullElementIterator implements Iterator<Object> {

		private boolean isNextInvoked = false;

		public void remove() {
		}

		public Object next() {

			isNextInvoked = true;
			return null;
		}

		public boolean hasNext() {

			return !isNextInvoked;
		}

	}
}
