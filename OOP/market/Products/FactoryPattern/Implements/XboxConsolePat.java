package Products.FactoryPattern.Implements;

import Entities.Gamepart.Xbox.Xboxconsole;
import Products.FactoryPattern.Product;

public class XboxConsolePat implements Product {
    public void show_catalog() throws Exception {
        Xboxconsole.show_catalog();
    }
}
