public class Bitcoin {

    // 计算攻击者成功概率的方法
    public static double attackerSuccessProbability(double q, int z){

        double p = 1.0 - q;  //
        double lambda = z * (q/p);
        double sum = 1.0;
        int i, k;
        for (k = 0; k <= z; k++) {
            double poisson = Math.exp(-lambda);
            for (i = 1; i<=k; i++){
                poisson *= lambda / i;
            }
            sum -= poisson * (1 - Math.pow(q/p,z-k));
        }
        System.out.println("kkk");
        return p;

    }

    public static void main(String args[]){
        double z = attackerSuccessProbability(0.1,9);
        System.out.println(z);
    }

//    public void loop(){
//        for(double loopNum = 1.0 ; loopNum <= 10.0; loopNum++){
//            double z = 0.0;
//            z = attackerSuccessProbability()
//            System.out.println();
//        }
//    }


}
