import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
public class ComparateAuto {
    private List<Auto> list;
    public ComparateAuto(List<Auto> list) {
        this.list = list;
    }
    public List<Auto> getAutosSortedById(){
        Comparator<Auto> comparatorById = (a1,a2) -> a1.getId() - a2.getId();//через лямбду
        return getSortedAutos(comparatorById);
    }
    public  List<Auto> getAutosSortedByBrand(){
        return getSortedAutos((a1,a2) -> a1.getBrand().compareTo(a2.getBrand()) );
    }
    public  List<Auto> getAutosSortedByYear(){
        return getSortedAutos((a1,a2) -> a1.getYear() - a2.getYear());
    }
    public  List<Auto> getAutosSortedByPrice(){
        return getSortedAutos( (a1,a2) -> a1.getPrice().compareTo(a2.getPrice())    );
    }


    public List<Auto> getSortedAutos(Comparator<Auto> comparator){
        if(list==null) {
            return null;
        }
        ArrayList<Auto> autos = new ArrayList<>(list);
        autos.sort( comparator );
        return autos;
    }

}
