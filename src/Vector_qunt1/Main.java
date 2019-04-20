package Vector_qunt1;

import java.util.ArrayList;
import java.util.Vector;

public class Main {
    public static node Divided_image(int pixel[][],int row ,int column){
        node parent = new node( row,column);
    //    objects.add(parent);
        // int[][] pixel = ImageClass.readImage("B:\\mozakra\\third year\\first semester\\multimedia\\assig\\Non_uniform_SQ\\src\\Non_uniform_SQ\\cameraMan.jpg");
     //   int [][] pixel={{1,2,7,9,4,11},{3,4,6,6,12,12},{4,9,15,14,9,9},{10,10,20,18,8,8},{4,3,17,16,1,4,},{4,5,18,18,5,6}};
        int length = pixel.length;
        int width = pixel[0].length;
        for (int i = 0; i < length; i += row) {
            for (int j = 0; j < width; j += column) {
                double[][] temp = new double[row][column];
                for (int l = 0; l < row; l++) {
                    for (int k = 0; k < column; k++) {
                        if (i + l < length && j + k < width) {
                            temp[l][k] = pixel[i + l][j + k];
                        }
                    }
                }
                parent.add_to_my_array(temp);
            }
        }
        parent.calc_avarage(row,column);
        return parent;
    }

    public static int differ(double [][]z,double[][]x){
        int co1=0,co2=0;
        for (int i=0;i<z.length;i++){
            for(int j=0;j<z[i].length;j++){
                co1+=z[i][j];
                co2+=x[i][j];
            }
        }
        return Math.abs(co1-co2);
    }
    public static void compression(int no_of_codebocks, int column, int row){
     //   int [][] pixel={{1,2,7,9,4,11},{3,4,6,6,12,12},{4,9,15,14,9,9},{10,10,20,18,8,8},{4,3,17,16,1,4,},{4,5,18,18,5,6}};
       int[][] pixel=ImageClass.readImage("B:\\mozakra\\third year\\first semester\\multimedia\\assig\\Vector_qunt1\\src\\Vector_qunt1\\a1.jpg");

        ArrayList<node> objects = new ArrayList<>();
        node parent = new node( row,column);
        parent=Divided_image(pixel,row,column);
        objects.add(parent);



        for (int co=1;co<no_of_codebocks;co*=2){
            int currSiz = objects.size();

            for(int j = 0 ; currSiz>0;) {
                node lef= new node(row,column) ;
                node righto =new node(row,column);
                double[][]teto=new double [row][column];
                double[][]teto1=new double [row][column];
                for (int temp1=0;temp1<objects.get(j).getAverage().length;temp1++){
                    for (int temp2=0;temp2<objects.get(j).getAverage()[temp1].length;temp2++){
                      //  System.out.println(Math.ceil(objects.get(j).getAverage()[temp1][temp2]));
                        teto[temp1][temp2]=Math.ceil(objects.get(j).getAverage()[temp1][temp2])-1;
                        teto1[temp1][temp2]=Math.ceil(objects.get(j).getAverage()[temp1][temp2])+1;
                    }
                }
                lef.setmyvalue(teto);
                righto.setmyvalue(teto1);
                for (int i=0;i<objects.get(j).myboys.size();i++) {

                    int z = differ(objects.get(j).myboys.get(i), lef.getmyvalue());
                    int finalz = differ(objects.get(j).myboys.get(i), righto.getmyvalue());

                    if (z < finalz) {
                        lef.myboys.add(objects.get(j).myboys.get(i));
                    } else {
                        righto.myboys.add(objects.get(j).myboys.get(i));
                    }
                }
                lef.calc_avarage(row,column);
                righto.calc_avarage(row,column);
              //  System.out.println(lef.myboys.size()+" "+righto.myboys.size());

                objects.remove(0);

                currSiz--;
                objects.add(lef);
                objects.add(righto);

            }}
        for (int j=0;j<objects.size();j++){
            objects.get(j).calc_avarage(row,column);}

            for (int i=0;i<objects.size();i++){
           objects.get(i).myboys.clear();
            }
     /*   for (int i=0;i<objects.size();i++){
            System.out.println(objects.get(i).myboys.size());
        }*/
     //   System.out.println(parent.myboys.size());
        for (int i=0;i<parent.myboys.size();i++) {
            int z=differ(parent.myboys.get(i),objects.get(0).getAverage());
            int finalz=z;
            int position=0;
            for (int j=1;j<objects.size();j++){
                int z1=differ(parent.myboys.get(i),objects.get(j).getAverage());
                if (z1<finalz){
                    finalz=z1;
                    position=j;
                }

            }  objects.get(position).myboys.add(parent.myboys.get(i));}

        for (int j=0;j<objects.size();j++){
         objects.get(j).calc_avarage(row,column);}

        int [] array=new int[parent.myboys.size()];
        Vector<double[][]>arr=new Vector<>();
                for (int i=0;i<parent.myboys.size();i++){
            for (int j=0;j<objects.size();j++){
                if (objects.get(j).myboys.contains(parent.myboys.get(i))){
                    arr.add(objects.get(j).getAverage());
                    array[i]=j;
                    break;
                }
            }
        }
        int temp1=0;
        int length = pixel.length;
        int width = pixel[0].length;
        for (int i = 0; i < length; i += row) {
            for (int j = 0; j < width; j += column) {
                //double[][] temp = new double[row][column];
                for (int l = 0; l < row; l++) {
                    for (int k = 0; k < column; k++) {
                        if (i + l < length && j + k < width) {
                            System.out.println((i+l)+" "+(j+k));
                            pixel[i + l][j + k] = (int) arr.get(temp1)[l][k];

                        }  else
                           break;

                    }

                }
                temp1++;
            }
        }
      /*  for (int i=0;i<parent.myboys.size();i++){
            System.out.println(array[i]);
        }
        for (int i=0;i<objects.size();i++){
            for (int ii=0;ii<objects.get(i).getAverage().length;ii++){

                for (int ii1=0;ii1<objects.get(i).getAverage()[ii].length;ii1++){
                    System.out.print(objects.get(i).getAverage()[ii][ii1]);
                }
                System.out.println();
            }System.out.println();
        }*/


        ImageClass.writeImage(pixel, "B:\\mozakra\\third year\\first semester\\multimedia\\assig\\Vector_qunt1\\src\\Vector_qunt1\\a2_out.jpg");

    }

}
