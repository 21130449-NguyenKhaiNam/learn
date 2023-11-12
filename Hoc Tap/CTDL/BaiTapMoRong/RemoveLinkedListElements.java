package LeetCode;

public class RemoveLinkedListElements {
	/*
	 * Xoa phan tu giong val ra khoi danh sach
	 */
	public class ListNode {
		int val;
		ListNode next;

		ListNode() {
		}

		ListNode(int val) {
			this.val = val;
		}

		ListNode(int val, ListNode next) {
			this.val = val;
			this.next = next;
		}
	}

	// So lan sai: 0
	public ListNode removeElements(ListNode head, int val) {
		if (head == null)
			return null;
		if (head.next == null)
			return head.val == val ? null : head;
		return head.val == val ? removeElements(head.next, val)
				: new ListNode(head.val, removeElements(head.next, val));
	}
}
