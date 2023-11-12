package LeetCode;

public class AddTwoNumbers {
	/*
	 * Cho hai danh sach lien ket khong rong, tim ket qua cong cua hai danh sach
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

	/*
	 * Cach khac ListNode l3 = new ListNode(); ListNode temp = l3; int c = 0; while(
	 * l1 != null || l2 != null || c == 1){ int sum = 0; if(l1 != null){ sum +=
	 * l1.val; l1 = l1.next; } if(l2 != null){ sum += l2.val; l2 = l2.next; } sum +=
	 * c; c = sum/10; ListNode node = new ListNode(sum % 10); temp.next = node; temp
	 * = temp.next; } return l3.next; }
	 */

	//SO lan sai: 6
	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		return addTwoNumbersVS2(l1, l2, 0);
	}

	private ListNode addTwoNumbersVS2(ListNode l1, ListNode l2, int i) {
		if (i == 1 && l1 == null && l2 == null)
			return new ListNode(i);
		if (l1 == null) {
			if (i == 1 && l2 != null) {
				int tinh = l2.val + i;
				return tinh == 10 ? new ListNode(0, addTwoNumbersVS2(null, l2.next, 1))
						: new ListNode(tinh, addTwoNumbersVS2(null, l2.next, 0));
			}
			return l2;
		}
		if (l2 == null) {
			if (i == 1 && l1 != null) {
				int tinh = l1.val + i;
				return tinh == 10 ? new ListNode(0, addTwoNumbersVS2(l1.next, null, 1))
						: new ListNode(tinh, addTwoNumbersVS2(l1.next, null, 0));
			}
			return l1;
		}
		int sum = l1.val + l2.val + i;
		if (sum >= 10) {
			sum -= 10;
			return new ListNode(sum, addTwoNumbersVS2(l1.next, l2.next, 1));
		}
		return new ListNode(sum, addTwoNumbersVS2(l1.next, l2.next, 0));
	}

}
