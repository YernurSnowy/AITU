package Products.FactoryPattern;

import Products.FactoryPattern.Implements.*;

public class ProductFactory {
    public static Product createProduct(String productType){
        switch (productType){
            case "Playstation Console":
                return new PlaystationConsolePat();
            case "Playstation Gamepad":
                return new PlaystationGamepadPat();
            case "Xbox Console":
                return new XboxConsolePat();
            case "Xbox Gamepad":
                return new XboxGamepadPat();
            case "Apple Headphone":
                return new AppleHeadphonePat();
            case "Samsung Headphone":
                return new SamsungHeadphonePat();
            case "Iphone":
                return new NotProIphonePat();
            case "Iphone Pro":
                return new ProIphonePat();
            case "Samsung Phone":
                return new SamsungPhonePat();
            case "Xiaomi Phone":
                return new XiaomiPhonePat();
            default:
                throw new IllegalArgumentException("Invalid product type:" + productType);
        }
    }
}
