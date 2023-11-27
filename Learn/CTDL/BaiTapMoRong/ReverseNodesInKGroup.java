package LeetCode;

public class ReverseNodesInKGroup {
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

	public ListNode reverseKGroup(ListNode head, int k) {
		reverse(head, null, k, size(head) / k);
		return head;
	}

	private void reverse(ListNode head, ListNode node, int k, int count) {
		// TODO Auto-generated method stub
		if (count == 0)
			return;
		reverse(push(head, pushReverse(head, node, k)), null, k, --count);
	}

	private ListNode push(ListNode head, ListNode node) {
		// TODO Auto-generated method stub
		if (node == null)
			return head;
		head.val = node.val;
		return push(head.next, node.next);
	}

	public ListNode pushReverse(ListNode head, ListNode node, int k) {
		return k == 0 ? node : pushReverse(head.next, new ListNode(head.val, node), --k);
	}

	private int size(ListNode head) {
		// TODO Auto-generated method stub
		return head == null ? 0 : 1 + size(head.next);
	}
}
