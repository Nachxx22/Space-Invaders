public class Timer {
    public Timer(){
        int minutos = 0;
        int segundos = 0;
        for (minutos = 0; minutos < 60; minutos++) {
            for (segundos = 0; segundos < 60; segundos++) {
                System.out.println(minutos + ":" + segundos);
                delaySegundo();
            }
        }
    }

    public static void delaySegundo(){
        try{
            Thread.sleep(1000);
        }catch (InterruptedException e){}
    }
}