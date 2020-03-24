
// 攻击者成功的概率
public class AttackerProbability {

    /* 计算攻击者成功概率的方法
        q：攻击者找到下一个区块的概率
        z: 攻击者落后诚实链的区块数量
     */
    public static double attackerSuccessProbability(double q, int z) {

        double p = 1.0 - q;  // 诚实节点找到下一个区块的概率
        double lambda = z * (q/p);  // 期望值
        double sum = 1.0;  // 先把攻击者成功的概率置为1
        int i, k;  // 定义两个未知数作为循环的变量

        /*
        循环，循环次数为：
        假设攻击者落后诚实链z个区块
         */
        for (k = 0; k <= z; k++) {  // 循环z次
            double poisson = Math.exp(-lambda);  // 泊松密度
            for (i = 1; i <= k; i++){
                poisson *= lambda / i;
            }
            sum -= poisson * (1 - Math.pow(q/p,z-k));
        }

        return sum;
    }

    public static void main(String args[]){
//        double Pz = attackerSuccessProbability(0.1,0);
//        System.out.println(Pz);
        double q = 0.3;
        for(int z = 0; z < 50 ;z++){
            double Pz = attackerSuccessProbability(q,z);
            System.out.println("当攻击者落后诚实节点的区块数量为：" + z + " 时");
            System.out.println("攻击者成功的概率为：" + Pz);
            System.out.println();
        }
    }
}
