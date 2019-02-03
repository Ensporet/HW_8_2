package com.Ens_Library.Ens_RunTheard;

import java.util.concurrent.Phaser;
import java.util.concurrent.locks.Lock;

import static java.lang.Thread.sleep;

public class example {


    public static void main(String[] args) {

//-----------------------------------------------Semaphore------------------------------------------------------------\\
        {

            final String string = "Semaphore";
            /*
             // Semaphore - ограничивает количество потоков работающих с одним ресурсом
             //10run -> (2) : 8whit 2run  : 7whit 2run 1done



            int i = 2; // максимальное количество одновременно работающих потоков с этим ресурсом
            Semaphore semaphore = new Semaphore(i);


            int sizeClones = 5 ; //Сколько нужно клонов
            RunTheardArrayClone runTheardArrayClone = new RunTheardArrayClone(

                    new RunTheard_Semaphore(semaphore) {



                        @Override
                        public void run() {

                            System.out.println("[" + this.getThread().getId()+ "]is start ");

                            try {
                                System.out.println("["+this.getThread().getId()+"]is relax");
                                sleep(1000);

                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                            System.out.println("[" + this.getThread().getId()+ "]is done ");
                        }
                    },
                    sizeClones

            );


            runTheardArrayClone.start();

            */
        }
//------------------------------------------SchedulerExecutorService--------------------------------------------------\\
        {

            final String string = "SchedulerExecutorService";
            /*

            // Запускает поток через определенное время
            // shutdown() - ожидание завершения и закрытие пула

            ScheduledExecutorService scheduledExecutorService = Executors.newSingleThreadScheduledExecutor();



            scheduledExecutorService.schedule(() -> {//Добавить задачу и время срабатывания
                System.out.println("Start runnable");
                try {
                    sleep(5000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("Runnable is dan");

            },2, TimeUnit.SECONDS);

            //--------------------------------------------------------
            scheduledExecutorService.schedule(//Добавить задачу и время срабатывания
                    () -> {

                        System.out.println("Start Callable");
                        sleep(5000);
                        System.out.println("Callable is dan");

                        return "null";
                    }

                    , 2, TimeUnit.SECONDS);

            scheduledExecutorService.shutdown();//Запуск таймера
            */
        }
//--------------------------------------------------Phaser------------------------------------------------------------\\
        {
            final String string = "Phaser";


            //Phaser - регистрирует два потока, и пока два потока не вызовут метод arriveAndAwaitAdvance()

            Phaser phaser = new Phaser(6);

            new RunTheardArrayClone( new RunTheard_default() {
                @Override
                public void run() {
                    System.out.println("["+this.getThread().getId()+"] : Start");

                    try {
                        sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println("["+this.getThread().getId()+"] : while others perform . Is perform : " + phaser.getUnarrivedParties());
                    phaser.arriveAndAwaitAdvance();

                    System.out.println("["+this.getThread().getId()+"] : dan !");


                }
            },5).start();


            new RunTheard_default() {
                @Override
                public void run() {

                    System.out.println("["+this.getThread().getId()+"] : Start");

                    try {
                        sleep(3000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println("["+this.getThread().getId()+"] : while others perform . Is perform : " + phaser.getUnarrivedParties());
                    phaser.arriveAndAwaitAdvance();

                    System.out.println("["+this.getThread().getId()+"] : dan !");

                }
            }.start();



        }
//---------------------------------------------------Lock-------------------------------------------------------------\\
        {
            final String string = "Lock";

            // Аналог synchronized  блочит поток .lock() если lock true

            Lock lock = new java.util.concurrent.locks.ReentrantLock();


               BoxLock boxLock = new BoxLock() {
                @Override
                public void action() {


                    System.out.println(Thread.currentThread().getId() + " : work....");
                    try {
                        sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(Thread.currentThread().getId() + " : dan ");
                }
            };


            RunTheard_default runTheard_default = new RunTheard_default() {
                @Override
                public void run() {
                    boxLock.begin();

                }
            };
            RunTheard_default runTheard_default1 = new RunTheard_default() {
                @Override
                public void run() {

                  boxLock.begin();


                }
            };

            runTheard_default.start();
            runTheard_default1.start();

        }
//------------------------------------------------- ForkJoin----------------------------------------------------------\\
        {
            final String string = "ForkJoin";

            /*
            // и задача, которая возвращает результат («задача»). Эти два типа задач представлены классами RecursiveAction и RecursiveTask
            //RecursiveAction
            //@Override
            //    protected void compute()  //клас определяющий каким образом задача будет разделена
            // В MyRecursiveTask примере также разбивает работу на подзадачи и планирует эти подзадачи для выполнения с помощью метода fork() .
            //Кроме того в этом примере затем получает результат, возвращаемый каждой подзадачи, вызвав метод join() каждого подзадачи.
            //1) метод execute() //Desired асинхронное выполнение; Вызовите его метод вилку разделить работу между несколькими потоками.
            //2) метод invoke(): //Await для получения результата; вызов метода invoke на бассейн.
            //3) метод submit(): //Returns будущего объекта, который можно использовать для проверки статуса и получения результата после его завершения.
            int i = Runtime.getRuntime().availableProcessors();
            ForkJoinPool forkJoinPool = new ForkJoinPool(i);


            forkJoinPool.invoke( forkJoinPool.submit(()->{ //

                System.out.println("Start  :" +Thread.currentThread().getId());

                forkJoinPool.invoke(forkJoinPool.submit(()->{
                    System.out.println("Start 2 :" +Thread.currentThread().getId());
                }));


            }));




*/


    }
//--------------------------------------------------Exchanger---------------------------------------------------------\\
        {
            final String string = "Exchanger";
/*
            Exchanger<String> exchanger = new Exchanger<>();
            //exchange() - передает эти данные между потоками, нужен общий exchange
            // Первый поток запускает exchange() и ждет пока второй поток тоже активирует exchange() и примет данные

            RunTheard_Exchanger exchanger1 = new RunTheard_Exchanger(exchanger) {
                @Override
                public void run() {



                        try {
                            System.out.println( Thread.currentThread().getId() + "start [t1]");
                            System.out.println(this.getExchanger().exchange("t1111ttt"+ " :" )+ String.valueOf(Thread.currentThread().getId()));
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }

                    System.out.println( Thread.currentThread().getId() + "end");


                }
            };

            RunTheard_Exchanger exchanger2 = new RunTheard_Exchanger(exchanger) {




                @Override
                public void run() {




                        try {
                            System.out.println( Thread.currentThread().getId() + "start [t2]");
                            System.out.println( this.getExchanger().exchange( "ttt222t"+ " :" ) + String.valueOf(Thread.currentThread().getId()) );
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }


                    System.out.println( Thread.currentThread().getId() + "end ");


                }
            };
            exchanger1.start();
            exchanger2.start();

*/

        }
//------------------------------------------------CyclicBarrier-------------------------------------------------------\\
        {
            final String string= "CyclicBarrier";
            /*
            //циклический барьер. Позволяет не начинать работу потоку CyclinRun, пока все 3 потока не вызовут метод await()
            int size = 4;
            CyclicBarrier cyclicBarrier = new CyclicBarrier(size,()->{
                System.out.println("Barrier shot , theard " + Thread.currentThread().getId() + " is run..." );
            });

            new RunTheardArrayClone(new RunTheard_CyclicBarrier(cyclicBarrier) {
                @Override
                public void run() {

                    System.out.println(Thread.currentThread().getId() + " : " + "start");
                    try {
                        sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(Thread.currentThread().getId() + " : " + "finish");


                }
            },
                  size  ).start();
*/

        }
//------------------------------------------------CountDownLatch------------------------------------------------------\\
        {
            final String string = "CountDownLatch";
            /*
            //CountDownLatch - предоставляет возможность любому количеству потоков ожидать, пока не завершаться все потоки методом countDown()
            //countDown() - уменьшает на единицу
            // await() - ждёт, чтобы счётчик дошёл до нуля
            int size = 3;
            CountDownLatch countDownLatch = new CountDownLatch(3);


            new RunTheardArrayClone(new RunTheard_CountDownLatch(countDownLatch) {
                @Override
                public void run() {

                    System.out.println(Thread.currentThread().getId() + " : Start");

                    try {
                        sleep( (new Random().nextBoolean() )? 1000 : 2000
                        );
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    try {
                        System.out.println(Thread.currentThread().getId() + " : await");
                        getCountDownLatch().countDown();
                        getCountDownLatch().await();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(Thread.currentThread().getId() + " : continue");


                }
            },size).start();

*/

        }
//--------------------------------------------------Condition---------------------------------------------------------\\
        {
            final String string = "Condition";
            /*
            Lock lock = new java.util.concurrent.locks.ReentrantLock();
            Condition condition = lock.newCondition();
            //Поток должен получить сигнал о готовности вызовом метода .signal()
            //Другой поток будет ждать этого сигнала с помощью метода .await()

            System.out.println(Thread.currentThread().getId() + " : Start");

            new RunTheard_default() {
                @Override
                public void run() {

                    System.out.println(Thread.currentThread().getId() + " : Start");

                    lock.lock();

                    try {
                        System.out.println(Thread.currentThread().getId() + " : waitSignal");
                        condition.await();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                    System.out.println(Thread.currentThread().getId() + " : work");
                    try {
                        sleep(2000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }




                    System.out.println(Thread.currentThread().getId() + " : end and exit");
                    lock.unlock();


                }
            }.start();
            new RunTheard_default() {
                @Override
                public void run() {

                    System.out.println(Thread.currentThread().getId() + " : Start");

                    lock.lock();

                    System.out.println(Thread.currentThread().getId() + " : work");
                    try {
                        sleep(2000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                    System.out.println(Thread.currentThread().getId() + " : end work send signal");
                    condition.signal();

                    System.out.println(Thread.currentThread().getId() + " : exit");
                    lock.unlock();


                }
            }.start();
        */
        }
//------------------------------------------------BlockingQueue-------------------------------------------------------\\
        {
            final String string = "BlockingQueue";
            /*
            //Поток будет заблочен если элемента нету
            BlockingQueue<String> queue = new PriorityBlockingQueue<>();


            new Thread(() -> {

                System.out.println(Thread.currentThread().getId() +" : start" );
                try {
                    System.out.println(Thread.currentThread().getId() + " take element :"+ queue.take());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                try {
                    System.out.println(Thread.currentThread().getId() + " take element :"+ queue.take());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getId() +" exit" );


            }).start();

            try {
                sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            new Thread(() -> {
                System.out.println(Thread.currentThread().getId() +" : start " );
                System.out.println(Thread.currentThread().getId() +  " > add element : " + queue.add("item")) ;
                try {
                    System.out.println(Thread.currentThread().getId() + " sleep ");
                    sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getId() +  " > add element : " + queue.add("new Item")) ;
                System.out.println(Thread.currentThread().getId() +  " exit") ;
            }).start();
*/
}
    }}


