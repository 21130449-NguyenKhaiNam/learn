package LeetCode;

public class RemoveDuplicatesfromSortedList {
	/*
	 * Cho truoc mot lop listnode da duoc sap xep, tao phuong thuc don sach cac phan
	 * tu bi trung trong do va tra ve lop do da duoc don sach dau tien can kiem tra
	 * lop do co lap khong, can mot phuong thuc gia tri khong bi troi di nen tao ra
	 * phuongThucKhac, no vao phuong thuc khac no cung kiem tra co lap khong dong
	 * thoi do cung la khi no biet can ngung lai, neu gia tri tiep theo giong gia
	 * tri truoc thi no bo qua gia tri truoc roi kiem tra tiep, neu khong thi chi
	 * kiem tra o phia sau con gia tri truoc giu lai
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

	// So lan sai: 1
	// Mot cach khac
//	 ListNode current_node = head;
//       while(current_node!=null && current_node.next!=null){
//           if(current_node.next.val == current_node.val){
//               current_node.next = current_node.next.next;
//           }else{
//               current_node = current_node.next;
//           }
//       }
//       return head;
	public static ListNode deleteDuplicates(ListNode head) {
		if (head == null || head.next == null)
			return head;
		return phuongThucKhac(head.val, head);
	}

	public static ListNode phuongThucKhac(int val, ListNode head) {
		if (head == null || head.next == null) {
			return head;
		} else if (val == head.next.val) {
			return phuongThucKhac(val, head.next);
		} else {
			head.next = phuongThucKhac(head.next.val, head.next);
			return head;
		}
	}

}
