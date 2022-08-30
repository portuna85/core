package hello.core.lifecycle;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

@Slf4j
public class NetworkClient{

    private String url;

    public NetworkClient() {
        log.info("생성자 호출, url = {}", url);

    }

    public void setUrl(String url) {
        this.url = url;
    }

    // 서비스 시작시 호출
    public void connect() {
        log.info("connect = {}", url);
    }

    public void call(String message) {
        log.info("call = {}, message = {}", url, message);
    }

    // 서비스 종료시 호출
    public void disconnect() {
        log.info("close = {}", url);
    }

    public void init(){
        connect();
        call("초기화 연결 메시지");
    }

    public void close() {
        log.info("NetworkClient.destory");
        disconnect();
    }
}
