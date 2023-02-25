package Products.FactoryPattern.Implements;

import Entities.Gamepart.Xbox.Xboxgamepad;
import Products.FactoryPattern.Product;

public class XboxGamepadPat implements Product {
    public void show_catalog() throws Exception{
        Xboxgamepad.show_catalog();
    }
}
