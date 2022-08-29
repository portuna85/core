package hello.core.singleton;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class SingletonService {
    private static final SingletonService instance = new SingletonService();

    public static SingletonService getInstance() {
        return instance;
    }

    private SingletonService() {
    }

   public void logic() {
       log.info("Singleton 객체 로직 호출");
   }


}
