package LeetCode;

public class SwapNodesInPairs {
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

	public ListNode swapPairs(ListNode head) {
		if (head == null || head.next == null)
			return head;
		int temp = head.val;
		head.val = head.next.val;
		head.next.val = temp;
		return head.next.next == null ? head
				: new ListNode(head.val, new ListNode(head.next.val, swapPairs(head.next.next)));
	}
}
