package Products.FactoryPattern.Implements;

import Entities.Smartphonepart.Xiaomi.Xiaomiphone;
import Products.FactoryPattern.Product;

public class XiaomiPhonePat implements Product {
    public void show_catalog() throws Exception{
        Xiaomiphone.show_catalog();
    }
}
