package hello.core.singleton;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class StatefulService {

    private int price;

    public void order(String name, int price) {
        log.info("name = {}, price = {}", name, price);
        this.price = price;
    }

    public int getPrice() {
        return price;
    }
}
