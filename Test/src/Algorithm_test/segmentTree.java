package Algorithm_test;

public class segmentTree {

	static int Capacity=1;
	static int[] tree;
	
	public static void main(String[] args) {
		int[] data = {1,2,3,4,5,6,7};
		BuildTree(data.length,data);
		
		System.out.println(Query(4,5));
	}
	
	// 세그먼트 트리 만들기
	static void BuildTree(int N, int[] data) {
		int cnt=0;
		for(int capacity = 1; capacity<N; capacity *= 2) {Capacity=capacity*2;}; // capacity 정함- N보다 큰 가장 작은 2의 제곱수
		tree = new int[Capacity*2]; // 트리의 크기는 Capacity의 2배로 하면 다 들어옴(귀찮으면 그냥 N*4하기도 함)
		for(int i=Capacity;i<Capacity+N;i++) {tree[i]=data[cnt++];} // 리프노드에 숫자 넣어주기		
		for(int i=Capacity-1; i>0;i--) {tree[i]=tree[2*i]+tree[2*i+1];} // 자식 노드의 합으로 부모노드 값 정해줌
	}
	
	// 데이터 삽입, 수정, 삭제 -> 시간 복잡도 log N
	static void Update(int i, int data) {
		int k = Capacity + i;
		tree[k] = data;
		for(int j=k/2;j>0;j /= 2) {tree[j]=tree[j*2]+tree[j*2+1];}
	}
	
	// 부분합 추출
	static int Query(int L, int R) {
		int ret = 0;
		L += Capacity; //리프노드로 감
		R += Capacity; //리프노드로 감
		
		for(;L<R;L/=2, R/=2) {
			if(L%2==1) ret+=tree[L++]; // 홀수라는 것은 우측에 있다는 것. 현재 L보다 좌측 값은 사용하지 않는다.
			if(R%2==0) ret+=tree[R--]; // 짝수라는 것은 좌측에 있다는 것. 현재 R보다 우측 값은 사용하지 않는다.
		}
		if(L==R) ret+= tree[L]; // 마지막에 같아져 더해주지 않은 값이 있으면 더해줌  
		return ret;
	}
	
	
	

}
