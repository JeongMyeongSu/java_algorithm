package Algorithm_test;

public class segmentTree {

	static int Capacity=1;
	static int[] tree;
	
	public static void main(String[] args) {
		int[] data = {1,2,3,4,5,6,7};
		BuildTree(data.length,data);
		
		System.out.println(Query(4,5));
	}
	
	// ���׸�Ʈ Ʈ�� �����
	static void BuildTree(int N, int[] data) {
		int cnt=0;
		for(int capacity = 1; capacity<N; capacity *= 2) {Capacity=capacity*2;}; // capacity ����- N���� ū ���� ���� 2�� ������
		tree = new int[Capacity*2]; // Ʈ���� ũ��� Capacity�� 2��� �ϸ� �� ����(�������� �׳� N*4�ϱ⵵ ��)
		for(int i=Capacity;i<Capacity+N;i++) {tree[i]=data[cnt++];} // ������忡 ���� �־��ֱ�		
		for(int i=Capacity-1; i>0;i--) {tree[i]=tree[2*i]+tree[2*i+1];} // �ڽ� ����� ������ �θ��� �� ������
	}
	
	// ������ ����, ����, ���� -> �ð� ���⵵ log N
	static void Update(int i, int data) {
		int k = Capacity + i;
		tree[k] = data;
		for(int j=k/2;j>0;j /= 2) {tree[j]=tree[j*2]+tree[j*2+1];}
	}
	
	// �κ��� ����
	static int Query(int L, int R) {
		int ret = 0;
		L += Capacity; //�������� ��
		R += Capacity; //�������� ��
		
		for(;L<R;L/=2, R/=2) {
			if(L%2==1) ret+=tree[L++]; // Ȧ����� ���� ������ �ִٴ� ��. ���� L���� ���� ���� ������� �ʴ´�.
			if(R%2==0) ret+=tree[R--]; // ¦����� ���� ������ �ִٴ� ��. ���� R���� ���� ���� ������� �ʴ´�.
		}
		if(L==R) ret+= tree[L]; // �������� ������ �������� ���� ���� ������ ������  
		return ret;
	}
	
	
	

}
