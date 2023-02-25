package Products.FactoryPattern.Implements;

import Entities.Gamepart.Ps.Playstationconsole;
import Products.FactoryPattern.Product;

public class PlaystationConsolePat  implements Product {
    public void show_catalog() throws Exception{
        Playstationconsole.show_catalog();
    }
}
