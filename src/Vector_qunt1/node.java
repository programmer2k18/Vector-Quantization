package Vector_qunt1;
import java.util.Vector;

public class node {

    public  double [][]avarage;
    public Vector<double[][]> myboys;
    public double[][]myvalue;
    node(){
        avarage=new double[0][0];
        myvalue=new double[0][0];
        myboys=new Vector<double[][]>();
    }
    node(int x,int y ){
        avarage=new double[x][y];
        myvalue=new double[x][y];
        myboys=new Vector<double[][]>();
    }
    public double[][] getAverage() {
        return avarage;
    }
    public double[][] getmyvalue() {
        return myvalue;
    }
    public  void set_avarage(double[][] x){avarage=x;}
    public  void setmyvalue(double[][] x){myvalue=x;}
    public  void add_to_my_array(double [][] x){ myboys.add(x);}
    public void calc_avarage(int  length, int higth){
        float sum=0;
        float counter=0;

        for (int j = 0; j<length; j++){
            for (int z = 0; z<higth; z++) {
                for(int ii=0;ii<myboys.size();ii++) {
                    sum += myboys.get(ii)[j][z];

                }

                counter=(sum/myboys.size());
                sum=0;
                avarage[j][z]=counter;
            }}


    }


}
