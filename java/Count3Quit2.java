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
		System.out.println("剩余编号为" + kc.first.id  + "的小朋友");
	}
}

//500个小朋友手牵手围成一个圈 （找名词类：Kid; KidCircle;）

class Kid { //Kid类里面有小朋友的身份id和不同人牵手时所伸的手;
	int id;
	Kid left;
	Kid right;
}

class KidCircle { //KidCircle类里面有小朋友的总数count和小朋友的位置先后;
	int count = 0;
	Kid first;
	Kid last;
	
	KidCircle(int n) { //构造方法添加总数;
		for(int i=0; i<n; i++) {
			add();
		}
	}
	
	void add() {
		Kid k = new Kid();
		k.id = count;
		
		if(count <= 0) { //KidCircle中一个小朋友都没有;
			first = k;
			last = k;
			k.left = k;
			k.right = k;
		}
	
		else { //KidCircle内原本有至少1个小朋友，将k插入到last和first之间（即该小朋友即是first也是last）;
			last.right = k;
			k.left = last;
			k.right = first;
			first.left = k;
			last = k;
		}
		
		count ++;
	}
	
	void delete(Kid k) { //KidCircle中一个小朋友都没有;
		if(count <= 0) {
			System.out.println("无数据，错误");
		}
		
		else if(count == 1 ){ //KidCircle中仅有一个小朋友，被删除后内部数据为空;
			first = last = null;
		}
		
		else { //将k插入到last和first之间后，再将k移除队列，连接first和last;
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