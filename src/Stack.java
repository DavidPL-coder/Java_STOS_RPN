public class Stack {
	private String[] elements;
	private int size;

	public Stack() {
		elements = new String[10];
		size = 0;
	}

	public void push(String item) {
		if (item == null)
			throw new IllegalArgumentException("Item cannot be null");

		if (size == elements.length)
			resize();

		elements[size] = item;
		size++;
	}

	public String pop() {
		if (isEmpty())
			throw new IllegalStateException("Cannot pop from an empty stack");

		size--;
		String poppedElement = elements[size];
		elements[size] = null;
		return poppedElement;
	}

	public String peek() {
		if (isEmpty())
			throw new IllegalStateException("Cannot peek from an empty stack");

		return elements[size - 1];
	}

	public boolean isEmpty() {
		return size == 0;
	}

	public int getSize() {
		return size;
	}

	private void resize() {
		String[] newElements = new String[elements.length * 2];
		System.arraycopy(elements, 0, newElements, 0, elements.length);
		elements = newElements;
	}
}

