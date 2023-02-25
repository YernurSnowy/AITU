package Products.FactoryPattern.Implements;

import Entities.Gamepart.Ps.Playstationgamepad;
import Products.FactoryPattern.Product;

public class PlaystationGamepadPat implements Product {
    public void show_catalog() throws Exception {
        Playstationgamepad.show_catalog();
    }
}
