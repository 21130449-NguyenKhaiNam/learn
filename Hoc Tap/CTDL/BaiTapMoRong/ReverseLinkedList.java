package LeetCode;

public class ReverseLinkedList {
	/*
	 * Dao mot danh sach lien ket
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
	//Su dung filo
	public ListNode reverseList(ListNode head) {
		ListNode footer = new ListNode();
		while(head != null){
			footer.val = head.val;
			footer = new ListNode(0, footer);
			head = head.next;
		}
		return footer;
	}
}





































