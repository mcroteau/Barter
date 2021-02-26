package barter.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Service;

@Service
@PropertySource("classpath:application.properties")
public class ViewService {

    @Value("${shop.name}")
    private String shopName;

    public String getShopName(){
        return this.shopName;
    }

}
