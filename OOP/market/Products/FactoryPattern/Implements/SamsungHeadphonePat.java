package Products.FactoryPattern.Implements;

import Entities.Headphonespart.Samsungheadphone;
import Products.FactoryPattern.Product;

public class SamsungHeadphonePat implements Product {
    public void show_catalog() throws Exception{
        Samsungheadphone.show_catalog();
    }
}
