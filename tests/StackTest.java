import org.junit.*;
import static org.junit.Assert.*;

public class StackTest {
	@Test
	public void testPushNull() {
		Stack stack = new Stack();

		IllegalArgumentException ex = assertThrows(IllegalArgumentException.class, () -> stack.push(null));
		assertEquals("push exception message is 'Item cannot be null'",
				"Item cannot be null",
				ex.getMessage());
	}

	@Test
	public void testPeekAfterPushOneItemToEmptyStack() {
		Stack stack = new Stack();

		stack.push("some-item");
		String poppedItem = stack.peek();

		assertEquals("pushed item", "some-item", poppedItem);
	}

	@Test
	public void testPeekAfterPushManyItems() {
		Stack stack = new Stack();

		stack.push("item1");
		stack.push("item2");
		stack.push("item3");
		String poppedItem = stack.peek();

		assertEquals("last pushed item", "item3", poppedItem);
	}

	@Test
	public void testPeekItemWhenStackIsEmpty() {
		Stack stack = new Stack();

		IllegalStateException ex = assertThrows(IllegalStateException.class, stack::peek);
		assertEquals("peek exception message is 'Cannot peek from an empty stack'",
				"Cannot peek from an empty stack",
				ex.getMessage());
	}

	@Test
	public void testPopAfterPushOneItemToEmptyStack() {
		Stack stack = new Stack();

		stack.push("some-item");
		String poppedItem = stack.pop();

		assertEquals("popped item", "some-item", poppedItem);
	}

	@Test
	public void testPopAfterPushManyItems() {
		Stack stack = new Stack();

		stack.push("item1");
		stack.push("item2");
		stack.push("item3");
		String poppedItem = stack.pop();

		assertEquals("last pushed item which was popped", "item3", poppedItem);
	}

	@Test
	public void testPopItemWhenStackIsEmpty() {
		Stack stack = new Stack();

		IllegalStateException ex = assertThrows(IllegalStateException.class, stack::pop);
		assertEquals("pop exception message is 'Cannot pop from an empty stack'",
				"Cannot pop from an empty stack",
				ex.getMessage());
	}

	@Test
	public void testGetSizeAfterPushOneItemToEmptyStack() {
		Stack stack = new Stack();

		stack.push("some-item");
		int sizeAfterPush = stack.getSize();

		assertEquals("size after push is 1", 1, sizeAfterPush);
	}

	@Test
	public void testGetSizeAfterPushManyItems() {
		Stack stack = new Stack();

		stack.push("item1");
		stack.push("item2");
		stack.push("item3");
		int sizeAfterPush = stack.getSize();

		assertEquals("size after push is 3", 3, sizeAfterPush);
	}

	@Test
	public void testGetSizeWhenStackIsEmpty() {
		Stack stack = new Stack();

		int sizeAfterPush = stack.getSize();

		assertEquals("size after push is 0", 0, sizeAfterPush);
	}

	@Test
	public void testGetSizeAfterPop() {
		Stack stack = new Stack();

		stack.push("some-item");
		stack.pop();
		int sizeAfterPush = stack.getSize();

		assertEquals("size after pop is 0", 0, sizeAfterPush);
	}

	@Test
	public void testIsEmptyAfterPushOneItemToEmptyStack() {
		Stack stack = new Stack();

		stack.push("some-item");
		boolean isEmptyAfterPush = stack.isEmpty();

		assertFalse("isEmpty returns false after push", isEmptyAfterPush);
	}

	@Test
	public void testIsEmptyAfterPushManyItems() {
		Stack stack = new Stack();

		stack.push("item1");
		stack.push("item2");
		stack.push("item3");
		boolean isEmptyAfterPush = stack.isEmpty();

		assertFalse("isEmpty returns false after push many items", isEmptyAfterPush);
	}

	@Test
	public void testIsEmptyWhenStackIsEmpty() {
		Stack stack = new Stack();

		boolean isEmpty = stack.isEmpty();

		assertTrue("isEmpty returns true when stack is empty", isEmpty);
	}

	@Test
	public void testIsEmptyAfterPop() {
		Stack stack = new Stack();

		stack.push("some-item");
		stack.pop();
		boolean isEmpty = stack.isEmpty();

		assertTrue("isEmpty returns true after pop last item", isEmpty);
	}
}
