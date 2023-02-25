package Products.FactoryPattern.Implements;

import Entities.Headphonespart.Appleheadphone;
import Products.FactoryPattern.Product;

public class AppleHeadphonePat implements Product {
    public void show_catalog() throws Exception{
        Appleheadphone.show_catalog();
    }
}
