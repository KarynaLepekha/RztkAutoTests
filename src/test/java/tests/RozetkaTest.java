package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.MainPage;

public class RozetkaTest extends BaseTest{

    @Test(description = "Verify screen diagonal is selected correctly")
    public void checkBox(){
        double screenDiagonal = 7.2;
        double maxValue;
        double minValue;
        String actualDiagonalValue = mainPage.
                clickPhonesAndElectronics().
                clickMobilePhones().
                selectCheckBox(screenDiagonal).
                getValueOfDiagonal();
        String[] diagonalValues = actualDiagonalValue.split("[^0-9\\.]+");
        if (diagonalValues.length == 1 && actualDiagonalValue.contains(" і менше")){
            maxValue = Double.parseDouble(diagonalValues[0]);
            Assert.assertTrue(screenDiagonal <= maxValue);
        } else if (diagonalValues.length == 1 && actualDiagonalValue.contains(" і більше")) {
            minValue = Double.parseDouble(diagonalValues[0]);
            Assert.assertTrue(screenDiagonal >= minValue);
        } else if (diagonalValues.length == 2)
        {
            minValue = Double.parseDouble(diagonalValues[0]);
            maxValue = Double.parseDouble(diagonalValues[1]);
            Assert.assertTrue(screenDiagonal >= minValue && screenDiagonal <= maxValue);
        }
    }
}

