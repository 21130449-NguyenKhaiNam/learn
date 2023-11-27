package LeetCode;

public class RemoveNthNodeFromEndofList {
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

	public ListNode removeNthFromEnd(ListNode head, int n) {
		return head == null ? null:re(head, length(head) - n);
	}

	private ListNode re(ListNode head, int count) {
		// TODO Auto-generated method stub
		return count < 1 ? head.next : new ListNode(head.val, re(head.next, --count));
	}

	private int length(ListNode head) {
		// TODO Auto-generated method stub
		return head == null ? 0 : 1 + length(head.next);
	}

	public static void main(String[] args) {
	}
}
