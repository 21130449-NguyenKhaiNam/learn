package LeetCode;

public class IntersectionofTwoLinkedLists {
	public class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
			next = null;
		}

		/**
		 * @param val
		 * @param next
		 */
		public ListNode(int val, ListNode next) {
			super();
			this.val = val;
			this.next = next;
		}
	}
	
	/*
	 * Tra ve nut ma tai do hai danh sach trung nhau, khong co tra ve null
	 */
	
	//Coppy code
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode ptrA = headA;
        ListNode ptrB = headB;
        if (ptrA == null || ptrB == null) {
            return null;
        }
        while (ptrA != ptrB) {
        	System.out.println(ptrA.val);
        	System.out.println(ptrB.val);
            ptrA = ptrA == null ? headB : ptrA.next;
            System.out.println(ptrA.val);
            ptrB = ptrB == null ? headA : ptrB.next;
            System.out.println(ptrB.val);
        }
        return ptrA;
    }
}
