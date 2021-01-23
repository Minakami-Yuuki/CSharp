public class Count3Quit2 {
	public static void main(String[] agrs) {
		KidCircle kc = new KidCircle (500);
		int countNum = 0;
		Kid k = kc.first;
		while(kc.count > 1) {
			countNum ++;
			if(countNum == 3) {
				countNum = 0;
				kc.delete(k);
			}
			k = k.right;
		}
		System.out.println("ʣ����Ϊ" + kc.first.id  + "��С����");
	}
}

//500��С������ǣ��Χ��һ��Ȧ ���������ࣺKid; KidCircle;��

class Kid { //Kid��������С���ѵ����id�Ͳ�ͬ��ǣ��ʱ�������;
	int id;
	Kid left;
	Kid right;
}

class KidCircle { //KidCircle��������С���ѵ�����count��С���ѵ�λ���Ⱥ�;
	int count = 0;
	Kid first;
	Kid last;
	
	KidCircle(int n) { //���췽���������;
		for(int i=0; i<n; i++) {
			add();
		}
	}
	
	void add() {
		Kid k = new Kid();
		k.id = count;
		
		if(count <= 0) { //KidCircle��һ��С���Ѷ�û��;
			first = k;
			last = k;
			k.left = k;
			k.right = k;
		}
	
		else { //KidCircle��ԭ��������1��С���ѣ���k���뵽last��first֮�䣨����С���Ѽ���firstҲ��last��;
			last.right = k;
			k.left = last;
			k.right = first;
			first.left = k;
			last = k;
		}
		
		count ++;
	}
	
	void delete(Kid k) { //KidCircle��һ��С���Ѷ�û��;
		if(count <= 0) {
			System.out.println("�����ݣ�����");
		}
		
		else if(count == 1 ){ //KidCircle�н���һ��С���ѣ���ɾ�����ڲ�����Ϊ��;
			first = last = null;
		}
		
		else { //��k���뵽last��first֮����ٽ�k�Ƴ����У�����first��last;
			k.left.right = k.right;
			k.right.left = k.left;
			
			if(k == first) {
				first = k.right;
			}
			
			if(k == last) {
				last = k.left;
			}
		}
		
		count --;
	}
}