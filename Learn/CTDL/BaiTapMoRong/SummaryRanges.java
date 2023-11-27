package LeetCode;

import java.util.ArrayList;
import java.util.List;

public class SummaryRanges {
	/*
	 * Cho mot mang so da duoc sap xep, tra ve danh sach cac chu so theo dung thu tu
	 * cua no Input: nums = [0,1,2,4,5,7] Output: ["0->2","4->5","7"] Explanation:
	 * The ranges are: [0,2] --> "0->2" [4,5] --> "4->5" [7,7] --> "7"
	 */

	// So lan sai: 3

	/*
	 * Giai thich: Dau tien mang chi co mot phan tu thi dua truc tiep phan tu do vao
	 * list. Bien count la bien se dem xem co bao nhieu phan tu lien tiep voi nhau,
	 * bien index se la bien vi tri chay cho mang. Co hai truong hop xay ra, index
	 * dat toi nums.length - 1 va index be hon. Hai truong hop nay xu ly khac nhau
	 * nen khong gop chung duoc. TH1: index dat toi nums.length - 1, neu bien count
	 * dem duoc da co 1 lan lien tiep tro len thi thuc hien viec them dau va cuoi
	 * cac so lien tiep, con khong thi them vi tri cuoi cung, boi do cung la ket
	 * thuc, sau do ngat khoi mang. TH2: Kiem tra xem bien count dem co hon 1 lan,
	 * neu co thuc hien luu nhu cong thuc, khong thi chi lay vi tri hien tai tru 1
	 * vi no chua phai phan tu cuoi cung. Luon khoi tao lai moi count neu da luu.
	 */
	
	/*
	 * Cach khac:
	 *  List<String> list = new ArrayList<>();
        
        if (nums.length ==1){
            list.add(Integer.toString(nums[0]));
            return list;
        }

        StringBuilder stringBuilder = new StringBuilder();

        for (int i = 0; i < nums.length; i++) {
            if (stringBuilder.isEmpty())
                stringBuilder.append(nums[i]);

            if (i + 1 != nums.length && nums[i] + 1 != nums[i + 1]) {
                String s = stringBuilder.toString();
                if (!s.contains(Integer.toString(nums[i]))) {
                    stringBuilder.append("->");
                    stringBuilder.append(nums[i]);
                    list.add(stringBuilder.toString());
                } else
                    list.add(stringBuilder.toString());
                stringBuilder = new StringBuilder();
            } else if (i + 1 == nums.length) {
                if (stringBuilder.isEmpty()) {
                    stringBuilder.append(nums[i]);
                }else if (nums[i] - 1 == nums[i - 1]){
                    stringBuilder.append("->");
                    stringBuilder.append(nums[i]);
                    list.add(stringBuilder.toString());
                }else {
                    list.add(stringBuilder.toString());
                    stringBuilder = new StringBuilder();
                    stringBuilder.append(nums[i]);
                    if (!list.contains(stringBuilder.toString()))
                        list.add(stringBuilder.toString());
                }
            }
        }

        return list;
	 */
	public static List<String> summaryRanges(int[] nums) {
		List<String> list = new ArrayList<String>();
		if (nums.length == 1) {
			list.add(nums[0] + "");
			return list;
		}
		int count = 0, index = 0;
		while (index < nums.length) {
			if (index == nums.length - 1) {
				if (count >= 1) {
					list.add(nums[index - count] + "->" + nums[index]);
				} else {
					list.add(nums[index] + "");
				}
				break;
			}
			if (Math.abs(nums[index] - nums[++index]) == 1) {
				++count;
				continue;
			}
			if (count >= 1) {
				list.add(nums[index - count - 1] + "->" + nums[--index]);
			} else {
				list.add(nums[--index] + "");
			}
			count = 0;
			++index;
		}
		return list;
	}

	public static void main(String[] args) {
		int[] arr = { -2, -3, -6 };
		System.out.println(summaryRanges(arr));
	}
}
