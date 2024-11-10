import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
class TestsAuto {
    private List<Auto> autos;
    private final Auto a1 = new Auto("БМВ", 2006, new BigDecimal("14500.00"));
    private final Auto a2 = new Auto("Опель", 2015, new BigDecimal("19500.00"));
    private final Auto a3 = new Auto("Фиат", 2022, new BigDecimal("9900.00"));
    private final Auto a4 = new Auto("Мерседес", 2011, new BigDecimal("35000.00"));
    private Auto a5 = new Auto("БМВ", 2019, new BigDecimal("40900.00"));
    private Auto a6 = new Auto("БМВ", 2024, new BigDecimal("46200.00"));
    private Auto a7 = new Auto("Мерседес", 2000, new BigDecimal("10000.00"));
    @BeforeEach
    public void tearUp() {
        autos = new ArrayList<>();
        autos.add(a1);
        autos.add(a2);
        autos.add(a3);
        autos.add(a4);
        autos.add(a5);
        autos.add(a6);
        autos.add(a7);
    }
    @Test
    @DisplayName("сортировка по id")
    void getAutosSortedById_regularCase() {
        ComparateAuto listAuto = new ComparateAuto(autos);
        List<Auto> actualResult = listAuto.getAutosSortedById();
        Assertions.assertIterableEquals(autos, actualResult);
    }
    @Test
    @DisplayName("сортировка по бренду")
    void getAutosSortedByBrand_regularCase() {
        ComparateAuto listAuto = new ComparateAuto(autos);
        List<Auto> actualResult = listAuto.getAutosSortedByBrand();
        boolean isSorted = true;
        for (int i = 1; i < actualResult.size(); i++) {
            if (actualResult.get(i - 1).getBrand().compareTo(actualResult.get(i).getBrand()) > 0) {
                isSorted = false;
                break;
            }
        }
        boolean IsListSorted = isSorted;
        boolean isSizeEquals = autos.size() == actualResult.size();
        Assertions.assertAll(
                () -> Assertions.assertTrue(IsListSorted),
                () -> Assertions.assertTrue(isSizeEquals)
        );
    }
    @Test
    @DisplayName("сортировка по году")
    void getAutosSortedByYear_regularCase() {
        ComparateAuto listAuto = new ComparateAuto(autos);
        List<Auto> actualResult = listAuto.getAutosSortedByYear();
        boolean isSorted = true;
        for (int i = 1; i < actualResult.size(); i++) {
            if (actualResult.get(i - 1).getYear() > actualResult.get(i).getYear()) {
                isSorted = false;
                break;
            }
        }
        boolean IsListSorted = isSorted;
        boolean isSizeEquals = autos.size() == actualResult.size();
        Assertions.assertAll(
                () -> Assertions.assertTrue(IsListSorted),
                () -> Assertions.assertTrue(isSizeEquals)
        );
    }
    @Test
    @DisplayName("сортировка по цене")
    void getAutosSortedByPrice_regularCase() {
        ComparateAuto listAuto = new ComparateAuto(autos);
        List<Auto> actualResult = listAuto.getAutosSortedByPrice();
        boolean sort = true;
        for (int i = 1; i < actualResult.size(); i++) {
            if (actualResult.get(i - 1).getPrice().compareTo(actualResult.get(i).getPrice()) > 0) {
                sort = false;
                break;
            }
        }
        boolean IsListSorted = sort;
        boolean isSizeEquals = autos.size() == actualResult.size();
        Assertions.assertAll(
                () -> Assertions.assertTrue(IsListSorted),
                () -> Assertions.assertTrue(isSizeEquals)
        );
    }
    @Test
    @DisplayName("сортировка если лист null")
    void getAutosSortedById_ifListIsNull() {
        ComparateAuto listAuto = new ComparateAuto(null);
        List<Auto> actualResult = listAuto.getAutosSortedById();
        Assertions.assertNull(actualResult);
    }
}