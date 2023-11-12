package LeetCode;

public class MergeKSortedLists {
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

	public ListNode mergeKLists(ListNode[] lists) {
		ListNode re = null;
		for (ListNode listNode : lists)
			re = a(re, listNode);
		return re;
	}

	private ListNode a(ListNode re, ListNode listNode) {
		// TODO Auto-generated method stub
		if (re == null)
			return listNode;
		if (listNode == null)
			return re;
		return listNode.val <= re.val ? new ListNode(listNode.val, a(re, listNode.next))
				: new ListNode(re.val, a(re.next, listNode));
	}
}
