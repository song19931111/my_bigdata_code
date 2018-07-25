package ForkJoin;

import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;
import java.util.concurrent.RecursiveAction;

/**
 * describe:
 *
 * @author nd.414567
 * @date 2018/06/29
 */
public class ForkJoin extends RecursiveAction {

    private File path;
    ForkJoin(File path){
        this.path = path;
    }

    @Override
    protected void compute() {
        List<ForkJoin>forkJoinList = new ArrayList<>();
        if(path != null){
            File[] files = path.listFiles();
            for(File path:files){
                if(path.isDirectory()){
                    forkJoinList.add(new ForkJoin(path));
                }else{
                    System.out.println(path.getAbsoluteFile().toString());
                }
            }
             for(ForkJoin forkJoin:invokeAll(forkJoinList)){
                //得到结果
                forkJoin.join();
             }

        }


    }

    public static void main(String args[]){
        ForkJoin forkJoin = new ForkJoin(new File("F://"));
        ForkJoinPool pool = new ForkJoinPool();
        pool.execute(forkJoin);
        forkJoin.join();



    }
}
