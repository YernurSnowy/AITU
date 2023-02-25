package Products.FactoryPattern.Implements;

import Entities.Smartphonepart.Apple.NotProIphone;
import Products.FactoryPattern.Product;

public class NotProIphonePat implements Product {
    public void show_catalog() throws Exception{
        NotProIphone.show_catalog();
    }
}
