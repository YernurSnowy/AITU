package Products.FactoryPattern.Implements;

import Entities.Smartphonepart.Apple.ProIphone;
import Products.FactoryPattern.Product;

public class ProIphonePat implements Product {
    public void show_catalog() throws Exception{
        ProIphone.show_catalog();
    }
}
