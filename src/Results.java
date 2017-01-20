import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;

/**
 * Created by 33558 on 19.01.2017.
 */
@XmlRootElement
public class Results {

    @XmlElement
    ArrayList<Rate> rate;

    @Override
    public String toString() {
        return "Results{" + ", " + "rates=" + rate;
    }
}
