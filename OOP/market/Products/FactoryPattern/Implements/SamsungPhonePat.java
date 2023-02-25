package Products.FactoryPattern.Implements;

import Entities.Smartphonepart.Samsung.Samsungphone;
import Products.FactoryPattern.Product;

public class SamsungPhonePat implements Product {
    public void show_catalog() throws Exception{
        Samsungphone.show_catalog();
    }
}
