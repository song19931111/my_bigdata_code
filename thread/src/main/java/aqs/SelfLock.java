package aqs;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.AbstractQueuedSynchronizer;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;

/**
 * Copyright@XiangSongNd.
 * Author:XiangSong
 * Date:2018/7/11
 * Description:实现类似ReentrankLock
 */
public class SelfLock implements Lock {


    //state = 1 获取到锁，state =0 表示当前没有线程拿到


    private static class Sync extends AbstractQueuedSynchronizer{
        @Override
        /**
         * 判定是否是一个独占
         */
        protected boolean isHeldExclusively() {
            return getState() == 1;
        }

        @Override
        protected boolean tryAcquire(int arg) {
            if(compareAndSetState(0,1)){
                //让线程拿到这个锁
                setExclusiveOwnerThread(Thread.currentThread());
                return true;
            }
            return  false;
        }

        @Override
        protected boolean tryReleaseShared(int arg) {
            if(getState() == 0){
                throw  new UnsupportedOperationException();
            }
            setExclusiveOwnerThread(null);
            //为什么释放的时候，用setState?
            //因为独占锁没有人抢着释放，而有很多人去抢着获取
            setState(0);
            return  true;
        }


        Condition newCondition(){
            return new ConditionObject();
        }

    }


    private final Sync sync = new Sync();
    public void lock() {
        //独占锁是1
        sync.acquire(1);

    }

    public void lockInterruptibly() throws InterruptedException {

        sync.acquireInterruptibly(1);

    }

    public boolean tryLock() {

        ;
        return sync.tryAcquire(1);
    }

    public boolean tryLock(long time, TimeUnit unit) throws InterruptedException {

        return sync.tryAcquireNanos(1,unit.toNanos(time));
    }

    public void unlock() {
        sync.release(1);
    }

    public Condition newCondition() {
        return sync.newCondition();
    }
}
